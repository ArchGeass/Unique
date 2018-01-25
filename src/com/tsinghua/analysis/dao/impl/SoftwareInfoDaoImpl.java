package com.tsinghua.analysis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.ISoftwareInfoDao;
import com.tsinghua.analysis.model.SoftwareInfo;

@Repository
public class SoftwareInfoDaoImpl implements ISoftwareInfoDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public SoftwareInfo selectByPrimaryKey(Integer id) {
		return sqlSessionTemplate.getMapper(SoftwareInfoDaoImpl.class).selectByPrimaryKey(id);
	}
}
