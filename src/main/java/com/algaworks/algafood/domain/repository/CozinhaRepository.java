package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	public List<Cozinha> listarTodos();
	
	public Cozinha buscarPorId(Long id);
	
	public Cozinha salvar(Cozinha cozinha);
	
	public void remover(Cozinha cozinha);

}
