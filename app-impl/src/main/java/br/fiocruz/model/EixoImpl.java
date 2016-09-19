package br.fiocruz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Eixo")
@Table(name="tb_item_estrutura_iett")
public class EixoImpl {
	
	@Id
	@Column(name="cod_iett")
	private Long id;
	
	@Column(name="sigla_iett")
	private String sigla;
	
	@Column(name="nome_iett")
	private String nome;
	
	@Column(name="nivel_iett")
	private Long nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}
}