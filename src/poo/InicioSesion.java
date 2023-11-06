package poo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCI;
	private JTextField textFieldContra;

	public InicioSesion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		textFieldCI = new JTextField();
		textFieldCI.setBounds(160, 145, 220, 19);
		contentPane.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		textFieldContra = new JTextField();
		textFieldContra.setBounds(163, 197, 217, 19);
		contentPane.add(textFieldContra);
		textFieldContra.setColumns(10);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldCI.getText()!=null && textFieldContra.getText()!=null) {
					Main.ingresar(textFieldCI.getText(),textFieldContra.getText());
					dispose();
					if(Main.isAdmin()) {
						PaginaUsuarioA pagA= new PaginaUsuarioA();
						pagA.setVisible(true);
					}else {
						PaginaUsuarioV pagV= new PaginaUsuarioV();
						pagV.setVisible(true);
					}
				}
			}
		});
		btnIngresar.setBounds(424, 270, 85, 21);
		contentPane.add(btnIngresar);
		
		
		JLabel lblCI = new JLabel("CI");
		lblCI.setBounds(85, 148, 45, 13);
		contentPane.add(lblCI);
		
		JLabel lblcontra = new JLabel("Contraseña");
		lblcontra.setBounds(85, 200, 69, 13);
		contentPane.add(lblcontra);
	}
}
