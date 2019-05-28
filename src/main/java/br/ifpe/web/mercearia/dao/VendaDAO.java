package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.Venda;

public interface VendaDAO extends JpaRepository<Venda, Integer>{

}
