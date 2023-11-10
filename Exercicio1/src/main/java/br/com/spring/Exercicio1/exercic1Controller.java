package br.com.spring.Exercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exercic1Controller {
		@GetMapping("/home")
		public String home() {		
			return "Olá, seja bem vindo ao sistema. Você está na home.";
		}
		
		@GetMapping("/aluno")
		public String aluno() {		
			return "Olá, bem vindo aluno(a).";
		}

		@GetMapping("/professor")
		public String professor() {		
			return  "Olá, bem vindo professor(a).";
		}

		@GetMapping("/senai")
		public String senai() {		
			return"Olá, bem vindo ao Senai.";
		}

}