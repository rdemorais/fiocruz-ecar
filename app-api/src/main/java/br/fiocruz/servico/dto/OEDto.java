package br.fiocruz.servico.dto;

public class OEDto {
	private Long id;
	private String sigla;
	private String nome;
	private EixoDto eixo;
	
	public OEDto() {
	
	}
	
	public OEDto(Long idEixo, String siglaEixo, Long id, String sigla, String nome) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.eixo = new EixoDto(idEixo, siglaEixo);
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
	public EixoDto getEixo() {
		return eixo;
	}
	public void setEixo(EixoDto eixo) {
		this.eixo = eixo;
	}

	@Override
	public String toString() {
		return "OEDto [eixo=" + eixo + ", id=" + id + ", sigla=" + sigla + ", nome=" + nome + "]";
	}
	
}