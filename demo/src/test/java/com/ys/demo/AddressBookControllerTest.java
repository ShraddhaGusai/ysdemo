package com.ys.demo;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys.controller.AddressBookController;
import com.ys.model.AddressBook;
import com.ys.model.AddressDetail;
import com.ys.service.AddressBookService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class AddressBookControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private AddressBookController addressBookController;

	@MockBean
	private AddressBookService addressBookService;

	private List<AddressBook> addressBook = new ArrayList<>();

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		AddressBook addressBook1 = new AddressBook();

		addressBook1.setAddressId(1);
		addressBook1.setEmail("shraddha.test111@gmail.com");
		addressBook1.setFirstName("Shraddhatest");
		addressBook1.setLastName("Gusaiiii");
		addressBook1.setPhoneNumber("07436299999");

		AddressDetail ab1AddressDetail1 = new AddressDetail();
		ab1AddressDetail1.setAddressDetailId(11);
		ab1AddressDetail1.setAddressType("Home");
		ab1AddressDetail1.setBuilding("House99");
		ab1AddressDetail1.setStreet("Canary Wharf");
		ab1AddressDetail1.setCity("London");
		ab1AddressDetail1.setCountry("UK");
		ab1AddressDetail1.setPostcode("E14 9QQ");

		AddressDetail ab1AddressDetail2 = new AddressDetail();
		ab1AddressDetail2.setAddressDetailId(12);
		ab1AddressDetail2.setAddressType("Office");
		ab1AddressDetail2.setBuilding("Building25");
		ab1AddressDetail2.setStreet("14 Upper Bank Street");
		ab1AddressDetail2.setLandmark("Canary Wharf");
		ab1AddressDetail2.setCity("London");
		ab1AddressDetail2.setCountry("UK");
		ab1AddressDetail2.setPostcode("E14 5NP");

		List<AddressDetail> lAddressDetail1 = new ArrayList<AddressDetail>();
		lAddressDetail1.add(ab1AddressDetail1);
		lAddressDetail1.add(ab1AddressDetail2);
		addressBook1.setAddresses(lAddressDetail1);
		this.addressBook.add(addressBook1);

		when(addressBookService.createNewAddressBook(anyObject())).thenReturn(addressBook1);
		when(addressBookService.getAllAddresses(anyObject())).thenReturn(this.addressBook);
		doNothing().when(addressBookService).deleteAddress(anyInt());
		when(addressBookService.getAddress(anyInt())).thenReturn(addressBook1);
	}

	@Test
	public void createNewAddressBook() throws Exception {
		AddressBook addressBook1 = new AddressBook();

		addressBook1.setEmail("shraddha.test111@gmail.com");
		addressBook1.setFirstName("Shraddhatest");
		addressBook1.setLastName("Gusaiiii");
		addressBook1.setPhoneNumber("07436299999");

		AddressDetail ab1AddressDetail1 = new AddressDetail();
		ab1AddressDetail1.setAddressType("Home");
		ab1AddressDetail1.setBuilding("House99");
		ab1AddressDetail1.setStreet("Canary Wharf");
		ab1AddressDetail1.setCity("London");
		ab1AddressDetail1.setCountry("UK");
		ab1AddressDetail1.setPostcode("E14 9QQ");

		AddressDetail ab1AddressDetail2 = new AddressDetail();
		ab1AddressDetail2.setAddressType("Office");
		ab1AddressDetail2.setBuilding("Building25");
		ab1AddressDetail2.setStreet("14 Upper Bank Street");
		ab1AddressDetail2.setLandmark("Canary Wharf");
		ab1AddressDetail2.setCity("London");
		ab1AddressDetail2.setCountry("UK");
		ab1AddressDetail2.setPostcode("E14 5NP");

		List<AddressDetail> lAddressDetail1 = new ArrayList<AddressDetail>();
		lAddressDetail1.add(ab1AddressDetail1);
		lAddressDetail1.add(ab1AddressDetail2);
		addressBook1.setAddresses(lAddressDetail1);

		ObjectMapper mapper = new ObjectMapper();
		String addressBookJson = mapper.writeValueAsString(addressBook1);
		mockMvc.perform(MockMvcRequestBuilders.post("/addressBook").contentType(MediaType.APPLICATION_JSON)
				.content(addressBookJson)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	public void createAddressBookWithBadRequest() throws Exception {
		AddressBook addressBook1 = new AddressBook();

		addressBook1.setEmail("shraddha.test^^^^@gmail.com");
		addressBook1.setFirstName("Shraddha###test");
		addressBook1.setLastName("Gu$$$aiiii");
		addressBook1.setPhoneNumber("07436299999");

		AddressDetail ab1AddressDetail1 = new AddressDetail();
		ab1AddressDetail1.setAddressType("Home");
		ab1AddressDetail1.setBuilding("House99");
		ab1AddressDetail1.setStreet("Canary Wharf");
		ab1AddressDetail1.setCity("London");
		ab1AddressDetail1.setCountry("UK");
		ab1AddressDetail1.setPostcode("E14 9QQ");

		AddressDetail ab1AddressDetail2 = new AddressDetail();
		ab1AddressDetail2.setAddressType("Office");
		ab1AddressDetail2.setBuilding("Building25");
		ab1AddressDetail2.setStreet("14 Upper Bank Street");
		ab1AddressDetail2.setLandmark("Canary Wharf");
		ab1AddressDetail2.setCity("London");
		ab1AddressDetail2.setCountry("UK");
		ab1AddressDetail2.setPostcode("E14 5NP");

		List<AddressDetail> lAddressDetail1 = new ArrayList<AddressDetail>();
		lAddressDetail1.add(ab1AddressDetail1);
		lAddressDetail1.add(ab1AddressDetail2);
		addressBook1.setAddresses(lAddressDetail1);

		ObjectMapper mapper = new ObjectMapper();
		String addressBookJson = mapper.writeValueAsString(addressBook1);
		mockMvc.perform(MockMvcRequestBuilders.post("/addressBook").contentType(MediaType.APPLICATION_JSON)
				.content(addressBookJson)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	public void getAllAddresses() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/addressBook").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void deleteAddress() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/addressBook/" + addressBook.get(0).getAddressId())
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andDo(print());
	}
}
