package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Contact;
import org.kitchenstudio.entity.ContactItem;

public interface ContactService {

	List<Contact> findAll();

	void save(Contact contact, List<ContactItem> contactItems);

}
