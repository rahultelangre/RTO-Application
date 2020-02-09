package com.rto.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rto.AppConstants.AppConstants;
import com.rto.mail.sender.MailSenderUtil;
import com.rto.model.VehicleDetails;
import com.rto.model.VehicleOwnerAddress;
import com.rto.model.VehicleOwnerDetails;
import com.rto.model.VehicleRegistrationDtls;
import com.rto.services.VchlRegistrationDetailsService;
import com.rto.services.VehicleDetailsService;
import com.rto.services.VehicleOwnerAddressService;
import com.rto.services.VehicleOwnerDetailsService;
/**
 * this Controller is used to handle request for VehicleSummary
 * after filling all form we need show the summary page 
 * with all data
 * @author SatishKumar
 *
 */
@Controller
public class VehicleSummaryController {
	/**
	 * inject VchlRegistrationDetailsService for fetching registration related data 
	 */
	@Autowired
	private VchlRegistrationDetailsService  vhclRegservice;
	/**
	 * inject VehicleDetailsService for fetching vehicle Details related data
	 */
	@Autowired
	private VehicleDetailsService  vhclDetailService;
	/**
	 * inject VehicleOwnerDetailsService for fetching vehicleowner dtls related data
	 */
	@Autowired
	private VehicleOwnerDetailsService vhclOwnerDtls;
	/**
	 * inject VehicleOwnerAddressService for fetching vehicleOwnerAddrress related data
	 */
	@Autowired
	private VehicleOwnerAddressService vhclAddrDts;
	/**
	 * inject AppProperties to fetch msg which is available in cache  
	 */
	@Autowired
	private com.rto.properties.AppProperties props;
	/**
	 * this is used to send all data in with successful registration page and show all data in
	 * tabular format in UI and  
	 * @param regNum
	 * @param model
	 * @return String 
	 */
	/**
	 * inject mail object for sending mail
	 */
	@Autowired
	private MailSenderUtil mailSender;
	
	
	@RequestMapping("/summary")
	public String getAllDetails(@RequestParam("regId") int regId,Model model) throws MessagingException {
			//VehicleRegistrationDtls vechicleData = vhclRegservice.findbyRegNum(regNum);
			VehicleRegistrationDtls vechicleData = vhclRegservice.getByRegId(regId);
				Integer vhclOwnerid = vechicleData.getDtlsEntity().getVhclOwnerid();
				VehicleDetails vehicleDetails = vhclDetailService.findVehicleByOwnerId(vhclOwnerid);
				VehicleOwnerDetails ownerDetails = vhclOwnerDtls.findById(vhclOwnerid);
				VehicleOwnerAddress address = vhclAddrDts.findAddrbyOwnerId(vhclOwnerid);
				
				boolean sendMail = mailSender.sendMail(ownerDetails.getEmail(),address.getCity(),vechicleData.getVehicleRegNumber(),vehicleDetails.getVehicleType());
				
				System.out.println("mail Sending Status===================>"+sendMail);
				
				String msg = props.getMessages().get(AppConstants.MODEL_ATTR_SUCC_MSG);
				model.addAttribute(AppConstants.MODEL_ATTR_SUCC_MSG_KEY, msg);
				model.addAttribute(AppConstants.MODEL_ATTR_KEY_OWNER_ADDR_DTLS,address);
				model.addAttribute(AppConstants.MODEL_ATTR_KEY_OWNER_DTLS, ownerDetails);
				model.addAttribute(AppConstants.MODEL_ATTR_KEY_VCHL_REG_SUMMARY, vechicleData);
				model.addAttribute(AppConstants.MODEL_ATTR_KEY_VEHICLE_DTLS,vehicleDetails);
		return AppConstants.LOGICAL_VHCL_SUMMARY_VIEW;
	}
}
