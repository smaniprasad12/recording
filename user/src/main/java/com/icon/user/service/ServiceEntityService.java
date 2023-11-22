package com.icon.user.service;

import java.util.List;

import com.icon.user.entity.ServiceEntity;

public interface ServiceEntityService {
	
	public  ServiceEntity add(ServiceEntity serviceEntity );
	public List<ServiceEntity> getAll();
	public ServiceEntity getById(int id);
    public ServiceEntity update(ServiceEntity serviceEntity);
    public void delete(int id);
}
