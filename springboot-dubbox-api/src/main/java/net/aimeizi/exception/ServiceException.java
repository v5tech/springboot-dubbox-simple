package net.aimeizi.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ServiceException extends Exception {

    private String errCode;

    private String errMsg;

    public ServiceException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }
}
