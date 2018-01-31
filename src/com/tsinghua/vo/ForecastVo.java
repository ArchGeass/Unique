package com.tsinghua.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.tsinghua.analysis.model.DataAnalysis;

import net.sf.json.JSONObject;

/*预测分数交互模型*/
public class ForecastVo {

	private String uuid;

	/* 预测分数 */
	private String forecastScore;

	/* 网络状态 */
	private String networkStatus;

	/* 地理位置 */
	private String location;

	/* 测试时间 */
	private String testDate;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getForecastScore() {
		return forecastScore;
	}

	public void setForecastScore(String forecastScore) {
		this.forecastScore = forecastScore;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public ForecastVo getScore(DataAnalysis data) {
		ForecastVo fv = new ForecastVo();
		fv.setUuid(data.getDaId());
		fv.forecastScore = data.getForecastScore();
		fv.networkStatus = data.getNetworkStatus();
		fv.location = data.getAddress();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		fv.testDate = dd.format(data.getStartTime());
		return fv;
	}

	public JSONObject toJson(ForecastVo vo) {
		JSONObject json = new JSONObject();
		json.put("uuid", vo.getUuid());// 数据id
		// json.put("forecastScore", vo.getForecastScore());
		// need网络状态判断标准
		// json.put("networkStatus", "网络状态一般\n打败了全国" + vo.getNetworkStatus() +
		// "的用户");
		// json.put("location", vo.getLocation());
		// json.put("testDate", vo.getTestDate());

		// 在没有使用python预测时的模拟返回值
		Random random = new Random();
		Integer rand = random.nextInt(5) % (5) + 1;
		Integer rand2 = random.nextInt(90) % (10) + 1;
		json.put("forecastScore", rand.toString());// 预测分数
		json.put("networkStatus", "网络状态一般\n打败了全国" + rand2.toString() + "%的用户");// 网络状态
		json.put("location", "江苏南通崇川区工农路6号");// 地理位置
		SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		json.put("testDate", dd.format(new Date()));// 测试时间
		return json;
	}
}
