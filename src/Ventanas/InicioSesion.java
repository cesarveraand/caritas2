package Ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ventana.Voluntario.PaginaUsuarioV;
import Ventanas.Admins.*;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;


public class InicioSesion extends JFrame{
	private JPanel contentPane;
	private JTextField textFieldCI;
	private JPasswordField passwordField;

	public InicioSesion() {
		

	    JToggleButton toggleButtonMostrarContrasena;
		
		//icono de ventana :)
		ImageIcon icono = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Ventanas\\src\\imagenes\\iconCaritas.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/imagenes_help/iconCaritas.png")));

		setTitle("Cáritas Bolivia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		setBounds(0, 0, 1920, 1000);
		setSize(1920, 1000);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
        toggleButtonMostrarContrasena = new JToggleButton("Mostrar");
        toggleButtonMostrarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (toggleButtonMostrarContrasena.isSelected()) {
                    // Si está seleccionado, muestra el texto
                    passwordField.setEchoChar((char) 0);
                } else {
                    // Si no está seleccionado, oculta el texto
                    passwordField.setEchoChar('\u2022');
                }
            }
        });
        toggleButtonMostrarContrasena.setBounds(1149, 588, 89, 21);
        contentPane.add(toggleButtonMostrarContrasena);
		
		//Inicio de sesion cuadros
		passwordField = new JPasswordField();
		passwordField.setBounds(789, 573, 350, 50);
		contentPane.add(passwordField);
		
		
		textFieldCI = new JTextField();
		textFieldCI.setBounds(789, 492, 350, 50);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		JLabel TextoUsuario = new JLabel("Usuario:");
		TextoUsuario.setForeground(Color.WHITE);
		TextoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextoUsuario.setBounds(657, 504, 94, 18);
		contentPane.add(TextoUsuario);
		
		JLabel TextoContraseña = new JLabel("Contraseña:");
		TextoContraseña.setForeground(Color.WHITE);
		TextoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextoContraseña.setBounds(657, 582, 137, 25);
		contentPane.add(TextoContraseña);
		
		JLabel cuadro = new JLabel("");
		cuadro.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes_help/fondo rojo.jpeg")));
		cuadro.setBounds(617, 379, 628, 370);
		contentPane.add(cuadro);
		
		
		
		
		// Botones
		JButton btnIngresar = new JButton("Iniciar sesión");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresar.setBounds(803, 787, 250, 65);
		getContentPane().add(btnIngresar);
		btnIngresar.setIcon(new ImageIcon(""));
		btnIngresar.setHorizontalTextPosition(SwingConstants.CENTER);
				
				
		//Acciones de los botones
		btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldCI.getText() != null && passwordField.getPassword() != null) {
                    String password = new String(passwordField.getPassword());
                    if (Main.ingresar(textFieldCI.getText(), password)) {
                        dispose();
                        if (Main.isAdmin()) {
                            PaginaUsuarioA pagA = new PaginaUsuarioA();
                            pagA.setVisible(true);
                        } else {
                            PaginaUsuarioV pagV = new PaginaUsuarioV();

                            pagV.setVisible(true);
                        }
                    } else {
                        // Muestra un mensaje de error si el inicio de sesión falla
                        JOptionPane.showMessageDialog(InicioSesion.this,
                                "Inicio de sesión inválido. Verifica tu CI y contraseña.", "Error de inicio de sesión",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
		
		
		//fondos principales
		JLabel caritasLogo = new JLabel("");
		caritasLogo.setBounds(829, 48, 272, 100);
		caritasLogo.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes_help/logoCaritas.jpg")));
		contentPane.add(caritasLogo);
		
		JLabel fundacion = new JLabel("");
		fundacion.setBackground(Color.WHITE);
		fundacion.setForeground(Color.WHITE);
		fundacion.setBounds(0, 0, 1920, 180);
		fundacion.setIcon(new ImageIcon(InicioSesion.class.getResource("/imagenes_help/fondoblanco.jpg")));
		contentPane.add(fundacion);
		
        // Hacer que la ventana se abra en pantalla completa
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
		

		JLabel imagenprincipal = new JLabel(new ImageIcon(InicioSesion.class.getResource("/imagenes_help/Fundacion.jpg")));
		imagenprincipal.setBounds(0, 180, 1920, 900);
		getContentPane().add(imagenprincipal);
		 
		
		setVisible(true);
		
	}
}

