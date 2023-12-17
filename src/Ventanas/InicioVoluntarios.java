package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import Ventanas.Formularios.Hoja_ruta;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class InicioVoluntarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioVoluntarios frame = new InicioVoluntarios();
					frame.setTitle("Inicio Voluntario");
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
	public InicioVoluntarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioVoluntarios.class.getResource("/imagenes_help/iconCaritas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        imagenCaritas.setIcon(new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelBotonesCabecera.setBackground(new Color(255, 255, 255));
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setBackground(new Color(23, 74, 131));
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        btnPerfil.setBackground(new Color(255, 255, 255));
        ImageIcon iconOriginal = new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/perfilpersona.png"));
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panelCabecera.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("FORMULARIO DE REGISTRO");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(478, 30, 360, 71);
        panel.add(btnNewButton);
        btnNewButton.setBackground(Color.BLUE); // Establece el color de fondo del botón a azul
        btnNewButton.setForeground(Color.WHITE); // Establece el color del texto en blanco
        btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Establece el borde en negro

        
        JButton btnFormularioDeRegistro = new JButton("BUSQUEDA DE HOJA DE RUTA P.M.H.");
        btnFormularioDeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnFormularioDeRegistro.setBounds(873, 30, 378, 71);
        panel.add(btnFormularioDeRegistro);
        btnFormularioDeRegistro.setBackground(Color.RED); // Establece el color de fondo del botón a rojo
        btnFormularioDeRegistro.setForeground(Color.WHITE); // Establece el color del texto en blanco
        btnFormularioDeRegistro.setBorder(new LineBorder(new Color(0, 0, 0))); // Establece el borde en negro
        
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);
        
     // JLabel 1
        JLabel lblNewLabel = new JLabel("");
        ImageIcon icon1 = new ImageIcon(InicioVoluntarios.class.getResource("/imagenes/CaritasBoliviaFondo.jpg"));
        Image img1 = icon1.getImage().getScaledInstance(651, 783, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(img1));
        lblNewLabel.setBounds(0, 0, 651, 783);
        panel_1.add(lblNewLabel);

        // JLabel 2
        JLabel lblNewLabel_1 = new JLabel("");
        ImageIcon icon2 = new ImageIcon(InicioVoluntarios.class.getResource("/imagenes/iconCaritas.png"));
        Image img2 = icon2.getImage().getScaledInstance(504, 580, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        lblNewLabel_1.setBounds(649, 105, 504, 580);
        panel_1.add(lblNewLabel_1);

        // JLabel 3
        JLabel lblNewLabel_2 = new JLabel("");
        ImageIcon icon3 = new ImageIcon(InicioVoluntarios.class.getResource("/imagenes/CaritasBoliviaFondo.jpg"));
        Image img3 = icon3.getImage().getScaledInstance(743, 783, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        lblNewLabel_2.setBounds(1153, 0, 743, 794);
        panel_1.add(lblNewLabel_2);
	}

}
