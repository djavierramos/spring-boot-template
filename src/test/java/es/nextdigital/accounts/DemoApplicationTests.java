package es.nextdigital.accounts;

import java.util.List;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import es.nextdigital.accounts.domain.dto.Card;
import es.nextdigital.accounts.domain.ports.CardsRepository;
import es.nextdigital.accounts.infrastructure.apirest.dto.PageRequestDTO;
import es.nextdigital.accounts.infrastructure.apirest.dto.PageRequestDTO.PageRequestDTOBuilder;
import jakarta.servlet.ServletContext;
import lombok.SneakyThrows;

@SpringBootTest
class DemoApplicationTests {
	private static final String CUSTOMER_ID_EXIST = "ASDF1234";
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	@Autowired
	CardsRepository cardsRepository;
	EasyRandom easyRandom;
	EasyRandomParameters easyRandomParameters;	
	@BeforeEach
	public void setup() throws Exception {
		easyRandomParameters = new EasyRandomParameters();
		easyRandomParameters.collectionSizeRange(2, 5);
		easyRandomParameters.stringLengthRange(2, 10);
		easyRandom = new EasyRandom(easyRandomParameters);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		cardsRepository.putAllCards(easyRandom.objects(Card.class, 50).toList());
	}	
	@Test
	void givenWhenAppStartsThenContextLoads() {
	}
	@Test
	@SneakyThrows
	public void givenUserWithAccountsWhenGetAccountsThenAccountsRetrieved() {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts?customer.id={customer.id}", CUSTOMER_ID_EXIST)).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	@SneakyThrows
	public void givenUserWithAccountsWhenGetAccountMovementsThenAccountMovementsRetrieved() {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/accounts/{account-id}/movements","ASDF1234")
			.param("page","1")
			.param("pageSize", "10"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	@SneakyThrows
	public void givienUserWithCardsAndExistingCardGetCardByPanThenGetTheCard() {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/cards").param("PAN", cardsRepository.getCards().get(0).getPAN()))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	@SneakyThrows
	public void givienUserWithCardsAndExistingCardGetCardByNotExistingThenGetTheCard() {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/cards").param("PAN", "NONEXISTINGPAN"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
