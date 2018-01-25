package com.tsinghua.analysis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IQueryRecordService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.RecordVO;

import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://recordService.service.analysis.tsinghua.com/", name = "IQueryRecordService", serviceName = "IQueryRecordService")
public class QueryRecordServiceImpl implements IQueryRecordService {

	private static Logger logger = Logger.getLogger(QueryRecordServiceImpl.class);

	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;

	@WebResult(name = "return", targetNamespace = "http://recordService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String record(String param) {
		RecordVO vo = new RecordVO(param);
		Map<String, Object> map = new HashMap<String, Object>();
		List<DataAnalysis> list = null;
		JSONObject resultJson = new JSONObject();
		try {
			if (vo.getSign().equals("1")) {
				map.put("udid", vo.getUuid());
				list = iDataAnalysisDao.selectRecord(map);
			} else {
				map.put("imsi", vo.getUuid());
				list = iDataAnalysisDao.selectRecord(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		Double score;
		if (list.size() == 0) {
			return ResultJson.error(null);
		}
		for (DataAnalysis data : list) {
			// 无预测分数的数据不进行展示
			if (data.getForecastScore() != null && !data.getForecastScore().isEmpty()) {
				resultJson.put("uuid", data.getDaId());
				resultJson.put("videoStartTime", data.getStartTime());
				score = Double.parseDouble(data.getForecastScore());
				if (score > 3) {
					resultJson.put("status", "良好");
				} else if (score > 1) {
					resultJson.put("status", "一般");
				} else {
					resultJson.put("status", "较差");
				}
			}
		}
		return ResultJson.success(resultJson);
	}

}
