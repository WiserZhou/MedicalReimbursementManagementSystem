//package com.example.wms.filter;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.wms.common.JwtUtils;
//import com.example.wms.poji.Result;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*")
//public class LoginCheckFilter {
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String url = req.getRequestURL().toString();
//
//        if(url.contains("login")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        String jwt = req.getHeader("token");
//
//        if(!StringUtils.hasLength(jwt)) {
//
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            res.getWriter().write(notLogin);
//            return;
//
//        }
//
//        try {
//            JwtUtils.parseJWT(jwt);
//        }catch (Exception e) {
//            e.printStackTrace();
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            res.getWriter().write(notLogin);
//            return;
//
//        }
//
//        chain.doFilter(request, response);
//
//    }
//
//}
