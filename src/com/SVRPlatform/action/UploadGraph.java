package com.SVRPlatform.action;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadGraph extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File graph;
	private String graphContentType;
	private String graphFileName;
	private String uploadPath;
	private String message;
	
	public File getGraph() {
		return graph;
	}

	public void setGraph(File graph) {
		this.graph = graph;
	}

	public String getGraphContentType() {
		return graphContentType;
	}

	public void setGraphContentType(String graphContentType) {
		this.graphContentType = graphContentType;
	}

	public String getGraphFileName() {
		return graphFileName;
	}

	public void setGraphFileName(String graphFileName) {
		this.graphFileName = graphFileName;
	}

	public String getMessage() {
		return message;
	}
	
	
	public String execute() throws Exception {
		
		uploadPath= ServletActionContext.getServletContext()
				.getRealPath("/upload");
		System.out.println(uploadPath);
		
		if(graph !=null){
			File savefile = new File(new File(uploadPath), graphFileName);
			if(!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
		
			if(graph.length()>2097152){
				message="graphTooBig";
				return "FileUploadFailed";
			}
			if(!graphContentType.equals("image/png") && !graphContentType.equals("image/bmp") && !graphContentType.equals("image/jpg")){ 
				message="graphWrongType";
				return "FileUploadFailed";
			}
			if(message==null){		
				FileUtils.copyFile(graph,savefile);
				return "FileUploadSuccess";
			}
			 System.out.println(graph.length());
		}
		else {
			message="graphIsNull";
			return "FileUploadFailed";
		}
		return "FileUploadSuccess";
	}
}