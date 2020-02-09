package com.rto.services;


import com.rto.model.VehicleRegistrationDtls;
/**
 * 
 * this is used to provide abstract operation for VchlRegistrationDetailsService 
 * @author SatishKumar
 *
 */
public interface VchlRegistrationDetailsService {
	/**
	 * this is used to done the registration 
	 * if all the comes with validness 
	 * 
	 * @param OwnerKey
	 * @param center
	 * @return VehicleRegistrationDtls
	 */
	public VehicleRegistrationDtls registration(Integer OwnerKey,String center);
	
	/**
	 * this method take registration number as input parameter
	 * and provide  Registration details 
	 * @param regNum
	 * @return VehicleRegistrationDtls
	 */
	public VehicleRegistrationDtls findbyRegNum(String regNum);
	public VehicleRegistrationDtls getByRegId(int regId);
}
