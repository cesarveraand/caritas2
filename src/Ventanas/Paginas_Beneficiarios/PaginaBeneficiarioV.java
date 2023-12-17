package Ventanas.Paginas_Beneficiarios;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import poo.*;
import Conexion.*;
import Ventanas.*;
import Ventanas.Formularios.Registro;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Color;

public class PaginaBeneficiarioV extends JFrame {

	private JPanel contentPane;
	static JComboBox comboBoxBuqueda = new JComboBox();
	private static JTable table_1 = new JTable();
	private JTextField txtBuscar;
	private static boolean ventanaAbierta = false;
	private static JTextField txtFechaInicio;
	private static JTextField txtFechaFinal;
	private static JButton btnBuscarFechas;

	public PaginaBeneficiarioV() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaBeneficiarioV.class.getResource("/imagenes_help/iconCaritas.png")));
		JPopupMenu jPopupMenu1 = new javax.swing.JPopupMenu();
		JMenuItem mnactualizar = new javax.swing.JMenuItem();
		JMenuItem mneliminar = new javax.swing.JMenuItem();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1242, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 99, 1152, 452);
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
		btnVolver.setBounds(36, 562, 85, 21);
		contentPane.add(btnVolver);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBackground(new Color(205, 55, 66));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro reg = new Registro();
				reg.setVisible(true);
				buscar("");
			}
		});
		btnAgregar.setBounds(1103, 562, 85, 21);
		contentPane.add(btnAgregar);

		JButton btnBuscar = new JButton("Mostrar Todo");
		btnBuscar.setBounds(729, 42, 134, 21);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscar.setText("");
				buscar("");
			}
		});

		txtBuscar = new JTextField();
		txtBuscar.setBounds(186, 42, 417, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		comboBoxBuqueda
				.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "C.I.", "Sexo", "Edad", "Formulario" }));
		comboBoxBuqueda.setBounds(36, 41, 140, 21);
		contentPane.add(comboBoxBuqueda);
		comboBoxBuqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * String selectedOption = (String) comboBoxBuqueda.getSelectedItem(); if
				 * ("Fechas".equals(selectedOption)) { desbloquearFechas(); } else {
				 * bloquearFechas(); }
				 */
			}
		});
		comboBoxBuqueda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Establecer el contenido del txtBuscar en blanco al seleccionar algo en el
				// comboBoxBuqueda
				txtBuscar.setText("");
				buscar("");
			}
		});

		JLabel lblFechaIinicio = new JLabel("Fecha Inicio (dd/MM/yyyy):");
		lblFechaIinicio.setBounds(36, 68, 166, 19);
		contentPane.add(lblFechaIinicio);

		txtFechaInicio = new JTextField();
		// txtFechaInicio.setEditable(false);
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(212, 66, 86, 20);
		contentPane.add(txtFechaInicio);

		JLabel lblFechaFinal = new JLabel("Fecha Fin (dd/MM/yyyy):");
		lblFechaFinal.setBounds(333, 70, 140, 14);
		contentPane.add(lblFechaFinal);

		txtFechaFinal = new JTextField();
		// txtFechaFinal.setEditable(false);
		txtFechaFinal.setColumns(10);
		txtFechaFinal.setBounds(483, 66, 86, 20);
		contentPane.add(txtFechaFinal);

		btnBuscarFechas = new JButton("Buscar por Fechas");
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
		// btnBuscarFechas.setEnabled(false);
		btnBuscarFechas.setBounds(615, 68, 150, 20);
		contentPane.add(btnBuscarFechas);

		JLabel lblNewLabel = new JLabel("Buscar por:");
		lblNewLabel.setBounds(37, 16, 84, 14);
		contentPane.add(lblNewLabel);
		/*
		 * comboBoxBuqueda.addItem("Nombre"); comboBoxBuqueda.addItem("CI");
		 * comboBoxBuqueda.addItem("Opción 3"); comboBoxBuqueda.addItem("Opción 4");
		 */
		txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        // Obtén el tipo de búsqueda seleccionado en el comboBoxBuqueda
		        String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();

		        // Si el tipo de búsqueda es "Edad", solo permite ingresar números
		        if ("Edad".equals(tipoBusqueda)) {
		            char c = evt.getKeyChar();
		            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		                evt.consume();
		            }
		        }
		        if ("Formulario".equals(tipoBusqueda)) {
		            char c = evt.getKeyChar();
		            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		                evt.consume();
		            }
		        }
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
		table_1.setComponentPopupMenu(jPopupMenu1);
		
		JButton btnBuscar_1 = new JButton("Actualizar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar("");
				txtBuscar.setText("");
			}
		});
		btnBuscar_1.setBounds(613, 41, 106, 21);
		contentPane.add(btnBuscar_1);
		buscar("");
		// tabla();
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

	public static void bloquearFechas() {
		txtFechaFinal.setEditable(false);
		txtFechaInicio.setEditable(false);
		btnBuscarFechas.setEnabled(false);

	}

	public static void desbloquearFechas() {
		txtFechaFinal.setEditable(true);
		txtFechaInicio.setEditable(true);
		btnBuscarFechas.setEnabled(true);
	}

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


		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Nombres de columna
		String[] columnNames = { "Beneficiario", "Nombre", "CI", "Fecha registro", "Edad", "Sexo", "Formulario" };
		String[] registros = new String[7];
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
				+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
				+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
				+ "group by a.cid, b.cfr";
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
						+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
						+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
						+ "and b.fechaRegistro between '" + fechaInicio + "' and '" + fechaFinal + "' \n"
						+ "group by a.cid, b.cfr";

			} else {
				switch (tipoBusqueda) {
				case "Nombre":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and lower(a.nombre) like '%" + valor.toLowerCase() + "%'\n" + "and b.fechaRegistro between '" + fechaInicio
							+ "' and '" + fechaFinal + "' \n" + "group by a.cid, b.cfr";
					break;
				case "C.I.":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.ci like '%" + valor + "%'\n" + "and b.fechaRegistro between '" + fechaInicio
							+ "' and '" + fechaFinal + "' \n" + "group by a.cid, b.cfr";
					break;
				case "Edad":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.edad = " + Integer.valueOf(valor) + "\n" + "and b.fechaRegistro between '" + fechaInicio
							+ "' and '" + fechaFinal + "' \n" + "group by a.cid, b.cfr";
					break;
				case "Sexo":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.sexo like '%" + valor.toUpperCase() + "%'\n" + "and b.fechaRegistro between '" + fechaInicio
							+ "' and '" + fechaFinal + "' \n" + "group by a.cid, b.cfr";
					break;
				case "Formulario":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and b.cfr = " + Integer.parseInt(valor) + " and b.fechaRegistro between '" + fechaInicio + "' and '"
							+ fechaFinal + "' \n" + "group by a.cid, b.cfr";
					break;
				}
			}

			ResultSet rs = s.executeQuery(cons);
			while (rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);
				registros[4] = rs.getString(5);
				registros[5] = rs.getString(6);
				registros[6] = rs.getString(7);

				model.addRow(registros);
			}
			table_1.setModel(model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Ajustar el ancho de las columnas
		int[] columnWidths = { 80, 200, 150, 150, 130 }; // Puedes ajustar estos valores según tus necesidades

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
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		try {
			Conexion cn = new Conexion();
			Connection conexion = cn.getConexionPostgres();
			java.sql.Statement s = conexion.createStatement();

			// Nombres de columna
			String[] columnNames = { "Beneficiario", "Nombre", "CI", "Fecha registro", "Edad", "Sexo", "Formulario" };
			String[] registros = new String[7];
			DefaultTableModel model = new DefaultTableModel(null, columnNames);
			String cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
					+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
					+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
					+ "group by a.cid, b.cfr";

			// Filtrar los funcionarios que coinciden con el valor de búsqueda
			if (valor.isEmpty()) {
				cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
						+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
						+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
						+ "group by a.cid, b.cfr";

			} else {
				switch (tipoBusqueda) {
				case "Nombre":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and lower(a.nombre) like '%" + valor.toLowerCase() + "%'\n" + "group by a.cid, b.cfr";
					break;
				case "C.I.":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.ci like '%" + valor + "%'\n" + "group by a.cid, b.cfr";
					break;
				case "Edad":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.edad = " + Integer.valueOf(valor) + "\n" + "group by a.cid, b.cfr";
					break;
				case "Sexo":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and a.sexo like '%" + valor.toUpperCase() + "%'\n" + "group by a.cid, b.cfr";
					break;
				case "Formulario":
					cons = "select a.cid, a.nombre, a.ci, TO_CHAR(b.fecharegistro, 'DD/MM/YYYY'), a.edad, a.sexo, b.cfr\n"
							+ "from beneficiario a, formularioregistro b, Formularioregbeneficiario c\n"
							+ "where a.cid = c.beneficiario_cid\n" + "and b.cfr = c.formularioregistro_cfr\n"
							+ "and b.cfr = " + Integer.parseInt(valor) + " group by a.cid, b.cfr";
					break;
				}
			}

			ResultSet rs = s.executeQuery(cons);
			while (rs.next()) {
				registros[0] = rs.getString(1);
				registros[1] = rs.getString(2);
				registros[2] = rs.getString(3);
				registros[3] = rs.getString(4);
				registros[4] = rs.getString(5);
				registros[5] = rs.getString(6);
				registros[6] = rs.getString(7);

				model.addRow(registros);
			}
			table_1.setModel(model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 80, 200, 150, 150, 130 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}

	}



	private void mnactualizarActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedRow = table_1.getSelectedRow();
		try {
			if (selectedRow != -1) {
				FormlarioRegistro f = null;
				int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 6));
				try {
					f = Conexion.traerFormulario(cod);
					Registro reg = new Registro(f);
					reg.setVisible(true);
					ventanaAbierta = true; // Marcar la ventana como abierta
					reg.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							ventanaAbierta = false; // Marcar la ventana como cerrada cuando se cierre
						}
					});
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Seleccione una fila");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
