package com.ygyniba.yudao.framework.web.core.util;

import com.ygyniba.yudao.framework.common.enums.UserTypeEnum;
import com.ygyniba.yudao.framework.common.pojo.CommonResult;
import com.ygyniba.yudao.framework.web.config.WebProperties;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class WebFrameworkUtils {

    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_ID = "login_user_id";
    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_TYPE = "login_user_type";

    private static final String REQUEST_ATTRIBUTE_COMMON_RESULT = "common_result";

    private static WebProperties properties;

    public WebFrameworkUtils(WebProperties webProperties) {
        WebFrameworkUtils.properties = webProperties;
    }

    /**
     * 获得当前用户的编号，从请求中
     * 注意：该方法仅限于 framework 框架使用！！！
     *
     * @param request 请求
     * @return 用户编号
     */
    public static Long getLoginUserId(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return (Long) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_USER_ID);
    }

    /**
     * 获得当前用户的类型
     * 注意：该方法仅限于 web 相关的 framework 组件使用！！！
     *
     * @param request 请求
     * @return 用户编号
     */
    public static Integer getLoginUserType(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        // 1. 优先，从 Attribute 中获取
        Integer userType = (Integer) request.getAttribute(REQUEST_ATTRIBUTE_LOGIN_USER_TYPE);
        if (userType != null) {
            return userType;
        }
        // 2. 其次，基于 URL 前缀的约定
        if (request.getRequestURI().startsWith(properties.getAdminApi().getPrefix())) {
            return UserTypeEnum.ADMIN.getValue();
        }
        if (request.getRequestURI().startsWith(properties.getAppApi().getPrefix())) {
            return UserTypeEnum.MEMBER.getValue();
        }
        return null;
    }

    public static CommonResult<?> getCommonResult(ServletRequest request) {
        return (CommonResult<?>) request.getAttribute(REQUEST_ATTRIBUTE_COMMON_RESULT);
    }
}
