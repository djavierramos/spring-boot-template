package es.nextdigital.accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import jakarta.servlet.ServletContext;
import lombok.SneakyThrows;

@SpringBootTest
class DemoApplicationTests {
	private static final String CUSTOMER_ID_EXIST = "ASDF1234";
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}	
	@Test
	void givenWhenAppStartsThenContextLoads() {
	}
	@Test
	@SneakyThrows
	public void givenUserWithAccountsWhenGetAccountsThenAccountsRetrieved() {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts?customer.id={customer.id}", CUSTOMER_ID_EXIST)).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
