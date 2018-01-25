package com.tsinghua.analysis.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @description:查询个体数据地图详情
 * @author sunchenlong
 * @time:2018年1月25日14点38分
 */
@WebService(targetNamespace = "http://mapService.service.analysis.tsinghua.com/", name = "IQueryMapService", serviceName = "IQueryMapService")
public interface IQueryMapService {

	@WebResult(name="return",targetNamespace="http://mapService.service.analysis.tsinghua.com/")
	@WebMethod
	String map(@WebParam(name = "param", targetNamespace = "http://mapService.service.analysis.tsinghua.com/")String param);
}
