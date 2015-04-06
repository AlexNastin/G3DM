package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.File;

public interface IFileDAO {
	
	public void update(File file);

	public void add(File file);

	public List<File> getAllFiles();

	public void remove(Integer id);

}
