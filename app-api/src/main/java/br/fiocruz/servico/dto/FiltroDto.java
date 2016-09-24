package br.fiocruz.servico.dto;

import br.fiocruz.model.Nivel;

public class FiltroDto {
	private Nivel nivel;
	private Long codAref;
	private Long codIettPai;
	private Long codEixo;
	
	public Long getCodEixo() {
		return codEixo;
	}

	public void setCodEixo(Long codEixo) {
		this.codEixo = codEixo;
	}

	public Long getCodIettPai() {
		return codIettPai;
	}

	public void setCodIettPai(Long codIettPai) {
		this.codIettPai = codIettPai;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Long getCodAref() {
		return codAref;
	}

	public void setCodAref(Long codAref) {
		this.codAref = codAref;
	}
	
}