package com.rto.servicesImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.VehicleDetailsEntity;
import com.rto.entity.VehicleOwnerDtlsEntity;
import com.rto.model.VehicleDetails;
import com.rto.repositories.VehicleDtlsRepository;
import com.rto.repositories.VhclOwnerDtlsRepository;
import com.rto.services.VehicleDetailsService;
/**
 * provide body for performing bussiness logic in VehicleDetails class and interact with db  
 * 
 * @author SatishKumar
 *
 */
@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService{
	/**
	 * To inject VehicleDtlsRepository object to store data in database
	 */
	@Autowired
	private  VehicleDtlsRepository vchldtlsRepo;
	/**
	 * toinject VhclOwnerDtlsRepository data to fetch data based on id and set in dtls object to make OneToOne
	 */
	@Autowired
	private VhclOwnerDtlsRepository vchlownerRepo;
	/**
	 * it is used to store the VehicleDetails in database
	 */
	@Override
	public Integer saveVehicleDetails(VehicleDetails det,Integer ownerId) {
		Integer dtlsId=1;
		Optional<VehicleOwnerDtlsEntity> ownerData = vchlownerRepo.findById(ownerId);
		VehicleDetailsEntity detailsEntity=new VehicleDetailsEntity();
		if(ownerData.isPresent()) {
			VehicleOwnerDtlsEntity ownerDtlsEntity = ownerData.get();
			BeanUtils.copyProperties(det, detailsEntity);
			detailsEntity.setDtlsEntity(ownerDtlsEntity);
			VehicleDetailsEntity vechicleDtls = vchldtlsRepo.save(detailsEntity);
			 dtlsId = vechicleDtls.getVhicleDtlsId();
			return dtlsId;
		}
		return dtlsId;
	}
	/**
	 * to  fetch VehicleDetails when user click on previous link
	 */
	@Override
	public VehicleDetails getVehicleDetails(Integer vehiclId) {
			VehicleDetails details=new VehicleDetails();
			Optional<VehicleDetailsEntity> vhclDtls = vchldtlsRepo.findById(vehiclId);
			if(vhclDtls.isPresent()) {
				VehicleDetailsEntity detailsEntity = vhclDtls.get();
				BeanUtils.copyProperties(detailsEntity, details);
				System.out.println(details);
				return details;
			}
			return details;
	}
	/**
	 * fetch data based on foreign key here owner primary key is used 
	 * because we do OneToOne mapping for making a relationship
	 */
	@Override
	public VehicleDetails findVehicleByOwnerId(Integer ownerId) {
		VehicleDetails details=new VehicleDetails();
		Optional<VehicleDetailsEntity> vhclDtls = vchldtlsRepo.findById(ownerId);
		if(vhclDtls.isPresent()) {
			VehicleDetailsEntity detailsEntity = vhclDtls.get();
			BeanUtils.copyProperties(detailsEntity, details);
			System.out.println(details);
			return details;
		}
		return details;
	}

}
