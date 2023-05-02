 package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.dto.LeadDto;
import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;

@RestController//these becomes api layer these will be layer will give me the api layer//here common interface develpoing here
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	 private LeadRepository leadRepository;
	
 //local://8080/api/leads enter these url go to all leads get the records and convert json object with help og getmapping 
	@GetMapping/////which take java objects convert into json objects
	public List <Lead>getAllLeads(){
		List<Lead> leads = leadRepository.findAll();// data put that into java object
              return  leads;//then java objects convert in  json  object
              
		}
	@PostMapping//it is used create record in database using json 
	public void saveLead(@RequestBody Lead lead) {//take json object convert into java object
		leadRepository.save(lead);
	
}
	//localhost:8080/api/leads/{id}"
	@DeleteMapping("/{id}")
	public void deleteOneLeadById(@PathVariable("id")long id ) {
		leadRepository.deleteById(id);
				
}
	//localhost:8080/api/leads/
	@PutMapping	    //is used to save the data
	public void updateOneLead(@RequestBody LeadDto leadDto) { 
		Lead l = new Lead ();
		l.setId(leadDto.getId());
		l.setFirstName(leadDto.getFirstName());
		l.setLastName(leadDto.getLastName());
		l.setEmail(leadDto.getEmail());
		l.setMobile(leadDto.getMobile());
		leadRepository.save(l);
}
	//http:localhost:8080/api/leads/{id}
	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable("id")long id) {
		
	Optional<Lead> findById = leadRepository.findById(id);
		
		
		return findById.get();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}