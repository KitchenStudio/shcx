package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Contact;
import org.kitchenstudio.model.ContactItem;

public interface ContactService {

	List<Contact> findAll();

	Contact findById();
	
	void save(Contact contact, List<ContactItem> contactItems);

}