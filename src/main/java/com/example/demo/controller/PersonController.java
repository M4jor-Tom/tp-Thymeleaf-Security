package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Person;
import com.example.demo.model.PersonForm;

/**
 * PersonController est une classe Controller. Il traite les demandes d'un
 * utilisateur et contrôle le flux (flow) de l'application.
 *
 */

@Controller
public class PersonController {

	private static List<Person> persons = new ArrayList<Person>();

	static {
		persons.add(new Person("Bill", "Gates"));
		persons.add(new Person("Steve", "Jobs"));
	}

	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = "person", method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = "personList", method = RequestMethod.GET)
	public String personList(Model model) {
		model.addAttribute("persons", persons);
		return "personList";
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "addPerson";
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String savePerson(
			Model model, //
			@ModelAttribute("personForm") PersonForm personForm
	) {
		//Permet de rediriger
		//return "redirect:/personList";
		persons.add(
				new Person(
						personForm.getFirstName(),
						personForm.getLastName()
				)
		);
		
		if(personForm.fieldsAreFilled())
			return "redirect:/personList";
		else
			model.addAttribute("errorMessage", errorMessage);
		
		return "addPerson";
	}

}
