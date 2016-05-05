package net.aimeizi.consts;


public class ServiceConst {

    public static class ErrorCode {

        /**
         * 约定0开头的,代表各种未知错误
         */
        public final static String UNKNOWN = "000";

        /**
         * 约定1开头的,代表各种参数错误
         */
        public final static String PARAM_ERROR = "100"; //参数错误
        public final static String PARAM_VALID_ERROR = "101"; //参数校验失败
        public final static String PARAM_EMPTY = "102"; //参数为空

        /**
         * 约定2开头的,代表各种DB层面的错误
         */
        public final static String DB_ERROR = "200"; //数据库层面的错误
    }


    public static class HttpCode {
        public final static String Continue = "100";
        public final static String SwitchingProtocols = "101";
        public final static String Processing = "102";
        public final static String OK = "200";
        public final static String Created = "201";
        public final static String Accepted = "202";

    }
}
