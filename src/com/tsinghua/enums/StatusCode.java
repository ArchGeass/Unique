package com.tsinghua.enums;

/*状态提示枚举*/
public enum StatusCode {

	SUCCESS_CODE("200"),
	FAIL_CODE("201"),
	SUCCESS_MESSAGE("请求成功"),
	FAIL_MESSAGE("请求失败"),
//	PYTHON_FILE_PATH("D:\\unique_txt\\QoE\\Qoe\\Test.py")//windows_local
	PYTHON_FILE_PATH("/root/QoE/Test.py")//linux_12.16
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
