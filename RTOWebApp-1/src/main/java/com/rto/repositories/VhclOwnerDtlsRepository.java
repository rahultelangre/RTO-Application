package com.rto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.entity.VehicleOwnerDtlsEntity;
/**
 * this repository is used to perform operiton on VehicleOwnerDtlsEntity data  in db side
 * 
 * @author RahulKumar
 */
public interface VhclOwnerDtlsRepository extends JpaRepository<VehicleOwnerDtlsEntity, Integer>{

}
