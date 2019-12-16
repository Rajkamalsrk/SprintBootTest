package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.model.ProviderDTO;
import com.example.demo.service.ProviderService;

@RestController
public class ProviderController {
	
	
	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "Welcome to My First Spring Boot WebApplication SRK!!";
		}

	@Autowired
	ProviderService providerService;

	@RequestMapping(value = "/provider",method = RequestMethod.POST)
	public ResponseEntity<Object> createProvider(@RequestBody ProviderDTO providerDTO) {
		return providerService.createProvider(providerDTO);
	}

	@RequestMapping(value = "/provider/{providerNumber}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateProvider(@PathVariable("providerNumber") String providerNumber,@RequestBody ProviderDTO providerDTO) {
		return providerService.updateProvider(providerNumber, providerDTO);
	}

	@RequestMapping(value ="/provider",method = RequestMethod.GET)
	public List<ProviderDTO> getProviderList() {
		return providerService.getProviderList();
	}

	@RequestMapping(value = "/provider/{providerNumber}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProvider(@PathVariable("providerNumber") String providerNumber) {
		return providerService.deleteProvider(providerNumber);
	}
	
	@RequestMapping(value="/RequestParamExample",method = RequestMethod.GET)
	@ResponseBody
	public String RequestParamExample(@RequestParam(value="id",required=false,defaultValue="12334")int id) {
		return providerService.RequestParamExample(id);
	}
}
