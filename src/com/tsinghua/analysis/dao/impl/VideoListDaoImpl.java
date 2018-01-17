package com.tsinghua.analysis.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsinghua.analysis.dao.IVideoListDao;
import com.tsinghua.analysis.model.VideoList;

@Repository
public class VideoListDaoImpl implements IVideoListDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insert(VideoList record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getAllVideoName() {
		return sqlSessionTemplate.getMapper(IVideoListDao.class).getAllVideoName();
	}

}
