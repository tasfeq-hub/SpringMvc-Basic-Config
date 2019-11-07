package com.tasfeq.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.tasfeq.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO contactDAO;
	
	@BeforeEach
	void setUpDataSource() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("contactdb");
		dataSource.setPassword("contactdb");
		
		contactDAO = new ContactDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Contact abir = new Contact("abir","abir@gmail.com","1231233");
		int result = contactDAO.save(abir);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact sourav = new Contact(1,"sourav","abir@gmail.com","1231233");
		int result = contactDAO.update(sourav);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = contactDAO.get(id);
		
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 1;
		int result = contactDAO.delete(1);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> contactList = contactDAO.list();
		
		assertTrue(!contactList.isEmpty());
	}

}
