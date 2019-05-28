package br.ifpe.web.mercearia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.mercearia.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer>{

	// Spring Data JPA já considera o findByXXX como pesquisa pelo campo XXX
	// Além disso o ContainingIgnoreCase ja aplica o criterio de like e case insensitive
//	@Query("select p from Produto p where UPPER(p.nome) like UPPER(CONCAT('%',:nomePesquisa, '%')) order by p.nome")
	public List<Produto> findByNomeContainingIgnoreCase(String nomePesquisa);

}
