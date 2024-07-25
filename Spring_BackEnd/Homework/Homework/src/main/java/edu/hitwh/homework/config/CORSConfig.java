package edu.hitwh.homework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(CORSConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("CORS Configuration Loaded");
        registry.addMapping("/**") // 允许跨域请求的所有路径
                .allowedOrigins("http://localhost:9528") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
                .allowCredentials(true) // 允许携带凭证
                .maxAge(3600); // 预请求的有效时间
    }
}
