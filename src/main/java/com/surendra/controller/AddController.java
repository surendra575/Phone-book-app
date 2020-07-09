package com.surendra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surendra.binding.Contact;
import com.surendra.service.ContactServiceImpl;

@Controller
public class AddController {

	@Autowired
	private ContactServiceImpl service;

	@GetMapping(value= {"/","/contactApp"})
	public String loadHomePage(Model model) {
		//System.out.println("check 1......");
		Contact c = new Contact();
		model.addAttribute("contact", c);

		return "contact";
	}

	@PostMapping("/addContact")
	public String addContact(@ModelAttribute("contact") Contact contact , RedirectAttributes ra,Model model) {
		if(contact.getContactEmail()==null || contact.getContactName()==null||contact.getContactNumber()==0)
		{
			ra.addFlashAttribute("er", "All fields are mandatory");
			return "redirect:/contactApp";
		} 
		//System.out.println("**********Contact Id: "+contact.getContactId());
		
		if (contact.getContactId() == 0) {
			boolean val = service.saveContact(contact);
			String msg = "";

			if (val) {
				msg = "Successfully stored in DB !!!";
				//model.addAttribute("smsg", msg);
				ra.addFlashAttribute("smsg", msg);

			} else {
				msg = "Not stored in DB !!!";
				//model.addAttribute("emsg", msg);
				ra.addFlashAttribute("emsg", msg);
			}

			return "redirect:/contactApp";
		} else {
			boolean val = service.saveContact(contact);
			String msg = "";

			if (val) {
				msg = "Contact updated successfully";
				//model.addAttribute("smsg", msg);
				ra.addFlashAttribute("smsg", msg);

			} else {
				msg = "Unable to update the record";
				//model.addAttribute("emsg", msg);
				ra.addFlashAttribute("emsg", msg);
			}

			return "redirect:/contactApp";

		}
	}

}
