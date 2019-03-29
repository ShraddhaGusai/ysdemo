/**
 * 
 */
package com.ys.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.ys.model.AddressBook;
import com.ys.model.AddressDetail;

/**
 * @author Shraddha Gusai
 *
 */
public interface AddressBookService {

	public List<AddressBook> getAllAddresses(Pageable pageable);

	public AddressBook getAddress(int addressId);
	
	public void deleteAddress(int addressId);

	public AddressBook createNewAddressBook(@Valid AddressBook addressBook);

	public List<AddressDetail> createNewAddressDetail(List<AddressDetail> addressDetail, int addressId);

}
