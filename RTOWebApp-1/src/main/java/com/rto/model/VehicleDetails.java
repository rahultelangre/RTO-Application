package com.rto.model;


import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rto.entity.VehicleOwnerDtlsEntity;

import lombok.Data;

/**
 * this class used to recieve the data from Vehicle details UI
 * when then request comes in our application
 * and also used refrence of that class in vehicle summary
 * 
 * @author RahulKumar
 *
 */
@Data
public class VehicleDetails {

	private Integer vhicleDtlsId;
	private String vehicleType;
	private Integer mfdYear;
	private String companyName;
	@XmlTransient
	@JsonIgnore
	private VehicleOwnerDtlsEntity dtlsEntity;
		
}
