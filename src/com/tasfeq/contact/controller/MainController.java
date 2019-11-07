package com.tasfeq.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tasfeq.contact.dao.ContactDAO;
import com.tasfeq.contact.model.Contact;

@Controller
public class MainController {

	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView home(ModelAndView model) {
		List<Contact> contactList = contactDAO.list();
		model.addObject("contactList",contactList);
		model.setViewName("index");
		
		return model;
	}
}
