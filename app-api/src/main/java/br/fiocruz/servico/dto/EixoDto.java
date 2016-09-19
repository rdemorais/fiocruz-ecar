package br.fiocruz.servico.dto;

public class EixoDto {
	private Long id;
	private String sigla;
	private String nome;
	
	public EixoDto() {
	
	}
	
	public EixoDto(Long id, String sigla, String nome) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public EixoDto(Long id, String sigla) {
		super();
		this.id = id;
		this.sigla = sigla;
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

	@Override
	public String toString() {
		return "EixoDto [id=" + id + ", sigla=" + sigla + ", nome=" + nome + "]";
	}
	
}