package com.tsinghua.analysis.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;

@Repository
public class DataAnalysisDaoImpl implements IDataAnalysisDao {

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

	@Override
	public DataAnalysis selectByPrimaryKey(String daid) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).selectByPrimaryKey(daid);
	}

	@Override
	public List<DataAnalysis> selectRecord(Map<String, Object> map) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).selectRecord(map);
	}

	@Override
	public List<DataAnalysis> selectMap(Map<String, Object> map) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).selectMap(map);
	}

	@Override
	public String selectAddressByGPS(Map<String, Object> map) {
		return sqlSessionTemplate.getMapper(IDataAnalysisDao.class).selectAddressByGPS(map);
	}
}
