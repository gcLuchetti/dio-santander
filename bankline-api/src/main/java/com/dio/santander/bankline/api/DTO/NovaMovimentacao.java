package com.dio.santander.bankline.api.DTO;

import com.dio.santander.bankline.api.model.TipoMovimentacao;

public class NovaMovimentacao {
	private String descricao;
	private Double valor;
	private Integer idConta;
	private TipoMovimentacao tipoMovimentacao;


	public String getDescricao() {
		return descricao;
	}
	public Double getValor() {
		return valor;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}


}
