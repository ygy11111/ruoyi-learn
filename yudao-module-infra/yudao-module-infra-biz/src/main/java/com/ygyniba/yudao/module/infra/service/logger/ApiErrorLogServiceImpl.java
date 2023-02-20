package com.ygyniba.yudao.module.infra.service.logger;

import com.ygyniba.yudao.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * API 错误日志 Service 实现类
 */
@Service
@Validated
public class ApiErrorLogServiceImpl implements ApiErrorLogService{

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createReqDTO) {
        // TODO: 2023/2/20 插入错误日志
    }
}
