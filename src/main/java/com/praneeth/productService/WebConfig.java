package com.praneeth.productService;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("https://foodyres.web.app")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .exposedHeaders("*")
//                .allowCredentials(true).maxAge(3600);
//    }
//}

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigures(){
        return  new WebMvcConfigurer ( ) {
            @Override
            public void addCorsMappings ( CorsRegistry registry ) {
                registry.addMapping ( "/**" )
                        .allowedOrigins ( "https://foodyres.web.app" )
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .exposedHeaders("*");
            }
        };
    }
}