package com.zt.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * Description: 返回结果统一封装
 *
 * @Date 2019/12/16 14:43
 * @Author Zeti
 */
@Data
@ApiModel(description = "返回信息")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1371075464648844846L;

    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;
    @ApiModelProperty(value = "承载数据")
    private T data;
    @ApiModelProperty(value = "返回消息", required = true)
    private String msg;


    private Result(ResultEnum ResultEnum) {
        this(ResultEnum, null, ResultEnum.getMessage());
    }

    private Result(ResultEnum ResultEnum, String msg) {
        this(ResultEnum, null, msg);
    }

    private Result(ResultEnum ResultEnum, T data) {
        this(ResultEnum, data, ResultEnum.getMessage());
    }

    private Result(ResultEnum ResultEnum, T data, String msg) {
        this(ResultEnum.getCode(), data, msg);
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = ResultEnum.SUCCESS.code == code;
    }


    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable Result<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtils.nullSafeEquals(ResultEnum.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable Result<?> result) {
        return !Result.isSuccess(result);
    }


    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultEnum.SUCCESS, msg);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS, data);
    }

    /**
     * 返回R
     *
     * @param ResultEnum 业务代码
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(ResultEnum ResultEnum) {
        return new Result<>(ResultEnum);
    }

    /**
     * 返回R
     *
     * @param ResultEnum 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(ResultEnum ResultEnum, String msg) {
        return new Result<>(ResultEnum, msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResultEnum.FAILURE, msg);
    }


    /**
     * 返回R
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    /**
     * 返回R
     *
     * @param ResultEnum 业务代码
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(ResultEnum ResultEnum) {
        return new Result<>(ResultEnum);
    }

    /**
     * 返回R
     *
     * @param ResultEnum 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(ResultEnum ResultEnum, String msg) {
        return new Result<>(ResultEnum, msg);
    }


    public static <T> Result<T> noData() {
        return new Result<>(ResultEnum.NO_DATA);
    }


    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return Result
     */
    public static <T> Result<T> Data(T data) {
        return new Result<>(ResultEnum.SUCCESS, data);
    }

    /**
     * 返回R
     *
     * @param flag 成功状态
     * @return Result
     */
    public static <T> Result<T> status(boolean flag) {
        return flag ? success("操作成功") : fail("操作失败");
    }


}
