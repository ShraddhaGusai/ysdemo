/**
 * 
 */
package com.ys.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.ys.model.AddressBook;
import com.ys.model.AddressDetail;
import com.ys.repository.AddressBookRepository;
import com.ys.repository.AddressDetailRepository;

/**
 * @author Shraddha Gusai
 *
 */
@Service
@Transactional
@EntityScan("com.ys.model")
@EnableJpaRepositories("com.ys.repository")
public class AddressBookServiceImpl implements AddressBookService{
	
	@Autowired
	AddressBookRepository addressBookRepository;
	
	@Autowired
	AddressDetailRepository addressDetailRepository;

	public List<AddressBook> getAllAddresses(Pageable pageable) {
		List<AddressBook> addressBook = new ArrayList<>();
		addressBookRepository.findAll().forEach(addressBook::add);
		return addressBook;
	}

	public AddressBook getAddress(int addressId) {		
		addressBookRepository.findById(addressId);
		return null;
	}

	public void deleteAddress(int addressId) {
		addressBookRepository.deleteById(addressId);		
	}

	@Override
	public AddressBook createNewAddressBook(@Valid AddressBook addressBook) {
		AddressBook persistAdressBook = addressBookRepository.save(addressBook);
		return persistAdressBook;
	}

	@Override
	public List<AddressDetail> createNewAddressDetail(List<AddressDetail> addressDetail, int addressId) {
		AddressBook addressBook = addressBookRepository.findById(addressId).get();
		addressBook.setAddresses(addressDetail);
		AddressBook persistAdressBook = addressBookRepository.save(addressBook);
		return persistAdressBook.getAddresses();
	}	
}
