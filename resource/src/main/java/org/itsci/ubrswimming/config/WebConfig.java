package org.itsci.ubrswimming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.itsci.ubrswimming")
public class WebConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image1/");
        registry.addResourceHandler("/img2/**").addResourceLocations("/WEB-INF/image2/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/img3/**").addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/stylesheet/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/javascript/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
