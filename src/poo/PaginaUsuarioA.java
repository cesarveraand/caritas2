package poo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PaginaUsuarioA extends JFrame {

	private JPanel contentPane;

	
	public PaginaUsuarioA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmins = new JButton("Administradores");
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
		btnAdmins.setBounds(298, 141, 198, 21);
		contentPane.add(btnAdmins);
		
		JButton btnVoluntarios = new JButton("Voluntarios");
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
		btnVoluntarios.setBounds(298, 191, 198, 21);
		contentPane.add(btnVoluntarios);
		
		JButton btnFormReg = new JButton("Formulario registro");
		btnFormReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
				try {
					forms = Conexion.formulariosRegistrado();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaFormulariosRegistro pg=new PaginaFormulariosRegistro(forms);
				pg.setVisible(true);
				
			}
		});
		btnFormReg.setBounds(298, 279, 198, 21);
		contentPane.add(btnFormReg);
		
		JButton btnRegFormHoja = new JButton("Formulario hoja de ruta");
		btnRegFormHoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<FormlarioRegistro> f=new ArrayList<>();
				try {
					f=Conexion.traerFormulariosSinHojaDeRuta(); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaHojaRuta pag=new PaginaHojaRuta(f);
				pag.setVisible(true);
			}
		});
		btnRegFormHoja.setBounds(298, 332, 198, 21);
		contentPane.add(btnRegFormHoja);
		
		JLabel lblnombre = new JLabel("Administrador:");
		lblnombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblnombre.setBounds(22, 26, 152, 36);
		contentPane.add(lblnombre);
		lblnombre.setText(lblnombre.getText()+Main.nombre());
		
		JButton btnRefugiados = new JButton("Beneficiarios");
		btnRefugiados.setBounds(298, 236, 198, 21);
		btnRefugiados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
				try {
					forms = Conexion.formulariosRegistrado();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaBeneficiario pg=new PaginaBeneficiario(forms);
				pg.setVisible(true);
				
			}
		});
		contentPane.add(btnRefugiados);
		
		JButton btnRegAcciones = new JButton("Agregar acciones hoja de ruta");
		btnRegAcciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Hoja_de_ruta> f=new ArrayList<Hoja_de_ruta>();
				try {
					f = Conexion.formHojaRutaAccions();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaHojaRutaAcciones hjr =new PaginaHojaRutaAcciones(f);
				hjr.setVisible(true);
			}
		});
		btnRegAcciones.setBounds(298, 387, 198, 21);
		contentPane.add(btnRegAcciones);
	}
}
