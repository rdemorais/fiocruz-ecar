package br.fiocruz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="UsuarioEcar")
@Table(name="tb_usuario_usu")
public class UsuarioEcarImpl implements UsuarioEcar{
	
	@Id
	@Column(name="cod_usu")
	private Long id;
	
	@Column(name="nome_usu")
	private String nome;
	
	@Column(name="email1_usu")
	private String email;

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
}