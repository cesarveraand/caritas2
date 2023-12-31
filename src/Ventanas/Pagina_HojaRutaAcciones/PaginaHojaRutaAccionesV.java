package Ventanas.Pagina_HojaRutaAcciones;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import poo.*;
import Conexion.*;
import Ventanas.*;
import Ventanas.Formularios.Hoja_ruta_acciones;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;

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

public class PaginaHojaRutaAccionesV extends JFrame {

	private JPanel contentPane;
	private static JTable table_1 = new JTable();
	private static boolean ventanaAbierta = false;
	private JTextField txtBuscar;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFinal;
	static JComboBox comboBoxBuqueda = new JComboBox();
	
	public PaginaHojaRutaAccionesV() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaHojaRutaAccionesV.class.getResource("/imagenes_help/iconCaritas.png")));
		
		JPopupMenu jPopupMenu1 = new javax.swing.JPopupMenu();
		JMenuItem mnactualizar = new javax.swing.JMenuItem();
		JMenuItem mneliminar = new javax.swing.JMenuItem();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 966, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 99, 897, 453);
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
		btnVolver.setBounds(29, 563, 85, 21);
		contentPane.add(btnVolver);
		
		JButton btnAgregar = new JButton("Editar Acciones");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBackground(new Color(205, 55, 66));
		if(!Main.getFun().isAdmin()) {
			btnAgregar.setEnabled(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRutaAccionesEV pg=new PaginaHojaRutaAccionesEV();
				pg.setVisible(true);
				dispose();
				buscar("");
				 
			}
		});
		btnAgregar.setBounds(792, 563, 134, 21);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel = new JLabel("Buscar por:");
		lblNewLabel.setBounds(29, 11, 84, 14);
		contentPane.add(lblNewLabel);
		comboBoxBuqueda.setModel(new DefaultComboBoxModel(new String[] {"Codigo Formulario", "CI Representante"}));
		

		comboBoxBuqueda.setBounds(28, 36, 140, 21);
		contentPane.add(comboBoxBuqueda);
		
		JLabel lblFechaIinicio = new JLabel("Fecha Inicio (dd/MM/yyyy):");
		lblFechaIinicio.setBounds(28, 63, 166, 19);
		contentPane.add(lblFechaIinicio);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(178, 37, 417, 19);
		contentPane.add(txtBuscar);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(204, 61, 86, 20);
		contentPane.add(txtFechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Fin (dd/MM/yyyy):");
		lblFechaFinal.setBounds(325, 65, 140, 14);
		contentPane.add(lblFechaFinal);
		
		txtFechaFinal = new JTextField();
		txtFechaFinal.setColumns(10);
		txtFechaFinal.setBounds(475, 61, 86, 20);
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
		btnBuscarFechas.setBounds(607, 63, 150, 20);
		contentPane.add(btnBuscarFechas);
		
		JButton btnBuscar = new JButton("Mostrar Todo");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscar.setText("");
				buscar("");
			}
		});
		btnBuscar.setBounds(721, 36, 134, 21);
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
		        if ("Codigo Formulario".equals(tipoBusqueda)) {
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
		
		JButton btnBuscar_1 = new JButton("Actualizar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar("");
				txtBuscar.setText("");
			}
		});
		btnBuscar_1.setBounds(605, 35, 106, 21);
		contentPane.add(btnBuscar_1);
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
		String[] columnNames = { "Codigo registro", "fecha", "CI representante", "Nombre Representante" };
		String[] registros = new String[7];
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
				+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
				+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
				+ "where b.cid = c.beneficiario_cid\n"
				+ "and a.cfr = c.formularioregistro_cfr\n"
				+ "and b.cid = d.beneficiario_cid\n"
				+ "and e.cf = d.familias_cf\n"
				+ "and b.ci = e.ci_r\n"
				+ "and a.cfr = f.formularioregistro_cfr\n"
				+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
				+ "and g.estado = true\n"
				+ "and b.estado = true\n"
				+ "and not exists (select * from FormularioHPMH i, PMH j\n"
				+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
				+ "				and j.cpmh = i.pmh_cpmh)\n"
				+ "group by g.cfhd, b.ci, a.fecharegistro";
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
						+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
						+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
						+ "where b.cid = c.beneficiario_cid\n"
						+ "and a.cfr = c.formularioregistro_cfr\n"
						+ "and b.cid = d.beneficiario_cid\n"
						+ "and e.cf = d.familias_cf\n"
						+ "and b.ci = e.ci_r\n"
						+ "and a.cfr = f.formularioregistro_cfr\n"
						+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
						+ "and g.estado = true\n"
						+ "and b.estado = true\n"
						+ "and a.fechaRegistro between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
						+ "and not exists (select * from FormularioHPMH i, PMH j\n"
						+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
						+ "				and j.cpmh = i.pmh_cpmh)\n"
						+ "group by g.cfhd, b.ci, a.fecharegistro";

			} else {
				switch (tipoBusqueda) {
				case "Codigo Formulario":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and g.cfhd = " + Integer.parseInt(valor) +"\n"
							+ "and a.fechaRegistro between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro";
					break;
				case "CI Representante":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and b.ci like '%" + valor + "%'\n"
							+ "and a.fechaRegistro between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro";
					break;
				case "Nombre Representante":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and a.fechaRegistro between '"+ fechaInicio +"' and '" + fechaFinal + "'\n"
							+ "and LOWER(b.nombre) like '%" + valor.toLowerCase() + "%'\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";
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
		int[] columnWidths = { 80, 130, 130, 130 }; 
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
		String[] columnNames = { "Codigo registro", "fecha", "CI representante", "Nombre Representante" };
		String[] registros = new String[7];
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
				+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
				+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
				+ "where b.cid = c.beneficiario_cid\n"
				+ "and a.cfr = c.formularioregistro_cfr\n"
				+ "and b.cid = d.beneficiario_cid\n"
				+ "and e.cf = d.familias_cf\n"
				+ "and b.ci = e.ci_r\n"
				+ "and a.cfr = f.formularioregistro_cfr\n"
				+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
				+ "and g.estado = true\n"
				+ "and b.estado = true\n"
				+ "and not exists (select * from FormularioHPMH i, PMH j\n"
				+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
				+ "				and j.cpmh = i.pmh_cpmh)\n"
				+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
						+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
						+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
						+ "where b.cid = c.beneficiario_cid\n"
						+ "and a.cfr = c.formularioregistro_cfr\n"
						+ "and b.cid = d.beneficiario_cid\n"
						+ "and e.cf = d.familias_cf\n"
						+ "and b.ci = e.ci_r\n"
						+ "and a.cfr = f.formularioregistro_cfr\n"
						+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
						+ "and g.estado = true\n"
						+ "and b.estado = true\n"
						+ "and not exists (select * from FormularioHPMH i, PMH j\n"
						+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
						+ "				and j.cpmh = i.pmh_cpmh)\n"
						+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";

			} else {
				switch (tipoBusqueda) {
				case "Codigo Formulario":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.cfhd = " + Integer.parseInt(valor) + "\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";
					break;
				case "CI Representante":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and b.ci like '%" + valor + "%'\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";
					break;
				case "Nombre Representante":
					cons = "select g.cfhd, TO_CHAR(a.fecharegistro, 'DD/MM/YYYY'), b.ci, b.nombre\n"
							+ "from formularioregistro a, beneficiario b, FormularioHojaDeRuta g,\n"
							+ "formularioregbeneficiario c, Familia_beneficiario_voluntario d, familias e, NombresBeneficiario f\n"
							+ "where b.cid = c.beneficiario_cid\n"
							+ "and a.cfr = c.formularioregistro_cfr\n"
							+ "and b.cid = d.beneficiario_cid\n"
							+ "and e.cf = d.familias_cf\n"
							+ "and b.ci = e.ci_r\n"
							+ "and a.cfr = f.formularioregistro_cfr\n"
							+ "and g.cfhd = f.FormularioHojaDeRuta_cfhd\n"
							+ "and g.estado = true\n"
							+ "and b.estado = true\n"
							+ "and LOWER(b.nombre) like '%" + valor.toLowerCase() + "%'\n"
							+ "and not exists (select * from FormularioHPMH i, PMH j\n"
							+ "				where g.cfhd = i.FormularioHojaDeRuta_cfhd\n"
							+ "				and j.cpmh = i.pmh_cpmh)\n"
							+ "group by g.cfhd, b.ci, a.fecharegistro, b.nombre";
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
		int[] columnWidths = { 80, 130, 130,130 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}

	}


	private void mnactualizarActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedRow = table_1.getSelectedRow();
		try {
            if (selectedRow != -1) {
            	
            	Hoja_de_ruta f = null;
                int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 0));
                try {
                    f = Conexion.traerFormularioHoja(cod);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                Hoja_ruta_acciones reg= new Hoja_ruta_acciones(f);
                reg.setVisible(true);
                
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

