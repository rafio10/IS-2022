package database;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogoDB {

	private ArrayList<RisorsaDB> risorse;

	public CatalogoDB() {
		super();
		this.risorse = new ArrayList<RisorsaDB> ();
	}
	
	public void CaricaDaDB() {
		
		try {
			ResultSet RS = DBConnectionManager.selectQuery("SELECT * FROM RISORSE");
			
			while (RS.next()) {
				
				RisorsaDB dbrisorsa = new RisorsaDB();
				dbrisorsa.setCodice(RS.getString("codice"));
				dbrisorsa.setTipo(RS.getString("tipo"));
				dbrisorsa.setTitolo(RS.getString("titolo"));
				dbrisorsa.setAutore(RS.getString("autore"));
				dbrisorsa.setDataPubblicazione(RS.getString("dataPubblicazione"));
				dbrisorsa.setCostoAcquisto(RS.getDouble("costoAcquisto"));
				dbrisorsa.setCostoNoleggio(RS.getDouble("costoNoleggio"));
				this.risorse.add(dbrisorsa);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public ArrayList<RisorsaDB> getRisorse() {
		return risorse;
	}
	public void setRisorse(ArrayList<RisorsaDB> risorse) {
		this.risorse = risorse;
	}

	
	
	
}
