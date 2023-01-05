package demoMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exoFormation.service.FormateurService;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private FormateurService formateurService;

	@GetMapping("")
	public String list() {
		System.out.println(formateurService);
		return null;
	}
}
