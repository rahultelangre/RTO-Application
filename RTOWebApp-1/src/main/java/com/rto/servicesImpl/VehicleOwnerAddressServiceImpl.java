package com.rto.servicesImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.VehicleOwnerAddrEntity;
import com.rto.entity.VehicleOwnerDtlsEntity;
import com.rto.model.VehicleOwnerAddress;
import com.rto.model.VehicleRegistrationDtls;
import com.rto.repositories.VhclOwnerAddrRepositories;
import com.rto.repositories.VhclOwnerDtlsRepository;
import com.rto.services.VchlRegistrationDetailsService;
import com.rto.services.VehicleOwnerAddressService;

/**
 * 
 * used to provide implementation for VehicleOwnerAddressService to perform some
 * business operation and with the help repo we send the database
 * 
 * @author SatishKumar
 *
 */
@Service
public class VehicleOwnerAddressServiceImpl implements VehicleOwnerAddressService {
	/**
	 * inject VhclOwnerAddrRepositories to store data in database
	 */
	@Autowired
	private VhclOwnerAddrRepositories addRepo;
	/**
	 * inject VhclOwnerDtlsRepository for performing OneToOne Mapping in database
	 */
	@Autowired
	private VhclOwnerDtlsRepository dtlsRepo;
	/**
	 * injecting service for Registration after address data stored we need to call
	 * service to inject registration data and generate registration number
	 */
	@Autowired
	private VchlRegistrationDetailsService regService;

	/**
	 * this is used, firstly we set address data in database and also fetch owner
	 * data based on PK and set data in address for association mapping
	 */

	@Override
	public String saveOwnerAddr(VehicleOwnerAddress addr, Integer ownerId) {
		VehicleRegistrationDtls registrationDtls = new VehicleRegistrationDtls();
		VehicleOwnerAddrEntity addrEntity = new VehicleOwnerAddrEntity();
		Optional<VehicleOwnerDtlsEntity> ownerDtls = dtlsRepo.findById(ownerId);
		if (ownerDtls.isPresent()) {
			VehicleOwnerDtlsEntity ownerDtlsEntity = ownerDtls.get();
			BeanUtils.copyProperties(addr, addrEntity);
			addrEntity.setDtlsEntity(ownerDtlsEntity);
			System.out.println(addrEntity);
			VehicleOwnerAddrEntity addrEntity2 = addRepo.save(addrEntity);
			registrationDtls = regService.registration(ownerId, addrEntity2.getCity());

			return registrationDtls.getVehicleRegNumber();
		}
		return registrationDtls.getVehicleRegNumber();
	}

	/**
	 * this operation is used to fetch VehicleOwnerAddress data based on Owner key
	 * because we use here foreign key relationship wit OwnerDtls data
	 */
	@Override
	public VehicleOwnerAddress findAddrbyOwnerId(Integer id) {
		VehicleOwnerAddress address = new VehicleOwnerAddress();
		Optional<VehicleOwnerAddrEntity> addrEntity = addRepo.findByOwnerId(id);
		if (addrEntity.isPresent()) {
			VehicleOwnerAddrEntity addrEntity2 = addrEntity.get();
			BeanUtils.copyProperties(addrEntity2, address);
			return address;

		}
		return address;
	}

	@Override
	public int saveOwnerAddr1(VehicleOwnerAddress addr, Integer ownerId) {
		VehicleRegistrationDtls registrationDtls = new VehicleRegistrationDtls();
		VehicleOwnerAddrEntity addrEntity = new VehicleOwnerAddrEntity();
		Optional<VehicleOwnerDtlsEntity> ownerDtls = dtlsRepo.findById(ownerId);
		if (ownerDtls.isPresent()) {
			VehicleOwnerDtlsEntity ownerDtlsEntity = ownerDtls.get();
			BeanUtils.copyProperties(addr, addrEntity);
			addrEntity.setDtlsEntity(ownerDtlsEntity);
			System.out.println(addrEntity);
			VehicleOwnerAddrEntity addrEntity2 = addRepo.save(addrEntity);
			registrationDtls = regService.registration(ownerId, addrEntity2.getCity());

			return registrationDtls.getVehicleRegId();
		}
		return registrationDtls.getVehicleRegId();
	}
}
