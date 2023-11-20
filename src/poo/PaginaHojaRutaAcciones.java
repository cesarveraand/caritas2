package poo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class PaginaHojaRutaAcciones extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Hoja_de_ruta> forms=new ArrayList<Hoja_de_ruta>();
	private static JTable table_1 = new JTable();
	private static boolean ventanaAbierta = false;
	private JTextField txtBuscar;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFinal;
	static JComboBox comboBoxBuqueda = new JComboBox();
	
	public PaginaHojaRutaAcciones(ArrayList<Hoja_de_ruta> forms) {
		
		this.forms=forms;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 99, 728, 365);
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
		btnVolver.setBounds(29, 491, 85, 21);
		contentPane.add(btnVolver);
		
		JButton btnAgregar = new JButton("Editar Acciones");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<HojaRutaAcciones> f= new ArrayList<HojaRutaAcciones>();
				try {
					f=Conexion.formHojaRutaAccionesExistentes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaHojaRutaAccionesE pg=new PaginaHojaRutaAccionesE(f);
				pg.setVisible(true);
				dispose();
				 
			}
		});
		btnAgregar.setBounds(672, 491, 85, 21);
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
		btnBuscar.setBounds(623, 37, 134, 21);
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
		buscar("");
		tabla();
	}
	/*
	public static void agregarFun(Funcionario fun) {
		admins.add(fun);
	}
	public static void removerFun(Funcionario fun) {
		admins.remove(fun);
	}
	public static void cambiar() {
		admins.clear();
		try {
			admins =Conexion.adminsRegistrados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
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
		// Nombres de columna
		String[] columnNames = { "Codigo registro", "fecha", "CI representante" };
		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Filtrar los funcionarios que coinciden con el valor de búsqueda

		for (Hoja_de_ruta i : forms) {
			LocalDate fechaRegsitro = i.getFechaReg();

			// Verificar si la fecha de contratación está dentro del rango especificado
			if (fechaRegsitro.isAfter(fechaInicio) && fechaRegsitro.isBefore(fechaFinal)) {

				if (valor == "") {
					model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
							i.getForm().getFam().getPrin().getCi() });

				} else {
					switch (tipoBusqueda) {
					case "Codigo Formulario":

						if (String.valueOf(i.getCfhd()).contains(valor)) {
							model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
									i.getForm().getFam().getPrin().getCi() });
						}
						break;
					case "CI Representante":

						if (i.getForm().getFam().getPrin().getCi().contains(valor)) {
							model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
									i.getForm().getFam().getPrin().getCi() });
						}
						break;
					}
				}
			}
		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 120, 120, 120 }; // Puedes ajustar estos valores según tus necesidades

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
		String[] columnNames = { "Codigo registro", "fecha", "CI representante" };
		// Obtener el tipo de búsqueda seleccionado en el comboBoxBuqueda
		String tipoBusqueda = (String) comboBoxBuqueda.getSelectedItem();
		// Crear el modelo de la tabla con los datos de las columnas
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Filtrar los funcionarios que coinciden con el valor de búsqueda

		for (Hoja_de_ruta i : forms) {

			if (valor == "") {
				model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
						i.getForm().getFam().getPrin().getCi() });

			} else {
				switch (tipoBusqueda) {
				case "Codigo Formulario":

					if (String.valueOf(i.getCfhd()).contains(valor)) {
						model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
								i.getForm().getFam().getPrin().getCi() });
					}
					break;
				case "CI Representante":

					if (i.getForm().getFam().getPrin().getCi().contains(valor)) {
						model.addRow(new String[] { i.getCfhd()+"", i.getFechaReg().format(dateFormatter),
								i.getForm().getFam().getPrin().getCi() });
					}
					break;
				}
			}

		}

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
		// Ajustar el ancho de las columnas
		int[] columnWidths = { 120, 120, 120 }; // Puedes ajustar estos valores según tus necesidades

		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = table_1.getColumnModel().getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}
	}
	public static void tabla() {

        table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (!ventanaAbierta) { // Verificar si la ventana no está abierta
                        int selectedRow = table_1.getSelectedRow();
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
                        
                        }
                    }
                }
            }
        });

	}
	
}

