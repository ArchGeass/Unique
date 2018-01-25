package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IQueryScoreService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.DataId;
import com.tsinghua.vo.ForecastVo;

import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://queryScore.service.analysis.tsinghua.com/", name = "IqueryScoreService", serviceName = "IqueryScoreService")
public class QueryScoreServiceImpl implements IQueryScoreService{

	private static Logger logger = Logger.getLogger(QueryScoreServiceImpl.class);
	
	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;
	
	@WebResult(name="return",targetNamespace="http://queryScore.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String queryScore(String param) {
		DataId id = new DataId(param);
		JSONObject resultJson = new JSONObject();
		ForecastVo forecast = new ForecastVo();
		DataAnalysis analysisModel = new DataAnalysis();
		try {
			analysisModel = iDataAnalysisDao.selectByPrimaryKey(id.getPrimaryKey());
			forecast = forecast.getScore(analysisModel);
			resultJson = forecast.toJson(forecast);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
