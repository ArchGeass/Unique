package com.tsinghua.utils;

import com.tsinghua.enums.StatusCode;

import net.sf.json.JSONObject;

public class ResultJson {

	public static String success(JSONObject json){
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", StatusCode.SUCCESS_CODE);
		resultJson.put("message", StatusCode.SUCCESS_MESSAGE);
		resultJson.put("resultjson", json);
		return resultJson.toString();
	}
	
	public static String error(JSONObject json){
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", StatusCode.FAIL_CODE);
		resultJson.put("message", StatusCode.FAIL_MESSAGE);
		resultJson.put("resultjson", json);
		return resultJson.toString();
	}
}
