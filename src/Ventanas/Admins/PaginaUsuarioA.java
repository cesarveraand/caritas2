package Ventanas.Admins;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import poo.*;
import Conexion.*;
import Ventanas.*;
import Ventanas.Formularios.Hoja_ruta;
import Ventanas.Formularios.Registro;
import Ventanas.Funcionarios.PerfilFuncionario;
import Ventanas.Pagina_HojaRutaAcciones.PaginaHojaRutaAcciones;
import Ventanas.Pagina_Registro.PaginaFormulariosRegistro;
import Ventanas.Paginas_Beneficiarios.PaginaBeneficiario;
import Ventanas.Paginas_HojaRuta.PaginaHojaRuta;
import Ventanas.Voluntario.PaginaVoluntarios;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class PaginaUsuarioA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static boolean ventanaAbierta=false;

	public PaginaUsuarioA() {
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
				
				PerfilFuncionario pf = new PerfilFuncionario(Main.getFun(), true);
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
        
        JLabel lblnombre = new JLabel("Administrador: ");
        lblnombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        panelCabecera.add(lblnombre, BorderLayout.CENTER);
		lblnombre.setText(lblnombre.getText()+Main.nombre());
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBounds(237, 239, 351, 358);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnFormReg = new JButton("FORMULARIO DE REGISTRO");
		btnFormReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaFormulariosRegistro pg=new PaginaFormulariosRegistro();
				pg.setVisible(true);
				
			}
		});
        btnFormReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFormReg.setBounds(47, 166, 268, 44);
        panel_1.add(btnFormReg);
        
        JButton btnRegFormHoja = new JButton("FORMULARIO HOJA DE RUTA");
		btnRegFormHoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRuta pag=new PaginaHojaRuta();
				pag.setVisible(true);
			}
		});
        btnRegFormHoja.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnRegFormHoja.setBounds(47, 221, 268, 44);
        panel_1.add(btnRegFormHoja);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        ImageIcon icon1 = new ImageIcon(PaginaUsuarioA.class.getResource("/imagenes_help/formulario.png"));
        Image img1 = icon1.getImage().getScaledInstance(240, 144, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(img1));
        lblNewLabel.setBounds(60, 11, 240, 144);
        panel_1.add(lblNewLabel);
        
        JButton btnRegAcciones = new JButton("AGREGAR ACCIONES HOJA DE RUTA");
		btnRegAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaHojaRutaAcciones hjr =new PaginaHojaRutaAcciones();
				hjr.setVisible(true);
			}
		});
        btnRegAcciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRegAcciones.setBounds(47, 276, 268, 44);
        panel_1.add(btnRegAcciones);
        ImageIcon icon2 = new ImageIcon(PaginaUsuarioA.class.getResource("/imagenes_help/estadisticasIcon.png"));
        Image img2 = icon2.getImage().getScaledInstance(268, 185, Image.SCALE_SMOOTH);

        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_3.setBounds(713, 258, 890, 281);
        panel.add(panel_3);
        panel_3.setLayout(null);
        
        
        
        JLabel lblNewLabel_1_1_2 = new JLabel("");
        ImageIcon iconA = new ImageIcon(PaginaUsuarioA.class.getResource("/imagenes_help/voluntarioIcon.png"));
        Image imgA = iconA.getImage().getScaledInstance(268, 166, Image.SCALE_SMOOTH);
        lblNewLabel_1_1_2.setIcon(new ImageIcon(imgA));
        lblNewLabel_1_1_2.setBounds(21, 33, 268, 166);
        panel_3.add(lblNewLabel_1_1_2);
        
        JButton btnAdmins = new JButton("ADMINISTRADORES");
		btnAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Funcionario> admis =new ArrayList<Funcionario>();
				try {
					admis=Conexion.adminsRegistrados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaAdministradores pagAd=new PaginaAdministradores(admis);
				pagAd.setVisible(true);
			}
		});
 
        btnAdmins.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdmins.setBounds(21, 210, 268, 44);
        panel_3.add(btnAdmins);
        
        JButton btnVoluntarios = new JButton("VOLUNTARIOS");
		btnVoluntarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Funcionario> v =new ArrayList<Funcionario>();
				try {
					v=Conexion.voluntariosRegistrados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaVoluntarios pagAd=new PaginaVoluntarios(v);
				pagAd.setVisible(true);
			}
		});
        btnVoluntarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnVoluntarios.setBounds(320, 210, 268, 44);
        panel_3.add(btnVoluntarios);
        
        JButton btnRefugiados = new JButton("BENEFICIARIOS");
		btnRefugiados.setBounds(298, 236, 198, 21);
		btnRefugiados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PaginaBeneficiario pg=new PaginaBeneficiario();
				pg.setVisible(true);
				
			}
		});
        btnRefugiados.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRefugiados.setBounds(612, 210, 268, 44);
        panel_3.add(btnRefugiados);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        ImageIcon icon3 = new ImageIcon(PaginaUsuarioA.class.getResource("/imagenes_help/voluntarioIcon.png"));
        Image img3 = icon3.getImage().getScaledInstance(268, 166, Image.SCALE_SMOOTH);
        lblNewLabel_1_1.setIcon(new ImageIcon(img3));
        lblNewLabel_1_1.setBounds(320, 33, 268, 166);
        panel_3.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("");
        ImageIcon icon4 = new ImageIcon(PaginaUsuarioA.class.getResource("/imagenes_help/refugiadosIcon.png"));
        Image img4 = icon4.getImage().getScaledInstance(268, 177, Image.SCALE_SMOOTH);
        lblNewLabel_1_1_1.setIcon(new ImageIcon(img4));
        lblNewLabel_1_1_1.setBounds(612, 22, 268, 177);
        panel_3.add(lblNewLabel_1_1_1);
        //ojojaosjoasASAS
        
        // Hacer que la ventana se abra en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
	}
}
