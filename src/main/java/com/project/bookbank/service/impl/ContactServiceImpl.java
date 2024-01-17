package com.project.bookbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Contact;
import com.project.bookbank.repository.ContactRepository;
import com.project.bookbank.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContact(Contact contact) {
		this.contactRepo.save(contact);
	}

}
