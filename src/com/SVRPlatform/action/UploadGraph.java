package com.SVRPlatform.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SVRPlatform.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class UploadGraph extends ActionSupport  implements ServletRequestAware,		//sign up~ register
ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File graph;
	private String graphContentType;
	private String graphFileName;
	private String uploadPath;
	private String message;
	private InputStream inputStream;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

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

		uploadPath = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		System.out.println(uploadPath);
		if (graph != null) {
			int indexOfDot = graphFileName.indexOf('.');
			String prefix = "Temp";
			String suffix = graphFileName.substring(indexOfDot);
			System.out.println(request.getSession().getId() + suffix);
			graphFileName = prefix + request.getSession().getId() + suffix;
			File savefile = new File(new File(uploadPath), graphFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();

			// if (graph.length() > 2097152) {
			// message = "graphTooBig";
			// return Constants.FAIL;
			// }
			if (!graphContentType.equals("image/png")
					&& !graphContentType.equals("image/bmp")
					&& !graphContentType.equals("image/jpg")
					&& !graphContentType.equals("image/jpeg")) {
				message = "graphWrongType";
			}
			FileUtils.copyFile(graph, savefile);
			String address = "upload/" + savefile.getName();
			inputStream = new ByteArrayInputStream(address.getBytes("UTF-8"));
			return Constants.SUCCESS;

		} else {
			message = "graphIsNull";
			System.out.println("message = " + message);
			return Constants.FAIL;
		}

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
}