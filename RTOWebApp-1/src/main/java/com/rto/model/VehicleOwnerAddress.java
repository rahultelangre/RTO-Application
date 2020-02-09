package com.rto.model;


import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rto.entity.VehicleOwnerDtlsEntity;

import lombok.Data;
/**
 * This class is able to capture all data comes in VehicleOwnerAddress Ui 
 * and send in service to store in database 
 * and used that class refrence in VehicleSummary class to get all details related to owner
 * 
 * @author RahulKumar
 *
 */
@Data
public class VehicleOwnerAddress {
	private Integer addressId;
	private String houseNo;
	private String streetName;	
	private String city;
	private Integer  zip;
	@JsonIgnore
	@XmlTransient
	private VehicleOwnerDtlsEntity dtlsEntity;
	
	
}
