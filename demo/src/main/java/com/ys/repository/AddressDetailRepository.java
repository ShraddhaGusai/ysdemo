package com.ys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ys.model.AddressDetail;

/**
 * @author Shraddha Gusai
 *
 */
@Repository
public interface AddressDetailRepository extends CrudRepository<AddressDetail, Integer> {

}
