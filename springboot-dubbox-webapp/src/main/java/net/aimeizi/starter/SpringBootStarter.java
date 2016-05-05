package net.aimeizi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 使用SpringBoot启动容器
 */
@SpringBootApplication
@ImportResource(locations = {"META-INF/dubbo/application-dubbo-consumer.xml"})
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(net.aimeizi.starter.SpringBootStarter.class, args);
    }
}
