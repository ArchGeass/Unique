package com.tsinghua.utils;

import com.tsinghua.enums.StatusCode;

import net.sf.json.JSONObject;

/*标准数据返回模型*/
public class ResultJson {

	public static String success(JSONObject json){
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", StatusCode.SUCCESS_CODE.getMessage());
		resultJson.put("message", StatusCode.SUCCESS_MESSAGE.getMessage());
		resultJson.put("success_response_data", json);
		return resultJson.toString();
	}
	
	public static String error(JSONObject json){
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", StatusCode.FAIL_CODE.getMessage());
		resultJson.put("message", StatusCode.FAIL_MESSAGE.getMessage());
		resultJson.put("success_response_data", json);
		return resultJson.toString();
	}
}
