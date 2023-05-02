	package com.marketing.controller;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadDto;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;
	
	@Controller
	public class LeadController {
		
		@Autowired
	private	LeadService  leadservice;
		//locaal 
		
		@Autowired   //it is an depencency injection it folloos single turn desingn pattern it becomes thread safety
		private EmailService emailService;
	
		@RequestMapping("/create") // acts like webservelt//map to  with url
		public String createnewleadform() {   
	             ////pre-populted already data is there meaning
	      	     	return "create_lead";//request dispatcher
		}
		
		@RequestMapping("/savereg")
		public String saveOneLead(  Lead lead,Model map)  { 
			
			map.addAttribute("msg", "lead saved succesful");
			leadservice.saveReg(lead);//after saving the lead i send to email
			emailService.sendEmail(lead.getEmail(), "test", "testing eamil service");
		return"create_lead"; 
	}
//		
		@RequestMapping("/list")
		public String getAllLeads(Model model) { //acts request setattribute or getattribute//bind the controller data withe the view
			
			List<Lead> leads = leadservice.findAlLeads();
			model.addAttribute("leads", leads);
			return"list_leads";//table 
		}
		@RequestMapping("/delete")
		public String deleteByPost(@RequestParam("id")long id,Model model ) {
			leadservice.deletebyid(id);
			
			List<Lead> leads = leadservice.findAlLeads();
			model.addAttribute("leads", leads);
			return"list_leads";
		}
		@RequestMapping("/update")
		public String findLeadId(@RequestParam("id") long id,Model model) {
			Lead lead = leadservice.findById(id);
			model.addAttribute("lead",lead );
			return"update_lead";
		}
		@RequestMapping("/editreg")
		public String findLeadId(LeadDto dto,Model model) {
			Lead lead  = new Lead();
			lead.setId(dto.getId());
			lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
	    lead.setMobile(dto.getMobile());
			leadservice.saveReg(lead);
			
			List<Lead> leads = leadservice.findAlLeads();
			model.addAttribute("leads", leads);
			return"list_leads";
		}
//		
//		
//		
//	
	}