package com.rto.entity;


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
/**
 * this entity is used to set data from  VehicleOwnerAddr UI store in that class with help of BeanUtils
 * and send data to VehicleOwnerAddrRepository 
 * 
 * @author RahulKumar
 *
 */


@Entity
@Table(name="vhcl_Owner_addr")
public class VehicleOwnerAddrEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownerId_generator")
	@SequenceGenerator(name="ownerId_generator", sequenceName = "ADRR_ID_SEQ")
	private Integer addressId;
	@Column(name="House_No",length =40)
	private String houseNo;
	@Column(name="Street_Name",length =40)
	private String streetName;	
	@Column(name="city",length =30)
	private String city;
	private Integer  zip;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="vehicle_Owner_Id")
	private VehicleOwnerDtlsEntity dtlsEntity;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public VehicleOwnerDtlsEntity getDtlsEntity() {
		return dtlsEntity;
	}
	public void setDtlsEntity(VehicleOwnerDtlsEntity dtlsEntity) {
		this.dtlsEntity = dtlsEntity;
	}
	
	
}
