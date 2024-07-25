//package com.example.wms.common;
//
//
//import lombok.Data;
//
//@Data
//public class Result {
//
//    private int code;//400
//    private String msg;//s or d
//    private Long total;//总记录数
//    private Object data;
//
//    public static Result fail(){
//        return result(400, "uibl", 0L, null);
//    }
//
//    public static Result success(){
//        return result(200, "ifgs", 0L, null);
//    }
//
//    public static Result success(Object data){
//        return result(200, "ifgs", 0L, data);
//    }
//
//    public static Result success(Object data,Long total){
//        return result(200, "ifgs", total, data);
//    }
//
//    public static Result result(int code, String msg, Long total, Object data) {
//        Result result = new Result();
//        result.setCode(code);
//        result.setMsg(msg);
//        result.setTotal(total);
//        result.setData(data);
//        return result;
//
//    }
//
//}
