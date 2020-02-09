package com.rto.resources.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.model.VehicleDetails;
import com.rto.model.VehicleOwnerAddress;
import com.rto.model.VehicleOwnerDetails;
import com.rto.model.VehicleRegistrationDtls;
import com.rto.resources.binding.VehicleSummaryDtls;
import com.rto.resources.services.VehicleSummaryService;
import com.rto.services.VchlRegistrationDetailsService;
import com.rto.services.VehicleDetailsService;
import com.rto.services.VehicleOwnerAddressService;
import com.rto.services.VehicleOwnerDetailsService;

@Service
public class VehicleSummaryServiceImpl implements VehicleSummaryService {
	
	@Autowired
	VchlRegistrationDetailsService vchlRegService;
	@Autowired
	VehicleDetailsService vhclDtlsService;
	@Autowired
	VehicleOwnerDetailsService vchlOwnerDtlsService;
	@Autowired
	VehicleOwnerAddressService vchlOwnerAddrsService;
	
	@Override
	public VehicleSummaryDtls getVehicleDetails(String regNum) {
		VehicleSummaryDtls vhclSummaryDtls=new VehicleSummaryDtls();
		int ownerId;
		VehicleRegistrationDtls vhclRegDtls=vchlRegService.findbyRegNum(regNum);
		ownerId=vhclRegDtls.getDtlsEntity().getVhclOwnerid();
	
		VehicleDetails vhclDtls=vhclDtlsService.findVehicleByOwnerId(ownerId);
		
		VehicleOwnerDetails vhclOwnerDtls=vchlOwnerDtlsService.findById(ownerId);
		
		VehicleOwnerAddress vhclAddrsDtls=vchlOwnerAddrsService.findAddrbyOwnerId(ownerId);
		
		vhclSummaryDtls.setVhclRegDtls(vhclRegDtls);
		vhclSummaryDtls.setVhclDtls(vhclDtls);
		vhclSummaryDtls.setVchlOwnerDtls(vhclOwnerDtls);
		vhclSummaryDtls.setVhclOwnerAddrs(vhclAddrsDtls);
		return vhclSummaryDtls;
	}

}
