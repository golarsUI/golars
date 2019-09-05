package com.schoolapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeviceInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String deviceId;

	private String fcmToken;
	private String categories;
	private String platform;
	private List<Settings> settings = new ArrayList<Settings>();
	private String serverKey;
	private String testMode;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPlatform() {
		return platform;
	}

	public void setSettings(List<Settings> settings) {
		this.settings = settings;
	}
	public List<Settings> getSettings() {
		return settings;
	}
	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}
	public String getServerKey() {
		return serverKey;
	}
	public void setTestMode(String testMode) {
		this.testMode = testMode;
	}
	public String getTestMode() {
		return testMode;
	}
}
