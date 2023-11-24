package poo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.EventObject;
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
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PaginaVoluntarios extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Funcionario> volun = new ArrayList<Funcionario>();
	private static JTable table_1 = new JTable();
	private static JTextField txtBuscar;
	private static boolean ventanaAbierta = false;
	static JComboBox comboBoxBuqueda = new JComboBox();
	private static JTextField txtFechaInicio;
	private static JTextField txtFechaFinal;
	private static JButton btnBuscarFechas;

	public PaginaVoluntarios(ArrayList<Funcionario> volun) {
		setTitle("Voluntarios");

		this.volun = volun;

		tabla("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1240, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 102, 1170, 468);
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
		btnVolver.setBounds(27, 581, 85, 21);
		contentPane.add(btnVolver);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarFuncionario addmin = new AgregarFuncionario(false);
				addmin.setVisible(true);
				tabla("");

			}
		});
		btnAgregar.setBounds(1112, 581, 85, 21);
		contentPane.add(btnAgregar);

		JButton btnBuscar = new JButton("Mostrar Todo");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla("");
				txtBuscar.setText("");
			}
		});
		btnBuscar.setBounds(706, 31, 122, 21);
		contentPane.add(btnBuscar);

		comboBoxBuqueda.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "C.I.", "Correo", "Telefono", "Ciudad"}));
		comboBoxBuqueda.setBounds(27, 31, 140, 21);
		contentPane.add(comboBoxBuqueda);
		/*
		 * comboBoxBuqueda.addItem("Nombre"); comboBoxBuqueda.addItem("CI");
		 * comboBoxBuqueda.addItem("Opción 3"); comboBoxBuqueda.addItem("Opción 4");
		 */

		txtBuscar = new JTextField();
		txtBuscar.setBounds(177, 31, 403, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblFechaIinicio = new JLabel("Fecha Inicio (dd/MM/yyyy):");
		lblFechaIinicio.setBounds(27, 63, 166, 19);
		contentPane.add(lblFechaIinicio);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(203, 61, 86, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);

		JLabel lblFechaFinal = new JLabel("Fecha Fin (dd/MM/yyyy):");
		lblFechaFinal.setBounds(324, 65, 140, 14);
		contentPane.add(lblFechaFinal);

		txtFechaFinal = new JTextField();
		txtFechaFinal.setBounds(474, 61, 86, 20);
		contentPane.add(txtFechaFinal);
		txtFechaFinal.setColumns(10);
		// txtFechaFinal.setEditable(false);
		// txtFechaInicio.setEditable(false);
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
				tabla("");
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
		btnBuscarFechas.setBounds(570, 61, 150, 20);
		contentPane.add(btnBuscarFechas);
		// btnBuscarFechas.setEnabled(false);

		JLabel lblNewLabel = new JLabel("Buscar por:");
		lblNewLabel.setBounds(28, 11, 84, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar_1 = new JButton("Actualizar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla("");
				txtBuscar.setText("");
			}
		});
		btnBuscar_1.setBounds(590, 31, 106, 21);
		contentPane.add(btnBuscar_1);
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Verifica si el evento es un clic derecho (BUTTON3)
				if (e.getButton() == MouseEvent.BUTTON3) {
					abrirPerfilFuncionario();
				}
			}
		});

	}

	public static void agregarFun(Funcionario fun) {
		volun.add(fun);
	}

	public static void removerFun(Funcionario fun) {
		volun.remove(fun);
	}

	public static void cambiar() {
		volun.clear();
		try {
			volun = Conexion.adminsRegistrados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtbuscarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtbuscarActionPerformed

	private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtbuscarKeyReleased
		// TODO add your handling code here:
		tabla(txtBuscar.getText());
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
		String[] columnNames = { "Codigo", "Nombre", "CI", "Fecha Contratación", "Correo", "Teléfono", "Ciudad", "Dirección" };

		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Definir el formato para mostrar las fechas
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (Funcionario i : volun) {
			LocalDate fechaContratacion = i.getLFechaCon();

			// Verificar si la fecha de contratación está dentro del rango especificado
			if (fechaContratacion.isAfter(fechaInicio) && fechaContratacion.isBefore(fechaFinal)) {
				// Realizar la búsqueda según el tipo seleccionado en comboBoxBuqueda
				switch (tipoBusqueda) {
				case "Nombre":
					if (i.getNombre().toLowerCase().contains(valor.toLowerCase())) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "C.I.":
					if (i.getCi().toLowerCase().contains(valor)) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "Correo":
					if (i.getCorreo().toLowerCase().contains(valor)) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "Telefono":
				    if (i.getTelefono().toLowerCase().contains(valor)) {
				        model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
				                i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
				    }
				    break;
				case "Ciudad":
				    if (i.getCiudad().toLowerCase().contains(valor)) {
				        model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
				                i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
				    }
				    break;
				}
			}
		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
		// Ajustar el ancho de las columnas
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 80, 150, 100, 80, 150, 100, 100, 100 }; 

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

	public static void tabla(String valor) {
		// Nombres de columna
		String[] columnNames = { "Codigo", "Nombre", "CI", "Fecha Contratación", "Correo", "Teléfono", "Ciudad", "Dirección" };

		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		// Filtrar los funcionarios que coinciden con el valor de búsqueda

		// Definir el formato para mostrar las fechas
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (Funcionario i : volun) {
			if (valor == "") {
				model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
				        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });


			} else {
				switch (tipoBusqueda) {
				case "Nombre":
					if (i.getNombre().toLowerCase().contains(valor.toLowerCase())) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "C.I.":
					if (i.getCi().toLowerCase().contains(valor)) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "Correo":
					if (i.getCorreo().toLowerCase().contains(valor)) {
						model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
						        i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
					}
					break;
				case "Telefono":
				    if (i.getTelefono().toLowerCase().contains(valor)) {
				        model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
				                i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
				    }
				    break;
				case "Ciudad":
				    if (i.getCiudad().toLowerCase().contains(valor)) {
				        model.addRow(new String[] { i.getCod() + "", i.getNombre(), i.getCi(),
				                i.getLFechaCon().format(dateFormatter), i.getCorreo(), i.getTelefono(), i.getCiudad(), i.getDireccion() });
				    }
				    break;
				}

			}
		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);

		// Ajustar el ancho de las columnas
		int[] columnWidths = { 80, 150, 100, 80, 150, 100, 100, 100 }; 


		for (int i = 0; i < columnWidths.length; i++) {
		    TableColumn column = table_1.getColumnModel().getColumn(i);
		    column.setPreferredWidth(columnWidths[i]);
		}
	}


	private void abrirPerfilFuncionario() {
		int selectedRow = table_1.getSelectedRow();
		if (selectedRow != -1) {
			Funcionario f = null;
			int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 0));
			try {
				f = Conexion.traerFuncionario(cod);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			PerfilFuncionario pf = new PerfilFuncionario(f, false);
			pf.setVisible(true);
			ventanaAbierta = true; // Marcar la ventana como abierta
			pf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					ventanaAbierta = false; // Marcar la ventana como cerrada cuando se cierre
				}
			});
		}
	}
}
