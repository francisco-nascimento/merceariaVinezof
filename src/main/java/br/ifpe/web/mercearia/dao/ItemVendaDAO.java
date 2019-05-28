package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.ItemVenda;

public interface ItemVendaDAO extends JpaRepository<ItemVenda, Integer>{

}
