package Ventanas.Formularios;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
public class EstatusMigratorio extends JPanel {
	private JComboBox comboBoxPaisesPaso;
	private JTextField txtPermanencia;
	private JTextField txtEstatus;
	public EstatusMigratorio() {

		setLayout(new FlowLayout());
		JLabel lblPaisPaso = new JLabel("PAÍS:");
		add(lblPaisPaso);
		comboBoxPaisesPaso = new JComboBox();
		comboBoxPaisesPaso.setModel(new DefaultComboBoxModel(new String[] {"pais 1"})); //paises 
		add(comboBoxPaisesPaso);
		
		JLabel lblPermanencia = new JLabel("PERMANENCIA:");
		add(lblPermanencia);
		txtPermanencia = new JTextField();
		txtPermanencia.setText("");
		add(txtPermanencia);
		txtPermanencia.setColumns(10);
		
		JLabel lblEstatus = new JLabel("ESTATUS:");
		add(lblEstatus);
		
		txtEstatus = new JTextField();
		add(txtEstatus);
		txtEstatus.setColumns(10);
		
		
	}
	
	public int getComboBoxPaisesPaso() { //cual esta seleccionando index
		return comboBoxPaisesPaso.getSelectedIndex();
	}
	public String getComboBoxPaisesPaso2() { //cual esta seleccionando String
		return (String) comboBoxPaisesPaso.getSelectedItem();
	}
	public String getTxtPermanencia() { //lo que esta en permanencia
		return txtPermanencia.getText();
	}
	public String getTxtEstatus() {
		return txtEstatus.getText();
	}

	public void setComboBoxPaisesPaso(JComboBox comboBoxPaisesPaso) {
		this.comboBoxPaisesPaso = comboBoxPaisesPaso;
	}

	public void setTxtPermanencia(JTextField txtPermanencia) {
		this.txtPermanencia = txtPermanencia;
	}

	public void setTxtEstatus(JTextField txtEstatus) {
		this.txtEstatus = txtEstatus;
	}
	

}
