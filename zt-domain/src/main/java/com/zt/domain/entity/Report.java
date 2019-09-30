
package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatis.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 包名       com.mybatis.plus.entity
 * 文件名:    Report
 * 创建时间:  2019-09-30
 * 描述:      实体类
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_report")
@ApiModel(value = "Report对象", description = "Report对象")
public class Report extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String shopName;

    /**
     * 门店电话
     */
    @ApiModelProperty(value = "门店电话")
    private String shopPhone;

    /**
     * 举报类型：0线下(默认)，1线上
     */
    @ApiModelProperty(value = "举报类型：0线下(默认)，1线上")
    private Integer reportType;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    /**
     * 商品售价（元）
     */
    @ApiModelProperty(value = "商品售价（元）")
    private BigDecimal goodsPrice;

    /**
     * 举报时间（yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty(value = "举报时间（yyyy-MM-dd HH:mm:ss）")
    private LocalDateTime reportTime;

    /**
     * 审核状态：0待审核，1审核有效，2审核无效
     */
    @ApiModelProperty(value = "审核状态：0待审核，1审核有效，2审核无效")
    private Integer status;

    /**
     * 被举报门店
     */
    @ApiModelProperty(value = "被举报门店")
    private String reportedStore;

    /**
     * 被举报门店地址
     */
    @ApiModelProperty(value = "被举报门店地址")
    private String reportedStoreAddress;

    /**
     * 被举报平台
     */
    @ApiModelProperty(value = "被举报平台")
    private String reportedPlatform;

    /**
     * 被举报账号
     */
    @ApiModelProperty(value = "被举报账号")
    private String reportedAccount;

    /**
     * 源码照片
     */
    @ApiModelProperty(value = "源码照片")
    private String sourcePicture;

    /**
     * 陈列商品照片
     */
    @ApiModelProperty(value = "陈列商品照片")
    private String showPicture;

    /**
     * 购买商品轨迹图
     */
    @ApiModelProperty(value = "购买商品轨迹图")
    private String buyPicture;

    /**
     * 数据提交类型：0 PC端(默认)，1 APP端
     */
    @ApiModelProperty(value = "数据提交类型：0 PC端(默认)，1 APP端")
    private Integer commit;

    /**
     * 备注说明
     */
    @ApiModelProperty(value = "备注说明")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updateUser;

    /**
     * 删除标记：0有效(默认），1删除
     */
    @ApiModelProperty(value = "删除标记：0有效(默认），1删除")
    private Integer isDeleted;


}
