package br.ifpe.web.mercearia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.mercearia.model.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}
