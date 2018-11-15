package com.vyavharamitra.greetings.beans;
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
import java.math.BigInteger;


import com.vyavharamitra.utils.DbConstant;
import java.util.Date;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Entity
@Table(name = "bil_brnmsg", schema = DbConstant.SCHEMA_NAME)
public class GreetingsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_brnmsg_brnmsg_id_seq")
	@SequenceGenerator(name="bil_brnmsg_brnmsg_id_seq", sequenceName="bil_brnmsg_brnmsg_id_seq", allocationSize=1)
	@Column(name = "brnmsg_id")
	private Integer greetingsId;
	
	@Column(name = "brnmsg_bid")
	private BigInteger branchId;
	
	@Column(name = "brnmsg_msg")
	private String branchMessage;
	
	
	@Column(name = "brnmsg_expdt")
	private Date branchExpiredDate;
	
	
	@Column(name = "brnmsg_sta")
	private String branchStatus;
	
	@Column(name = "brnmsg_eby")
	private String branchEnteredBy;
	
	@Column(name = "brnmsg_edt")
	private Date branchDate;
	
	@Column(name = "brnmsg_et")
	private String branchTime;
	
	@OneToOne(targetEntity=BranchBean.class,cascade=CascadeType.ALL)
	@JoinColumn(name="brnmsg_bid",referencedColumnName="bm_id" ,insertable=false ,updatable=false)
	private BranchBean branchBean;

	/**
	 * @return the branchBean
	 */
	public BranchBean getBranchBean() {
		return branchBean;
	}

	/**
	 * @param branchBean the branchBean to set
	 */
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}

	/**
	 * @return the greetingsId
	 */
	public Integer getGreetingsId() {
		return greetingsId;
	}

	/**
	 * @param greetingsId the greetingsId to set
	 */
	public void setGreetingsId(Integer greetingsId) {
		this.greetingsId = greetingsId;
	}

	/**
	 * @return the branchId
	 */
	public BigInteger getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(BigInteger branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchMessage
	 */
	public String getBranchMessage() {
		return branchMessage;
	}

	/**
	 * @param branchMessage the branchMessage to set
	 */
	public void setBranchMessage(String branchMessage) {
		this.branchMessage = branchMessage;
	}

	/**
	 * @return the branchExpiredDate
	 */
	public Date getBranchExpiredDate() {
		return branchExpiredDate;
	}

	/**
	 * @param branchExpiredDate the branchExpiredDate to set
	 */
	public void setBranchExpiredDate(Date branchExpiredDate) {
		this.branchExpiredDate = branchExpiredDate;
	}

	/**
	 * @return the branchStatus
	 */
	public String getBranchStatus() {
		return branchStatus;
	}

	/**
	 * @param branchStatus the branchStatus to set
	 */
	public void setBranchStatus(String branchStatus) {
		this.branchStatus = branchStatus;
	}

	/**
	 * @return the branchEnteredBy
	 */
	public String getBranchEnteredBy() {
		return branchEnteredBy;
	}

	/**
	 * @param branchEnteredBy the branchEnteredBy to set
	 */
	public void setBranchEnteredBy(String branchEnteredBy) {
		this.branchEnteredBy = branchEnteredBy;
	}

	/**
	 * @return the branchDate
	 */
	public Date getBranchDate() {
		return branchDate;
	}

	/**
	 * @param branchDate the branchDate to set
	 */
	public void setBranchDate(Date branchDate) {
		this.branchDate = branchDate;
	}

	/**
	 * @return the branchTime
	 */
	public String getBranchTime() {
		return branchTime;
	}

	/**
	 * @param branchTime the branchTime to set
	 */
	public void setBranchTime(String branchTime) {
		this.branchTime = branchTime;
	}
	
	
	
	

}



	