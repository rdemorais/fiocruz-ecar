package br.fiocruz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Situacao")
@Table(name="tb_situacao_sit")
public class SituacaoImpl implements Situacao {
	
	@Id
	@Column(name="cod_sit")
	private Long id;
	
	@Column(name="descricao_sit")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}