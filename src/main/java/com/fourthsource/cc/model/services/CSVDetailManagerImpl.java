package com.fourthsource.cc.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fourthsource.cc.domain.CSVDetailEntity;
import com.fourthsource.cc.model.dao.CSVDetailDAO;

@Service
public class CSVDetailManagerImpl implements CSVDetailManager {
	
	@Autowired
    private CSVDetailDAO csvDetailDAO;

	@Override
	@Transactional
	public List<CSVDetailEntity> getAllByCSVHeadId(Integer id) {
		return csvDetailDAO.getAllByCSVHeadId(id);
	}
	
	@Override
	@Transactional
	public Integer saveCSVDetail(CSVDetailEntity entity) {
		return csvDetailDAO.saveCSVDetail(entity);
	}
	
}
