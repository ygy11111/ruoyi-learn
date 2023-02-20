package com.ygyniba.yudao.module.infra.service.logger;

import com.ygyniba.yudao.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;

public interface ApiAccessLogService {

    /**
     * 创建 API 访问日志
     *
     * @param createReqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDTO createReqDTO);

}
