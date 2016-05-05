package net.aimeizi.exception;


import net.aimeizi.consts.ServiceConst;

public class ParamException extends ServiceException {


    public ParamException(String errMsg) {
        super(errMsg);
        setErrCode(ServiceConst.ErrorCode.PARAM_ERROR);
    }

    public ParamException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
