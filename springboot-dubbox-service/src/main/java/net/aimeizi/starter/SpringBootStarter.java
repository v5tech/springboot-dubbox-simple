package net.aimeizi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 使用SpringBoot启动容器
 */
@SpringBootApplication
@ImportResource(locations={"META-INF/spring/application-dubbo-provider.xml"})
public class SpringBootStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}
}
