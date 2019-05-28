package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}
