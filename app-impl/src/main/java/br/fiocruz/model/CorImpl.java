package br.fiocruz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Cor")
@Table(name="tb_cor")
public class CorImpl implements Cor{
	
	@Id
	@Column(name="cod_cor")
	private Long id;
	
	@Column(name="significado_cor")
	private String significado;
	
	@Column(name="nome_cor")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSignificado() {
		return significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}