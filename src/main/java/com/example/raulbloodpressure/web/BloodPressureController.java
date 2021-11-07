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

	@RequestMapping(value = { "/", "/home" })
	public String bloodpressureList(Model model) {

		// in code executed by endpoint, information can be placed in
		// the model that is displayed on the html page
		model.addAttribute("bloodpressures", repository.findAll());

		// returns the file name to be displayed -
		// spring adds a .html extension itself, it can't be put here

		return "home";
	}

	@RequestMapping(value = "/add")
	public String addBloodpressure(Model model) {
		model.addAttribute("bloodpressures", new Bloodpressure());
		return "addbloodpressure";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBloodpressure(Bloodpressure bloodpressure) {
		repository.save(bloodpressure);
		// after saving, page returns to the home.html
		return "redirect:home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBloodpressure(@PathVariable("id") Long BloodpressureId, Model model) {
		repository.deleteById(BloodpressureId);
		// after deleting, page returns to the last page which is home.html
		return "redirect../";
		
	}

}
