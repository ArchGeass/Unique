package com.tsinghua.vo;

import com.tsinghua.analysis.model.DataAnalysis;

import net.sf.json.JSONObject;

public class ScoreSuggestVO {

	/* 数据主键 */
	private String daId;
	
	/*用户对预测分数的建议*/
	private String scoreSuggest;
	
	public String getDaId() {
		return daId;
	}

	public String getScoreSuggest() {
		return scoreSuggest;
	}

	public ScoreSuggestVO(String param){
		JSONObject obj = JSONObject.fromObject(param);
		daId = obj.getString("daId");
		scoreSuggest = obj.getString("scoreSuggest");
	}
	
	public DataAnalysis updateSuggest(ScoreSuggestVO vo){
		DataAnalysis analysisData = new DataAnalysis();
		analysisData.setScoreSuggest(vo.getScoreSuggest());
		analysisData.setDaId(vo.getDaId());
		return analysisData;
	}
}
