package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.DisProgram;

public interface IDisProgramDAO {
	
	public void update(DisProgram disProgram);

	public void add(DisProgram disProgram);

	public List<DisProgram> getAllDisPrograms();

	public void remove(Integer id);

}
