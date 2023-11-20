package poo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PaginaBeneficiarioV extends JFrame {

	private JPanel contentPane;
	private static ArrayList<FormlarioRegistro> forms = new ArrayList<FormlarioRegistro>();
	private static ArrayList<Beneficiarios> bens = new ArrayList<Beneficiarios>();
	static JComboBox comboBoxBuqueda = new JComboBox();
	private static JTable table_1 = new JTable();
	private JTextField txtBuscar;
	private static boolean ventanaAbierta = false;
	private static JTextField txtFechaInicio;
	private static JTextField txtFechaFinal;
	private static JButton btnBuscarFechas;

	public PaginaBeneficiarioV(ArrayList<FormlarioRegistro> forms) {
		setTitle("Beneficiarios");

		this.forms = forms;
		for (FormlarioRegistro i : forms) {
			for (Beneficiarios j : i.getFam().getFamilia()) {
				bens.add(j);
			}
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 99, 729, 365);
		contentPane.add(scrollPane);

		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(table_1);

		setContentPane(contentPane);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(36, 488, 85, 21);
		contentPane.add(btnVolver);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro reg = new Registro();
				reg.setVisible(true);

			}
		});
		btnAgregar.setBounds(680, 488, 85, 21);
		contentPane.add(btnAgregar);

		JButton btnBuscar = new JButton("Mostrar Todo");
		btnBuscar.setBounds(631, 42, 134, 21);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar("");
			}
		});

		txtBuscar = new JTextField();
		txtBuscar.setBounds(186, 42, 417, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		comboBoxBuqueda.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "C.I.", "Sexo", "Edad", "Formulario"}));
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

		            // Filtrar los funcionarios por fecha, nombre y tipo de búsqueda y actualizar la tabla
		            filtrarPorFechas(fechaInicio, fechaFinal, txtBuscar.getText());
		        } else {
		            // Mostrar mensaje de error si alguna de las fechas no tiene el formato correcto
		            JOptionPane.showMessageDialog(null, "Ingrese fechas válidas en el formato dd/MM/yyyy", "Error en fechas",
		                    JOptionPane.ERROR_MESSAGE);
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
		buscar("");
		tabla();
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
		// Nombres de columna
		String[] columnNames = { "Beneficiario", "Nombre", "CI", "Fecha registro", "Edad", "Sexo", "Formulario" };
		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (FormlarioRegistro i : forms) {
			for (Beneficiarios j : i.getFam().getFamilia()) {
				LocalDate fechaRegsitro = i.getFechaRegistro();

				// Verificar si la fecha de contratación está dentro del rango especificado
				if (fechaRegsitro.isAfter(fechaInicio) && fechaRegsitro.isBefore(fechaFinal)) {
					switch (tipoBusqueda) {
					case "Nombre":

						if (j.getNombre().toLowerCase().contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "C.I.":
						if (j.getCi().contains(valor)) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Edad":
						if (String.valueOf(j.getEdad()).contains(valor)) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Sexo":
						// Agregar búsqueda por sexo
						if (j.getSexo().toLowerCase().contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Formulario":
						// Agregar búsqueda por sexo
						if (String.valueOf(i.getCfr()).contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()),
									j.getSexo(), String.valueOf(i.getCfr()) });
						}
						break;
					}
				}
			}
		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
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
		// Nombres de columna
		String[] columnNames = { "Beneficiario", "Nombre", "CI", "Fecha registro", "Edad", "Sexo", "Formulario" };
		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Filtrar los funcionarios que coinciden con el valor de búsqueda

		for (FormlarioRegistro i : forms) {
			for (Beneficiarios j : i.getFam().getFamilia()) {
				if (valor == "") {
					model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
							i.getFechaRegistro().toString(), String.valueOf(j.getEdad()), j.getSexo(),
							String.valueOf(i.getCfr()) });

				} else {
					switch (tipoBusqueda) {
					case "Nombre":

						if (j.getNombre().toLowerCase().contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "C.I.":
						if (j.getCi().contains(valor)) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Edad":
						if (String.valueOf(j.getEdad()).contains(valor)) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Sexo":
						// Agregar búsqueda por sexo
						if (j.getSexo().toLowerCase().contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()), j.getSexo(),
									String.valueOf(i.getCfr()) });
						}
						break;
					case "Formulario":
						// Agregar búsqueda por sexo
						if (String.valueOf(i.getCfr()).contains(valor.toLowerCase())) {
							model.addRow(new String[] { j.getCodBen() + "", j.getNombre(), j.getCi(),
									i.getFechaRegistro().format(dateFormatter), String.valueOf(j.getEdad()),
									j.getSexo(), String.valueOf(i.getCfr()) });
						}
						break;
					}
				}

			}
		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 80, 200, 150, 150, 130 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}
	}

	public static void tabla() {

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopupMenu(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopupMenu(e);
				}
			}

			private void showPopupMenu(MouseEvent e) {
				int selectedRow = table_1.rowAtPoint(e.getPoint());
				if (selectedRow != -1) {
					FormlarioRegistro f = null;
					int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 0));
					try {
						f = Conexion.traerFormulario(cod);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JPopupMenu popupMenu = createPopupMenu(f);
					popupMenu.show(table_1, e.getX(), e.getY());
				}
			}
		});

	}

	private static JPopupMenu createPopupMenu(FormlarioRegistro f) {
		JPopupMenu popupMenu = new JPopupMenu();

		JButton boton3 = new JButton("Visualizar y Actualizar");
		boton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Registro reg = new Registro(f);
				reg.setVisible(true);
				ventanaAbierta = true; // Marcar la ventana como abierta
				reg.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ventanaAbierta = false; // Marcar la ventana como cerrada cuando se cierre
					}
				});
			}
		});

		// Agregar los botones al menú flotante
		popupMenu.add(boton3);
		// popupMenu.add(boton4);

		return popupMenu;
	}

}
