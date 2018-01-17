package com.tsinghua.analysis.service.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IVideoListDao;
import com.tsinghua.analysis.service.IVideoListService;
import com.tsinghua.enums.URL;
import com.tsinghua.utils.ResultJson;

import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://videoListService.service.analysis.tsinghua.com/", name = "IVideoListService", serviceName = "IVideoListService")
public class VideoListServiceImpl implements IVideoListService{
	
	private static Logger logger = Logger.getLogger(VideoListServiceImpl.class);
	
	@Autowired
	private IVideoListDao iVideoListDao;

	@WebResult(name="return",targetNamespace="http://videoListService.service.analysis.tsinghua.com/")
	@WebMethod
	@Override
	public String videolist(String param) {
		JSONObject resultJson = new JSONObject();
		List<String> videoList = null;
		try {
			videoList = iVideoListDao.getAllVideoName();
			for(int i = 0; i < videoList.size(); i++){
				videoList.set(i, URL.IPAddress + videoList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
		resultJson.put("videoList", videoList);
		return ResultJson.success(resultJson);
	}

}
