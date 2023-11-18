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

public class PaginaBeneficiario extends JFrame {

	private JPanel contentPane;
	private static ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
	private static ArrayList<Beneficiarios> bens=new ArrayList<Beneficiarios>();

	private static JTable table_1 = new JTable();
	private JTextField textFieldBusqueda;
	private static boolean ventanaAbierta = false;

	public PaginaBeneficiario(ArrayList<FormlarioRegistro> forms) {
		
		this.forms=forms;
		for( FormlarioRegistro i:forms) {
			for(Beneficiarios j: i.getFam().getFamilia()) {
				bens.add(j);
			}
		}
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
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro reg= new Registro();
				reg.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(629, 506, 85, 21);
		contentPane.add(btnAgregar);
		
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
		
		String[][] data = new String[bens.size()][5];
		int c = 0;
		for( FormlarioRegistro i:forms) {
			for(Beneficiarios j: i.getFam().getFamilia()) {
				bens.add(j);
		
					data[c][0] = j.getCodBen()+"";
					data[c][1] = j.getNombre() + "";
					data[c][2] =j.getCi()+"";
					data[c][3]= i.getFechaRegistro()+"";
					data[c][4] =i.getCfr()+ "";
					c++;
				
			
		} 
			}

		// Nombres de columna
		String[] columnNames = { "Codigo Beneficiario", "Nombre", "CI","Fecha registro","Codigo Formulario" };
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
                        	
                            FormlarioRegistro f = null;
                            int cod = Integer.parseInt((String) table_1.getValueAt(selectedRow, 4));
                            try {
                                f = Conexion.traerFormulario(cod);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                           // Registro reg= new Registro(f);
                            //reg.setVisible(true);
                            JPopupMenu popupMenu = createPopupMenu(f);
    						popupMenu.show(table_1, 0, table_1.getRowHeight() * selectedRow);
                          
                        
                        }
                    }
                }
            }
        });

	}
	private static JPopupMenu createPopupMenu(FormlarioRegistro f) {
        JPopupMenu popupMenu = new JPopupMenu();
        
        // Crear botones con las acciones deseadas
        JButton boton1 = new JButton("Eliminar");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        
        JButton boton3 = new JButton("Visualizar y Actualizar");
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Registro reg= new Registro(f);
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
        popupMenu.add(boton1);
        popupMenu.add(boton3);
        //popupMenu.add(boton4);

        return popupMenu;
    }
}