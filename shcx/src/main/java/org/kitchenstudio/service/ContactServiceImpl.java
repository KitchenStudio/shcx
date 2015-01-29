package org.kitchenstudio.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kitchenstudio.model.Contact;
import org.kitchenstudio.model.ContactItem;
import org.kitchenstudio.repository.ContactItemRepository;
import org.kitchenstudio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	private final ContactItemRepository contactItemRepository;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository,
			ContactItemRepository contactItemRepository) {
		this.contactRepository = contactRepository;
		this.contactItemRepository = contactItemRepository;
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public void save(Contact contact, List<ContactItem> contactItems) {
		Set<ContactItem> savedItems = new HashSet<>();
		for (ContactItem contactItem : contactItems) {
			savedItems.add(contactItemRepository.save(contactItem));
		}
		
		contact.setContactItems(savedItems);
		contactRepository.save(contact);
	}

}
