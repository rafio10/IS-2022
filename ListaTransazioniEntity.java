package entity;

import java.util.ArrayList;

import database.ListaTransazioniDB;
import database.TransazioneDB;

public class ListaTransazioniEntity {

	private ArrayList<TransazioneEntity> transazioni;

	public ListaTransazioniEntity() {
		super();
		this.transazioni = new ArrayList<TransazioneEntity>();
	}
	
	public void CaricaTransazioni() {
		ListaTransazioniDB dbtransazioni = new ListaTransazioniDB();	
		dbtransazioni.CaricaDaDB();
		
		for (TransazioneDB transazionedb : dbtransazioni.getTransazioni()) {
			
			TransazioneEntity transazione = new TransazioneEntity(transazionedb);
			this.transazioni.add(transazione);
		}
	}
	
	public ArrayList<TransazioneEntity> getTransazioni() {
		return transazioni;
	}
	public void setTransazioni(ArrayList<TransazioneEntity> transazioni) {
		this.transazioni = transazioni;
	}
	
	
	
	
}
