package com.SVRPlatform.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadGraph extends ActionSupport {
	
	private String username;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String uploadPath;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	public String execute() throws Exception {
		
		InputStream is = new FileInputStream(myFile);
		uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File toFile = new File(uploadPath, this.getMyFileFileName());
		OutputStream os = new FileOutputStream(toFile);
		
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
		}
		System.out.println("上传用户"+username);
		System.out.println("上传文件名"+myFileFileName);
		System.out.println("上传文件类型"+myFileContentType);
		System.out.println("上传文件地址"+uploadPath);
		System.out.println("=========");
		
		is.close();
		os.close();
		return message;
	}



}
