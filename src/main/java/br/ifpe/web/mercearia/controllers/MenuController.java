package br.ifpe.web.mercearia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/vinezof")
	public String exibirPaginaInicial() {
		return "home";
	}
	@GetMapping("/categorias")
	public String exibirCategorias() {
		return "/categorias-list";
	}
	
	@GetMapping("/fornecedores")
	public String exibirFornecedores() {
		return "/fornecedores-list";
	}

	
}
