package com.zt.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Description: 封装状态码
 *
 * @Date 2019/12/16 15:10
 * @Author Zeti
 */
@Getter
@AllArgsConstructor
public enum ResultEnum implements Serializable {

    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),

    /**
     * 业务异常
     */
    FAILURE(-1, "业务异常"),

    /**
     * 暂无数据
     */
    NO_DATA(0, "暂无数据"),

    /**
     * 404 没找到请求
     */
    NOT_FOUND(404, "404 没找到请求"),


    /**
     * 不支持当前请求方法
     */
    METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),

    /**
     * 不支持当前媒体类型
     */
    MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),

    /**
     * 请求被拒绝
     */
    REQ_REJECT(403, "请求被拒绝"),

    /**
     * 服务器异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器异常"),

    /**
     * 缺少必要的请求参数
     */
    PARAM_MISS(400, "缺少必要的请求参数"),

    /**
     * 请求参数类型错误
     */
    PARAM_TYPE_ERROR(400, "请求参数类型错误"),
    /**
     * 消息不能读取
     */
    MSG_NOT_READABLE(400, "消息不能读取"),
    /**
     * 请求参数绑定错误
     */
    PARAM_BIND_ERROR(400, "请求参数绑定错误"),

    /**
     * 参数校验失败
     */
    PARAM_VALID_ERROR(400, "参数校验失败"),

    /**
     * 请求未授权
     */
    UN_AUTHORIZED(666, "请求未授权");

    /**
     * code编码
     */
    final int code;
    /**
     * 中文信息描述
     */
    final String message;
}
