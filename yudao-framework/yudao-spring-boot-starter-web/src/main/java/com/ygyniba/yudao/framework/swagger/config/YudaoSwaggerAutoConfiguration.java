package com.ygyniba.yudao.framework.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @Description:
 * @author: ygy
 * @date: 2023/2/9 14:37
 */
@AutoConfiguration
@EnableSwagger2WebMvc
@EnableKnife4j
@ConditionalOnClass({Docket.class, ApiInfoBuilder.class})
// 允许使用 swagger.enable=false 禁用 Swagger
@ConditionalOnProperty(prefix = "yudao.swagger", value = "enable", matchIfMissing = true)
@EnableConfigurationProperties(value = SwaggerProperties.class)
public class YudaoSwaggerAutoConfiguration {

    public Docket createRestApi(SwaggerProperties properties) {
        // 创建 Docket 对象
        return new Docket(DocumentationType.SWAGGER_2)
                // ① 用来创建该 API 的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo(properties))
                // ② 设置扫描指定 package 包下的
                .select()
                .apis(basePackage(properties.getBasePackage()))
//                .apis(basePackage("com.ygyniba.yudao.module.system"")) // 可用于 swagger 无法展示时使用
                .paths(PathSelectors.any())
                .build();
                // ③ 安全上下文（认证）
                /*.securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(globalRequestParameters());*/
    }

    // ========== apiInfo ==========

    /**
     * API 摘要信息
     */
    private ApiInfo apiInfo(SwaggerProperties properties) {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .contact(new Contact(properties.getAuthor(), null, null))
                .version(properties.getVersion())
                .build();
    }

    // ========== securitySchemes ==========

    /**
     * 安全模式，这里配置通过请求头 Authorization 传递 token 参数
     */
    /*private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey(HttpHeaders.AUTHORIZATION, "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {

    }

    private List<Parameter> globalRequestParameters() {

    }*/

}
