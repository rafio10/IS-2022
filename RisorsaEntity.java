package entity;

import database.RisorsaDB;

public class RisorsaEntity {

	private String codice;
	private String tipo;
	private String titolo;
	private String autore;
	private String dataPubblicazione;
	private Double costoAcquisto;
	private Double costoNoleggio;
	
	public RisorsaEntity() {
		super();
	}
	
	public RisorsaEntity(RisorsaDB risorsa) {
		super();
		this.setCodice(risorsa.getCodice());
		this.setAutore(risorsa.getAutore());
		this.setTipo(risorsa.getTipo());
		this.setTitolo(risorsa.getTitolo());
		this.setDataPubblicazione(risorsa.getDataPubblicazione());
		this.setCostoAcquisto(risorsa.getCostoAcquisto());
		this.setCostoNoleggio(risorsa.getCostoNoleggio());
	}

	public void SalvaRisorsa() {
		RisorsaDB dbrisorsa = new RisorsaDB();
		dbrisorsa.setCodice(this.codice);
		dbrisorsa.setTipo(this.tipo);
		dbrisorsa.setTitolo(this.titolo);
		dbrisorsa.setAutore(this.autore);
		dbrisorsa.setDataPubblicazione(this.dataPubblicazione);
		dbrisorsa.setCostoAcquisto(this.costoAcquisto);
		dbrisorsa.setCostoNoleggio(this.costoNoleggio);
		dbrisorsa.SalvaSuDB();
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(String dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public Double getCostoAcquisto() {
		return costoAcquisto;
	}
	public void setCostoAcquisto(Double costoAcquisto) {
		this.costoAcquisto = costoAcquisto;
	}
	public Double getCostoNoleggio() {
		return costoNoleggio;
	}
	public void setCostoNoleggio(Double costoNoleggio) {
		this.costoNoleggio = costoNoleggio;
	}

	
	
	
	
}
