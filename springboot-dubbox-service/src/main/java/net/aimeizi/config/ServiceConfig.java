package net.aimeizi.config;

import lombok.Data;

@Data
public class ServiceConfig {

    /**
     * service provider发生错误时,是否抛出异常
     */
    private boolean throwException;
}
