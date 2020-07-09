package com.surendra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surendra.binding.Contact;
import com.surendra.entity.ContactEntity;
import com.surendra.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository repo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity e=new ContactEntity();
//		e.setContactName(c.getContactName());
//		e.setContactEmail(c.getContactEmail());
//		e.setContactNumber(c.getContactNumber());
		BeanUtils.copyProperties(c, e);
		ContactEntity entity = repo.save(e);
		return entity.getContactName()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> clist=new ArrayList<>();
		List<ContactEntity> all = repo.findAll(); 
		 for(ContactEntity e:all)
		 {
			 Contact c=new Contact();        
			  
//			 c.setContactId(e.getContactId());
//			 c.setContactName(e.getContactName());
//			 c.setContactEmail(e.getContactEmail());
//			 c.setContactNumber(e.getContactNumber());
			 
			 BeanUtils.copyProperties(e, c); 
			 
			 clist.add(c);
		 } 
		return clist;
	}

	@Override
	public boolean deleteContact(int id) {
		repo.deleteById(id);
		boolean res=repo.existsById(id);
		if(res) {
		return false;}
		else
		{
			return true;
		}
	}

	@Override
	public Contact getContactById(int id) {
		Optional<ContactEntity> ent = repo.findById(id);
		ContactEntity cty=ent.get();
		Contact c=new Contact();		
		BeanUtils.copyProperties(cty, c);
		return c;
	}

}
