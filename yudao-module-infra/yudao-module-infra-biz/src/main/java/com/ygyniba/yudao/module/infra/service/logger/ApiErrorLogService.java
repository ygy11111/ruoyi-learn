package com.ygyniba.yudao.module.infra.service.logger;

import com.ygyniba.yudao.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;

import java.util.List;

/**
 * API 错误日志 Service 接口
 */
public interface ApiErrorLogService {

    /**
     * 创建 API 错误日志
     *
     * @param createReqDTO API 错误日志
     */
    void createApiErrorLog(ApiErrorLogCreateReqDTO createReqDTO);

}
