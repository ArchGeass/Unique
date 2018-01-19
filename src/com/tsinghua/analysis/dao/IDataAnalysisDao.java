package com.tsinghua.analysis.dao;

import com.tsinghua.analysis.model.DataAnalysis;

public interface IDataAnalysisDao {

	int insert(DataAnalysis data);
	
	int insertSelective(DataAnalysis data);
	
	int updateByPrimaryKeySelective(DataAnalysis data);
	
	DataAnalysis selectByPrimaryKey(String daid);
}
