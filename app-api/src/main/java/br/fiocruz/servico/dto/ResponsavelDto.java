package br.fiocruz.servico.dto;

public class ResponsavelDto {
	private Long id;
	private String nome;
	private String email;
	
	public ResponsavelDto() {
	
	}
	
	public ResponsavelDto(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public ResponsavelDto(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ResponsavelDto [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
}