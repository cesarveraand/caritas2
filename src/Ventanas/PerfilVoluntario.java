package Ventanas;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

public class PerfilVoluntario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField ci;
	private JTextField sexo;
	private JTextField correo;
	private JTextField telefono;
	private JTextField dia;
	private JTextField mes;
	private JTextField anio;
	private boolean isEditing = false;

	ButtonGroup grupoSexo;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilVoluntario frame = new PerfilVoluntario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PerfilVoluntario() {
		grupoSexo=new ButtonGroup();
		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1920, 1000);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		ArrayList <String> opcion=new ArrayList<String>();
		opcion.add("Femenino");
		opcion.add("Masculino"); 
		
		
		//datos de usuario administrador
		
		JLabel txtnombre = new JLabel("Nombre:");
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtnombre.setBounds(522, 274, 162, 50);
		contentPane.add(txtnombre);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 40));
		nombre.setText("Nombre de administrador");
		nombre.setBounds(703, 264, 1062, 60);
		contentPane.add(nombre);
		nombre.setColumns(10);
		nombre.setEditable(false);
		
		JLabel txtci = new JLabel("CI: ");
		txtci.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtci.setBounds(620, 362, 50, 50);
		contentPane.add(txtci);
		
		ci = new JTextField();
		ci.setText("1234567");
		ci.setFont(new Font("Tahoma", Font.PLAIN, 40));
		ci.setColumns(10);
		ci.setBounds(703, 352, 188, 60);
		contentPane.add(ci);
		ci.setEditable(false);
		
		JLabel txtsexo = new JLabel("Sexo:");
		txtsexo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtsexo.setBounds(324, 508, 129, 50);
		contentPane.add(txtsexo);
		
		ArrayList <String> tsexo= new ArrayList <>();
		tsexo.add("Masculino");tsexo.add("Femenino");
		
		JRadioButton rdbtnFemenino = new JRadioButton(tsexo.get(1));
		rdbtnFemenino.setBounds(649, 508, 150, 50);
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFemenino.setRolloverEnabled(false);
		grupoSexo.add(rdbtnFemenino);
		JRadioButton radbtnMasculino = new JRadioButton(tsexo.get(0));
		radbtnMasculino.setBounds(485, 508, 150, 50);
		radbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radbtnMasculino.setRolloverEnabled(false);
		grupoSexo.add(radbtnMasculino);
		
		sexo = new JTextField(tsexo.get(0));
		sexo.setText("");
		sexo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		sexo.setColumns(10);
		sexo.setBounds(485, 500, 400, 60);
		contentPane.add(sexo);
		sexo.setEditable(false);
		
		JLabel txtcorreo = new JLabel("Correo:");
		txtcorreo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtcorreo.setBounds(299, 610, 162, 50);
		contentPane.add(txtcorreo);
		
		correo = new JTextField();
		correo.setText("prueba@correo.com");
		correo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		correo.setColumns(10);
		correo.setBounds(485, 604, 698, 60);
		contentPane.add(correo);
		correo.setEditable(false);
		
		JLabel txttelefono = new JLabel("Teléfono:");
		txttelefono.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txttelefono.setBounds(271, 716, 162, 50);
		contentPane.add(txttelefono);
		
		telefono = new JTextField();
		telefono.setText("74004586");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 40));
		telefono.setColumns(10);
		telefono.setBounds(485, 710, 346, 60);
		contentPane.add(telefono);
		telefono.setEditable(false);
		
		JLabel txtnacimiento = new JLabel("Fecha de nacimiento:");
		txtnacimiento.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtnacimiento.setBounds(87, 827, 389, 50);
		contentPane.add(txtnacimiento);
		
		dia = new JTextField();
		dia.setHorizontalAlignment(SwingConstants.CENTER);
		dia.setText("12");
		dia.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dia.setColumns(10);
		dia.setBounds(485, 821, 75, 60);
		contentPane.add(dia);
		dia.setEditable(false);
		mes = new JTextField();
		mes.setText("12");
		mes.setHorizontalAlignment(SwingConstants.CENTER);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 40));
		mes.setEditable(false);
		mes.setColumns(10);
		mes.setBounds(620, 821, 75, 60);
		contentPane.add(mes);
		anio = new JTextField();
		anio.setText("1992");
		anio.setHorizontalAlignment(SwingConstants.CENTER);
		anio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		anio.setEditable(false);
		anio.setColumns(10);
		anio.setBounds(756, 821, 100, 60);
		contentPane.add(anio);
		
		JLabel slash = new JLabel("/\t           /\r\n");
		slash.setFont(new Font("Tahoma", Font.PLAIN, 35));
		slash.setBounds(582, 827, 423, 50);
		contentPane.add(slash);
		
		JLabel labelFoto = new JLabel("Foto");
		labelFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		labelFoto.setIcon(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/fotolabel.png")));
		labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelFoto.setBounds(135, 234, 200, 200);
		contentPane.add(labelFoto);
		labelFoto.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnFotoIcon = new JButton("");
		btnFotoIcon.setIcon(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/fotoicon.jpg")));
		btnFotoIcon.setBounds(345, 384, 50, 50);
		contentPane.add(btnFotoIcon);
		btnFotoIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFotoIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Subir foto
			}
		});
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/editaricon.jpg")));
		btnEditar.setBounds(1760, 870, 50, 50);
		contentPane.add(btnEditar);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.addActionListener(new ActionListener() {
			int s=0;
			public void actionPerformed(ActionEvent e) {
				if (!isEditing) {
					isEditing = true;
					contentPane.remove(sexo);
					contentPane.add(radbtnMasculino);
					contentPane.add(rdbtnFemenino);
					
					btnEditar.setIcon(new ImageIcon("Guardar"));
					btnEditar.setBounds(1700,870, 150, 50);
					btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
					
					nombre.setEditable(true);
					ci.setEditable(true);
					
					correo.setEditable(true);
					telefono.setEditable(true);
					dia.setEditable(true);
					mes.setEditable(true);
					anio.setEditable(true);
				}
				else {
					isEditing = false;
					btnEditar.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\editaricon.jpg"));
					btnEditar.setBounds(1760, 870, 50, 50);
					contentPane.add(btnEditar);
					
					contentPane.remove(radbtnMasculino);
					contentPane.remove(rdbtnFemenino);
					nombre.setEditable(false);
					ci.setEditable(false);
					if (radbtnMasculino.isSelected()) {
						sexo.setText(tsexo.get(0));
					}
					if(rdbtnFemenino.isSelected()) {
						sexo.setText(tsexo.get(1));
					}
					contentPane.add(sexo);
					correo.setEditable(false);
					telefono.setEditable(false);
					dia.setEditable(false);
					mes.setEditable(false);
					anio.setEditable(false);
					
					btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				
	
			}
		});
		
		JButton btnBack = new JButton("Atrás >");
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		//fondos principales
		JLabel linea1 = new JLabel("_______________________________________________________________________________________________________\r\n");
		linea1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		linea1.setBounds(456, 294, 1464, 69);
		contentPane.add(linea1);
		btnBack.setBounds(1720, 56, 122, 45);
		contentPane.add(btnBack);
		
		JLabel linea = new JLabel("________________________________________________________________________________________________________________________________________");
		linea.setFont(new Font("Tahoma", Font.PLAIN, 26));
		linea.setBounds(0, 112, 1920, 69);
		contentPane.add(linea);
		
		
		JLabel caritasLogo = new JLabel("");
		caritasLogo.setBounds(57, 28, 253, 90);
		caritasLogo.setIcon(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/logoCaritas.jpg")));
		contentPane.add(caritasLogo);

		JLabel fondo1 = new JLabel(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/fondoblanco.jpg")));
		fondo1.setBounds(0, 73, 1920, 980);
		getContentPane().add(fondo1);
		setVisible(true);	
		
		JLabel fundacion = new JLabel("");
		fundacion.setBounds(0, 0, 1920, 151);
		fundacion.setBackground(Color.WHITE);
		fundacion.setForeground(Color.WHITE);
		fundacion.setIcon(new ImageIcon(PerfilVoluntario.class.getResource("/imagenes_help/fondoblanco.jpg")));
		contentPane.add(fundacion);
	}
}

