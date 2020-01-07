package com.zt.common.configuration;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2020/1/7 14:28
 * @Author Zeti
 */
public class Json {

    private final String value;

    public Json(String value) {
        this.value = value;
    }

    @JsonValue
    @JsonRawValue
    public String value() {
        return this.value;
    }
}
