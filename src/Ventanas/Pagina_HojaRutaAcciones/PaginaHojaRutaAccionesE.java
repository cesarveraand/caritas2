package Ventanas.Pagina_HojaRutaAcciones;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import poo.*;
import Conexion.*;
import Ventanas.*;
import Ventanas.Formularios.Hoja_ruta_acciones;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;

public class PaginaHojaRutaAccionesE extends JFrame {

	private JPanel contentPane;
	private static ArrayList<HojaRutaAcciones> forms=new ArrayList<HojaRutaAcciones>();
	private static JTable table_1 = new JTable();
	private static boolean ventanaAbierta = false;
	private JTextField txtFechaInicio;
	private JTextField txtBuscar;
	private JTextField txtFechaFinal;
	static JComboBox comboBoxBuqueda = new JComboBox();
	
	public PaginaHojaRutaAccionesE() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaHojaRutaAccionesE.class.getResource("/imagenes_help/iconCaritas.png")));
		JPopupMenu jPopupMenu1 = new javax.swing.JPopupMenu();
		JMenuItem mnactualizar = new javax.swing.JMenuItem();
		JMenuItem mneliminar = new javax.swing.JMenuItem();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 99, 728, 365);
		contentPane.add(scrollPane);

		
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(table_1);
		
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(23, 74, 131));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(38, 488, 85, 21);
		contentPane.add(btnVolver);
		
		JButton btnVerHojasDeRutaExistentes = new JButton("Agregar");
		btnVerHojasDeRutaExistentes.setForeground(new Color(255, 255, 255));
		btnVerHojasDeRutaExistentes.setBackground(new Color(205, 55, 66));
		btnVerHojasDeRutaExistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRutaAcciones hjr =new PaginaHojaRutaAcciones();
				hjr.setVisible(true);
				dispose();
				buscar("");
			}
		});
		btnVerHojasDeRutaExistentes.setBounds(681, 488, 85, 21);
		contentPane.add(btnVerHojasDeRutaExistentes);
		
		JLabel lblNewLabel = new JLabel("Buscar por:");
		lblNewLabel.setBounds(38, 16, 84, 14);
		contentPane.add(lblNewLabel);
		comboBoxBuqueda.setModel(new DefaultComboBoxModel(new String[] {"Codigo Accion", "CI Representante", "Codigo Formulario"}));
		

		comboBoxBuqueda.setBounds(37, 41, 140, 21);
		contentPane.add(comboBoxBuqueda);
		
		JLabel lblFechaIinicio = new JLabel("Fecha Inicio (dd/MM/yyyy):");
		lblFechaIinicio.setBounds(37, 68, 166, 19);
		contentPane.add(lblFechaIinicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(213, 66, 86, 20);
		contentPane.add(txtFechaInicio);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(187, 42, 417, 19);
		contentPane.add(txtBuscar);
		
		JLabel lblFechaFinal = new JLabel("Fecha Fin (dd/MM/yyyy):");
		lblFechaFinal.setBounds(334, 70, 140, 14);
		contentPane.add(lblFechaFinal);
		
		txtFechaFinal = new JTextField();
		txtFechaFinal.setColumns(10);
		txtFechaFinal.setBounds(484, 66, 86, 20);
		contentPane.add(txtFechaFinal);
		
		JButton btnBuscarFechas = new JButton("Buscar por Fechas");
		btnBuscarFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener las fechas de inicio y fin ingresadas en los campos de texto
				String fechaInicioStr = txtFechaInicio.getText();
				String fechaFinalStr = txtFechaFinal.getText();

				// Validar si ambas fechas tienen el formato correcto
				if (validarFormatoFecha(fechaInicioStr) && validarFormatoFecha(fechaFinalStr)) {
					LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					LocalDate fechaFinal = LocalDate.parse(fechaFinalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

					// Filtrar los funcionarios por fecha, nombre y tipo de búsqueda y actualizar la
					// tabla
					filtrarPorFechas(fechaInicio, fechaFinal, txtBuscar.getText());
				} else {
					// Mostrar mensaje de error si alguna de las fechas no tiene el formato correcto
					JOptionPane.showMessageDialog(null, "Ingrese fechas válidas en el formato dd/MM/yyyy",
							"Error en fechas", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnBuscarFechas.setBounds(616, 68, 150, 20);
		contentPane.add(btnBuscarFechas);
		
		JButton btnBuscar = new JButton("Mostrar Todo");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscar.setText("");
				buscar("");
			}
		});
		btnBuscar.setBounds(632, 42, 134, 21);
		contentPane.add(btnBuscar);
		/*comboBoxBuqueda.addItem("Nombre");
		comboBoxBuqueda.addItem("CI");
		comboBoxBuqueda.addItem("Opción 3");
        comboBoxBuqueda.addItem("Opción 4");*/
		comboBoxBuqueda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Establecer el contenido del txtBuscar en blanco al seleccionar algo en el
				// comboBoxBuqueda
				txtBuscar.setText("");
				buscar("");
			}
		});
		txtBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtbuscarActionPerformed(evt);
			}
		});
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtbuscarKeyReleased(evt);
			}
		});
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        // Obtén el tipo de búsqueda seleccionado en el comboBoxBuqueda
		        String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();

		        // Si el tipo de búsqueda es "Edad", solo permite ingresar números
		        if ("Codigo Formulario".equals(tipoBusqueda)) {
		            char c = evt.getKeyChar();
		            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		                evt.consume();
		            }
		        }
		    }
		});
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        // Obtén el tipo de búsqueda seleccionado en el comboBoxBuqueda
		        String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();

		        // Si el tipo de búsqueda es "Edad", solo permite ingresar números
		        if ("Codigo Accion".equals(tipoBusqueda)) {
		            char c = evt.getKeyChar();
		            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		                evt.consume();
		            }
		        }
		    }
		});
		mnactualizar.setText("Agregar Acción");
		mnactualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnactualizarActionPerformed(evt);
			}
		});
		jPopupMenu1.add(mnactualizar);

		mneliminar.setText("Eliminar");
		mneliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mneliminarActionPerformed(evt);
			}
		});
		jPopupMenu1.add(mneliminar);
		txtBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtbuscarActionPerformed(evt);
			}
		});
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtbuscarKeyReleased(evt);
			}
		});
		table_1.setComponentPopupMenu(jPopupMenu1);
		buscar("");

	}

	/*
	 * public static void agregarFun(Funcionario fun) { admins.add(fun); } public
	 * static void removerFun(Funcionario fun) { admins.remove(fun); } public static
	 * void cambiar() { admins.clear(); try { admins =Conexion.adminsRegistrados();
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtbuscarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtbuscarActionPerformed

	private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtbuscarKeyReleased
		// TODO add your handling code here:
		buscar(txtBuscar.getText());
	}// GEN-LAST:event_txtbuscarKeyReleased

	// Método para validar el formato de la fecha
	private boolean validarFormatoFecha(String fechaStr) {
		try {
			LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	private void filtrarPorFechas(LocalDate fechaInicio, LocalDate fechaFinal, String valor) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Nombres de columna
		String[] columnNames = { "Codigo registro", "fecha", "CI representante","Codigo hoja de ruta" };
		String[] registros = new String[7];
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
				+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
				+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
				+ "FormularioHPMH i, PMH j\n"
				+ "where b.cid = c.beneficiario_cid\n"
				+ "and a.cfr = c.formularioregistro_cfr\n"
				+ "and b.cid = d.beneficiario_cid\n"
				+ "and e.cf = d.familias_cf\n"
				+ "and b.ci = e.ci_r\n"
				+ "and a.cfr = f.formularioregistro_cfr\n"
				+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
				+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
				+ "and j.cpmh = i.pmh_cpmh\n"
				+ "and j.fecha between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
				+ "and a.estado = true\n"
				+ "and j.estado = true\n"
				+ "and g.estado = true\n"
				+ "and b.estado = true\n"
				+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
						+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
						+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
						+ "FormularioHPMH i, PMH j\n"
						+ "where b.cid = c.beneficiario_cid\n"
						+ "and a.cfr = c.formularioregistro_cfr\n"
						+ "and b.cid = d.beneficiario_cid\n"
						+ "and e.cf = d.familias_cf\n"
						+ "and b.ci = e.ci_r\n"
						+ "and a.cfr = f.formularioregistro_cfr\n"
						+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
						+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
						+ "and j.cpmh = i.pmh_cpmh\n"
						+ "and j.fecha between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
						+ "and a.estado = true\n"
						+ "and j.estado = true\n"
						+ "and g.estado = true\n"
						+ "and b.estado = true\n"
						+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";

			} else {
				switch (tipoBusqueda) {
				case "Codigo Accion":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and j.cpmh = " + Integer.parseInt(valor) + "\n"
							+ "and j.fecha between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				case "CI Representante":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and b.ci like '%" + valor + "%'\n"
							+ "and j.fecha between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				case "Codigo Formulario":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and g.cfhd = " + Integer.parseInt(valor) + "\n"
							+ "and j.fecha between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				}
			}

			ResultSet rs = s.executeQuery(cons);
			while (rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);

				model.addRow(registros);
			}
			table_1.setModel(model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Ajustar el ancho de las columnas
		int[] columnWidths = { 130, 130, 130, 130 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}
		if (model.getRowCount() == 0) {
			// Mostrar un mensaje si no se encontraron resultados
			JOptionPane.showMessageDialog(null, "No se encontraron resultados", "Búsqueda sin resultados",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void buscar(String valor) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Nombres de columna
		String[] columnNames = { "Codigo registro", "fecha", "CI representante","Codigo hoja de ruta" };
		String[] registros = new String[7];
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
				+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
				+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
				+ "FormularioHPMH i, PMH j\n"
				+ "where b.cid = c.beneficiario_cid\n"
				+ "and a.cfr = c.formularioregistro_cfr\n"
				+ "and b.cid = d.beneficiario_cid\n"
				+ "and e.cf = d.familias_cf\n"
				+ "and b.ci = e.ci_r\n"
				+ "and a.cfr = f.formularioregistro_cfr\n"
				+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
				+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
				+ "and j.cpmh = i.pmh_cpmh\n"
				+ "and a.estado = true\n"
				+ "and j.estado = true\n"
				+ "and g.estado = true\n"
				+ "and b.estado = true\n"
				+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
						+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
						+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
						+ "FormularioHPMH i, PMH j\n"
						+ "where b.cid = c.beneficiario_cid\n"
						+ "and a.cfr = c.formularioregistro_cfr\n"
						+ "and b.cid = d.beneficiario_cid\n"
						+ "and e.cf = d.familias_cf\n"
						+ "and b.ci = e.ci_r\n"
						+ "and a.cfr = f.formularioregistro_cfr\n"
						+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
						+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
						+ "and j.cpmh = i.pmh_cpmh\n"
						+ "and a.estado = true\n"
						+ "and j.estado = true\n"
						+ "and g.estado = true\n"
						+ "and b.estado = true\n"
						+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";

			} else {
				switch (tipoBusqueda) {
				case "Codigo Accion":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and j.cpmh = " + Integer.parseInt(valor) + "\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				case "CI Representante":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and b.ci like '%" + valor + "%'\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				case "Codigo Formulario":
					cons = "select distinct j.cpmh, TO_CHAR(j.fecha, 'DD/MM/YYYY'), b.ci, g.cfhd\n"
							+ "from formularioregistro a, beneficiario b, formularioregbeneficiario c,\n"
							+ "Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f, FormularioHojaDeRuta g,\n"
							+ "FormularioHPMH i, PMH j\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "and j.cpmh = i.pmh_cpmh\n"
							+ "and g.cfhd = " + Integer.parseInt(valor) + "\n"
							+ "and a.estado = true\n"
							+ "and j.estado = true\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "group by j.cpmh, b.ci, j.fecha, g.cfhd";
					break;
				}
			}

			ResultSet rs = s.executeQuery(cons);
			while (rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);

				model.addRow(registros);
			}
			table_1.setModel(model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 130, 130, 130, 130 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}

	}

	private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedRow = table_1.getSelectedRow();
		try {
			if (selectedRow != -1) {
				ArrayList<HojaRutaAcciones> f = new ArrayList<HojaRutaAcciones>();
				int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 3));
				try {
					f = Conexion.traerHojaRutaAccion(cod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            	try {
            		
					Conexion.eliminarAccion(f);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	for(HojaRutaAcciones i: f) {
            		forms.remove(i);
            	}
            	buscar("");

			} else {
				JOptionPane.showMessageDialog(null, "Seleccione una fila");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void mnactualizarActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedRow = table_1.getSelectedRow();
		try {

			if (selectedRow != -1) {
				ArrayList<HojaRutaAcciones> f = new ArrayList<HojaRutaAcciones>();
				int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 3));
				try {
					f = Conexion.traerHojaRutaAccion(cod);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            	Hoja_ruta_acciones reg=null;
                if(f.size()>1) {
                	reg= new Hoja_ruta_acciones(f.get(0),f.get(1));
                    reg.setVisible(true);
                }else {
                	reg= new Hoja_ruta_acciones(f.get(0));
                    reg.setVisible(true);
                }
                
            	 ventanaAbierta = true; // Marcar la ventana como abierta
                 reg.addWindowListener(new WindowAdapter() {
                     @Override
                     public void windowClosed(WindowEvent e) {
                       ventanaAbierta = false; // Marcar la ventana como cerrada cuando se cierre
                     }
                 
                 });
			} else {
				JOptionPane.showMessageDialog(null, "Seleccione una fila");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
