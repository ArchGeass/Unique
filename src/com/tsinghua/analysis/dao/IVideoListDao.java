package com.tsinghua.analysis.dao;

import java.util.List;

import com.tsinghua.analysis.model.VideoList;

public interface IVideoListDao {

	int insert(VideoList record);
	
	List<String> getAllVideoName();
}
