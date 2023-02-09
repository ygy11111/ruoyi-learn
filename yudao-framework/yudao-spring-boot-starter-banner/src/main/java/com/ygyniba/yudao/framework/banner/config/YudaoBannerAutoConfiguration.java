package com.ygyniba.yudao.framework.banner.config;

import com.ygyniba.yudao.framework.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @author: ygy
 * @date: 2023/2/9 18:07
 */
@AutoConfiguration
public class YudaoBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }

}
