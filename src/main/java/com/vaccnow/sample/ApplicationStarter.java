package com.vaccnow.sample;

import com.vaccnow.sample.dao.model.VaccineBranches;
import com.vaccnow.sample.services.VaccineBranchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
@PropertySource("classpath:application.properties")
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.vaccnow.sample")).build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){

        ApiInfo apiInfo = new ApiInfo("Spring Boot Rest API for Vaccination Branch details","","1.0","",new Contact("Ajinkya Choudhary","nikhilchoudhary1991@gmail.com","9890974610"),"","",new ArrayList<>());
    return apiInfo;
    }
    //http://localhost:8080/h2-console
}
