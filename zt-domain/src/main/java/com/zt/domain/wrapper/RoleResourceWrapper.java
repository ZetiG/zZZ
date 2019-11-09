package com.zt.domain.wrapper;

import com.mybatis.plus.support.BaseEntityWrapper;
import com.zt.domain.entity.RoleResource;
import com.zt.domain.vo.RoleResourceVO;
import lombok.AllArgsConstructor;

/**
 *
 * 包名   com.zt.mybatis.wrapper
 * 文件名:   RoleResourceWrapper
 * 创建时间:  2019-11-09
 * 描述:      包装类,返回视图层所需的字段
 *
 * @author Zeti
 */
@AllArgsConstructor
public class RoleResourceWrapper extends BaseEntityWrapper<RoleResource, RoleResourceVO> {


	@Override
	public RoleResourceVO entityVO(RoleResource entity) {
		return null;
	}
}
