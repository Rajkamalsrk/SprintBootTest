package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.ProviderDTO;

public class ProviderServiceControllerTest extends ProviderAbstractTest {
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Test
	   public void getProductsList() throws Exception {
	      String uri = "/provider";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      ProviderDTO[] productlist = super.mapFromJson(content, ProviderDTO[].class);
	      assertTrue(productlist.length > 0);
	   }
	   
	   @Test
	   public void createProvider() throws Exception {
	      String uri = "/provider";
	      ProviderDTO providerDTO = new ProviderDTO();
	      providerDTO.setProviderNumber("109881");
		  providerDTO.setProviderName("FairView");
		  providerDTO.setAddress("3535 BlueCross Road");
		  providerDTO.setCity("Eagan");
		  providerDTO.setState("MN");
		  providerDTO.setZip("55122");
	      String inputJson = super.mapToJson(providerDTO);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      System.out.println(status);
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Provider is added into FAD System!!");
	   }
	   
	   @Test
	   public void updateProduct() throws Exception {
	      String uri = "/provider/109878";
	      ProviderDTO providerDTO = new ProviderDTO();
	      providerDTO.setProviderName("FairView");
	      String inputJson = super.mapToJson(providerDTO);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Provider Information is updated!!");
	   }
	   
	   @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/provider/109878";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Provder is deleted from FAD System!!");
	   }
}
