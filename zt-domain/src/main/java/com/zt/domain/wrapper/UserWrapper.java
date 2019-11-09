package com.zt.domain.wrapper;

import com.mybatis.plus.support.BaseEntityWrapper;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import lombok.AllArgsConstructor;

/**
 *
 * 包名   com.zt.mybatis.wrapper
 * 文件名:   UserWrapper
 * 创建时间:  2019-11-09
 * 描述:      包装类,返回视图层所需的字段
 *
 * @author Zeti
 */
@AllArgsConstructor
public class UserWrapper extends BaseEntityWrapper<UserEntity, UserVO> {


	@Override
	public UserVO entityVO(UserEntity entity) {
		return null;
	}
}
