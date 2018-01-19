package com.tsinghua.vo;

import java.text.SimpleDateFormat;

import com.tsinghua.analysis.model.DataAnalysis;

import net.sf.json.JSONObject;

public class ForecastVo {

	/*预测分数*/
	private String forecastScore;
	
	/*网络状态*/
	private String networkStatus;
	
	/*地理位置*/
	private String location;
	
	/*测试时间*/
	private String testDate;
	
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

	public ForecastVo getScore(DataAnalysis data){
		ForecastVo fv = new ForecastVo();
		fv.forecastScore = data.getForecastScore();
		fv.networkStatus = data.getNetworkStatus();
		fv.location = data.getAddress();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		fv.testDate = dd.format(data.getStartTime());
		return fv;
	}
	
	public JSONObject toJson(ForecastVo vo) {
		JSONObject json = new JSONObject();
		json.put("forecastScore", vo.getForecastScore());
		json.put("networkStatus", vo.getNetworkStatus());
		json.put("location", vo.getLocation());
		json.put("testDate", vo.getTestDate());
		return json;
	}
}
