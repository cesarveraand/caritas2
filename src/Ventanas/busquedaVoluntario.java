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
import java.awt.Color;
import java.awt.Toolkit;

public class busquedaVoluntario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					busquedaVoluntario frame = new busquedaVoluntario();
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
	public busquedaVoluntario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(busquedaVoluntario.class.getResource("/imagenes_help/iconCaritas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(Color.WHITE);
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        imagenCaritas.setIcon(new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelBotonesCabecera.setBackground(Color.WHITE);
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setBackground(new Color(23, 74, 131));
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        btnPerfil.setBackground(Color.WHITE);
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
	}
}
