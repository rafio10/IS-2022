package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MultimediaController;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GeneraReport extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			GeneraReport dialog = new GeneraReport();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GeneraReport() {
		setTitle("Report Mensile");
		setBounds(100, 100, 394, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTipologiaRisorse = new JLabel("Tipologia risorse");
		lblTipologiaRisorse.setBounds(10, 21, 136, 14);
		contentPanel.add(lblTipologiaRisorse);
		
		JComboBox TipologiaComboBox = new JComboBox();
		TipologiaComboBox.setBounds(156, 18, 213, 20);
		TipologiaComboBox.setModel(new DefaultComboBoxModel(new String[] {"File Audio", "Video", "Immagine", "Podcasts"}));
		contentPanel.add(TipologiaComboBox);
		
		JLabel lblMeseReport = new JLabel("Mese report");
		lblMeseReport.setBounds(10, 56, 136, 14);
		contentPanel.add(lblMeseReport);
		
		JTextField MeseTextField = new JTextField();
		MeseTextField.setBounds(158, 53, 195, 20);
		contentPanel.add(MeseTextField);
		MeseTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 360, 123);
		contentPanel.add(scrollPane);
		
		DefaultListModel riepilogo_model = new DefaultListModel();
		JList<String> riepilogoList = new JList<String>(riepilogo_model);
		scrollPane.setViewportView(riepilogoList);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton GeneraButton = new JButton("GENERA");
				GeneraButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
							
						riepilogo_model.removeAllElements();
						
						String tipologia = (String) TipologiaComboBox.getSelectedItem();
						String mese = (String) MeseTextField.getText();
						
						Boolean Check4 = false;
						
						String m1 = "01";
						String m2 = "02";
						String m3 = "03";
						String m4 = "04";
						String m5 = "05";
						String m6 = "06";
						String m7 = "07";
						String m8 = "08";
						String m9 = "09";
						String m10 = "10";
						String m11 = "11";
						String m12 = "12";
						
						ArrayList<String> errori = new ArrayList<String>();
						
						if((mese.equals(m1)) || (mese.equals(m2)) || (mese.equals(m3)) || (mese.equals(m4)) || (mese.equals(m5)) || (mese.equals(m6)) || (mese.equals(m7)) || (mese.equals(m8)) || (mese.equals(m9)) || (mese.equals(m10)) || (mese.equals(m11)) || (mese.equals(m12))) {
							Check4 = true;
						} else {
							errori.add("Mese non valido!");
						}
							String[] meseSplit = mese.split(" ");
							
							MultimediaController MC = new MultimediaController();
							
							ArrayList<Double> incassi = MC.GeneraReport(tipologia, meseSplit[0]);
							
							if(Check4) {
								riepilogo_model.addElement("Totale incassi noleggio: " + incassi.get(0));
								riepilogo_model.addElement("Totale incassi acquisto: " + incassi.get(1));
							}
							
							else {
								JOptionPane.showMessageDialog(null, new JScrollPane(new JList<Object>(errori.toArray())), "Generazione non effettuata", JOptionPane.ERROR_MESSAGE);
							}
					
					}
				});
				GeneraButton.setActionCommand("OK");
				buttonPane.add(GeneraButton);
				getRootPane().setDefaultButton(GeneraButton);
			}
		}
	}
}
