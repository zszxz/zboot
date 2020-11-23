package com.zboot.common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Function;
import java.util.function.Predicate;


/**
 * @Author lsc
 * <p> </p>
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig  {



    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        Docket build = docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zboot"))
                .paths(PathSelectors.any())
                .build();
        return build;

    }


    /* *
     * @Author lsc
     * <p> 文档信息</p>
     * @Param []
     * @Return springfox.documentation.service.ApiInfo
     */
    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        ApiInfo apiInfo = apiInfoBuilder.title("zboot API doc")
                .description("zboot API doc！")
                .version("v1")
                .contact("lsc_106@126.com")
                .build();

        return apiInfo;
    }
}