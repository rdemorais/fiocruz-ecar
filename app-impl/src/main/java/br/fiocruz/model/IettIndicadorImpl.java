package br.fiocruz.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="IettIndicador")
@Table(name="tb_item_estrt_ind_resul_iettr")
public class IettIndicadorImpl implements IettIndicador{
	
	@Id
	@Column(name="cod_iettir")
	private Long id;
	
	@Column(name="nome_iettir")
	private String nome;
	
	@Column(name="ind_ativo_iettr")
	private String ativo;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=IettImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_iett", referencedColumnName = "cod_iett")
	private Iett iett;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Iett getIett() {
		return iett;
	}

	public void setIett(Iett iett) {
		this.iett = iett;
	}
}