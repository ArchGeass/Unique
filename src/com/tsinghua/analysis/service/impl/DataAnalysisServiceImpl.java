package com.tsinghua.analysis.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

//import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsinghua.analysis.dao.IDataAnalysisDao;
import com.tsinghua.analysis.model.DataAnalysis;
import com.tsinghua.analysis.service.IDataAnalysisService;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.DataAnalysisVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(targetNamespace = "http://analysis.interfaces.service.webservice.tsinghua.com/", name = "IDataAnalysisService", serviceName = "IDataAnalysisService")
public class DataAnalysisServiceImpl implements IDataAnalysisService {

	private static Logger logger = Logger.getLogger(DataAnalysisServiceImpl.class);

	@Autowired
	private IDataAnalysisDao iDataAnalysisDao;

	@WebResult(name = "return", targetNamespace = "http://analysis.interfaces.service.webservice.tsinghua.com/")
	@WebMethod
	@Override
	public String insertData(String param) {
		try {
			DataAnalysisVO analysisData = new DataAnalysisVO(JSONArray.fromObject(param).getString(0));
			DataAnalysis analysisModel = analysisData.saveModel(analysisData);
			// DataAnalysis analysisModel = new DataAnalysis();
			// BeanUtils.copyProperties(analysisData,
			// analysisModel);//尝试使用copy方法
			String uuid = UUID.randomUUID().toString();
			analysisModel.setDaId(uuid);// 设置数据id
			analysisModel.setDisplay("1");// 设置为展示
			iDataAnalysisDao.insert(analysisModel);
			// 测试阶段生成随机数
			Random random = new Random();
			Integer rand = random.nextInt(5) % (5) + 1;
			Integer rand2 = random.nextInt(90) % (10) + 1;
			JSONObject resultJson = new JSONObject();
			resultJson.put("uuid", uuid);// 数据id
			resultJson.put("forecastScore", rand.toString());// 预测分数
			resultJson.put("networkStatus", "网络状态一般\n打败了全国" + rand2.toString() + "%的用户");// 网络状态
			resultJson.put("location", "江苏南通崇川区工农路6号");// 地理位置
			SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			resultJson.put("testDate", dd.format(new Date()));// 测试时间
			return ResultJson.success(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
	}

}
