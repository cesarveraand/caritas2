package poo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalTime;
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

public class PaginaHojaRutaAccionesE extends JFrame {

	private JPanel contentPane;
	private static ArrayList<HojaRutaAcciones> forms=new ArrayList<HojaRutaAcciones>();
	private static JTable table_1 = new JTable();
	private JTextField textFieldBusqueda;
	private static boolean ventanaAbierta = false;
	
	public PaginaHojaRutaAccionesE(ArrayList<HojaRutaAcciones> forms) {
		
		this.forms=forms;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 99, 648, 365);
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
		btnVolver.setBounds(66, 506, 85, 21);
		contentPane.add(btnVolver);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(629, 45, 85, 21);
		contentPane.add(btnBuscar);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(216, 46, 403, 19);
		contentPane.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		JComboBox comboBoxBuqueda = new JComboBox();
		comboBoxBuqueda.setBounds(66, 45, 140, 21);
		contentPane.add(comboBoxBuqueda);
		
		JButton btnVerHojasDeRutaExistentes = new JButton("Agregar");
		btnVerHojasDeRutaExistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Hoja_de_ruta> f=new ArrayList<Hoja_de_ruta>();
				try {
					f = Conexion.formHojaRutaAccions();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaHojaRutaAcciones hjr =new PaginaHojaRutaAcciones(f);
				hjr.setVisible(true);
				dispose();
			}
		});
		btnVerHojasDeRutaExistentes.setBounds(629, 506, 85, 21);
		contentPane.add(btnVerHojasDeRutaExistentes);
		/*comboBoxBuqueda.addItem("Nombre");
		comboBoxBuqueda.addItem("CI");
		comboBoxBuqueda.addItem("Opción 3");
        comboBoxBuqueda.addItem("Opción 4");*/
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
	public static void tabla() {
		
		String[][] data = new String[forms.size()][4];
		int c = 0;
		for (HojaRutaAcciones i : forms) {
			
					data[c][0] = i.getCpmh()+"";
					data[c][1] = i.getFechaAccion() + "";
					data[c][2] =i.getHjr().getForm().getFam().getPrin().getCi()+ "";
					data[c][3]= i.getHjr().getCfhd()+"";
					c++;
				
			
		} 

		// Nombres de columna
		String[] columnNames = { "Codigo registro", "fecha", "CI representante","Codigo hoja de ruta" };
		// Crear el modelo de la tabla con los datos y nombres de columna
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		// Asignar el modelo a la instancia existente de JTable
		table_1.setModel(model);
		TableColumn column = table_1.getColumnModel().getColumn(1);
        column.setPreferredWidth(200);
        table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (!ventanaAbierta) { // Verificar si la ventana no está abierta
                        int selectedRow = table_1.getSelectedRow();
                        if (selectedRow != -1) {
                        	Hoja_ruta_acciones reg=null;
                        	ArrayList<HojaRutaAcciones> f = new ArrayList<HojaRutaAcciones>();
                            int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 3));
                            try {
                                f = Conexion.traerHojaRutaAccion(cod);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
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
                        
                        }
                    }
                }
            }
        });

	}
	
}


