package com.tsinghua.analysis.service.impl;

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
import com.tsinghua.analysis.service.IQueryMapService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.RecordVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://mapService.service.analysis.tsinghua.com/", name = "IQueryMapService", serviceName = "IQueryMapService")
public class QueryMapServiceImpl implements IQueryMapService {

	private static Logger logger = Logger.getLogger(QueryMapServiceImpl.class);

	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;

	@WebResult(name = "return", targetNamespace = "http://mapService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String map(String param) {
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
		List<String> gpslist = new ArrayList<String>();
		for (DataAnalysis data : list) {
			gpslist.add(formatGps(data.getGpsLongitudeOne(),data.getGpsLatitudeOne()));
		}
		resultJson.put("gpslist", gpslist);
		return ResultJson.success(resultJson);
	}
	
	public String formatGps(String longitude, String Latitude){
		JSONObject json = new JSONObject();
		if(longitude != null && !longitude.isEmpty()){
			json.put("longitude", longitude);
		}else{
			json.put("longitude", "");
		}
		if(Latitude != null && !Latitude.isEmpty()){
			json.put("Latitude", Latitude);
		}else{
			json.put("Latitude", "");
		}
		return json.toString();
	}

}
