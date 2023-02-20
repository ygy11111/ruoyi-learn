package com.ygyniba.yudao.module.infra.api.logger;

import com.ygyniba.yudao.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ApiErrorLogApiImpl implements ApiErrorLogApi{

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {

    }
}
