package com.cg.media.exception;

public class MediaComposerManagementSystemException extends RuntimeException{

	
	private static final long serialVersionUID = -3737130698911056028L;
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MediaComposerManagementSystemException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public MediaComposerManagementSystemException() {
		super();
	}
	
	
}
