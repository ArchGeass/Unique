package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:查询测试数据详情
 * @author sunchenlong
 * @time:2018年1月19日15点58分
 */
@WebService(targetNamespace = "http://detailService.service.analysis.tsinghua.com/", name = "IQueryDetailService", serviceName = "IQueryDetailService")
public interface IQueryDetailService {

	@WebResult(name="return",targetNamespace="http://detailService.service.analysis.tsinghua.com/")
	@WebMethod
	String detail(@WebParam(name = "param", targetNamespace = "http://detailService.service.analysis.tsinghua.com/")String param);
}
