package com.tibudget.dto;

import java.io.Serializable;

public class PluginCollectorDto implements Serializable {

	private static final long serialVersionUID = -7926805471096621734L;

	private String id;
	
	private String bundleName;
	
	private String staticsContext;
	
	private String vendor;

	private String version;

	public PluginCollectorDto(String id, String bundleName,
			String staticsContext, String vendor, String version) {
		super();
		this.id = id;
		this.bundleName = bundleName;
		this.staticsContext = staticsContext;
		this.vendor = vendor;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public String getStaticsContext() {
		return staticsContext;
	}

	public void setStaticsContext(String staticsContext) {
		this.staticsContext = staticsContext;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
