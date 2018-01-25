package com.tsinghua.vo;

import net.sf.json.JSONObject;

/*软件信息交互模型*/
public class SoftwareInfoVO {

	/*内容*/
	private String info;
	
	public String getInfo() {
		return info;
	}
	
	public SoftwareInfoVO(String message){
		info = message;
	}

	public JSONObject toJson(SoftwareInfoVO vo){
		JSONObject json = new JSONObject();
		json.put("info", vo.getInfo());
		return json;
	}
}
