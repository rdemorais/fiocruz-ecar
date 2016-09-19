package br.fiocruz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="AcompReferenciaAref")
@Table(name="tb_acomp_referencia_aref")
public class AcompReferenciaArefImpl implements AcompReferenciaAref {
	
	@Id
	@Column(name="cod_aref")
	private Long id;
	
	@Column(name="mes_aref")
	private String mes;
	
	@Column(name="ano_aref")
	private String ano;
	
	@Column(name="nome_aref")
	private String nome;
	
	@Column(name="cod_exe")
	private Long codExe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodExe() {
		return codExe;
	}

	public void setCodExe(Long codExe) {
		this.codExe = codExe;
	}
}