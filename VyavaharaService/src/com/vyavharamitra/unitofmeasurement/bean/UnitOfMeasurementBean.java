package com.vyavharamitra.unitofmeasurement.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Babu Prakash
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_uom", schema = DbConstant.SCHEMA_NAME)
public class UnitOfMeasurementBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_uom_uom_uid_seq")
	@SequenceGenerator(name="bil_uom_uom_uid_seq", sequenceName="bil_uom_uom_uid_seq", allocationSize=1)
	@Column(name = "uom_uid")
	private Integer unitMeasurementNumber;

	@NotBlank(message = "Please Enter Unit Name")
	@Size(max = 50, message = "Unit Name must between 1 and 50 characters")
	@Column(name = "uom_name", length = 50)
	private String unitName;

	@Size(max = 30)
	@Value("KittuKiran")
	@Column(name = "uom_eby", length = 30)
	private String enteredBy;

	@Value("02 DEC 2017")
	@Column(name = "uom_on")
	private Date enteredDate;

	@Column(name = "uom_etime", length = 10)
	private String enteredTime;

	/**
	 * @return the unitMeasurementNumber
	 */
	public Integer getUnitMeasurementNumber() {
		return unitMeasurementNumber;
	}

	/**
	 * @param unitMeasurementNumber
	 *            the unitMeasurementNumber to set
	 */
	public void setUnitMeasurementNumber(Integer unitMeasurementNumber) {
		this.unitMeasurementNumber = unitMeasurementNumber;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName
	 *            the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	 * @return the enteredDate
	 */
	public Date getEnteredDate() {
		return enteredDate;
	}

	/**
	 * @param enteredDate
	 *            the enteredDate to set
	 */
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	/**
	 * @return the enteredTime
	 */
	public String getEnteredTime() {
		return enteredTime;
	}

	/**
	 * @param enteredTime
	 *            the enteredTime to set
	 */
	public void setEnteredTime(String enteredTime) {
		this.enteredTime = enteredTime;
	}

}
