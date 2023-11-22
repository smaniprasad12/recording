package com.icon.user;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icon.user.entity.ServiceEntity;
import com.icon.user.service.ServiceEntityService;
import com.icon.user.service.ServiceEntityServiceimpl;

@WebMvcTest
class UserApplicationTests {
	
	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private ServiceEntityService service;
	
	
	@Test
	public void createService() throws Exception{
		ServiceEntity entity=ServiceEntity.builder()
				.date("19-08-22")
				.servicename("cutting")
				.serviceprice(100)
				.build();
		mockmvc.perform(MockMvcRequestBuilders.post("/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(entity))).andExpect(MockMvcResultMatchers.status().isOk());
			
	}
	@Test
	public void getAllTest() throws Exception{
		
		ArrayList<ServiceEntity> list=new  ArrayList<ServiceEntity>();
		
		list.add(ServiceEntity.builder().date("23-06-23").servicename("haircutting").serviceprice(200).build());
		list.add(ServiceEntity.builder().date("24-06-23").servicename("hair").serviceprice(205).build());
		
		BDDMockito.given(service.getAll()).willReturn(list);
		
		ResultActions response=mockmvc.perform(MockMvcRequestBuilders.get("/getall"));
		
		  response.andExpect(MockMvcResultMatchers.status().isOk())
	       .andDo(print())
	       .andExpect( MockMvcResultMatchers.jsonPath("$.size()", is(list.size())));	
		
	}
	@Test
	public void getById() throws Exception {
		
		int id=1;
		ServiceEntity entity=ServiceEntity.builder()
				.id(1)
				.date("19-08-22")
				.servicename("cutting")
				.serviceprice(100)
				.build();
		BDDMockito.given(service.getById(id)).willReturn(entity);
		ResultActions response=mockmvc.perform(MockMvcRequestBuilders.get("/{id}",id));
		response.andExpect(status().isOk())
    	.andDo(print())
    	.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(entity.getId())))
	    .andExpect(MockMvcResultMatchers.jsonPath("$.date", is(entity.getDate())))
		.andExpect(MockMvcResultMatchers.jsonPath("$.servicename", is(entity.getServicename())))
		.andExpect(MockMvcResultMatchers.jsonPath("$.serviceprice", is(entity.getServiceprice())));	
		
	}	
	
	@Test
	public void  delete()throws Exception {
		int id=2;
		willDoNothing().given(service).delete(id);
    	ResultActions response=mockmvc.perform(MockMvcRequestBuilders.delete("/delete/{id}",id));
    	response.andExpect(status().isOk())
    	        .andDo(print());	
		
	}

}
