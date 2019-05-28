package br.ifpe.web.mercearia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web.mercearia.dao.CategoriaDAO;
import br.ifpe.web.mercearia.dao.FornecedorDAO;
import br.ifpe.web.mercearia.dao.ProdutoDAO;
import br.ifpe.web.mercearia.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private CategoriaDAO categoriaDao;
	@Autowired
	private FornecedorDAO fornecedorDao;
	@Autowired
	private ProdutoDAO produtoDao;
	
	@GetMapping("/produtos")
	public ModelAndView exibirProdutos() {
		ModelAndView mv = new ModelAndView("/produtos-list");		
		mv.addObject("listaProdutos", this.produtoDao.findAll(Sort.by("nome")));
		return mv;
	}
	
	@PostMapping("/produtos")
	public ModelAndView pesquisarProdutos(@RequestParam(required=false) String nomePesquisa) {
		ModelAndView mv = new ModelAndView("/produtos-list");		
		
		List<Produto> listaProdutos;
		if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
			listaProdutos = this.produtoDao.findAll(Sort.by("nome"));	
		} else {
			listaProdutos = this.produtoDao.findByNomeContainingIgnoreCase(nomePesquisa);
		}
		
		mv.addObject("listaProdutos", listaProdutos);
		return mv;
	}

	@PostMapping("/salvarProduto")
	public ModelAndView salvarProduto(@Valid Produto produto, BindingResult br) {


		if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("/produtos-form");
			mv.addObject("listaCategorias", this.categoriaDao.findAll(Sort.by("nome")));
			mv.addObject("listaFornecedores", this.fornecedorDao.findAll(Sort.by("nome")));
			return mv;
		} 

		this.produtoDao.save(produto);
		return exibirProdutos();
	}
	
	@GetMapping("/produtosForm")
	public ModelAndView exibirFormProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("/produtos-form");		
		mv.addObject("listaCategorias", this.categoriaDao.findAll(Sort.by("nome")));
		mv.addObject("listaFornecedores", this.fornecedorDao.findAll(Sort.by("nome")));
		// Caso seja passado o Id do produto, esta chamada será para edição do produto
		if (produto != null && produto.getId() != null) {
			produto = this.produtoDao.getOne(produto.getId());
		} else { // Caso contrário, será uma adição de novo produto
			produto = new Produto();
		}
		mv.addObject("produto", produto);
		return mv;
	}
	
	@GetMapping("/produtosRem")
	public String removerProduto(Produto produto) {
		if (produto != null && produto.getId() != null) {
			this.produtoDao.delete(produto);
		}
		return "redirect:/produtos";
	}
}
