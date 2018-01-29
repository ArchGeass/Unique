package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.ISoftwareInfoDao;
import com.tsinghua.analysis.model.SoftwareInfo;
import com.tsinghua.analysis.service.ISoftwareInfoService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.SoftwareInfoVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://softwareInfoService.service.analysis.tsinghua.com/", name = "ISoftwareInfoService", serviceName = "ISoftwareInfoService")
public class SoftwareInfoServiceImpl implements ISoftwareInfoService {

	private static Logger logger = Logger.getLogger(SoftwareInfoServiceImpl.class);

	@Autowired
	private ISoftwareInfoDao iSoftwareInfoDao;

	@WebResult(name = "return", targetNamespace = "http://softwareInfoService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String getInfo(String param) {
		JSONObject obj = JSONObject.fromObject(JSONArray.fromObject(param).getString(0));
		String mark = obj.getString("mark");
		SoftwareInfo info = new SoftwareInfo();
		JSONObject resultJson = new JSONObject();
		try {
			info = iSoftwareInfoDao.selectByPrimaryKey(Integer.parseInt(mark));
			SoftwareInfoVO infoVo = new SoftwareInfoVO(info.getMessage());
			resultJson = infoVo.toJson(infoVo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
