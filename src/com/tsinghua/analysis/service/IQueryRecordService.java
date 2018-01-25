package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:查询个体测试记录
 * @author sunchenlong
 * @time:2018年1月24日17点12分
 */
@WebService(targetNamespace = "http://recordService.service.analysis.tsinghua.com/", name = "IQueryRecordService", serviceName = "IQueryRecordService")
public interface IQueryRecordService {

	@WebResult(name="return",targetNamespace="http://recordService.service.analysis.tsinghua.com/")
	@WebMethod
	String record(@WebParam(name = "param", targetNamespace = "http://recordService.service.analysis.tsinghua.com/")String param);
}
