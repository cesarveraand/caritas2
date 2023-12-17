package Ventanas;



import java.awt.BorderLayout;

import java.awt.Color;
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
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class Login extends JFrame{
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contrasenia;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		//icono de ventana :)
		ImageIcon icono = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Ventanas\\src\\imagenes\\iconCaritas.png");
		setIconImage(icono.getImage());

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
		
		//Inicio de sesion cuadros
		contrasenia = new JPasswordField();
		contrasenia.setBounds(829, 585, 350, 50);
		contentPane.add(contrasenia);
		
		
		usuario = new JTextField();
		usuario.setBounds(829, 504, 350, 50);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel TextoUsuario = new JLabel("Usuario:");
		TextoUsuario.setForeground(Color.WHITE);
		TextoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextoUsuario.setBounds(725, 516, 94, 18);
		contentPane.add(TextoUsuario);
		
		JLabel TextoContraseña = new JLabel("Contraseña:");
		TextoContraseña.setForeground(Color.WHITE);
		TextoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextoContraseña.setBounds(697, 594, 137, 25);
		contentPane.add(TextoContraseña);
		
		JLabel cuadro = new JLabel("");
		cuadro.setIcon(new ImageIcon(Login.class.getResource("/imagenes_help/fondo rojo.jpeg")));
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
			@Override
			public void actionPerformed(ActionEvent e) {
				char [] clave= contrasenia.getPassword();
				String claveFinal= new String(clave);
				
				if (usuario.getText().equals("Voluntario")) {
					//PerfilVoluntario p1 = new PerfilVoluntario(); pasar a panel de voluntario
					//p1.setSize(900,600);
					//p1.setLocation(0,0);
									
					contentPane.removeAll();
					//contentPane.add(p1,BorderLayout.CENTER);
					contentPane.revalidate();
					contentPane.repaint();
				}
				else {
					if(usuario.getText().equals("Admin")) {
						//PerfilAdmin p1 = new PerfilAdmin(); pasar a panel de Admin
						//p1.setSize(1920,1080);
						//p1.setLocation(0,0);
										
						contentPane.removeAll();
						//contentPane.add(p1,BorderLayout.CENTER);
						contentPane.revalidate();
						contentPane.repaint();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		
		
		//fondos principales
		JLabel caritasLogo = new JLabel("");
		caritasLogo.setBounds(829, 48, 272, 100);
		caritasLogo.setIcon(new ImageIcon(Login.class.getResource("/imagenes_help/logoCaritas.jpg")));
		contentPane.add(caritasLogo);
		
		JLabel fundacion = new JLabel("");
		fundacion.setBackground(Color.WHITE);
		fundacion.setForeground(Color.WHITE);
		fundacion.setBounds(0, 0, 1920, 180);
		fundacion.setIcon(new ImageIcon(Login.class.getResource("/imagenes_help/fondoblanco.jpg")));
		contentPane.add(fundacion);

		JLabel imagenprincipal = new JLabel(new ImageIcon(Login.class.getResource("/imagenes_help/Fundacion.jpg")));
		imagenprincipal.setBounds(0, 180, 1920, 900);
		getContentPane().add(imagenprincipal);
		setVisible(true);
	}
}

