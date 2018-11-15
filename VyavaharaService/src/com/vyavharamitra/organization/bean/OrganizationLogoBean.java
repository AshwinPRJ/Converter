package com.vyavharamitra.organization.bean;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

@Entity
@Table(name = "bil_omglogo", schema = DbConstant.SCHEMA_NAME)
public class OrganizationLogoBean {
	
	@Column(name="omglogo_data")
	private byte[] fileData;
	
	@Column(name="omglogo_name")
	private String fileName;
	
	@Id
	@Column(name ="omglogo_om_id")
	private Integer omgId;
	
		public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getOmgId() {
		return omgId;
	}
	public void setOmgId(Integer omgId) {
		this.omgId = omgId;
	}
	
	

}
