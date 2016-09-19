package br.fiocruz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="AcompReferenciaItemAri")
@Table(name="tb_acomp_referencia_item_ari")
public class AcompReferenciaItemAriImpl implements AcompReferenciaItemAri{
	
	@Id
	@Column(name="cod_ari")
	private Long id;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = false, targetEntity=AcompReferenciaArefImpl.class)
	@JoinColumn(name="cod_aref")
	private AcompReferenciaAref aref;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=IettImpl.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cod_iett", referencedColumnName = "cod_iett")
	private Iett iett;
	
	@OneToMany(targetEntity=AcompRelatorioArelImpl.class, cascade=CascadeType.MERGE, fetch=FetchType.LAZY, mappedBy="ari")
	private List<AcompRelatorioArel> pareceres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcompReferenciaAref getAref() {
		return aref;
	}

	public void setAref(AcompReferenciaAref aref) {
		this.aref = aref;
	}
	
	public List<AcompRelatorioArel> getPareceres() {
		return pareceres;
	}

	public void setPareceres(List<AcompRelatorioArel> pareceres) {
		this.pareceres = pareceres;
	}

	public Iett getIett() {
		return iett;
	}

	public void setIett(Iett iett) {
		this.iett = iett;
	}
	
}