package com.rto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
/**
 * this entity is used to set data from  VehicleOwnerDtls UI store in that class with help of BeanUtils
 * and send data to VehicleOwnerDtlsRepository 
 * 
 * @author RahulKumar
 *
 */


@Entity
@Table(name="vhcl_Owner_Dtls")
public class VehicleOwnerDtlsEntity {

	@Id
	@Column(name="vehicle_Owner_Id",updatable = false,nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownerId_generator")
	@SequenceGenerator(name="ownerId_generator", sequenceName = "Vchl_owner_Id_Seq")
	private Integer vhclOwnerid;
	@Column(name="first_name" ,length = 30)
	private String fname;
	@Column(name="last_name",length = 30)
	private String lname;
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
	@Column(name="Gender",length = 10)
	private String gender;
	@Column(name="Email",length = 40)
	private String email;
	private Long phno;
	@Column(name="SSN_ID",length = 11)
	private String zzn;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="Create_DT")
	private Date  createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="Update_DT")
	private Date updateDate;
	public Integer getVhclOwnerid() {
		return vhclOwnerid;
	}
	public void setVhclOwnerid(Integer vhclOwnerid) {
		this.vhclOwnerid = vhclOwnerid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getZzn() {
		return zzn;
	}
	public void setZzn(String zzn) {
		this.zzn = zzn;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
