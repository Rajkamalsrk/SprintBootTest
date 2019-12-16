package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProviderDuplicateException;
import com.example.demo.exception.ProviderNotfoundException;
import com.example.demo.model.ProviderDTO;
import com.example.demo.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	private static Map<String, ProviderDTO> providerMap = new HashMap<String,ProviderDTO>();
	
	static{
		ProviderDTO providerDTO = new ProviderDTO();
		providerDTO.setProviderNumber("109878");
		providerDTO.setProviderName("FairView");
		providerDTO.setAddress("3535 BlueCross Road");
		providerDTO.setCity("Eagan");
		providerDTO.setState("MN");
		providerDTO.setZip("55122");
		providerMap.put(providerDTO.getProviderNumber(), providerDTO);
		
		ProviderDTO providerDTO1 = new ProviderDTO();
		providerDTO1.setProviderNumber("109879");
		providerDTO1.setProviderName("HealthPartner");
		providerDTO1.setAddress("3513 Cinnamon Ridge");
		providerDTO1.setCity("Apple Valley");
		providerDTO1.setState("MN");
		providerDTO1.setZip("55124");
		providerMap.put(providerDTO1.getProviderNumber(), providerDTO1);
	}

	@Override
	public ResponseEntity<Object> createProvider(ProviderDTO providerDTO) {
		if(providerMap.containsKey(providerDTO.getProviderNumber()))throw new ProviderDuplicateException();
		providerMap.put(providerDTO.getProviderNumber(), providerDTO);
		return new ResponseEntity<Object>("Provider is added into FAD System!!",HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<Object> updateProvider(String providerNumber, ProviderDTO providerDTO) {
		if(!providerMap.containsKey(providerNumber))throw new ProviderNotfoundException();
		providerMap.remove(providerNumber);
		providerDTO.setProviderNumber(providerNumber);
		providerMap.put(providerNumber, providerDTO);
		return new ResponseEntity<Object>("Provider Information is updated!!",HttpStatus.OK);
		
	}

	@Override
	public List<ProviderDTO> getProviderList() {
		List<ProviderDTO> list = new ArrayList<ProviderDTO>(providerMap.values());
		return list;
	}

	@Override
	public ResponseEntity<Object> deleteProvider(String providerNumber) {
		providerMap.remove(providerNumber);
		return new ResponseEntity<Object>("Provder is deleted from FAD System!!",HttpStatus.OK);
		
	}

	@Override
	public String RequestParamExample(int id) {
		return "RequestParamExample with id= "+id;
	}

}
