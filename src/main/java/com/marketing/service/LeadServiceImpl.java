package com.marketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;
import com.marketing.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadrepo;///

	@Override
	public void saveReg(Lead lead) {
		leadrepo.save(lead);

	}

	@Override
	public List<Lead> findAlLeads() {//<lead> is    here 
		List<Lead> leads = leadrepo.findAll();//
		return leads;
	}

	@Override
	public void deletebyid(long id) {
		leadrepo.deleteById(id);
		
	}

	@Override
	public Lead findById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}


	


	
}
