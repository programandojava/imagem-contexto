package com.programandojava.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "uploadMB")
@ViewScoped
public class UploadController implements Serializable {
	private static final long serialVersionUID = 7475247398584602545L;

	private byte[] imageBytes;
	
	public void handlePictureUploaded(FileUploadEvent uploadEvent){
		this.imageBytes = uploadEvent.getFile().getContents(); 
	}

	//
	//	GETTERS / SETTERS
	//
	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
}