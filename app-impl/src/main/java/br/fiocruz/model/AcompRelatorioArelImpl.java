package br.fiocruz.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="AcompRelatorioArel")
@Table(name="tb_acomp_relatorio_arel")
public class AcompRelatorioArelImpl implements AcompRelatorioArel{
	
	@Id
	@Column(name="cod_arel")
	private Long id;
	
	@Column(name="data_ult_manut_arel")
	private Date dataUltManut;
	
	@Column(name="descricao_arel")
	private String parecer;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = false, targetEntity=CorImpl.class)
	@JoinColumn(name="cod_cor")
	private Cor cor;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = false, targetEntity=SituacaoImpl.class)
	@JoinColumn(name="cod_sit")
	private Situacao situacao;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=AcompReferenciaItemAriImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_ari", referencedColumnName = "cod_ari")
	private AcompReferenciaItemAri ari;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = false, targetEntity=UsuarioEcarImpl.class)
	@JoinColumn(name="cod_usuultmanut_arel")
	private UsuarioEcar usuarioUltParecer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataUltManut() {
		return dataUltManut;
	}

	public void setDataUltManut(Date dataUltManut) {
		this.dataUltManut = dataUltManut;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public AcompReferenciaItemAri getAri() {
		return ari;
	}

	public void setAri(AcompReferenciaItemAri ari) {
		this.ari = ari;
	}

	public UsuarioEcar getUsuarioUltParecer() {
		return usuarioUltParecer;
	}

	public void setUsuarioUltParecer(UsuarioEcar usuarioUltParecer) {
		this.usuarioUltParecer = usuarioUltParecer;
	}
}