package com.tsinghua.enums;

public enum StatusCode {

	SUCCESS_CODE("200"),
	FAIL_CODE("201"),
	SUCCESS_MESSAGE("请求成功"),
	FAIL_MESSAGE("请求失败")
	;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	StatusCode(String message){
		this.message = message;
	}
}
