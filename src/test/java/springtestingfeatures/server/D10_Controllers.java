package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import springtestingfeatures.server.configurations.D08_JdbcConfiguration;
import springtestingfeatures.server.configurations.D10_ControllerConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "classpath:CreateItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:DeleteItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes= {D10_ControllerConfiguration.class})
@AutoConfigureMockMvc
public class D10_Controllers {

	@Autowired MockMvc mockMvc;
	@Autowired ItemRepository itemRepository;
	@Autowired ItemController controller;
	
	@Test public  void itLoads() {
		assertNotNull(mockMvc);
		assertNotNull(itemRepository);
		assertNotNull(controller);
	}
	
	@Test
	public void whenNoItemsAvailable_thenGetReturnsAnErrorCode() throws Exception {
		this.mockMvc
		.perform(get("/items/"))
		.andDo(print())
    	.andExpect(status().isServiceUnavailable());
	}
	
	@Test
	public void whenItemsAreAdded_thenGetReturnsNumberOfItems() throws Exception {
		
		mockMvc.perform(
				post("/items/add/")
				.content(asJsonString("Item1"))
				.contentType("application/json"))
	    		.andExpect(status().isOk());
	    mockMvc.perform(
	    		post("/items/add/")
	    		.content(asJsonString("Item2"))
				.contentType("application/json"))
				.andExpect(status().isOk());

	    MvcResult result =  mockMvc.perform(
	    		get("/items/"))
	    	.andExpect(status().isOk())
	    	.andReturn();
	    
	    assertEquals("2 Items",result.getResponse().getContentAsString());
    
	}


	private String asJsonString(Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
