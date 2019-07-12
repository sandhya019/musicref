package com.cg.media.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class MediaComposerExceptionHandler {
private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	
    @ExceptionHandler(value = MediaComposerManagementSystemException.class)  
    public ResponseEntity<MediaComposerManagementSystemException> handleBaseException(MediaComposerManagementSystemException e){     	
    	
    	slf4jLogger.error("Checked exception occurred",e);
    	MediaComposerManagementSystemException result = new MediaComposerManagementSystemException(e.getCode(), e.getMessage());
    	if(e.getCode() == 204) {
    		return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
    	}
    		else {
			 
    		return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
    	}

    } 


}
