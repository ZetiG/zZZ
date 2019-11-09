package com.zt.domain.wrapper;

import com.mybatis.plus.support.BaseEntityWrapper;
import com.zt.domain.entity.UserRole;
import com.zt.domain.vo.UserRoleVO;
import lombok.AllArgsConstructor;

/**
 *
 * 包名   com.zt.mybatis.wrapper
 * 文件名:   UserRoleWrapper
 * 创建时间:  2019-11-09
 * 描述:      包装类,返回视图层所需的字段
 *
 * @author Zeti
 */
@AllArgsConstructor
public class UserRoleWrapper extends BaseEntityWrapper<UserRole, UserRoleVO> {


	@Override
	public UserRoleVO entityVO(UserRole entity) {
		return null;
	}
}
