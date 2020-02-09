package com.rto.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * This class is able to capture all data comes in VehicleOwnerDetails Ui 
 * and send in service to store in database 
 * and used that class refrence in VehicleSummary class to get all details related to owner
 * 
 * @author RahulKumar
 *
 */

@Data
public class VehicleOwnerDetails {

	private Integer vhclOwnerid;
	private String fname;
	private String lname;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dob;
	private String gender;
	private String email;
	private Long phno;
	private String zzn;
	
	
}
