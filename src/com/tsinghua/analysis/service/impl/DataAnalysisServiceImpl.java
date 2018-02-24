package com.tsinghua.analysis.service.impl;

import java.text.DecimalFormat;
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
import com.tsinghua.utils.JavaToPy;
import com.tsinghua.utils.ResultJson;
import com.tsinghua.vo.DataAnalysisVO;
import com.tsinghua.vo.scoreFormat;

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
			analysisModel.setForecastScore("3");// 模拟存储预测分数
			iDataAnalysisDao.insert(analysisModel);
			// 调用python
			JavaToPy py = new JavaToPy();
			String result = py.getPython(analysisModel.getBufferingDelay(), analysisModel.getVideoPlayTotalTime(),
					analysisModel.getKaDurationProportion(), analysisModel.getVideoBitrate(),
					formatvideoClarity(analysisModel.getVideoClarity()));
			// 处理返回数据
			String[] resultArray = null;
			if (result != null && !result.isEmpty()) {
				resultArray = result.split(",");
			} else {
				resultArray = new String[4];
				resultArray[0] = "vMOS=0.185852";
				resultArray[1] = "QualityScore=1.345928";
				resultArray[2] = "StallingScore=3.845956";
				resultArray[3] = "LoadingScroe=1.731890";
			}
			String vMOSScore = resultArray[0].replace("vMOS=", "");
			String QualityScore = resultArray[1].replace("QualityScore=", "");
			String StallingScore = resultArray[2].replace("StallingScore=", "");
			String LoadingScroe = resultArray[3].replace("LoadingScroe=", "");
			vMOSScore = formatScore(vMOSScore, true);
			QualityScore = formatScore(QualityScore, true);
			StallingScore = formatScore(StallingScore, true);
			LoadingScroe = formatScore(LoadingScroe, true);
			// 存储预测分数
			analysisModel.setForecastScore(vMOSScore);
			analysisModel.setEvMos(vMOSScore);
			analysisModel.setUserScore(QualityScore);
			analysisModel.setEstalling(StallingScore);
			analysisModel.setEloading(LoadingScroe);
			iDataAnalysisDao.updateByPrimaryKeySelective(analysisModel);

			vMOSScore = formatScore(vMOSScore, false);
			// 测试阶段生成随机数
			Random random = new Random();
			// Integer rand = random.nextInt(5) % (5) + 1;
			Integer rand2 = random.nextInt(95) % (66) + 30;
			JSONObject resultJson = new JSONObject();
			resultJson.put("uuid", uuid);// 数据id
			resultJson.put("forecastScore", vMOSScore);// 预测分数
			resultJson.put("networkStatus", "网络状态一般\n打败了全国" + rand2.toString() + "%的用户");// 网络状态
			resultJson.put("location", analysisModel.getAddress());// 地理位置
			SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			resultJson.put("testDate", dd.format(new Date()));// 测试时间
			return ResultJson.success(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return ResultJson.error(null);
		}
	}

	// 对数据做精度+范围处理
	private String formatScore(String str, Boolean flag) {
		DecimalFormat df = new DecimalFormat("0.0");
		Double number = Double.valueOf(str);
		if (flag) {
			return df.format(number);
		}
		return scoreFormat.vMOSFormat(number.toString());
	}

	// 格式化视频清晰度
	private String formatvideoClarity(String videoClarity) {
		if (videoClarity.equals("240")) {
			return "0";
		} else if (videoClarity.equals("360")) {
			return "1";
		} else if (videoClarity.equals("720")) {
			return "2";
		} else {
			return "3";
		}
	}

}
