package com.icon.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icon.user.entity.ServiceEntity;
import com.icon.user.repository.ServiceRepository;

@Service
public class ServiceEntityServiceimpl implements ServiceEntityService {
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public ServiceEntity add(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		return this.serviceRepository.save(serviceEntity);
	}

	@Override
	public List<ServiceEntity> getAll() {
		// TODO Auto-generated method stub
		return this.serviceRepository.findAll();
	}

	@Override
	public ServiceEntity getById(int id) {
		// TODO Auto-generated method stub
		Optional<ServiceEntity> serevicedb=this.serviceRepository.findById(id);
		if(serevicedb.isPresent()) {
			return serevicedb.get();
		}
		else {
			return null;
			
		}
		
	}

	@Override
	public ServiceEntity update(ServiceEntity serviceEntity) {
		Optional<ServiceEntity> serevicedb=this.serviceRepository.findById(serviceEntity.getId());
		if(serevicedb.isPresent()) {
			ServiceEntity serviceupdate=serevicedb.get();
			serviceupdate.setDate(serviceEntity.getDate());
			serviceupdate.setServicename(serviceEntity.getServicename());
			serviceupdate.setServiceprice(serviceEntity.getServiceprice());
			serviceRepository.save(serviceupdate);
			return serviceupdate;
		}
			else {	
				return null;
			}
		}

	@Override
	public void delete(int id) {
		Optional<ServiceEntity> serevicedb=this.serviceRepository.findById(id);
		if(serevicedb.isPresent()) {
			serviceRepository.delete(serevicedb.get());
			
		}
		
		
	}
		
		
	
	

}
