//package com.example.wms.interceptor;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.wms.common.JwtUtils;
//import com.example.wms.poji.Result;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@Component
//public class LoginCheckInterceptor implements HandlerInterceptor {
//    @Override//目标资源方法运行前，true放行
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            System.out.println("pre");
//
//        //1,获取url
//        String url = request.getRequestURL().toString();
//
//        //登录放行
//        if (url.contains("login")) {
//            return true;
//        }
//
//        //获取token（令牌）
//        String jwt = request.getHeader("token");
//
//        //不存在返回未登录
//        if (!StringUtils.hasLength(jwt)) {
//            Result error = Result.error("NOT_LOGIN");
//            String noLogin = JSONObject.toJSONString(error);
//            response.getWriter().write(noLogin);
//            return false;
//        }
//
//        //解析
//        try{
//            JwtUtils.parseJWT(jwt);
//        }catch (Exception e){
//            e.printStackTrace();
//            Result error = Result.error("NOT_LOGIN");
//            String noLogin = JSONObject.toJSONString(error);
//            response.getWriter().write(noLogin);
//
//            return false;
//        }
//
//        return true;
//
//    }
//
//    @Override//运行后
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("post");
//    }
//
//    @Override//视图渲染完毕
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("after");
//    }
//}
