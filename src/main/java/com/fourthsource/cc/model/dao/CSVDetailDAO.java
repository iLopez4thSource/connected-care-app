package com.fourthsource.cc.model.dao;

import java.util.List;
import java.util.Set;

import com.fourthsource.cc.domain.CSVDetailEntity;

public interface CSVDetailDAO {
	
	public Set<CSVDetailEntity> getAllByCSVHeadId(Integer id);
	public List<CSVDetailEntity> getAllProcessedByCSVHeadId(Integer id);
    public Integer saveCSVDetail(CSVDetailEntity entity);
	public void deleteByCSVHeadId(Integer id);
	public void callSPGetPatientInfo();
	public void callSPClearDB();
	public void callSPReconciliation();
    
}