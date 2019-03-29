package com.ys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ys.model.AddressBook;

/**
 * @author Shraddha Gusai
 *
 */
@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {

}
