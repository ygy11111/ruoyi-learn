package com.ygyniba.yudao.framework.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCodeConstants {

    SUCCESS(0, "成功");

    private final Integer code;

    private final String message;

}
