package com.SVRPlatform.dao;

import java.io.Serializable;

import com.SVRPlatform.model.Software;

public interface SoftwareDAO extends basicDAO{
	
	public Serializable getByName(String name);
	
	public Serializable addSoftware(Software software);
}
