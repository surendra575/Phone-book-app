package com.surendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.surendra.binding.Contact;
import com.surendra.service.ContactServiceImpl;

@Controller
public class ViewController {
	@Autowired
	private ContactServiceImpl ser;
	
	@GetMapping("/viewAllContacts")
	public String allContacts(Model model)
	{
		List<Contact> allContacts = ser.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContacts";
	}
	
	
	
	@GetMapping(value="/delete/{contactId}")
	public String deleteContact(@PathVariable int contactId,Model model)
	{
		System.out.println("contact Id: "+contactId);
		boolean result = ser.deleteContact(contactId);
		if(result) {
//		if(result)
//		{
//			model.addAttribute("msg", "Contact deleted successfully...!!!");
//			return "viewContacts";
//		}
//		else
//		{
//			model.addAttribute("msg", "Some error occured...!!");
//			return "viewContacts";
//		}
		System.out.println("--------------------------->");
		return "redirect:/viewAllContacts";}
		else
		{
			return null;
		}
	}
	
	
	@GetMapping(value="/edit/{contactId}") 
	public String editContact(@PathVariable int contactId, Model model) {
		
		Contact con = ser.getContactById(contactId);
		//System.out.println(con.getContactId()+" "+con.getContactName()+" "+con.getContactEmail());
		model.addAttribute("contact", con);
		return "contact";
	}

}
