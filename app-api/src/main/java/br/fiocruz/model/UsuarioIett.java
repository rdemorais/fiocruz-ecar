package br.fiocruz.model;

public interface UsuarioIett {
	public Iett getIett();
	public void setIett(Iett iett);
	public UsuarioEcar getUsuarioEcar();
	public void setUsuarioEcar(UsuarioEcar usuarioEcar);
	public Long getCodTpfa();
	public void setCodTpfa(Long codTpfa);
}