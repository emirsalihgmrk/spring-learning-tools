package com.example.section_15.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.section_15.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

	//@PreAuthorize("hasRole('USER')")
	List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);

}
