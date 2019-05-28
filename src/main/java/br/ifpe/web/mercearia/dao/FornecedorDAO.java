package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.Fornecedor;

public interface FornecedorDAO extends JpaRepository<Fornecedor, Integer>{

}
