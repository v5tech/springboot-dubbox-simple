package net.aimeizi;

import net.aimeizi.config.RestServiceConfig;
import net.aimeizi.order.OrderService;
import net.aimeizi.person.PersonService;
import net.aimeizi.user.User;
import net.aimeizi.user.UserService;
import org.apache.avro.AvroRemoteException;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class ServiceConsumer {

    private static Logger logger = null;

    private static String baseUrl = "";

    private final static Client client = ClientBuilder.newClient();

    public static void main(String[] args) throws IOException, TException {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dubbo/application-dubbo-consumer.xml");

        logger = LoggerFactory.getLogger(ServiceConsumer.class);

        baseUrl = context.getBean(RestServiceConfig.class).getBaseUrl();

        UserService dubboService = context.getBean(UserService.class, "userService");
        System.out.println("dubboService ping:" + dubboService.ping());

        PersonService avroService = context.getBean("personService", PersonService.class);
        System.out.println("avroService ping:" + avroService.ping());

        OrderService.Iface thriftService = context.getBean("orderService", OrderService.Iface.class);
        System.out.println("thriftService ping:" + thriftService.ping());

        rpcTest(dubboService);

        restTest();

        performanceTest(dubboService, avroService, thriftService);

        restErrorTest();

    }

    private static void restErrorTest() {
        post(baseUrl + "register", getUser(0L), MediaType.APPLICATION_JSON_TYPE);
    }

    private static void restTest() {
        logger.info("\nREST test begin ...");
        get(baseUrl + "0");
        get(baseUrl + "2");
        post(baseUrl + "delete", 2L, MediaType.APPLICATION_JSON_TYPE);
        post(baseUrl + "post", "", MediaType.APPLICATION_JSON_TYPE);
        post(baseUrl + "register", getUser(3L), MediaType.APPLICATION_JSON_TYPE);
    }


    private static void rpcTest(UserService userService) {
        logger.info("rpc test begin ...");
        logger.info("getUserById test => ");
        logger.info(userService.getUserById(1L).toString());
        logger.info(userService.ping());
        logger.info(userService.deleteUserById(2L).toString());
        logger.info(userService.updatePassword(1L, "12345678", "abcdefgh").toString());
        logger.info(userService.registerUser(getUser(5L)).toString());
    }


    private static void performanceTest(UserService dubboService, PersonService avroService, OrderService.Iface thriftService) throws AvroRemoteException, TException {

        System.out.println(dubboService.ping());
        get(baseUrl + "ping");
        System.out.println(avroService.ping());

        logger.warn("dubbo RPC testing => ");

        int max = 50000;
        long start = System.currentTimeMillis();

        for (int i = 0; i < max; i++) {
            dubboService.ping();
        }

        long end = System.currentTimeMillis();
        long elapsedMilliseconds = end - start;

        logger.warn(String.format("%d次RPC调用(dubbo协议),共耗时%d毫秒,平均%f/秒", max, elapsedMilliseconds, max / (elapsedMilliseconds / 1000.0F)));

        logger.warn("avro RPC testing => ");

        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            avroService.ping();
        }
        end = System.currentTimeMillis();
        elapsedMilliseconds = end - start;

        logger.warn(String.format("%d次RPC调用(avro协议),共耗时%d毫秒,平均%f/秒", max, elapsedMilliseconds, max / (elapsedMilliseconds / 1000.0F)));


        logger.warn("thrift RPC testing => ");

        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            thriftService.ping();
        }
        end = System.currentTimeMillis();
        elapsedMilliseconds = end - start;

        logger.warn(String.format("%d次RPC调用(thrift协议),共耗时%d毫秒,平均%f/秒", max, elapsedMilliseconds, max / (elapsedMilliseconds / 1000.0F)));


        logger.warn("REST testing => ");

        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            get(baseUrl + "ping");
        }
        end = System.currentTimeMillis();
        elapsedMilliseconds = end - start;

        logger.warn(String.format("%d次REST调用,共耗时%d毫秒,平均%f/秒", max, elapsedMilliseconds, max / (elapsedMilliseconds / 1000.0F)));
    }

    private static void get(String url) {
        logger.info(url);
        WebTarget target = client.target(url);
        Response response = target.request().get();
        output(response, client);
    }

    private static <T> void post(String url, T t, MediaType mediaType) {
        WebTarget target = client.target(url);
        Response response = target.request().buildPost(Entity.entity(t, mediaType)).invoke();
        output(response, client);
    }

    private static void output(Response response, Client client) {
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            logger.debug(response.readEntity(String.class));
        } finally {
            response.close();
            //client.close();
        }
    }

    private static User getUser(Long i) {
        return new User(i, "jimmy", "123456ab", 20);
    }
}