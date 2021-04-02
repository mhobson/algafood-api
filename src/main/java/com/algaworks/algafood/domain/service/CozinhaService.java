package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		
		} catch (EmptyResultDataAccessException e) {
			// Entra aqui caso não exista cozinha com o id informado
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe cozinha com o código %d no cadastro.", cozinhaId));
		
		} catch (DataIntegrityViolationException e) {
			// Entra aqui caso a cozinha já esteja associada a algum restaurante no banco de dados
			throw new EntidadeEmUsoException(
				String.format("Cozinha de código %d não pode ser removida, pois está em uso.", cozinhaId));
		}
	}

}
