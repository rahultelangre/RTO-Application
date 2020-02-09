package com.rto.resources.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.resources.binding.VehicleSummaryDtls;
import com.rto.resources.services.VehicleSummaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/rest")
@Api(value="For getting Vechicle Details ", description = "This api used to get th deatils related to vechicle")
public class VhclSummaryRestController {
	@Autowired
	VehicleSummaryService vhclSummaryService;
	
	@ApiOperation(value = "This operation fetches all Details  related to vechicle",response = ResponseEntity.class)
	@GetMapping(value="/findVehicleDetails/{vno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleSummaryDtls> getVchlDtls (@ApiParam(value = "send Your vehicle Reg Number as path parameter",required = true) @PathVariable("vno") String regNum){
		
		VehicleSummaryDtls vchlSummaryDtls = vhclSummaryService.getVehicleDetails(regNum);
		
		return new ResponseEntity<VehicleSummaryDtls>(vchlSummaryDtls, HttpStatus.OK);
	}
}
