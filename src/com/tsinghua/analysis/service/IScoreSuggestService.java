package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:用户提交测试建议分数
 * @author sunchenlong
 * @time:2018年1月19日10点29分
 */
@WebService(targetNamespace = "http://scoreSuggest.service.analysis.tsinghua.com/", name = "IScoreSuggestService", serviceName = "IScoreSuggestService")
public interface IScoreSuggestService {

	@WebResult(name="return",targetNamespace="http://scoreSuggest.service.analysis.tsinghua.com/")
	@WebMethod
	String suggest(@WebParam(name = "param", targetNamespace = "http://scoreSuggest.service.analysis.tsinghua.com/")String param);
}
