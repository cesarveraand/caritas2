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
import javax.swing.SwingConstants;

public class PaginaUsuarioV extends JFrame {

	private JPanel contentPane;

	
	public PaginaUsuarioV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFormReg = new JButton("Formulario registro");
		btnFormReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro pg=new Registro();
				pg.setVisible(true);
				
			}
		});
		btnFormReg.setBounds(298, 207, 198, 21);
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
				PaginaHojaRutaV pag=new PaginaHojaRutaV(f);
				pag.setVisible(true);
			}
		});
		btnRegFormHoja.setBounds(298, 261, 198, 21);
		contentPane.add(btnRegFormHoja);
		
		JLabel lblnombre = new JLabel("Administrador:");
		lblnombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblnombre.setBounds(22, 26, 152, 36);
		contentPane.add(lblnombre);
		lblnombre.setText(lblnombre.getText()+Main.nombre());
		
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
				PaginaHojaRutaAccionesV hjr =new PaginaHojaRutaAccionesV(f);
				hjr.setVisible(true); 
			}
		});
		btnRegAcciones.setBounds(298, 320, 198, 21);
		contentPane.add(btnRegAcciones); 
		
		JButton btnBene = new JButton("Beneficiarios");
		btnBene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
				try {
					forms = Conexion.formulariosRegistrado();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PaginaBeneficiarioV pg=new PaginaBeneficiarioV(forms);
				pg.setVisible(true);
				
			}
		});
		btnBene.setBounds(298, 152, 198, 21);
		contentPane.add(btnBene);
	}
}
