package br.fiocruz.servico.dto;

import java.util.List;

public class RelatorioJasperDto {
	private String ciclo;
	private List<IettDto> listaItens;

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<IettDto> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<IettDto> listaItens) {
		this.listaItens = listaItens;
	}
}