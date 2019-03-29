package com.ys.bootstarp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ys.model.AddressBook;
import com.ys.model.AddressDetail;
import com.ys.repository.AddressBookRepository;

/**
 * @author Shraddha Gusai
 *
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AddressBookRepository addressBookRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();

	}

	private void initData() {
		AddressBook addressBook1 = new AddressBook();

		addressBook1.setEmail("shraddha.test@gmail.com");
		addressBook1.setFirstName("Shraddha");
		addressBook1.setLastName("Gusai");
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
		ab1AddressDetail2.setStreet("10 Upper Bank Street");
		ab1AddressDetail2.setLandmark("Canary Wharf");
		ab1AddressDetail2.setCity("London");
		ab1AddressDetail2.setCountry("UK");
		ab1AddressDetail2.setPostcode("E14 5NP");
		
		List<AddressDetail> lAddressDetail1=new ArrayList<AddressDetail>();
		lAddressDetail1.add(ab1AddressDetail1);	
		lAddressDetail1.add(ab1AddressDetail2);
		addressBook1.setAddresses(lAddressDetail1);
		this.addressBookRepository.save(addressBook1);
		
		AddressBook addressBook2 = new AddressBook();
		addressBook2.setEmail("surabhi.swami@gmail.com");
		addressBook2.setFirstName("Surabhi");
		addressBook2.setLastName("Swami");
		addressBook2.setPhoneNumber("09100205309");

		AddressDetail ab2AddressDetail1 = new AddressDetail();
		ab2AddressDetail1.setAddressType("Home");
		ab2AddressDetail1.setBuilding("Flat #3");
		ab2AddressDetail1.setStreet("Patel Colony");
		ab2AddressDetail1.setCity("Jamnagar");
		ab2AddressDetail1.setCountry("India");
		ab2AddressDetail1.setPostcode("361008");
		
		AddressDetail ab2AddressDetail2 = new AddressDetail();
		ab2AddressDetail2.setAddressType("Office");
		ab2AddressDetail2.setBuilding("City Arc");
		ab2AddressDetail2.setStreet("xyz Street");
		ab2AddressDetail2.setLandmark("Main circle");
		ab2AddressDetail2.setCity("Jamnagar");
		ab2AddressDetail2.setCountry("India");
		ab2AddressDetail2.setPostcode("361008");
		
		List<AddressDetail> lAddressDetail2=new ArrayList<AddressDetail>();
		lAddressDetail2.add(ab2AddressDetail1);	
		lAddressDetail2.add(ab2AddressDetail2);
		addressBook2.setAddresses(lAddressDetail2);
		this.addressBookRepository.save(addressBook2);		

	}

}
