package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.File;

public interface IFileDAO {
	
	public void update(File file);

	public void add(File file);

	public List<File> getAllFiles();

	public void remove(Integer id);

}
