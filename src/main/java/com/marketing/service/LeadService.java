package com.marketing.service;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
	public void saveReg(Lead lead);

	public List <Lead> findAlLeads();//lead objects gwnerate

	public void deletebyid( long id);

	public void findbyid(long id);

	

	//public list<Lead> findalleads();


	
	
	
}


