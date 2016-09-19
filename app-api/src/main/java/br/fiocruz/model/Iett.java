package br.fiocruz.model;

import java.util.List;

public interface Iett {
	public Long getId();
	public void setId(Long id);
	public String getSigla();
	public void setSigla(String sigla);
	public String getNome();
	public void setNome(String nome);
	public Long getNivel();
	public void setNivel(Long nivel);
	public List<UsuarioIett> getUsuarios();
	public void setUsuarios(List<UsuarioIett> usuarios);
	public String getAtivo();
	public void setAtivo(String ativo);
	public List<AcompReferenciaItemAri> getAris();
	public void setAris(List<AcompReferenciaItemAri> aris);
	public List<IettIndicador> getIndicadores();
	public void setIndicadores(List<IettIndicador> indicadores);
}