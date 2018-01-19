package com.tsinghua.analysis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;

@Repository
public class DataAnalysisDaoImpl implements IDataAnalysisDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insert(DataAnalysis data) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).insert(data);
	}

	@Override
	public int insertSelective(DataAnalysis data) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).insertSelective(data);
	}

	@Override
	public int updateByPrimaryKeySelective(DataAnalysis data) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).updateByPrimaryKeySelective(data);
	}
}
