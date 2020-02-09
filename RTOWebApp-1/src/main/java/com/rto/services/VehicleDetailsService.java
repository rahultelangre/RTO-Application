package com.rto.services;

import com.rto.model.VehicleDetails;
/**
 * To provide operation details for VehicleDetails 
 * 
 * @author SatishKumar
 *
 */
public interface VehicleDetailsService {
	/**
	 * to store VehicleDetails related  data in database and also owner data for making OneToOne realtionship
	 * 
	 * @param det
	 * @param ownerId
	 * @return	 Integer
	 */
	public Integer saveVehicleDetails(VehicleDetails det,Integer ownerId);
	
	/**
	 * to fetch VehicleDetails data when user is click previous hyperlink
	 * 	
	 * @param vehiclId
	 * @return VehicleDetails
	 */
	public VehicleDetails getVehicleDetails(Integer vehiclId);
	/**
	 * to get VehicleDetails data based on Owner key here we use Foreign key to fetch data 
	 * from child table
	 * @param ownerId
	 * @return VehicleDetails
	 */
	public VehicleDetails findVehicleByOwnerId(Integer ownerId);
	
	
	
}
