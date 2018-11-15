package com.vyavharamitra.cashsales.beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_sellitem", schema = DbConstant.SCHEMA_NAME)
public class CashSalesBean extends CashSalesHelper {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_sellitem_sellitem_sid_seq")
    @SequenceGenerator(name="bil_sellitem_sellitem_sid_seq", sequenceName="bil_sellitem_sellitem_sid_seq", allocationSize=1)
	@Column(name = "sellitem_sid")
	private Integer sellItemId;

	@Column(name = "sellitem_cname")
	private String sellItemCustomerName;

	@Column(name = "sellitem_sdate")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date sellItemDate;

	@Column(name = "sellitem_totcost")
	private BigDecimal sellItemTotalCost;

	@Column(name = "sellitem_eby")
	private String sellItemEnteredBy;

	@Column(name = "sellitem_edate")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date sellItemEnteredDate;

	@Column(name = "sellitem_etime")
	private String sellItemEnteredTime;

	@Column(name = "sellitem_cphno")
	private BigInteger sellItemCustomerPhone;

	@Column(name = "sellitem_bid")
	private Integer sellItemBranchId;

	@Column(name = "sellitem_billno")
	private BigInteger sellItemBillNumber;
	
	@Column(name = "sellitem_sta")
	private String sellItemStatus;
	
	@Column(name = "sellitem_gstin")
	private String sellItemGSTIN;
	
	@Column(name="sellitem_bdno")
	private String buildingNo;
	
	@Column(name="sellitem_bdname")
	private String buildingName;
	
	@Column(name="sellitem_srt")
	private String street;
	
	@Column(name="sellitem_lty")
	private String locality;
	
	@Column(name="sellitem_dist")
	private String district;
	
	@Column(name="sellitem_city")
	private String city;
	
	@Column(name="sellitem_st")
	private String state;
	
	@Column(name="sellitem_pin")
	private BigInteger pinNumber;
	
	@Column(name="sellitem_remarks")
	private String remarks;
	
	@Column(name="sellitem_transtype")
	private String transType;
	
	@Column(name="sellitem_transdetails")
	private String transDetails;
	

	/**
	 * @return the sellItemId
	 */
	public Integer getSellItemId() {
		return sellItemId;
	}

	/**
	 * @param sellItemId the sellItemId to set
	 */
	public void setSellItemId(Integer sellItemId) {
		this.sellItemId = sellItemId;
	}

	/**
	 * @return the sellItemCustomerName
	 */
	public String getSellItemCustomerName() {
		return sellItemCustomerName;
	}

	/**
	 * @param sellItemCustomerName the sellItemCustomerName to set
	 */
	public void setSellItemCustomerName(String sellItemCustomerName) {
		this.sellItemCustomerName = sellItemCustomerName;
	}

	/**
	 * @return the sellItemDate
	 */
	public Date getSellItemDate() {
		return sellItemDate;
	}

	/**
	 * @param sellItemDate the sellItemDate to set
	 */
	public void setSellItemDate(Date sellItemDate) {
		this.sellItemDate = sellItemDate;
	}

	/**
	 * @return the sellItemTotalCost
	 */
	public BigDecimal getSellItemTotalCost() {
		return sellItemTotalCost;
	}

	/**
	 * @param sellItemTotalCost the sellItemTotalCost to set
	 */
	public void setSellItemTotalCost(BigDecimal sellItemTotalCost) {
		this.sellItemTotalCost = sellItemTotalCost;
	}

	/**
	 * @return the sellItemEnteredBy
	 */
	public String getSellItemEnteredBy() {
		return sellItemEnteredBy;
	}

	/**
	 * @param sellItemEnteredBy the sellItemEnteredBy to set
	 */
	public void setSellItemEnteredBy(String sellItemEnteredBy) {
		this.sellItemEnteredBy = sellItemEnteredBy;
	}

	/**
	 * @return the sellItemEnteredDate
	 */
	public Date getSellItemEnteredDate() {
		return sellItemEnteredDate;
	}

	/**
	 * @param sellItemEnteredDate the sellItemEnteredDate to set
	 */
	public void setSellItemEnteredDate(Date sellItemEnteredDate) {
		this.sellItemEnteredDate = sellItemEnteredDate;
	}

	/**
	 * @return the sellItemEnteredTime
	 */
	public String getSellItemEnteredTime() {
		return sellItemEnteredTime;
	}

	/**
	 * @param sellItemEnteredTime the sellItemEnteredTime to set
	 */
	public void setSellItemEnteredTime(String sellItemEnteredTime) {
		this.sellItemEnteredTime = sellItemEnteredTime;
	}

	/**
	 * @return the sellItemCustomerPhone
	 */
	public BigInteger getSellItemCustomerPhone() {
		return sellItemCustomerPhone;
	}

	/**
	 * @param sellItemCustomerPhone the sellItemCustomerPhone to set
	 */
	public void setSellItemCustomerPhone(BigInteger sellItemCustomerPhone) {
		this.sellItemCustomerPhone = sellItemCustomerPhone;
	}

	/**
	 * @return the sellItemBranchId
	 */
	public Integer getSellItemBranchId() {
		return sellItemBranchId;
	}

	/**
	 * @param sellItemBranchId the sellItemBranchId to set
	 */
	public void setSellItemBranchId(Integer sellItemBranchId) {
		this.sellItemBranchId = sellItemBranchId;
	}

	/**
	 * @return the sellItemBillNumber
	 */
	public BigInteger getSellItemBillNumber() {
		return sellItemBillNumber;
	}

	/**
	 * @param sellItemBillNumber the sellItemBillNumber to set
	 */
	public void setSellItemBillNumber(BigInteger sellItemBillNumber) {
		this.sellItemBillNumber = sellItemBillNumber;
	}

	/**
	 * @return the sellItemStatus
	 */
	public String getSellItemStatus() {
		return sellItemStatus;
	}

	/**
	 * @param sellItemStatus the sellItemStatus to set
	 */
	public void setSellItemStatus(String sellItemStatus) {
		this.sellItemStatus = sellItemStatus;
	}

	/**
	 * @return the sellItemGSTIN
	 */
	

	/**
	 * @return the buildingNo
	 */
	public String getBuildingNo() {
		return buildingNo;
	}

	public String getSellItemGSTIN() {
		return sellItemGSTIN;
	}

	public void setSellItemGSTIN(String sellItemGSTIN) {
		this.sellItemGSTIN = sellItemGSTIN;
	}

	/**
	 * @param buildingNo the buildingNo to set
	 */
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pinNumber
	 */
	public BigInteger getPinNumber() {
		return pinNumber;
	}

	/**
	 * @param pinNumber the pinNumber to set
	 */
	public void setPinNumber(BigInteger pinNumber) {
		this.pinNumber = pinNumber;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * @param transType the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * @return the transDetails
	 */
	public String getTransDetails() {
		return transDetails;
	}

	/**
	 * @param transDetails the transDetails to set
	 */
	public void setTransDetails(String transDetails) {
		this.transDetails = transDetails;
	}

	
	public Integer getItemNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CashSalesBean [sellItemId=" + sellItemId + ", sellItemCustomerName=" + sellItemCustomerName
				+ ", sellItemDate=" + sellItemDate + ", sellItemTotalCost=" + sellItemTotalCost + ", sellItemEnteredBy="
				+ sellItemEnteredBy + ", sellItemEnteredDate=" + sellItemEnteredDate + ", sellItemEnteredTime="
				+ sellItemEnteredTime + ", sellItemCustomerPhone=" + sellItemCustomerPhone + ", sellItemBranchId="
				+ sellItemBranchId + ", sellItemBillNumber=" + sellItemBillNumber + ", sellItemStatus=" + sellItemStatus
				+ ", sellItemGSTIN=" + sellItemGSTIN + ", buildingNo=" + buildingNo + ", buildingName=" + buildingName
				+ ", street=" + street + ", locality=" + locality + ", district=" + district + ", city=" + city
				+ ", state=" + state + ", pinNumber=" + pinNumber + ", remarks=" + remarks + ", transType=" + transType
				+ ", transDetails=" + transDetails + "]";
	}

	
	
}