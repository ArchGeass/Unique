package com.tsinghua.analysis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.IPropertyDao;

@Repository
public class PropertyDaoImpl implements IPropertyDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
}
