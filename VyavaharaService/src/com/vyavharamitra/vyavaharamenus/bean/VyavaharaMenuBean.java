package com.vyavharamitra.vyavaharamenus.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */

@Entity
@Table(name = "bil_umof", schema = DbConstant.SCHEMA_NAME)

public class VyavaharaMenuBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "umof_id")
	private Integer menunumber;
	
	@Column(name = "umof_oid")
	private Integer organizationid;

	@Column(name = "umof_sl")
	private Integer serialline;
	
	@Column(name="umof_ml")
	private Integer menulevel;
	
	@Column(name = "umof_so")
	private Integer serialorder;
	
	@Column(name="umof_mitem")
	private String menuitem;
	
	@Column(name = "umof_url")
	private String url;
	
	@Column(name="umof_scode")
	private String shortcode;
	
	@Column(name = "umof_st")
	private String status;
	
	@Column(name="umof_type")
	private String usertype;
	
	@Column(name="umof_level")
	private String userlevel;

	/**
	 * @return the menunumber
	 */
	public Integer getMenunumber() {
		return menunumber;
	}

	/**
	 * @param menunumber the menunumber to set
	 */
	public void setMenunumber(Integer menunumber) {
		this.menunumber = menunumber;
	}

	/**
	 * @return the organizationid
	 */
	public Integer getOrganizationid() {
		return organizationid;
	}

	/**
	 * @param organizationid the organizationid to set
	 */
	public void setOrganizationid(Integer organizationid) {
		this.organizationid = organizationid;
	}

	/**
	 * @return the serialline
	 */
	public Integer getSerialline() {
		return serialline;
	}

	/**
	 * @param serialline the serialline to set
	 */
	public void setSerialline(Integer serialline) {
		this.serialline = serialline;
	}

	/**
	 * @return the menulevel
	 */
	public Integer getMenulevel() {
		return menulevel;
	}

	/**
	 * @param menulevel the menulevel to set
	 */
	public void setMenulevel(Integer menulevel) {
		this.menulevel = menulevel;
	}

	/**
	 * @return the serialorder
	 */
	public Integer getSerialorder() {
		return serialorder;
	}

	/**
	 * @param serialorder the serialorder to set
	 */
	public void setSerialorder(Integer serialorder) {
		this.serialorder = serialorder;
	}

	/**
	 * @return the menuitem
	 */
	public String getMenuitem() {
		return menuitem;
	}

	/**
	 * @param menuitem the menuitem to set
	 */
	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the shortcode
	 */
	public String getShortcode() {
		return shortcode;
	}

	/**
	 * @param shortcode the shortcode to set
	 */
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the usertype
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the userlevel
	 */
	public String getUserlevel() {
		return userlevel;
	}

	/**
	 * @param userlevel the userlevel to set
	 */
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	
	
	
	
	
}
