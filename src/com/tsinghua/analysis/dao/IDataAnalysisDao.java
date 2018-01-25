package com.tsinghua.analysis.dao;

import java.util.List;
import java.util.Map;

import com.tsinghua.analysis.model.DataAnalysis;

public interface IDataAnalysisDao {

	int insert(DataAnalysis data);
	
	int insertSelective(DataAnalysis data);
	
	int updateByPrimaryKeySelective(DataAnalysis data);
	
	DataAnalysis selectByPrimaryKey(String daid);
	
	/*查询个体测试记录*/
	List<DataAnalysis> selectRecord(Map<String, Object> map);
}
