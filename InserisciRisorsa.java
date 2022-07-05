package boundary;

import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.MultimediaController;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class InserisciRisorsa extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField TitoloTextField;
	private JTextField AutoreTextField;
	private JTextField AcquistoTextField;
	private JTextField NoleggioTextField;

	public static void main(String[] args) {
		try {
			InserisciRisorsa dialog = new InserisciRisorsa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InserisciRisorsa() {
		setTitle("Inserimento nuova risorsa");
		setBounds(100, 100, 485, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setBounds(10, 35, 76, 14);
		contentPanel.add(lblTipologia);
		
		JComboBox<Object> TipologiaComboBox = new JComboBox<Object>();
		TipologiaComboBox.setBounds(119, 32, 316, 20);
		TipologiaComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"File Audio", "Video", "Immagine", "Podcast"}));
		contentPanel.add(TipologiaComboBox);
		
		JLabel lblTitolo = new JLabel("Titolo");
		lblTitolo.setBounds(10, 91, 46, 14);
		contentPanel.add(lblTitolo);
		
		TitoloTextField = new JTextField();
		TitoloTextField.setBounds(119, 88, 316, 20);
		contentPanel.add(TitoloTextField);
		TitoloTextField.setColumns(10);
		
		JLabel lblAutore = new JLabel("Autore");
		lblAutore.setBounds(10, 149, 46, 14);
		contentPanel.add(lblAutore);
		
		AutoreTextField = new JTextField();
		AutoreTextField.setBounds(119, 146, 316, 20);
		contentPanel.add(AutoreTextField);
		AutoreTextField.setColumns(10);
		
		JLabel lblCostoacquisto = new JLabel("Costo Acquisto");
		lblCostoacquisto.setBounds(10, 209, 100, 14);
		contentPanel.add(lblCostoacquisto);
		
		AcquistoTextField = new JTextField();
		AcquistoTextField.setBounds(119, 206, 86, 20);
		contentPanel.add(AcquistoTextField);
		AcquistoTextField.setColumns(10);
		
		JLabel lblCostonoleggio = new JLabel("Costo Noleggio");
		lblCostonoleggio.setBounds(245, 209, 106, 14);
		contentPanel.add(lblCostonoleggio);
		
		NoleggioTextField = new JTextField();
		NoleggioTextField.setBounds(346, 206, 89, 20);
		contentPanel.add(NoleggioTextField);
		NoleggioTextField.setColumns(10);
		
		JButton btnConferma = new JButton("CONFERMA");
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				MultimediaController MC = new MultimediaController();
				Calendar cal = Calendar.getInstance();
				
				Random rand = new Random();
				int upper = 1000;
				int int_random = rand.nextInt(upper);
				
				String tipologia = (String)TipologiaComboBox.getSelectedItem();
				String titolo = TitoloTextField.getText();
				String autore = AutoreTextField.getText();
				String dataPubblicazione = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
				String codice = String.valueOf(int_random);
				Double costoAcquisto = null;
				Double costoNoleggio = null;
				
				Boolean Check1 = false;
				Boolean Check2 = false;
				Boolean Check4 = true;
				Boolean Check5 = true;
				
				
				ArrayList<String> errori = new ArrayList<String>();
											
				if (titolo.length() > 30) {
					errori.add("Il titolo è troppo lungo");
					Check4 = false;
				}
				if (autore.length() > 30) {
					errori.add("L'autore è troppo lungo");
					Check5 = false;
				}
				try {
					costoAcquisto = Double.parseDouble(AcquistoTextField.getText());
					Check1 = true;
				} catch (NumberFormatException ex) {
					errori.add("Errore inserimento Costo Acquisto");
				}
				if(costoAcquisto<0) {
					Check1 = false;
					errori.add("Costo Acquisto non valido");
				}
				
				try {
					costoNoleggio = Double.parseDouble(NoleggioTextField.getText());
					Check2 = true;
				} catch (NumberFormatException ex) {
					errori.add("Errore inserimento Costo Noleggio");
				}
				if(costoNoleggio<0) {
					Check2 = false;
					errori.add("Costo Noleggio non valido");
				}
				
				if (Check1 && Check2 && Check4 && Check5) {
					
					if(MC.InserisciRisorsa(codice, tipologia, titolo, autore, dataPubblicazione, costoAcquisto, costoNoleggio)) {
						JOptionPane.showMessageDialog(null, "Risorsa inserita correttamente nel catalogo", "" ,JOptionPane.CLOSED_OPTION);
					}
					else {
						JOptionPane.showMessageDialog(null, "Risorsa gi� presente nel catalogo", "", JOptionPane.ERROR_MESSAGE);
					} 
				} else {
					JOptionPane.showMessageDialog(null, new JScrollPane(new JList<Object>(errori.toArray())), "Inserimento non effettuato", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnConferma.setBounds(285, 254, 150, 23);
		contentPanel.add(btnConferma);
	}
}
