package net.aimeizi.starter;

/**
 * 使用java config方式
 */
public class JavaConfigBootstrap {
    public static void main(String[] args) {
        // 实现Spring的JavaConfig配置方式，使用 Main.main(args) (需传参javaconfig设置使用JavaConfigContainer) 启动时可直接扫描 dubbo.spring.javaconfig 包下的所有的Spring配置类
        String[] customArgs = new String[]{"javaconfig"};
        com.alibaba.dubbo.container.Main.main(customArgs);
    }
}
