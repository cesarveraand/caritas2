package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import Ventanas.Formularios.Hoja_ruta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class InicioAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioAdmin frame = new InicioAdmin();
					frame.setTitle("Inicio Administrador");
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
	public InicioAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioAdmin.class.getResource("/imagenes_help/iconCaritas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(255, 255, 255));
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        imagenCaritas.setIcon(new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Salir");
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
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBounds(242, 88, 351, 281);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnFormularioDeRegistro = new JButton("FORMULARIO DE REGISTRO");
        btnFormularioDeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFormularioDeRegistro.setBounds(47, 166, 268, 44);
        panel_1.add(btnFormularioDeRegistro);
        
        JButton btnBusquedaDeHoja = new JButton("BUSQUEDA DE HOJA DE RUTA P.M.H.");
        btnBusquedaDeHoja.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBusquedaDeHoja.setBounds(47, 221, 268, 44);
        panel_1.add(btnBusquedaDeHoja);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        ImageIcon icon1 = new ImageIcon(InicioAdmin.class.getResource("/imagenes_help/formulario.png"));
        Image img1 = icon1.getImage().getScaledInstance(240, 144, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(img1));
        lblNewLabel.setBounds(60, 11, 240, 144);
        panel_1.add(lblNewLabel);

        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_2.setBounds(242, 439, 351, 281);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JButton btnFormularioDeRegistro_1 = new JButton("ESTADISTICAS");
        btnFormularioDeRegistro_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFormularioDeRegistro_1.setBounds(48, 205, 268, 44);
        panel_2.add(btnFormularioDeRegistro_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        ImageIcon icon2 = new ImageIcon(InicioAdmin.class.getResource("/imagenes_help/estadisticasIcon.png"));
        Image img2 = icon2.getImage().getScaledInstance(268, 185, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        lblNewLabel_1.setBounds(48, 11, 268, 185);
        panel_2.add(lblNewLabel_1);

        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_3.setBounds(804, 258, 799, 281);
        panel.add(panel_3);
        panel_3.setLayout(null);
        
        JButton btnFormularioDeRegistro_1_1 = new JButton("VOLUNTARIOS");
        btnFormularioDeRegistro_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFormularioDeRegistro_1_1.setBounds(80, 199, 268, 44);
        panel_3.add(btnFormularioDeRegistro_1_1);
        
        JButton btnFormularioDeRegistro_1_1_1 = new JButton("REFUGIADOS");
        btnFormularioDeRegistro_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFormularioDeRegistro_1_1_1.setBounds(465, 199, 268, 44);
        panel_3.add(btnFormularioDeRegistro_1_1_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        ImageIcon icon3 = new ImageIcon(InicioAdmin.class.getResource("/imagenes_help/voluntarioIcon.png"));
        Image img3 = icon3.getImage().getScaledInstance(268, 166, Image.SCALE_SMOOTH);
        lblNewLabel_1_1.setIcon(new ImageIcon(img3));
        lblNewLabel_1_1.setBounds(80, 22, 268, 166);
        panel_3.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("");
        ImageIcon icon4 = new ImageIcon(InicioAdmin.class.getResource("/imagenes_help/refugiadosIcon.png"));
        Image img4 = icon4.getImage().getScaledInstance(268, 177, Image.SCALE_SMOOTH);
        lblNewLabel_1_1_1.setIcon(new ImageIcon(img4));
        lblNewLabel_1_1_1.setBounds(465, 11, 268, 177);
        panel_3.add(lblNewLabel_1_1_1);
        //ojojaosjoasASAS
        
	}
	
}
