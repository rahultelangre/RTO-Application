package com.rto.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * this entity is used to set data from  VehicleRegistration UI store in that class with help of BeanUtils
 * and send data to VehicleRegistrationRepository 
 * 
 * @author RahulKumar
 *
 */

@Entity
@Table(name="vehicle_reg_dtls")

public class VehicleRegistrationEntity {

	@Id
	@GeneratedValue
	@Column(name="vhcl_reg_id")
	private Integer vehicleRegId;
	
	@Column(name="vhcl_reg_number",length = 20)
	private String vehicleRegNumber;
	
	@Column(name="vhcl_reg_center",length = 20)
	private String  regCenter;
	
	@Temporal(TemporalType.DATE)
	@Column(name="vhcl_reg_Date")
	private Date  regDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date create_Dt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date update_Dt;
	
	@OneToOne(cascade =CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="vehicle_Owner_Id",referencedColumnName = "vehicle_Owner_Id")
	private VehicleOwnerDtlsEntity dtlsEntity;

	public Integer getVehicleRegId() {
		return vehicleRegId;
	}

	public void setVehicleRegId(Integer vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}

	public String getRegCenter() {
		return regCenter;
	}

	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getCreate_Dt() {
		return create_Dt;
	}

	public void setCreate_Dt(Date create_Dt) {
		this.create_Dt = create_Dt;
	}

	public Date getUpdate_Dt() {
		return update_Dt;
	}

	public void setUpdate_Dt(Date update_Dt) {
		this.update_Dt = update_Dt;
	}

	public VehicleOwnerDtlsEntity getDtlsEntity() {
		return dtlsEntity;
	}

	public void setDtlsEntity(VehicleOwnerDtlsEntity dtlsEntity) {
		this.dtlsEntity = dtlsEntity;
	}
	
	
}
