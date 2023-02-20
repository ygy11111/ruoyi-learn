package com.ygyniba.yudao.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.ygyniba.yudao.module.infra.api.logger.ApiErrorLogApi;
import com.ygyniba.yudao.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService{

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
    public void createApiErrorLog(ApiErrorLog apiErrorLog) {
        ApiErrorLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiErrorLog, ApiErrorLogCreateReqDTO.class);
        apiErrorLogApi.createApiErrorLog(reqDTO);
    }
}
