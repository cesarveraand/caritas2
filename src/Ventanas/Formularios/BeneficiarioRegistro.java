package Ventanas.Formularios;

import java.awt.*;

import javax.swing.*;

public class BeneficiarioRegistro extends JPanel {
	private JTextField txtNombre ;
	private JComboBox comboBoxEdades;
	private JTextField txtDocIdentidad;
	private JTextField txtExpedido;
	private JComboBox comboBoxEducacion;
	private JRadioButton rdbtnSexoFemenino;
	private JRadioButton rdbtnSexoMasculino;
	private JRadioButton rdbtnSexoOtro;
	private JRadioButton rdbtnIngresoRegular ;
	private JRadioButton rdbtnIngresoIrregular;
	public BeneficiarioRegistro() {
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(800, 80));
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		add(txtNombre);
		
		JLabel lblEdad = new JLabel("EDAD:");
		
		add(lblEdad);
		
		comboBoxEdades = new JComboBox();
		 comboBoxEdades.setModel(new DefaultComboBoxModel(new String[] { // se manejaran edades o rangos de edades?
		            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
		            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
		            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
		            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
		            "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		
		add(comboBoxEdades);
		
		JLabel lblDocIdentidad = new JLabel("NÚMERO DE DOCUMENTO DE IDENTIDAD:");
		
		add(lblDocIdentidad);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		add(txtDocIdentidad);
		
		JLabel lblExpedido = new JLabel("EXPEDIDO EN:");
		add(lblExpedido);
		
		txtExpedido = new JTextField();
		txtExpedido.setColumns(10);
		add(txtExpedido);
		
		JLabel lblEducacion = new JLabel("NIVEL DE EDUCACION:");
		add(lblEducacion);
		
		comboBoxEducacion = new JComboBox();
		comboBoxEducacion.setModel(new DefaultComboBoxModel(new String[] {"Primaria", "Secundaria", "Técnico Superior", "Universitario "}));
		
		add(comboBoxEducacion);
		
		JLabel lblSexo = new JLabel("SEXO:");
		add(lblSexo);
		
		rdbtnSexoFemenino = new JRadioButton("F");
		add(rdbtnSexoFemenino);
		
		rdbtnSexoMasculino = new JRadioButton("M");
		add(rdbtnSexoMasculino);
		
		rdbtnSexoOtro = new JRadioButton("OTRO");
		add(rdbtnSexoOtro);
		
		ButtonGroup buttonGroupSexo = new ButtonGroup();
        buttonGroupSexo.add(rdbtnSexoFemenino);
        buttonGroupSexo.add(rdbtnSexoMasculino);
        buttonGroupSexo.add(rdbtnSexoOtro);
		
		
		
		JLabel lblIngreso = new JLabel("INGRESO:");
		add(lblIngreso);
		
		rdbtnIngresoRegular = new JRadioButton("REGULAR");
		add(rdbtnIngresoRegular);
		
		rdbtnIngresoIrregular = new JRadioButton("IRREGULAR");
		add(rdbtnIngresoIrregular);
		
	    ButtonGroup buttonGroupIngreso = new ButtonGroup();
	    buttonGroupIngreso.add(rdbtnIngresoRegular);
	    buttonGroupIngreso.add(rdbtnIngresoIrregular);
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2);
		
	}
	public String getTxtNombre() {
		return txtNombre.getText();
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public String getComboBoxEdades() {
		return (String) comboBoxEdades.getSelectedItem();
	}
	public void setComboBoxEdades(JComboBox comboBoxEdades) {
		this.comboBoxEdades = comboBoxEdades;
	}
	public String getTxtDocIdentidad() {
		return txtDocIdentidad.getText();
	}
	public void setTxtDocIdentidad(JTextField txtDocIdentidad) {
		this.txtDocIdentidad = txtDocIdentidad;
	}
	public String getTxtExpedido() {
		return txtExpedido.getText();
	}
	public void setTxtExpedido(JTextField txtExpedido) {
		this.txtExpedido = txtExpedido;
	}
	public String getComboBoxEducacion() {
		return (String) comboBoxEducacion.getSelectedItem();
	}
	public void setComboBoxEducacion(JComboBox comboBoxEducacion) {
		this.comboBoxEducacion = comboBoxEducacion;
	}
	public Boolean getRdbtnSexoFemenino() {
		return rdbtnSexoFemenino.isSelected();
	}
	public void setRdbtnSexoFemenino(JRadioButton rdbtnSexoFemenino) {
		this.rdbtnSexoFemenino = rdbtnSexoFemenino;
	}
	public Boolean  getRdbtnSexoMasculino() {
		return rdbtnSexoMasculino.isSelected();
	}
	public void setRdbtnSexoMasculino(JRadioButton rdbtnSexoMasculino) {
		this.rdbtnSexoMasculino = rdbtnSexoMasculino;
	}
	public Boolean getRdbtnSexoOtro() {
		return rdbtnSexoOtro.isSelected();
	}
	public void setRdbtnSexoOtro(JRadioButton rdbtnSexoOtro) {
		this.rdbtnSexoOtro = rdbtnSexoOtro;
	}
	public boolean getRdbtnIngresoRegular() {
		return rdbtnIngresoRegular.isSelected();
	}
	public void setRdbtnIngresoRegular(JRadioButton rdbtnIngresoRegular) {
		this.rdbtnIngresoRegular = rdbtnIngresoRegular;
	}
	public Boolean getRdbtnIngresoIrregular() {
		return rdbtnIngresoIrregular.isSelected();
	}
	public void setRdbtnIngresoIrregular(JRadioButton rdbtnIngresoIrregular) {
		this.rdbtnIngresoIrregular = rdbtnIngresoIrregular;
	}
	
	
	

}
