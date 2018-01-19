package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IScoreSuggestService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.ScoreSuggestVO;

import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://scoreSuggest.service.analysis.tsinghua.com/", name = "IScoreSuggestService", serviceName = "IScoreSuggestService")
public class ScoreSuggestServiceImpl implements IScoreSuggestService{

	private static Logger logger = Logger.getLogger(ScoreSuggestServiceImpl.class);
	
	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;
	
	@WebResult(name="return",targetNamespace="http://scoreSuggest.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String suggest(String param) {
		ScoreSuggestVO vo = new ScoreSuggestVO(param);
		DataAnalysis analysisModel = vo.updateSuggest(vo);
		JSONObject resultJson = new JSONObject();
		try {
			iDataAnalysisDao.updateByPrimaryKeySelective(analysisModel);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
