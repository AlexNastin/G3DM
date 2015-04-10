package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.DisProgram;

public interface IDisProgramDAO {
	
	public void update(DisProgram disProgram);

	public void add(DisProgram disProgram);

	public List<DisProgram> getAllDisPrograms();

	public void remove(Integer id);

}
