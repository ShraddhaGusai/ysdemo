/**
 * 
 */
package com.ys.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ys.model.AddressBook;
import com.ys.model.AddressDetail;
import com.ys.service.AddressBookService;

/**
 * @author Shraddha Gusai
 *
 */
@RestController
public class AddressBookController {

	@Autowired
	private AddressBookService addressBookService;
	
	@RequestMapping(value = "/addressBook", method=RequestMethod.GET)
	public List<AddressBook> getAllAddresses(Pageable pageable){
		return addressBookService.getAllAddresses(pageable);
	}
		
	@RequestMapping(value="/addressBook/{addressId}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public AddressBook getAddress(@PathVariable int addressId) {
		return addressBookService.getAddress(addressId);
	}
	@RequestMapping(value = "/addressBook", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public AddressBook createNewAddressBook(@Valid @RequestBody AddressBook addressBook) {
		return addressBookService.createNewAddressBook(addressBook);
	}
	
	@RequestMapping(value = "/addressBook/{addressId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAddress(@PathVariable int addressId) {
		addressBookService.deleteAddress(addressId);
	}	
}
