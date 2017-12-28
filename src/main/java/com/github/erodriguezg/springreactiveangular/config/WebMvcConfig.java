package com.github.erodriguezg.springreactiveangular.config;

import com.github.erodriguezg.javautils.CodecUtils;
import com.github.erodriguezg.javautils.DateUtils;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by eduar on 15/05/2017.
 */

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/", "classpath:/frontend-dist/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }
    }

    @Bean
    public CommonsMultipartResolver filterMultipartResolver() {
        CommonsMultipartResolver filterMultipartResolver = new CommonsMultipartResolver();
        filterMultipartResolver.setMaxUploadSize(20971520);
        return filterMultipartResolver;
    }

    /*
    Servlet Dispatcher MVC
     */

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet(), "/*");
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return registration;
    }

    /*
    Listeners
    */

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    /*
    Filter CORS
     */

    @Bean
    public FilterRegistrationBean urlCorsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new com.github.erodriguezg.springreactiveangular.security.CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.INCLUDE, DispatcherType.ASYNC, DispatcherType.ERROR));
        registration.setName("corsFilter");
        registration.setOrder(1);
        return registration;
    }

    /*
    Filter URL REWRITE
     */

    @Bean
    public FilterRegistrationBean urlRewriteFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new org.tuckey.web.filters.urlrewrite.UrlRewriteFilter());
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.INCLUDE, DispatcherType.ASYNC, DispatcherType.ERROR));
        registration.setName("urlRewriteFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/access.html"));
            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html"));
        };
    }

    /*
    Utilitarios
     */

    @Bean
    public CodecUtils codecUtils() {
        return new CodecUtils();
    }

    @Bean
    public DateUtils dateUtils() {
        return new DateUtils();
    }

}
