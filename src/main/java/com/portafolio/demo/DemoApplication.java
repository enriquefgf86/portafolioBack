package com.portafolio.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/post/all").allowedOrigins("*")
			            .allowedMethods("PUT", "DELETE","POST","GET")
						.allowedHeaders("application/json", "text/plain", "application/x-www-form-urlencoded")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}

}


//@Configuration
//@EnableWebMvc
// class WebConfig implements Filter,WebMvcConfigurer {
//
//
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
//		HttpServletResponse response = (HttpServletResponse) res;
//		HttpServletRequest request = (HttpServletRequest) req;
//		System.out.println("WebConfig; "+request.getRequestURI());
//		response.setHeader("Access-Control-Allow-Origin", "http://portafolio-angular-bucket.s3-website-us-west-2.amazonaws.com");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Expose-Headers", "Authorization");
//		response.addHeader("Access-Control-Expose-Headers", "responseType");
//		response.addHeader("Access-Control-Expose-Headers", "observe");
//		System.out.println("Request Method: "+request.getMethod());
//		if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
//			try {
//				chain.doFilter(req, res);
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("Pre-flight");
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
//			response.setHeader("Access-Control-Max-Age", "3600");
//			response.setHeader("Access-Control-Allow-Headers", "Access-Control-Expose-Headers"+"Authorization, content-type," +
//					"USERID"+"ROLE"+
//					"access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,responseType,observe");
//			response.setStatus(HttpServletResponse.SC_OK);
//		}
//
//	}
//
//}



