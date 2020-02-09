package com.rto.entity;


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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * this entity is used to set data from  VehicleDetails UI store in that class with help of BeanUtils
 * and send data to VehicleDetailsRepository 
 * 
 * @author RahulKumar
 *
 */

@Entity
@Table(name="vehicle_dtls")
public class VehicleDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="vehicle_dtls")
	@SequenceGenerator(name="vehicle_dtls",sequenceName = "VCHL_DTLS_ID_SEQ")
	private Integer vhicleDtlsId;
	@Column(length = 15)
	private String vehicleType;
	private Integer mfdYear;
	@Column(name="company_name",length = 30)
	private String companyName;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date  create_Dt;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date update_Dt;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="vehicle_Owner_Id")
	private VehicleOwnerDtlsEntity dtlsEntity;
	public Integer getVhicleDtlsId() {
		return vhicleDtlsId;
	}
	public void setVhicleDtlsId(Integer vhicleDtlsId) {
		this.vhicleDtlsId = vhicleDtlsId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getMfdYear() {
		return mfdYear;
	}
	public void setMfdYear(Integer mfdYear) {
		this.mfdYear = mfdYear;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
