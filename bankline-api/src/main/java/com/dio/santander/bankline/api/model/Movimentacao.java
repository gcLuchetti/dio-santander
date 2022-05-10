package com.dio.santander.bankline.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_hora")
	private LocalDateTime dataHora;

	private String descricao;
	private Double valor;

	@Column(name = "id_conta")
	private Integer idConta;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	public Integer getId() {
		return id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
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
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
}
