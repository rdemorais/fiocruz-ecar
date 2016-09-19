package br.fiocruz.servico.dto;

public class IndicadorDto {
	private String nome;

	public IndicadorDto() {
	
	}
	
	public IndicadorDto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}