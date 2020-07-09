package com.surendra.service;

import java.util.List;

import com.surendra.binding.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	
	public List<Contact> getAllContacts(); 
	
	public boolean deleteContact(int id);
	
	public Contact getContactById(int id);

}
