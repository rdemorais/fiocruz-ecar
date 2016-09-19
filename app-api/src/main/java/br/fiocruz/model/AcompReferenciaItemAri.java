package br.fiocruz.model;

import java.util.List;

public interface AcompReferenciaItemAri {
	public Long getId();
	public void setId(Long id);
	public AcompReferenciaAref getAref();
	public void setAref(AcompReferenciaAref aref);
	public List<AcompRelatorioArel> getPareceres();
	public void setPareceres(List<AcompRelatorioArel> pareceres);
	public Iett getIett();
	public void setIett(Iett iett);
}