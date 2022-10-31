package com.keyrequests.consumer.model;


public class KeyObject {


	private long idkey;
	private String keycontent;
	private String serialnumber;
	private long keystate;

	public long getIdkey() {
		return idkey;
	}

	public void setIdkey(long idkey) {
		this.idkey = idkey;
	}

	public String getKeycontent() {
		return keycontent;
	}

	public void setKeycontent(String keycontent) {
		this.keycontent = keycontent;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public long getKeystate() {
		return keystate;
	}

	public void setKeystate(long keystate) {
		this.keystate = keystate;
	}
	
}
