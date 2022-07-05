package database;

public class TransazioneDB {

	private Integer codice;
	private String tipo;
	private String data;
	private RisorsaDB risorsa;
	private Double costo;
	
	public TransazioneDB() {
		super();
	}
	
	public void CaricaRisorsaDaDB(String codiceRisorsa) {
		
		this.risorsa = new RisorsaDB(codiceRisorsa);
		
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
	public RisorsaDB getRisorsa() {
		return risorsa;
	}
	public void setRisorsa(RisorsaDB risorsa) {
		this.risorsa = risorsa;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public double getCosto() {
		return costo;
	}

	
}
