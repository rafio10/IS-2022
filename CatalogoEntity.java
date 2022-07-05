package entity;

import java.util.ArrayList;

import database.CatalogoDB;
import database.RisorsaDB;

public class CatalogoEntity {

	private ArrayList<RisorsaEntity> risorse;

	public CatalogoEntity() {
		super();
		this.risorse = new ArrayList<RisorsaEntity>();
	}
	
	public void CaricaCatalogo() {
		CatalogoDB dbcatalogo = new CatalogoDB();
		dbcatalogo.CaricaDaDB();
		InizializzaDaDB(dbcatalogo);
	}
	
	private void InizializzaDaDB(CatalogoDB dbcatalogo) {
		
		for (RisorsaDB dbrisorsa : dbcatalogo.getRisorse()) {
			
			RisorsaEntity risorsa = new RisorsaEntity();
			risorsa.setCodice(dbrisorsa.getCodice());
			risorsa.setTitolo(dbrisorsa.getTitolo());
			risorsa.setTipo(dbrisorsa.getTipo());
			risorsa.setDataPubblicazione(dbrisorsa.getDataPubblicazione());
			risorsa.setAutore(dbrisorsa.getAutore());
			risorsa.setCostoNoleggio(dbrisorsa.getCostoNoleggio());
			risorsa.setCostoAcquisto(dbrisorsa.getCostoAcquisto());
			this.risorse.add(risorsa);
		}
	}

	public ArrayList<RisorsaEntity> getRisorse() {
		return risorse;
	}
	public void setRisorse(ArrayList<RisorsaEntity> risorse) {
		this.risorse = risorse;
	}
	
	
	
}
