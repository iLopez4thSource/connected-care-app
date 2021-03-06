package com.fourthsource.cc.domain.properties;

import java.io.Serializable;

import com.fourthsource.cc.domain.Message;

public class FileUploadProperties implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String path;
	private Message successMessage;
	private Message fileSizeExceeded;
	private Message fileEmpty;
	private Message generalException;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public Message getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(Message successMessage) {
		this.successMessage = successMessage;
	}

	public Message getFileSizeExceeded() {
		return fileSizeExceeded;
	}

	public void setFileSizeExceeded(Message fileSizeExceeded) {
		this.fileSizeExceeded = fileSizeExceeded;
	}

	public Message getFileEmpty() {
		return fileEmpty;
	}

	public void setFileEmpty(Message fileEmpty) {
		this.fileEmpty = fileEmpty;
	}

	public Message getGeneralException() {
		return generalException;
	}

	public void setGeneralException(Message generalException) {
		this.generalException = generalException;
	}

}
