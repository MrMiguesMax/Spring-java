package br.com.spring.Exercicio10.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Exercicio10Controller {

	@GetMapping("/compra")
	public String obterCotacaoCompraDolarReal() {
		return obterCotacaoPorTipo("bid");
	}

	@GetMapping("/venda")
	public String obterCotacaoVendaDolarReal() {
		return obterCotacaoPorTipo("ask");
	}

	@GetMapping("/max")
	public String obterCotacaoMaimaDolarReal() {
		return obterCotacaoPorTipo("high");
	}

	@GetMapping("/min")
	public String obterCotacaoMinimaDolarReal() {
		return obterCotacaoPorTipo("low");
	}

	@GetMapping("/all")
	public String obterCotacoesDolarReal() {
		return obterCotacaoPorTipo("all");
	}

	private String obterCotacaoPorTipo(String tipo) {
		RestTemplate restTemplate = new RestTemplate();

		String url = "https://https://economia.awesomeapi.com.br/json/last/USD-BRL";

		try {
			String resposta = restTemplate.getForObject(url, String.class);

			try {
				if (tipo.equals("all")) {
					return resposta;
				} else {
					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode rootNode = objectMapper.readTree(resposta);
					JsonNode campoNode = rootNode.get("USDBRL").get("tipo");
					return campoNode.asText();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Erro ao obter o valor: " + e.getMessage();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao obter o valor: " + e.getMessage();
		}
	}
}