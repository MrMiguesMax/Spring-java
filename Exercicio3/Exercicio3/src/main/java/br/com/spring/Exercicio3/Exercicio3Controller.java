package br.com.spring.Exercicio3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio3Controller {
	@GetMapping("/adicao")
	public String adicao(@RequestParam int n1, @RequestParam int n2) {
		int resultado;
		resultado = n1 + n2;
		return "O resultado da soma é: " + resultado;

	}

	@GetMapping("/subtracao")
	public String subtracao(@RequestParam int n1, @RequestParam int n2) {
		int resultado;
		resultado = n1 - n2;
		return "O resultado da subtração é: " + resultado;
	}

	@GetMapping("/multiplicacao")
	public String multiplicacao(@RequestParam int n1, @RequestParam int n2) {
		int resultado;
		resultado = n1 * n2;
		return "O resultado da multiplicação é: " + resultado;
	}

	@GetMapping("/divisao")
	public String divisao(@RequestParam int n1, @RequestParam int n2) {
		int resultado;
		resultado = n1 / n2;
		return "O resultado da divisão é: " + resultado;
	}

}