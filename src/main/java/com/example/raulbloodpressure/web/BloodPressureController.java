package com.example.raulbloodpressure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.raulbloodpressure.model.Bloodpressure;
import com.example.raulbloodpressure.model.BloodpressureRepository;

@Controller
public class BloodPressureController {
	@Autowired
	private BloodpressureRepository repository;
	
	@RequestMapping(value = { "/", "/bloodpressurelist" })
	public String bloodpressurelist(Model model) {
		model.addAttributes("bloodpressures", repository.findAll());
		
		return "bloodpressurelist";
	}
	
	@RequestMapping(value = "/add")
	public String addBloodpressure(Model model) {
		model.addAttribute("bloodpressure", new Bloodpressure());
		return "addBloodpressure";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBloodpressure(Bloodpressure bloodpressure) {
		repository.save(bloodpressure);
		return "redirect:bloodpressurelist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBloodpressure(@PathVariable("id") Long BloodpressureId, Model model) {
		repository.deleteById(BloodpressureId);
		return "redirect../bloodpressurelist";
	}
	

}
