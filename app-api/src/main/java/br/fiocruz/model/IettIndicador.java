package br.fiocruz.model;

public interface IettIndicador {
	public Long getId();
	public void setId(Long id);
	public String getNome();
	public void setNome(String nome);
	public String getAtivo();
	public void setAtivo(String ativo);
	public Iett getIett();
	public void setIett(Iett iett);
}