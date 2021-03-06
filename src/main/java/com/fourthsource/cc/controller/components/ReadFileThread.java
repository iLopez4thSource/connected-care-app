package com.fourthsource.cc.controller.components;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fourthsource.cc.controller.services.UploadFileService;
import com.fourthsource.cc.controller.utils.FileManager;
import com.fourthsource.cc.domain.CSVDetailEntity;
import com.fourthsource.cc.domain.CSVHeadEntity;
import com.fourthsource.cc.domain.properties.FileTitleHeaderProperties;
import com.fourthsource.cc.domain.properties.FileUploadProperties;
import com.fourthsource.cc.model.services.CSVDetailManager;
import com.fourthsource.cc.model.services.CSVHeadManager;

public class ReadFileThread extends Thread {
	
	private final static Logger logger = LoggerFactory.getLogger(UploadFileService.class);
	
	@Autowired
	private FileUploadProperties fileUploadProperties;
	
	@Autowired
	private CSVFileManager csvFileManager;
	
	@Autowired
	private CSVHeadManager csvHeadManager;
	
	@Autowired
	private CSVDetailManager csvDetailManager;
	
	private int idFile;
	private int rowsInFile;
	private int rowsLoaded;
	
	public int getIdFile() {
		return idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}

	public int getRowsInFile() {
		return rowsInFile;
	}

	public void setRowsInFile(int rowsInFile) {
		this.rowsInFile = rowsInFile;
	}

	public int getRowsLoaded() {
		return rowsLoaded;
	}

	public void setRowsLoaded(int rowsLoaded) {
		this.rowsLoaded = rowsLoaded;
	}
	
	@Override
	public void run() {
		logger.info("Thread '" + this.getName() + "' is running, idFile = " + this.idFile);
		this.rowsLoaded = 0;
		
		try {
			CSVHeadEntity entity = csvHeadManager.getCSVHead(this.idFile);
			File file = new File(fileUploadProperties.getPath() + entity.getCsvName());
			List<FileTitleHeaderProperties> fileHeaders = csvFileManager.getTitleHeadersFromProperties();
			List<String> fileData = FileManager.readFile(file);
			List<CSVDetailEntity> data = csvFileManager.getFileData(fileData, fileHeaders);
			
			for(CSVDetailEntity row : data) {
				row.setCsvId(entity);
				Integer idRow = csvDetailManager.saveCSVDetail(row);
				this.rowsLoaded++;
				logger.debug("ID generated for row: " + idRow);	
			}
			
			this.rowsInFile = fileData.size();
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		logger.info("Thread '" + this.getName() + "' was ended, idFile = " + this.idFile);
	}
	
}
