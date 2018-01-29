package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IHideDataService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.DataId;

import net.sf.json.JSONArray;

@WebService(targetNamespace = "http://hideService.service.analysis.tsinghua.com/", name = "IHideDataService", serviceName = "IHideDataService")
public class HideDataServiceImpl implements IHideDataService{

	private static Logger logger = Logger.getLogger(HideDataServiceImpl.class);

	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;
	
	@WebResult(name="return",targetNamespace="http://hideService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String hide(String param) {
		DataId id = new DataId(JSONArray.fromObject(param).getString(0));
		DataAnalysis data = new DataAnalysis();
		data.setDaId(id.getPrimaryKey());
		data.setDisplay("0");
		try {
			iDataAnalysisDao.updateByPrimaryKeySelective(data);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(null);
	}
}
