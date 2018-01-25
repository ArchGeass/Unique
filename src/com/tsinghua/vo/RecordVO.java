package com.tsinghua.vo;

import net.sf.json.JSONObject;

public class RecordVO {

	/*手机类型标识*/
	private String sign;
	
	/*手机唯一性标识*/
	private String uuid;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public RecordVO(String param){
		JSONObject obj = JSONObject.fromObject(param);
		uuid = obj.getString("uuid");
		sign = obj.getString("sign");
	}
}
