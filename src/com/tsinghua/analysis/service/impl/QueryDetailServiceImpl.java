package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IQueryDetailService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.AnalysisDetailVO;
import com.tsinghua.vo.DataId;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://detailService.service.analysis.tsinghua.com/", name = "IQueryDetailService", serviceName = "IQueryDetailService")
public class QueryDetailServiceImpl implements IQueryDetailService{

	private static Logger logger = Logger.getLogger(QueryDetailServiceImpl.class);
	
	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;
	
	@WebResult(name="return",targetNamespace="http://detailService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String detail(String param) {
		DataId id = new DataId(JSONArray.fromObject(param).getString(0));
		JSONObject resultJson = new JSONObject();
		AnalysisDetailVO advo = new AnalysisDetailVO();
		DataAnalysis analysisModel = new DataAnalysis();
		try {
			analysisModel = iDataAnalysisDao.selectByPrimaryKey(id.getPrimaryKey());
			advo = advo.getData(analysisModel);
			resultJson = advo.toJson(advo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
