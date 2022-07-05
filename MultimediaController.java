package control;

import java.util.ArrayList;

import entity.CatalogoEntity;
import entity.ListaTransazioniEntity;
import entity.RisorsaEntity;

public class MultimediaController {

	public Boolean InserisciRisorsa(String codice, String tipologia, String titolo, String autore, String dataPubblicazione, Double costoAcquisto, Double costoNoleggio) {
		
		Boolean esitoCheck = false;
		Boolean esitoInsert = true;
		
		CatalogoEntity catalogo = new CatalogoEntity();
		catalogo.CaricaCatalogo(); 
		esitoCheck = CheckRisorsaPresente(catalogo, titolo, autore);
		
		if (esitoCheck) {
			esitoInsert = false;
		} else {
			RisorsaEntity risorsa = new RisorsaEntity();
			risorsa.setCodice(codice);
			risorsa.setTitolo(titolo);
			risorsa.setTipo(tipologia);
			risorsa.setAutore(autore);
			risorsa.setDataPubblicazione(dataPubblicazione);
			risorsa.setCostoAcquisto(costoAcquisto);
			risorsa.setCostoNoleggio(costoNoleggio);
			
			//IL CONTROLLO SULLA DUPLICAZIONE DELLE RISORSE � FATTO A PRIORI SUL CATALOGO 
			//QUINDI POSSO INSERIRE LA RISORSA UTILIZZANDO DIRETTAMENTE LA CLASSE RISORSADB E NON PASSANDO PER CATALOGODB
			//INOLTRE QUESTO � CORRETTO PERCH� UN NUOVO INSERIMENTO COMPORTA NUOVAMENTE IL CARICAMENTO DEL CATALOGO E DI FATTO IL SUO AGGIORNAMENTO
			risorsa.SalvaRisorsa();			
		}
		return esitoInsert;
	}

	private Boolean CheckRisorsaPresente(CatalogoEntity catalogo, String titolo, String autore) {

		Boolean esito = false;
		
		for (RisorsaEntity risorsa : catalogo.getRisorse()) {
			
			if (risorsa.getAutore().equals(autore) && risorsa.getTitolo().equals(titolo)) {
				esito = true;
			}
		}
		return esito;
	}

	public ArrayList<Double> GeneraReport(String tipologia, String mese) {
		
		ArrayList<Double> incassi = new ArrayList<Double>();
		ListaTransazioniEntity transazioni = new ListaTransazioniEntity();
		transazioni.CaricaTransazioni();
		Double noleggioIncassi = (double) 0;
		Double acquistoIncassi = (double) 0;
		
		for(int i = 0; i<transazioni.getTransazioni().size(); i++) {
			
			String data = transazioni.getTransazioni().get(i).getData();
			String[] dataSplit = data.split("/");
			String meseTrans = dataSplit[1];
						
			if (meseTrans.equals(mese)) {
				
					if (transazioni.getTransazioni().get(i).getRisorsa().getTipo().equals(tipologia)) {
				
					if (transazioni.getTransazioni().get(i).getTipo().equals("Noleggio")) {
						noleggioIncassi += transazioni.getTransazioni().get(i).getRisorsa().getCostoNoleggio();
					}
					else if (transazioni.getTransazioni().get(i).getTipo().equals("Acquisto")) {
						acquistoIncassi += transazioni.getTransazioni().get(i).getRisorsa().getCostoAcquisto();
					}
				}
			}
		}
		
		incassi.add(noleggioIncassi);
		incassi.add(acquistoIncassi);
				
		return incassi;
		
	}

}
