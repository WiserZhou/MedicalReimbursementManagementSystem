//package com.example.wms.UserController;
//
//import com.example.wms.common.JwtUtils;
//import com.example.wms.poji.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class LoginController {
//
//    @Autowired
//    private EmpService empService;
//
//    @PostMapping("/login")
//    public Result login(@RequestBody Emp emp) {
//
//        Emp e = empService.login(emp);
//        //下发令牌
//        System.out.println(e);
//        if (e != null) {
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("id", e.getId());
//            claims.put("name", e.getName());
//            claims.put("username", e.getUsername());
//
//            System.out.println(claims);
//            String jwt = JwtUtils.generateJwt(claims);
//            System.out.println(jwt);
//            return Result.success(jwt);
//        }
//
//        return Result.error("用户名或密码错误");
//    }
//
//}
