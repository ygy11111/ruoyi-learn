package com.ygyniba.yudao.module.infra.service.logger;

import com.ygyniba.yudao.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * API 访问日志 Service 实现类
 */
@Service
@Validated
public class ApiAccessLogServiceImpl implements ApiAccessLogService {

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createReqDTO) {
        // TODO: 2023/2/20 插入访问日志
    }
}
