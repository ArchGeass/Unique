package com.tsinghua.utils;

import net.sf.json.JSONObject;

/*数据展示详情接口内部返回json模板*/
public class DetailJson {
	public String toString(String title, String score, Integer type){
		JSONObject json = new JSONObject();
		json.put("title", title);
		if(score != null && !score.isEmpty()){
			json.put("score", score);
		}else{
			json.put("score", "");
		}
		json.put("type", type.toString());
		return json.toString();
	}
}
