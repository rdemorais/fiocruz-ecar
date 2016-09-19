package br.fiocruz.model;

import java.util.Date;

public interface AcompRelatorioArel {
	public Long getId();
	public void setId(Long id);
	public Date getDataUltManut();
	public void setDataUltManut(Date dataUltManut);
	public String getParecer();
	public void setParecer(String parecer);
	public Cor getCor();
	public void setCor(Cor cor);
	public Situacao getSituacao();
	public void setSituacao(Situacao situacao);
	public AcompReferenciaItemAri getAri();
	public void setAri(AcompReferenciaItemAri ari);
	public UsuarioEcar getUsuarioUltParecer();
	public void setUsuarioUltParecer(UsuarioEcar usuarioUltParecer);
}