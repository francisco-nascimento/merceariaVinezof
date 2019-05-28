package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.Vendedor;

public interface VendedorDAO extends JpaRepository<Vendedor, Integer>{

}
