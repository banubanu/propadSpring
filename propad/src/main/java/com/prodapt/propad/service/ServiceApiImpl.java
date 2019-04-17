package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.repository.ServiceRepository;


@Service
public class ServiceApiImpl implements ServiceApi {
ServiceRepository serviceRepository;
	
	public ServiceApiImpl(ServiceRepository serviceRepository) {
		// TODO Auto-generated constructor stub
		this.serviceRepository = serviceRepository;
	}
	
	@Override
	public List<PropadInitiateEmployee> getAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public PropadInitiateEmployee save(PropadInitiateEmployee pie) {
		// TODO Auto-generated method stub
		return serviceRepository.save(pie);
	}
	
	

}








