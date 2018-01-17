package com.tsinghua.analysis.model;

import java.util.Date;

/**
 * @description:视频源列表
 * @author sunchenlong
 * @time:2018年1月17日15点22分
 */
public class VideoList {

	/*视频主键*/
	private Integer videoId;
	
	/*视频名称*/
	private String videoName;
	
	/*更新时间*/
	private Date updateDate;

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
