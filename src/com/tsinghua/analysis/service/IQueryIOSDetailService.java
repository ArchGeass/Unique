package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:ios查询测试数据详情
 * @author sunchenlong
 * @time:2018年1月31日16点30分
 */
@WebService(targetNamespace = "http://iosDetailService.service.analysis.tsinghua.com/", name = "IQueryIOSDetailService", serviceName = "IQueryIOSDetailService")
public interface IQueryIOSDetailService {

	@WebResult(name="return",targetNamespace="http://iosDetailService.service.analysis.tsinghua.com/")
	@WebMethod
	String detail(@WebParam(name = "param", targetNamespace = "http://iosDetailService.service.analysis.tsinghua.com/")String param);
}
