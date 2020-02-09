package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rto.AppConstants.AppConstants;
import com.rto.model.VehicleDetails;
import com.rto.model.VehicleOwnerDetails;
import com.rto.repositories.VhclOwnerDtlsRepository;
import com.rto.services.VehicleOwnerDetailsService;

@Controller
public class VhclOwnerDltsController {

	@Autowired
	VhclOwnerDtlsRepository vhclOwnerDltsRepository;

	@Autowired
	VehicleOwnerDetailsService ownerService;

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registrationForm(Model model,@ModelAttribute("vehicleOwnerDtls") VehicleOwnerDetails vehicleOwnerDtls) {
		
		return AppConstants.LOGICAL_OWNER_DTLS_VIEW;
	}

	@RequestMapping(value = "/registerOwnerDlts", method = RequestMethod.POST)
	public String registrationSuccessfull(@ModelAttribute("vehicleOwnerDtls") VehicleOwnerDetails vehicleOwnerDtls,
			@RequestParam("ownerId") Integer ownerid, Model model) {
		VehicleDetails vhclDlts = new VehicleDetails();
		if (ownerid != null && ownerid > 0) {
			vehicleOwnerDtls.setVhclOwnerid(ownerid);
		}

		Integer ownerKey = ownerService.saveOwnerDtls(vehicleOwnerDtls);

		model.addAttribute(AppConstants.MODEL_ATTR_KEY_FOR_OWNER_PK, ownerKey);
		model.addAttribute(AppConstants.MODEL_ATTR_KEY_VEHICLE_DTLS, vhclDlts);
		return AppConstants.LOGICAL_VEHICLE_DTLS_VIEW;
	}

	@RequestMapping("/prevToOwnerDtls")
	public String getVhclOwnerData(@RequestParam("ownkey") Integer ownKey, Model model) {
		VehicleOwnerDetails ownerdetails = ownerService.findById(ownKey);
		model.addAttribute(AppConstants.MODEL_ATTR_KEY_OWNER_DTLS, ownerdetails);
		return AppConstants.LOGICAL_OWNER_DTLS_VIEW;
	}
}