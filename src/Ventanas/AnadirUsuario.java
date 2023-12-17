package Ventanas;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Window.Type;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Component;

public class AnadirUsuario extends JFrame {
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField ci;
	private JTextField sexo;
	private JTextField correo;
	private JTextField telefono;
	private JTextField dia;
	private JTextField mes;
	private JTextField anio;
	private JPasswordField contrasena;
	ButtonGroup grupoTipo;
	ButtonGroup grupoSexo;
	private final Action action = new SwingAction();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirUsuario frame = new AnadirUsuario();
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
	public AnadirUsuario() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1920, 1000);
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		grupoTipo=new ButtonGroup();
   		grupoSexo=new ButtonGroup();
		
		
		//datos de usuario administrador
		
		JLabel txtnombre = new JLabel("Nombre:");
		txtnombre.setBounds(477, 228, 162, 50);
		txtnombre.setForeground(Color.WHITE);
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txtnombre);
		
		nombre = new JTextField();
		nombre.setBounds(649, 222, 1062, 60);
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 35));
		nombre.setText("Nombre de administrador");
		contentPane.add(nombre);
		nombre.setColumns(10);
		nombre.setEditable(true);
		
		JLabel txtci = new JLabel("CI: ");
		txtci.setBounds(556, 325, 50, 50);
		txtci.setForeground(Color.WHITE);
		txtci.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txtci);
		
		ci = new JTextField();
		ci.setBounds(649, 317, 188, 60);
		ci.setText("1234567");
		ci.setFont(new Font("Tahoma", Font.PLAIN, 40));
		ci.setColumns(10);
		contentPane.add(ci);
		
		JLabel txtsexo = new JLabel("Sexo:");
		txtsexo.setBounds(525, 420, 129, 50);
		txtsexo.setForeground(new Color(255, 255, 255));
		txtsexo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txtsexo);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(819, 416, 150, 50);
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupoSexo.add(rdbtnFemenino);
		JRadioButton radbtnMasculino = new JRadioButton("Masculino");
		radbtnMasculino.setBounds(649, 416, 150, 50);
		radbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupoSexo.add(radbtnMasculino);
		contentPane.add(radbtnMasculino);
		contentPane.add(rdbtnFemenino);
		
	
		JLabel txtcorreo = new JLabel("Correo:");
		txtcorreo.setBounds(505, 523, 162, 50);
		txtcorreo.setForeground(Color.WHITE);
		txtcorreo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txtcorreo);
		
		correo = new JTextField();
		correo.setBounds(649, 503, 698, 60);
		correo.setText("prueba@correo.com");
		correo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		correo.setColumns(10);
		contentPane.add(correo);
		
		JLabel txttelefono = new JLabel("Teléfono:");
		txttelefono.setBounds(482, 621, 162, 50);
		txttelefono.setForeground(Color.WHITE);
		txttelefono.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txttelefono);
		
		telefono = new JTextField();
		telefono.setBounds(649, 596, 346, 60);
		telefono.setText("74004586");
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 35));
		telefono.setColumns(10);
		contentPane.add(telefono);
		
		JLabel txtnacimiento = new JLabel("Fecha de nacimiento:");
		txtnacimiento.setBounds(326, 696, 309, 50);
		txtnacimiento.setForeground(Color.WHITE);
		txtnacimiento.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(txtnacimiento);
		
		dia = new JTextField();
		dia.setBounds(649, 690, 75, 60);
		dia.setHorizontalAlignment(SwingConstants.CENTER);
		dia.setText("12");
		dia.setFont(new Font("Tahoma", Font.PLAIN, 35));
		dia.setColumns(10);
		contentPane.add(dia);
		mes = new JTextField();
		mes.setBounds(762, 690, 75, 60);
		mes.setText("12");
		mes.setHorizontalAlignment(SwingConstants.CENTER);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		mes.setColumns(10);
		contentPane.add(mes);
		anio = new JTextField();
		anio.setBounds(869, 690, 100, 60);
		anio.setText("1992");
		anio.setHorizontalAlignment(SwingConstants.CENTER);
		anio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		anio.setColumns(10);
		contentPane.add(anio);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Administrador");
		rdbtnAdmin.setBounds(819, 794, 150, 50);
		rdbtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupoTipo.add(rdbtnAdmin);
		
		JRadioButton radbtnVoluntario = new JRadioButton("Voluntario");
		radbtnVoluntario.setBounds(649, 794, 150, 50);
		radbtnVoluntario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupoTipo.add(radbtnVoluntario);
		
		
		
		JLabel txtTipo = new JLabel("Tipo de usuario: ");
		txtTipo.setForeground(Color.WHITE);
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTipo.setBounds(394, 790, 226, 50);
		contentPane.add(txtTipo);
		
		JLabel txtnUsuario = new JLabel("Nuevo usuario");
		txtnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtnUsuario.setBounds(525, 40, 320, 78);
		contentPane.add(txtnUsuario);
		
		
		contentPane.add(radbtnVoluntario);
		contentPane.add(rdbtnAdmin);
		
		JLabel slash = new JLabel("/\t           /\r\n");
		slash.setBounds(738, 696, 145, 50);
		slash.setForeground(Color.WHITE);
		slash.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(slash);
		
		
		
		JLabel labelFoto = new JLabel("Foto");
		labelFoto.setBounds(146, 379, 200, 200);
		labelFoto.setVerticalAlignment(SwingConstants.BOTTOM);
		labelFoto.setIcon(new ImageIcon(AnadirUsuario.class.getResource("/imagenes_help/fotolabel.png")));
		labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelFoto);
		labelFoto.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton btnFotoIcon = new JButton("");
		btnFotoIcon.setBounds(356, 529, 50, 50);
		btnFotoIcon.setIcon(new ImageIcon(AnadirUsuario.class.getResource("/imagenes_help/fotoicon.jpg")));
		contentPane.add(btnFotoIcon);
		btnFotoIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFotoIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Subir foto
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(1650, 870, 150, 50);
		btnGuardar.setIcon(new ImageIcon(""));
		contentPane.add(btnGuardar);
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAdmin.isSelected()) {
                    PasswordDialog passwordDialog = new PasswordDialog();
                    passwordDialog.setVisible(true);
                    if (passwordDialog.isPasswordCorrect()) {
                    	JOptionPane.showMessageDialog(null, "administrador agregado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                    }
                } else {
                	JOptionPane.showMessageDialog(null, "voluntario agregado.");
                }
			}
		});
		
		JButton btnBack = new JButton("Atrás >");
		btnBack.setBounds(1720, 56, 122, 45);
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnBack);
		
		JLabel linea = new JLabel("________________________________________________________________________________________________________________________________________");
		linea.setBounds(0, 112, 1920, 69);
		linea.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(linea);
		
		
		JLabel caritasLogo = new JLabel("");
		caritasLogo.setBounds(57, 28, 253, 90);
		caritasLogo.setIcon(new ImageIcon(AnadirUsuario.class.getResource("/imagenes_help/logoCaritas.jpg")));
		contentPane.add(caritasLogo);

		JLabel fondo1 = new JLabel(new ImageIcon(AnadirUsuario.class.getResource("/imagenes_help/fondoazul.jpg")));
		fondo1.setBounds(-80, 162, 2040, 836);
		getContentPane().add(fondo1);
		setVisible(true);	
		fondo1.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel fundacion = new JLabel("");
		fundacion.setBounds(0, 0, 1920, 151);
		fundacion.setBackground(Color.WHITE);
		fundacion.setForeground(Color.WHITE);
		fundacion.setIcon(new ImageIcon(AnadirUsuario.class.getResource("/imagenes_help/fondoblanco.jpg")));
		contentPane.add(fundacion);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

