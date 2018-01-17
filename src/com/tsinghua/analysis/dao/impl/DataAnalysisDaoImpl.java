package com.tsinghua.analysis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.IDataAnalysisDao;

@Repository
public class DataAnalysisDaoImpl implements IDataAnalysisDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
}
