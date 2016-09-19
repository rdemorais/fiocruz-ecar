package br.fiocruz.model;

public enum Nivel {
	EIXO(1L), OE(2L), INICIATIVA(3L);
	
	private Long nivel;
	
	private Nivel(Long nivel) {
		this.nivel = nivel;
	}
	
	public Long getNv() {
		return nivel;
	}
}