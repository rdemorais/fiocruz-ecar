package br.fiocruz.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="UsuarioIett")
@Table(name="TB_ITEM_EST_USUTPFUAC_IETTUTFA")
public class UsuarioIettImpl implements UsuarioIett, Serializable{
	
	private static final long serialVersionUID = -4276771148342382393L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=IettImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_iett", referencedColumnName = "cod_iett")
	private Iett iett;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=UsuarioEcarImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_usu", referencedColumnName = "cod_usu")
	private UsuarioEcar usuarioEcar;
	
	@Id
	@Column(name="cod_tpfa")
	private Long codTpfa;

	public Iett getIett() {
		return iett;
	}

	public void setIett(Iett iett) {
		this.iett = iett;
	}

	public UsuarioEcar getUsuarioEcar() {
		return usuarioEcar;
	}

	public void setUsuarioEcar(UsuarioEcar usuarioEcar) {
		this.usuarioEcar = usuarioEcar;
	}

	public Long getCodTpfa() {
		return codTpfa;
	}

	public void setCodTpfa(Long codTpfa) {
		this.codTpfa = codTpfa;
	}
}