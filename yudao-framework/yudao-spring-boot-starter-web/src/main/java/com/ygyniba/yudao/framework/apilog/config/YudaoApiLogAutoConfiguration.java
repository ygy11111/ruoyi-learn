package com.ygyniba.yudao.framework.apilog.config;

import com.ygyniba.yudao.framework.apilog.core.filter.ApiAccessLogFilter;
import com.ygyniba.yudao.framework.apilog.core.service.ApiAccessLogFrameworkService;
import com.ygyniba.yudao.framework.apilog.core.service.ApiAccessLogFrameworkServiceImpl;
import com.ygyniba.yudao.framework.apilog.core.service.ApiErrorLogFrameworkService;
import com.ygyniba.yudao.framework.apilog.core.service.ApiErrorLogFrameworkServiceImpl;
import com.ygyniba.yudao.framework.common.enums.WebFilterOrderEnum;
import com.ygyniba.yudao.framework.web.config.WebProperties;
import com.ygyniba.yudao.framework.web.config.YudaoWebAutoConfiguration;
import com.ygyniba.yudao.module.infra.api.logger.ApiAccessLogApi;
import com.ygyniba.yudao.module.infra.api.logger.ApiErrorLogApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@AutoConfiguration(after = YudaoWebAutoConfiguration.class)
public class YudaoApiLogAutoConfiguration {

    @Bean
    public ApiAccessLogFrameworkService apiAccessLogFrameworkService(ApiAccessLogApi apiAccessLogApi) {
        return new ApiAccessLogFrameworkServiceImpl(apiAccessLogApi);
    }

    @Bean
    public ApiErrorLogFrameworkService apiErrorLogFrameworkService(ApiErrorLogApi apiErrorLogApi) {
        return new ApiErrorLogFrameworkServiceImpl(apiErrorLogApi);
    }

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "yudao.access-log", value = "enable", matchIfMissing = true) // 允许使用 yudao.access-log.enable=false 禁用访问日志
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiAccessLogFrameworkService apiAccessLogFrameworkService) {
        return createFilterBean(new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogFrameworkService),
                WebFilterOrderEnum.API_ACCESS_LOG_FILTER);
    }

    public static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }
}
