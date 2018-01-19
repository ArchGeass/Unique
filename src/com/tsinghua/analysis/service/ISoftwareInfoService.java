package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:获取软件信息
 * @author sunchenlong
 * @time:2018年1月19日16点51分
 */
@WebService(targetNamespace = "http://SoftwareInfoService.service.analysis.tsinghua.com/", name = "ISoftwareInfoService", serviceName = "ISoftwareInfoService")
public interface ISoftwareInfoService {

	@WebResult(name="return",targetNamespace="http://SoftwareInfoService.service.analysis.tsinghua.com/")
	@WebMethod
	String getInfo(@WebParam(name = "param", targetNamespace = "http://SoftwareInfoService.service.analysis.tsinghua.com/")String param);
}
