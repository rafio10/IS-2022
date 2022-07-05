package database;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ListaTransazioniDB {

	private ArrayList<TransazioneDB> transazioni;

	public ListaTransazioniDB() {
		super();
		this.transazioni = new ArrayList<TransazioneDB>();
	}
	
	public void CaricaDaDB() {
	
		try {
			ResultSet RS = DBConnectionManager.selectQuery("SELECT * FROM TRANSAZIONI");
			
			while (RS.next()) {
				
				TransazioneDB dbtransazione = new TransazioneDB();
				dbtransazione.setCodice(RS.getInt("codice"));
				dbtransazione.setTipo(RS.getString("tipo"));
				dbtransazione.setData(RS.getString("data"));
				dbtransazione.CaricaRisorsaDaDB(RS.getString("risorse_Codice"));
				dbtransazione.setCosto(RS.getDouble("costo"));
				transazioni.add(dbtransazione);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<TransazioneDB> getTransazioni() {
		return transazioni;
	}
	public void setTransazioni(ArrayList<TransazioneDB> transazioni) {
		this.transazioni = transazioni;
	}
	
}
