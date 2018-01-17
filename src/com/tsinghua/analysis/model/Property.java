package com.tsinghua.analysis.model;

import java.util.Date;
/**
 * @description:软件信息属性表
 * @author sunchenlong
 * @time:2018年1月17日20点34分
 */
public class Property {

	/*主键*/
	private Integer id;
	
	/*概要*/
	private String summary;
	
	/*内容*/
	private String message;
	
	/*更新时间*/
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
