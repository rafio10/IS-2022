package entity;

import database.TransazioneDB;

public class TransazioneEntity {

	private Integer codice;
	private String tipo;
	private String data;
	private Double costo;
	private RisorsaEntity risorsa;
	
	public TransazioneEntity() {
		super();
	}
	
	public TransazioneEntity(TransazioneDB transazionedb) {
		this.setCodice(transazionedb.getCodice());
		this.setData(transazionedb.getData());
		this.setTipo(transazionedb.getTipo());
		this.risorsa = new RisorsaEntity(transazionedb.getRisorsa());
	}

	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public RisorsaEntity getRisorsa() {
		return risorsa;
	}
	public void setRisorsa(RisorsaEntity risorsa) {
		this.risorsa = risorsa;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
}
