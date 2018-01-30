package com.tsinghua.vo;

import net.sf.json.JSONObject;

public class RecordVO {

	/*手机类型标识*/
	private String sign;
	
	/*手机唯一性标识*/
	private String sole;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getSole() {
		return sole;
	}

	public void setSole(String sole) {
		this.sole = sole;
	}

	public RecordVO(String param){
		JSONObject obj = JSONObject.fromObject(param);
		sole = obj.getString("sole");
		sign = obj.getString("sign");
	}
}
