package br.fiocruz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Iett")
@Table(name="tb_item_estrutura_iett")
public class IettImpl implements Iett{
	
	@Id
	@Column(name="cod_iett")
	private Long id;
	
	@Column(name="sigla_iett")
	private String sigla;
	
	@Column(name="nome_iett")
	private String nome;
	
	@Column(name="nivel_iett")
	private Long nivel;
	
	@Column(name="ind_ativo_iett")
	private String ativo;
	
	@OneToMany(targetEntity=UsuarioIettImpl.class, cascade=CascadeType.MERGE, fetch=FetchType.LAZY, mappedBy="iett")
	private List<UsuarioIett> usuarios;
	
	@OneToMany(targetEntity=AcompReferenciaItemAriImpl.class, cascade=CascadeType.MERGE, fetch=FetchType.LAZY, mappedBy="iett")
	private List<AcompReferenciaItemAri> aris;
	
	@OneToMany(targetEntity=IettIndicadorImpl.class, cascade=CascadeType.MERGE, fetch=FetchType.LAZY, mappedBy="iett")
	private List<IettIndicador> indicadores;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=IettImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_iett_pai", referencedColumnName = "cod_iett")
	private Iett iettPai;

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

	public List<UsuarioIett> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioIett> usuarios) {
		this.usuarios = usuarios;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Iett getIettPai() {
		return iettPai;
	}

	public void setIettPai(Iett iettPai) {
		this.iettPai = iettPai;
	}

	public List<AcompReferenciaItemAri> getAris() {
		return aris;
	}

	public void setAris(List<AcompReferenciaItemAri> aris) {
		this.aris = aris;
	}

	public List<IettIndicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<IettIndicador> indicadores) {
		this.indicadores = indicadores;
	}
	
}