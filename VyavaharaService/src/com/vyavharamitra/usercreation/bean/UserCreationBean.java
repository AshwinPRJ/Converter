package com.vyavharamitra.usercreation.bean;
/**
 * @author : lavanya
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.utils.DbConstant;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_usm", schema = DbConstant.SCHEMA_NAME)
public class UserCreationBean extends UserCreationHealperBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_usm_usm_sno_seq")
	@SequenceGenerator(name="bil_usm_usm_sno_seq", sequenceName="bil_usm_usm_sno_seq", allocationSize=1)
	
	@Column(name = "usm_sno")
	private Integer serialNumber;

	@NotBlank(message = "Please Enter User Name")
	@Size(min = 8, max = 15, message = "User Id must have 8-15 Chracters")
	@Column(name = "usm_uid")
	private String userNumber;

	@JsonIgnore
	@Size(max = 15)
	@Column(name = "usm_cid", length = 16)
	private String customerNumber;

	@NotBlank(message = "Please Enter Name")
	@Size(min = 1, max = 40, message = "Username must between 1 and 40")
	@Column(name = "usm_sn", length = 40)
	private String userShortName;

	/*@NotBlank(message = "Please Enter Password")
	@Size(min = 8, max = 15, message = "Password must between 1 and 15")*/
	@Column(name = "usm_fp",length=50)
	private String userFirstPassword;

	/*@NotBlank(message = "Please Enter Second Password")
	@Size(min = 8, max = 15, message = "Password must between 1 and 15")*/
	@Column(name = "usm_sp",length=50)
	private String userSecondPassword;


	@Column(name = "usm_sta",length=1)
	private String userStatus;

	@Column(name = "usm_bid")
	private Integer branchNumber;

	@Value("Y")
	@Column(name = "usm_reset", length = 1)
	private String passwordReset;

	@Column(name = "usm_lip")
	private String userLastIp;

	@Column(name = "usm_lst")
	private String userLst;

	@Value("NA")
	@Column(name = "usm_eby")
	private String enteredBy;

	@Column(name = "usm_edt")
	private Date enterDate;

	@Column(name = "usm_et")
	private String enterTime;

	@Column(name = "usm_uby")
	private String updateBy;

	@Column(name = "usm_udt")
	private Date updateDate;

	@Column(name = "usm_ut")
	private String updateTime;

	@Column(name = "usm_type")
	private String userType;

	@Column(name = "usm_level")
	private String userLevel;

	@OneToOne(targetEntity = OrganizationMasterBean.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "usm_bid", referencedColumnName = "om_id", insertable = false, updatable = false)
	private OrganizationMasterBean organizationMasterBean;

	/**
	 * @return the serialNumber
	 */
	public Integer getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the userNumber
	 */
	public String getUserNumber() {
		return userNumber;
	}

	/**
	 * @param userNumber
	 *            the userNumber to set
	 */
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber
	 *            the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the userShortName
	 */
	public String getUserShortName() {
		return userShortName;
	}

	/**
	 * @param userShortName
	 *            the userShortName to set
	 */
	public void setUserShortName(String userShortName) {
		this.userShortName = userShortName;
	}

	/**
	 * @return the userFirstPassword
	 */
	public String getUserFirstPassword() {
		return userFirstPassword;
	}

	/**
	 * @param userFirstPassword
	 *            the userFirstPassword to set
	 */
	public void setUserFirstPassword(String userFirstPassword) {
		this.userFirstPassword = userFirstPassword;
	}

	/**
	 * @return the userSecondPassword
	 */
	public String getUserSecondPassword() {
		return userSecondPassword;
	}

	/**
	 * @param userSecondPassword
	 *            the userSecondPassword to set
	 */
	public void setUserSecondPassword(String userSecondPassword) {
		this.userSecondPassword = userSecondPassword;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the branchNumber
	 */
	public Integer getBranchNumber() {
		return branchNumber;
	}

	/**
	 * @param branchNumber
	 *            the branchNumber to set
	 */
	public void setBranchNumber(Integer branchNumber) {
		this.branchNumber = branchNumber;
	}

	/**
	 * @return the passwordReset
	 */
	public String getPasswordReset() {
		return passwordReset;
	}

	/**
	 * @param passwordReset
	 *            the passwordReset to set
	 */
	public void setPasswordReset(String passwordReset) {
		this.passwordReset = passwordReset;
	}

	/**
	 * @return the userLastIp
	 */
	public String getUserLastIp() {
		return userLastIp;
	}

	/**
	 * @param userLastIp
	 *            the userLastIp to set
	 */
	public void setUserLastIp(String userLastIp) {
		this.userLastIp = userLastIp;
	}

	/**
	 * @return the userLst
	 */
	public String getUserLst() {
		return userLst;
	}

	/**
	 * @param userLst
	 *            the userLst to set
	 */
	public void setUserLst(String userLst) {
		this.userLst = userLst;
	}

	/**
	 * @return the enteredBy
	 */
	public String getEnteredBy() {
		return enteredBy;
	}

	/**
	 * @param enteredBy
	 *            the enteredBy to set
	 */
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/**
	 * @return the enterDate
	 */
	public Date getEnterDate() {
		return enterDate;
	}

	/**
	 * @param enterDate
	 *            the enterDate to set
	 */
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	/**
	 * @return the enterTime
	 */
	public String getEnterTime() {
		return enterTime;
	}

	/**
	 * @param enterTime
	 *            the enterTime to set
	 */
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy
	 *            the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the userLevel
	 */
	public String getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel
	 *            the userLevel to set
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @return the organizationMasterBean
	 */
	public OrganizationMasterBean getOrganizationMasterBean() {
		return organizationMasterBean;
	}

	/**
	 * @param organizationMasterBean
	 *            the organizationMasterBean to set
	 */
	public void setOrganizationMasterBean(OrganizationMasterBean organizationMasterBean) {
		this.organizationMasterBean = organizationMasterBean;
	}

}