package com.rto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rto.entity.VehicleDetailsEntity;
/**
 * this repository is used to perform operations on VehicleDetailsEntity data in database 
 * 
 * @author RahulKumar
 */
public interface VehicleDtlsRepository extends JpaRepository<VehicleDetailsEntity, Integer>{
	/**
	 * This is used to get VehicleDetailsEntity based to foreign key(owner primary key)
	 * with the help of one to one mapping 
	 * @param id
	 * @return Optional<VehicleDetailsEntity>
	 */
	@Query("select d from VehicleDetailsEntity d where  d.dtlsEntity.vhclOwnerid=:id")
	public Optional<VehicleDetailsEntity> findByOwnerId(Integer id);
}
