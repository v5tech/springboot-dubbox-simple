package net.aimeizi.starter;

/**
 * 使用dubbo启动容器服务
 * Created by Administrator on 2016/5/4 0004.
 */
public class ApplicationBootstrap {

    public static void main(String[] args) throws Exception {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:META-INF/spring/application-dubbo-provider.xml"});
//        context.start();
//        System.in.read();

        com.alibaba.dubbo.container.Main.main(args);
    }

}
