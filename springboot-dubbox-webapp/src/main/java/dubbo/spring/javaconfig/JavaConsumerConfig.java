package dubbo.spring.javaconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import net.aimeizi.consumer.JavaConfigConsumer;
import net.aimeizi.exception.ValidationExceptionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/5/6 0006.
 * 将XML配置方式转换为JavaConfig配置
 * 实现Spring的JavaConfig配置方式，使用 Main.main(args) (需传参javaconfig设置使用JavaConfigContainer) 启动时可直接扫描 dubbo.spring.javaconfig 包下的所有的Spring配置类
 */
@Configuration
public class JavaConsumerConfig {

    public static final String APPLICATION_NAME = "dubbo-consumer";

    public static final String REGISTRY_ADDRESS = "zookeeper://127.0.0.1:2181";

    public static final String ANNOTATION_PACKAGE = "net.aimeizi.consumer";

    /**
     * 自动装配消费者
     * @return
     */
    @Bean
    public JavaConfigConsumer javaConfigConsumer(){
        // 会调用@PostConstruct注解标注的方法
        return new JavaConfigConsumer();
    }

    @Bean
    public ValidationExceptionMapper validationExceptionMapper(){
        return new ValidationExceptionMapper();
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        return registryConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(ANNOTATION_PACKAGE);
        return annotationBean;
    }

}
