package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.DTO.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.TipoMovimentacao;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository corrRepository;
	
	public void Save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		 
		Double valor = novaMovimentacao.getTipoMovimentacao()==TipoMovimentacao.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipoMovimentacao(novaMovimentacao.getTipoMovimentacao());
		movimentacao.setValor(valor);
		
		Correntista correntista = corrRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if(correntista == null) 
			return;
			
		correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
		corrRepository.save(correntista);
		
		repository.save(movimentacao);
	}
}
