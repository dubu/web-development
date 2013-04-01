package com.dubu.struts.service;


import com.dubu.struts.model.Person;

public interface EditService {
	
	
	Person getPerson() ;

	void savePerson(Person personBean);

}
