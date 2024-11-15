package co.edu.unbosque.mensajeria.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.mensajeria.services.EmailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
    private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body){
		try {
			emailService.sendEmail(to, URLDecoder.decode(subject, StandardCharsets.UTF_8.toString()), URLDecoder.decode(body, StandardCharsets.UTF_8.toString()));
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Correo en espera a ser procesado.");
		} catch (UnsupportedEncodingException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Imposible procesar el correo.");
		}
	}
	
}
