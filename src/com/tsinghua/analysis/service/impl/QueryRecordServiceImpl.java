package com.tsinghua.analysis.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import net.sf.json.JSONArray;
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
		RecordVO vo = new RecordVO(JSONArray.fromObject(param).getString(0));
		Map<String, Object> map = new HashMap<String, Object>();
		List<DataAnalysis> list = null;
		JSONObject resultJson = new JSONObject();
		try {
			if (vo.getSign().equals("1")) {
				map.put("udid", vo.getSole());
				list = iDataAnalysisDao.selectRecord(map);
			} else {
				map.put("imsi", vo.getSole());
				list = iDataAnalysisDao.selectRecord(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		Double score;
//		if (list.size() == 0) {
//			return ResultJson.error(null);
//		}
		List<JSONObject> recordList = new ArrayList<JSONObject>();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		for (DataAnalysis data : list) {
			// 无预测分数的数据不进行展示
			if (data.getForecastScore() != null && !data.getForecastScore().isEmpty()) {
				JSONObject tempJson = new JSONObject();
				tempJson.put("uuid", data.getDaId());
				tempJson.put("videoStartTime", dd.format(data.getStartTime()));
				score = Double.parseDouble(data.getForecastScore());
				if (score > 3) {
					tempJson.put("status", "良好");
				} else if (score > 1) {
					tempJson.put("status", "一般");
				} else {
					tempJson.put("status", "较差");
				}
				recordList.add(tempJson);
			}
		}
		resultJson.put("resultJson", recordList.toString());
		return ResultJson.success(resultJson);
	}

}
