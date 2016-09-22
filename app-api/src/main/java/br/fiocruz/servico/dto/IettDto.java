package br.fiocruz.servico.dto;

import java.awt.image.BufferedImage;
import java.util.List;

public class IettDto {
	private Long id;
	private String sigla;
	private String nome;
	private String nomeResponsavel;
	private String emailResponsavel;
	private String significadoCor;
	private String nomeCor;
	private String situacao;
	private String parecer;
	private BufferedImage imgStatus;
	private List<IettDto> descendentes;
	private List<IndicadorDto> indicadores;
	
	public IettDto() {
	
	}
	
	public IettDto(Long id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public IettDto(Long id, String sigla, String nome, String nomeResponsavel, String emailResponsavel) {
		this(id, sigla, nome);
		this.nomeResponsavel = nomeResponsavel;
		this.emailResponsavel = emailResponsavel;
	}
	
	public IettDto(Long id, String sigla, String nome, String nomeResponsavel, String emailResponsavel, 
			String significadoCor, String nomeCor, String situacao, String parecer) {
		this(id, sigla, nome, nomeResponsavel, emailResponsavel);
		this.nomeCor = nomeCor;
		this.significadoCor = significadoCor;
		this.situacao = situacao;
		this.parecer = parecer;
	}
	
	public String getNomeCor() {
		return nomeCor;
	}

	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}

	public BufferedImage getImgStatus() {
		return imgStatus;
	}

	public void setImgStatus(BufferedImage imgStatus) {
		this.imgStatus = imgStatus;
	}

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
	
	public List<IettDto> getDescendentes() {
		return descendentes;
	}

	public void setDescendentes(List<IettDto> descendentes) {
		this.descendentes = descendentes;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getSignificadoCor() {
		return significadoCor;
	}

	public void setSignificadoCor(String significadoCor) {
		this.significadoCor = significadoCor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	
	public List<IndicadorDto> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<IndicadorDto> indicadores) {
		this.indicadores = indicadores;
	}

	@Override
	public String toString() {
		return "IettDto [id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", nomeResponsavel=" + nomeResponsavel
				+ ", emailResponsavel=" + emailResponsavel + ", significadoCor=" + significadoCor + ", situacao="
				+ situacao + ", parecer=" + parecer + ", descendentes=" + descendentes + "]";
	}
	
}