package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:删除某条数据
 * @author sunchenlong
 * @time:2018年1月25日14点09分
 */
@WebService(targetNamespace = "http://hideService.service.analysis.tsinghua.com/", name = "IHideDataService", serviceName = "IHideDataService")
public interface IHideDataService {

	@WebResult(name="return",targetNamespace="http://hideService.service.analysis.tsinghua.com/")
	@WebMethod
	String hide(@WebParam(name = "param", targetNamespace = "http://hideService.service.analysis.tsinghua.com/")String param);
}
