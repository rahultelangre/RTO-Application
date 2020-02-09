package com.rto.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rto.entity.VehicleOwnerDtlsEntity;

import lombok.Data;
/**
 * This class is able to capture all data comes in VehicleRegistrationDtls Ui 
 * and send in service to store in database 
 * and used that class refrence in VehicleSummary class to get all details related to owner
 * 
 * @author RahulKumar
 *
 */

@Data
public class VehicleRegistrationDtls {

	private Integer vehicleRegId;
	
	private String vehicleRegNumber;
	
	private String  regCenter;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date  regDate;
	@JsonIgnore
	@XmlTransient
	private VehicleOwnerDtlsEntity dtlsEntity;
		
}
