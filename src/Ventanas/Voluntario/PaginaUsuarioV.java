package Ventanas.Voluntario;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import poo.*;
import Ventanas.Main;
import Ventanas.Formularios.*;
import Ventanas.Funcionarios.PerfilFuncionario;
import Ventanas.Pagina_HojaRutaAcciones.PaginaHojaRutaAccionesV;
import Ventanas.Paginas_Beneficiarios.PaginaBeneficiarioV;
import Ventanas.Paginas_HojaRuta.PaginaHojaRutaV;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;




import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class PaginaUsuarioV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean ventanaAbierta=false;

	public PaginaUsuarioV() {
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
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBotonesCabecera.add(btnAtras);

		JButton btnPerfil = new JButton("");
		ImageIcon iconOriginal = new ImageIcon(Registro.class.getResource("/imagenes_help/perfilpersona.png"));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PerfilFuncionario pf = new PerfilFuncionario(Main.getFun(), false);
				pf.setVisible(true);
				ventanaAbierta = true; // Marcar la ventana como abierta
				pf.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ventanaAbierta = false; // Marcar la ventana como cerrada cuando se cierre
					}
				});
			}
		});
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
        panelCabecera.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton btnBene = new JButton("BENEFICIARIOS");
		btnBene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaBeneficiarioV pg=new PaginaBeneficiarioV();
				pg.setVisible(true);
				
			}
		});
        btnBene.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBene.setBounds(34, 52, 225, 71);
        panel.add(btnBene);
        btnBene.setBackground(Color.BLUE); // Establece el color de fondo del botón a azul
        btnBene.setForeground(Color.WHITE); // Establece el color del texto en blanco
        btnBene.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Establece el borde en negro

        
        JButton btnFormReg = new JButton("FORMULARIO REGISTRO");
		btnFormReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro pg=new Registro();
				pg.setVisible(true);
				
			}
		});
        btnFormReg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnFormReg.setBounds(269, 52, 244, 71);
        panel.add(btnFormReg);
        btnFormReg.setBackground(Color.RED); // Establece el color de fondo del botón a rojo
        btnFormReg.setForeground(Color.WHITE); // Establece el color del texto en blanco
        btnFormReg.setBorder(new LineBorder(new Color(0, 0, 0))); // Establece el borde en negro
        
        JButton btnRegFormHoja = new JButton("FORMULARIO HOJA DE RUTA");
		btnRegFormHoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRutaV pag=new PaginaHojaRutaV();
				pag.setVisible(true);
			}
		});
        btnRegFormHoja.setForeground(Color.WHITE);
        btnRegFormHoja.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRegFormHoja.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnRegFormHoja.setBackground(Color.BLUE);
        btnRegFormHoja.setBounds(523, 52, 225, 71);
        panel.add(btnRegFormHoja);
        
        JButton btnRegAcciones = new JButton("AGREGAR ACCIONES HOJA DE RUTA");
		btnRegAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRutaAccionesV hjr =new PaginaHojaRutaAccionesV();
				hjr.setVisible(true); 
			}
		});
        btnRegAcciones.setForeground(Color.WHITE);
        btnRegAcciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRegAcciones.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnRegAcciones.setBackground(Color.RED);
        btnRegAcciones.setBounds(758, 52, 305, 71);
        panel.add(btnRegAcciones);
        
        JLabel lblnombre = new JLabel("Voluntario: ");
        lblnombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblnombre.setBounds(24, 11, 152, 36);
        panel.add(lblnombre);
		lblnombre.setText(lblnombre.getText()+Main.nombre());
        
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);
        
     // JLabel 1
        JLabel lblNewLabel = new JLabel("");
        ImageIcon icon1 = new ImageIcon(PaginaUsuarioV.class.getResource("/imagenes_help/CaritasBoliviaFondo.jpg"));
        Image img1 = icon1.getImage().getScaledInstance(651, 783, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(img1));
        lblNewLabel.setBounds(0, 0, 651, 783);
        panel_1.add(lblNewLabel);

        // JLabel 2
        JLabel lblNewLabel_1 = new JLabel("");
        ImageIcon icon2 = new ImageIcon(PaginaUsuarioV.class.getResource("/imagenes_help/iconCaritas.png"));
        Image img2 = icon2.getImage().getScaledInstance(504, 580, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(img2));
        lblNewLabel_1.setBounds(649, 105, 504, 580);
        panel_1.add(lblNewLabel_1);

        // JLabel 3
        JLabel lblNewLabel_2 = new JLabel("");
        ImageIcon icon3 = new ImageIcon(PaginaUsuarioV.class.getResource("/imagenes_help/CaritasBoliviaFondo.jpg"));
        Image img3 = icon3.getImage().getScaledInstance(743, 783, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(img3));
        lblNewLabel_2.setBounds(1153, 0, 743, 794);
        panel_1.add(lblNewLabel_2);
        
        // Hacer que la ventana se abra en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}

