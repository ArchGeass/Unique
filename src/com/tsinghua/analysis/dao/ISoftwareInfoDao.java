package com.tsinghua.analysis.dao;

import com.tsinghua.analysis.model.SoftwareInfo;

public interface ISoftwareInfoDao {

	public SoftwareInfo selectByPrimaryKey(Integer id);
}
