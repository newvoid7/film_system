package edu.seu.film_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class StaticResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // static 文件夹，如果 url 中出现 / 的话
        // http://127.0.0.1:8256/film/img/wallpaper.jpg
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 指定盘符下，如果 url 中出现 resource 的话
        // http://127.0.0.1:8256/film/resource/image/p1.jpg
        registry.addResourceHandler("/resource/image/*").addResourceLocations("file:D:/film/image/");
        // http://127.0.0.1:8256/film/resource/video/v1.mp4
        registry.addResourceHandler("/resource/video/*").addResourceLocations("file:D:/film/video/");
    }
}