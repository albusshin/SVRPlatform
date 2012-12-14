/*
 * $Id: HelloWorld.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package Junit.test.Jingxuan;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



/**
 * <code>Set welcome message.</code>
 */
public class Upload extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream inputStream;

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


	public InputStream getInputStream() {
		return inputStream;
	}



	public String execute() throws Exception {
		uploadPath= ServletActionContext.getServletContext()
				.getRealPath("/upload");
		System.out.println(uploadPath);
		if(graph !=null){
			File savefile = new File(new File(uploadPath), graphFileName);
			if(!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
		
			if(!graphContentType.equals("image/png") && 
					!graphContentType.equals("image/bmp") && 
					!graphContentType.equals("image/jpg") &&
					!graphContentType.equals("image/jpeg") ){ 
				message="graphWrongType";
			}
			else if(message==null){		
				FileUtils.copyFile(graph,savefile);
				message = "<img src=\"upload/" + savefile.getName() + "\"/>";
			}
			 System.out.println(graph.length());
		}
		else {
			message="graphIsNull";
		}
    	inputStream = new ByteArrayInputStream(message.getBytes("utf-8"));
        return SUCCESS;
    }
    
}
