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
		comboBoxPaisesPaso.setModel(new DefaultComboBoxModel(new String[] { "Afganistán", "Albania", "Alemania",
				"Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bahréin", "Bangladés",
				"Barbados", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina",
				"Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya",
				"Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras", "Congo",
				"Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca",
				"Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia",
				"Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi",
				"Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guinea",
				"Guinea-Bisáu", "Guyana", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán",
				"Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón",
				"Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia",
				"Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte",
				"Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania",
				"México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia",
				"Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos",
				"Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal",
				"Reino Unido", "República Centroafricana", "República Checa", "República Democrática del Congo",
				"República Dominicana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino",
				"San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia",
				"Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica",
				"Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Taiwán", "Tanzania", "Tayikistán",
				"Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu",
				"Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Vaticano", "Venezuela", "Vietnam", "Yemen",
				"Yibuti", "Zambia", "Zimbabue" })); //paises 
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
