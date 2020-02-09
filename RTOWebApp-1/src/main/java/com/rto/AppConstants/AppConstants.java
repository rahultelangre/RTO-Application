package com.rto.AppConstants;

public interface AppConstants {
	/**
	 * this used to return logical view name  for vehicleOwnerDetails 
	 */
	public static final String LOGICAL_OWNER_DTLS_VIEW="vehicleOwnerDetails";
	
	/**
	 * this is used to return logical view name  for vehicleDetails
	 */
	public static final String LOGICAL_VEHICLE_DTLS_VIEW="vehicleDetails";
	
	
	/**
	 * this is used to return logical view name for vehicleOwnerAdress
	 */
	public static final String LOGICAL_OWNER_ADDR_VIEW="vehicleOwnerAdress";
	
	/**
	 * this is used to return logical view name for  vehicleSummary
	 */
	public static final String LOGICAL_VHCL_SUMMARY_VIEW="vehicleSummary";
	
	/**
	 * this is used to store owner data for send from controller to UI
	 */
	public static final String MODEL_ATTR_KEY_OWNER_DTLS="vehicleOwnerDtls";
	
	/**
	 * this is used to store vehicle data for send from controller to UI
	 */
	public static final String MODEL_ATTR_KEY_VEHICLE_DTLS="vehicleDtls";
	
	/**
	 *this is used to store owneraddr data for send from controller to UI 
	 */
	public static final String MODEL_ATTR_KEY_OWNER_ADDR_DTLS="ownerAddr";
	
	/**
	 * this is used to store vehicle registration summary data for send from controller to UI
	 */
	public static final String MODEL_ATTR_KEY_VCHL_REG_SUMMARY="vchlReg";
	
	/**
	 *sending primary key of vehicleOwner from controller to UI for making request as state full
	 */
	public static final String MODEL_ATTR_KEY_FOR_OWNER_PK="vehicleOwnerKey";
	
	/**
	 * sending primary key of vehicleDtls from controller to UI for making request as state full
	 */
	public static final String MODEL_ATTR_KEY_FOR_VHCL_PK="vehicleDtlsKey";
	
	/**
	 * this is used to store msg  for model to send Controller to UI 
	 */
	public static final String MODEL_ATTR_SUCC_MSG_KEY="msg";
	
	/**
	 * this is used to get msg from cache which we write in yaml file and store in map object 
	 */
	public static final String MODEL_ATTR_SUCC_MSG="succMsg";
	
	/**
	 * this is used to redirection when all screen data saved then after we need to show the summary
	 * for user 
	 */
	public static final String REDIRECT_VEHICLE_SUMMARY="redirect:summary?regId=";

}
