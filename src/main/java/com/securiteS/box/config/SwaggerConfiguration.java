package com.securiteS.box.config;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public BeanConfig beanConfig() {
        BeanConfig swaggerConfigBean = new BeanConfig();
        swaggerConfigBean.setConfigId("Spring Swagger Jersey Example");
        swaggerConfigBean.setTitle("Rest APIs using JAX-RS, Spring boot, Jersey as Implementation, Swagger");
        swaggerConfigBean.setVersion("v1");
        swaggerConfigBean.setContact("Azedine Lamaouaj");
        swaggerConfigBean.setSchemes(new String[]{"http", "https"});
        swaggerConfigBean.setBasePath("/api/");
        swaggerConfigBean.setResourcePackage("com.securiteS.box.resources");
        swaggerConfigBean.setPrettyPrint(true);
        swaggerConfigBean.setScan(true);
        return swaggerConfigBean;
    }

}
