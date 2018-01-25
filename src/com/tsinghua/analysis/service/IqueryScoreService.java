package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:查询建议分数
 * @author sunchenlong
 * @time:2018年1月19日14点17分
 */
@WebService(targetNamespace = "http://queryScore.service.analysis.tsinghua.com/", name = "IQueryScoreService", serviceName = "IQueryScoreService")
public interface IQueryScoreService {

	@WebResult(name="return",targetNamespace="http://queryScore.service.analysis.tsinghua.com/")
	@WebMethod
	String queryScore(@WebParam(name = "param", targetNamespace = "http://queryScore.service.analysis.tsinghua.com/")String param);
}
