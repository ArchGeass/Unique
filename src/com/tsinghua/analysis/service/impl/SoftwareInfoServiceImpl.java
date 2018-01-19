package com.tsinghua.analysis.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.tsinghua.analysis.dao.ISoftwareInfoDao;
import com.tsinghua.analysis.model.SoftwareInfo;
import com.tsinghua.analysis.service.ISoftwareInfoService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.DataId;
import com.tsinghua.vo.SoftwareInfoVO;

import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://SoftwareInfoService.service.analysis.tsinghua.com/", name = "ISoftwareInfoService", serviceName = "ISoftwareInfoService")
public class SoftwareInfoServiceImpl implements ISoftwareInfoService{

	private static Logger logger = Logger.getLogger(SoftwareInfoServiceImpl.class);
	
	private ISoftwareInfoDao iSoftwareInfoDao;
	
	@WebResult(name="return",targetNamespace="http://SoftwareInfoService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String getInfo(String param) {
		DataId id = new DataId(param);
		SoftwareInfo info = new SoftwareInfo();
		JSONObject resultJson = new JSONObject();
		try {
			info = iSoftwareInfoDao.selectByPrimaryKey(Integer.parseInt(id.getPrimaryKey()));
			SoftwareInfoVO infoVo = new SoftwareInfoVO(info.getMessage());
			resultJson = infoVo.toJson(infoVo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		return ResultJson.success(resultJson);
	}

}
