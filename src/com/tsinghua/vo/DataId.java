package com.tsinghua.vo;

import net.sf.json.JSONObject;

/*数据ID交互模型*/
public class DataId {

	private String primaryKey;
	
	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public DataId(String param){
		JSONObject obj = JSONObject.fromObject(param);
		primaryKey = obj.getString("uuid");
	}
}
