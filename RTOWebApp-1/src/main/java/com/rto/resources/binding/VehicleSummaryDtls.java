package com.rto.resources.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rto.model.VehicleDetails;
import com.rto.model.VehicleOwnerAddress;
import com.rto.model.VehicleOwnerDetails;
import com.rto.model.VehicleRegistrationDtls;

import lombok.Data;

@XmlRootElement(name = "vehicle-summary")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"registration-details","owner-details","owner-address","vehicle-details"})
@Data
public class VehicleSummaryDtls {
	
	@XmlElement(name="vehicle-details")
	private VehicleDetails vhclDtls;
	@XmlElement(name = "owner-details")
	private VehicleOwnerDetails vchlOwnerDtls;
	@XmlElement(name = "owner-address")
	private VehicleOwnerAddress vhclOwnerAddrs;
	@XmlElement(name = "registration-details")
	private VehicleRegistrationDtls vhclRegDtls;

}
