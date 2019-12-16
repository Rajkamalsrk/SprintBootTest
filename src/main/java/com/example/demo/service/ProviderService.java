package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.ProviderDTO;

public interface ProviderService {
	
	public ResponseEntity<Object> createProvider(ProviderDTO providerDTO);
	
	public ResponseEntity<Object> updateProvider(String providerNumber, ProviderDTO providerDTO);
	
	public List<ProviderDTO> getProviderList();
	
	public ResponseEntity<Object> deleteProvider(String providerNumber);
	
	 
	public String RequestParamExample(int id); 
	 

}
