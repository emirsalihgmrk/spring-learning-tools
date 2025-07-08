package com.example.section8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.section8.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
	
}
