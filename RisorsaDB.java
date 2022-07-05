package database;

import java.sql.ResultSet;

public class RisorsaDB {

	private String codice;
	private String tipo;
	private String titolo;
	private String autore;
	private String dataPubblicazione;
	private Double costoAcquisto;
	private Double costoNoleggio;
	
	
	public RisorsaDB() {
		super();
	}
	
	public RisorsaDB(String codiceRisorsa) {
		super();
		CaricaDaDB(codiceRisorsa);
	}
	
	public int SalvaSuDB() {

		int ret = 0;
		
		try {
			ret = DBConnectionManager.updateQuery("INSERT INTO RISORSE (CODICE, TIPO, TITOLO, AUTORE, DATAPUBBLICAZIONE, COSTOACQUISTO, COSTONOLEGGIO) VALUES ('"+this.codice+"', '"+this.tipo+"', '"+this.titolo+"', '"+this.autore+"', '"+this.dataPubblicazione+"', '"+this.costoAcquisto+"', '"+this.costoNoleggio+"');");
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = 0;
		}
		
		return ret;
	}

	public void CaricaDaDB(String codiceRisorsa) {
		
		try {
			ResultSet RS = DBConnectionManager.selectQuery("SELECT * FROM RISORSE WHERE CODICE = '"+codiceRisorsa+"';");
			
			if (RS.next()) {
				this.setCodice(RS.getString("codice"));
				this.setAutore(RS.getString("autore"));
				this.setTipo(RS.getString("tipo"));
				this.setDataPubblicazione(RS.getString("dataPubblicazione"));
				this.setTitolo(RS.getString("titolo"));
				this.setCostoAcquisto(RS.getDouble("costoAcquisto"));
				this.setCostoNoleggio(RS.getDouble("costoNoleggio"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

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
