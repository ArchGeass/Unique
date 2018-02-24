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

import net.sf.json.JSONArray;

@WebService(targetNamespace = "http://scoreSuggest.service.analysis.tsinghua.com/", name = "IScoreSuggestService", serviceName = "IScoreSuggestService")
public class ScoreSuggestServiceImpl implements IScoreSuggestService{

	private static Logger logger = Logger.getLogger(ScoreSuggestServiceImpl.class);
	
	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;
	
	@WebResult(name="return",targetNamespace="http://scoreSuggest.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String suggest(String param) {
		ScoreSuggestVO vo = new ScoreSuggestVO(JSONArray.fromObject(param).getString(0));
		DataAnalysis analysisModel = vo.updateSuggest(vo);
		try {
			//需要增加已有分数的判断,没有分数才可以进行提交
			DataAnalysis scoreFlag = iDataAnalysisDao.selectByPrimaryKey(vo.getDaId());
			if(scoreFlag.getScoreSuggest() != null && !scoreFlag.getScoreSuggest().isEmpty()){
				return ResultJson.success(null);//已有分数时不进行数据覆盖
			}
			iDataAnalysisDao.updateByPrimaryKeySelective(analysisModel);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(null);
	}

}
