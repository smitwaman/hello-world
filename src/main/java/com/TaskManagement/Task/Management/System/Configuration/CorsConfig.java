package com.TaskManagement.Task.Management.System.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("*") // You can specify specific origins instead of "*"
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowCredentials(true)
	                .maxAge(3600); // Optional: set the maximum age of preflight requests
	 }
}
