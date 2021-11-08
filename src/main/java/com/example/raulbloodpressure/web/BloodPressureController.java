package com.example.raulbloodpressure.web;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.raulbloodpressure.model.Bloodpressure;
import com.example.raulbloodpressure.model.BloodpressureRepository;

@Controller // mark class as a Spring web MVC controller, we don't need @ResponseBody when
			// using Thymeleaf templates
public class BloodPressureController {
	@Autowired
	private BloodpressureRepository repository;
	// @Autowired enables the interaction between the controller and the repository

	// @RequestMapping maps the URLs to controller methods
	@RequestMapping(value = { "/", "/home" })
	public String bloodpressureList(Model model) {

		// in code executed by endpoint, information can be placed in
		// the model that is displayed on the html page
		model.addAttribute("bloodpressures", repository.findAll());

		// returns the file name to be displayed -
		// spring adds a .html extension itself, it can't be put here

		return "home";
	}

	// add a bloodpressure
	@RequestMapping(value = "/add")
	public String addBloodpressure(Model model) {
		model.addAttribute("bloodpressures", new Bloodpressure(0, 0, 0, LocalDate.now()));
		return "addbloodpressure";
	}

	// save the bloodpressure
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBloodpressure(Bloodpressure bloodpressure) {
		repository.save(bloodpressure);
		// after saving, page returns to the home.html
		return "redirect:home";
	}

	// for deleting bloodpressure
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBloodpressure(@PathVariable("id") Long BloodpressureId, Model model) {
		repository.deleteById(BloodpressureId);
		// after deleting, page returns to the last page which is home.html
		return "redirect:../";
	}

	// for editing bloodpressure
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBloodpressure(@PathVariable("id") Long BloodpressureId, Model model) {

		Optional<Bloodpressure> Bloodpressure = repository.findById(BloodpressureId);
		model.addAttribute("bloodpressures", repository.findById(BloodpressureId));
		return "edit";
	}

}
