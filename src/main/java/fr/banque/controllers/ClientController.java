package fr.banque.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

	@GetMapping()
	public String hello() {
		return "Hello nouveau client de la banque !";
	}
}
