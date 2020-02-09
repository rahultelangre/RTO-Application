package com.rto.servicesImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.VehicleOwnerDtlsEntity;
import com.rto.entity.VehicleRegistrationEntity;
import com.rto.model.VehicleRegistrationDtls;
import com.rto.repositories.VchlRegistrationRepository;
import com.rto.repositories.VhclOwnerDtlsRepository;
import com.rto.services.VchlRegistrationDetailsService;
import com.rto.util.RandomGenerators;
/**
 * Implementation of VchlRegistrationDetailsService to provide body for operations
 * 
 * @author SatishKumar
 *
 */
@Service
public class VchlRegistrationDetailsServiceImpl implements VchlRegistrationDetailsService{
	
	/**
	 * inject VchlRegistrationRepository to interact with db and store data in db
	 */
	@Autowired
	private VchlRegistrationRepository regDtls;
	/**
	 * to get Owner data because of onetoOne mapping we need to set owner Details also 
	 * as part of registration data to make relationship 
	 * 
	 */
	@Autowired
	private VhclOwnerDtlsRepository ownerRepo;
	/**
	 * to save vehicle data in database and return VehicleRegistrationDtls to controller
	 * 
	 */
	@Override
	public VehicleRegistrationDtls registration(Integer ownerId,String regCenter) {
		VehicleRegistrationDtls dtls=new VehicleRegistrationDtls();
		VehicleRegistrationEntity entity=new VehicleRegistrationEntity();
		String regNo=RandomGenerators.getRegNumber();
		Optional<VehicleOwnerDtlsEntity> ownerDtls = ownerRepo.findById(ownerId);
		if(ownerDtls.isPresent()) {
			VehicleOwnerDtlsEntity ownerDtlsEntity = ownerDtls.get();
			entity.setRegDate(new Date());
			entity.setVehicleRegNumber(regNo);
			entity.setRegCenter(regCenter);
			entity.setDtlsEntity(ownerDtlsEntity);
			VehicleRegistrationEntity registrationEntity = regDtls.save(entity);
			BeanUtils.copyProperties(registrationEntity, dtls);
			return dtls;
		}
		return dtls;
	}

	/**
	 * To fetch all the registration related data baed to vehicle Number
	 */
	@Override
	public VehicleRegistrationDtls findbyRegNum(String regNum) {
		VehicleRegistrationDtls dtls=new VehicleRegistrationDtls();
		Optional<VehicleRegistrationEntity> findRegDtls = regDtls.findRegDtls(regNum);
		if(findRegDtls.isPresent()) {
			VehicleRegistrationEntity registrationEntity = findRegDtls.get();
			BeanUtils.copyProperties(registrationEntity, dtls);
			return dtls;
		}
		return dtls;
	}

	@Override
	public VehicleRegistrationDtls getByRegId(int regId) {
		VehicleRegistrationDtls dtls=new VehicleRegistrationDtls();
		Optional<VehicleRegistrationEntity> findRegDtls = regDtls.findById(regId);
		if(findRegDtls.isPresent()) {
			VehicleRegistrationEntity registrationEntity = findRegDtls.get();
			BeanUtils.copyProperties(registrationEntity, dtls);
			return dtls;
		}
		return dtls;
	}
}
