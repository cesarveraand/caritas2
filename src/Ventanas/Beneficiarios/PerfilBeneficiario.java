package Ventanas.Beneficiarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ventanas.Formularios.Hoja_ruta_acciones;
import Ventanas.Formularios.Registro;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilBeneficiario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDocIdentidad;
	private JTextField txtEdad;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilBeneficiario frame = new PerfilBeneficiario();
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
	public PerfilBeneficiario() {
		//los campos no se pueden editar y deben ser sacados de la BD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(new BorderLayout(0, 0));
		
		JLabel imagenCaritas = new JLabel("");
		imagenCaritas.setIcon(new ImageIcon(PerfilBeneficiario.class.getResource("/imagenes_help/caritas-bolivia.png")));
		panelCabecera.add(imagenCaritas, BorderLayout.WEST);
		
		JPanel panelBotonesCabecera = new JPanel();
		panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
		panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAtras = new JButton("< Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBotonesCabecera.add(btnAtras);
		
		JSeparator separator = new JSeparator();
		panelCabecera.add(separator, BorderLayout.SOUTH);
		
		JPanel panelPerfil = new JPanel();
		contentPane.add(panelPerfil, BorderLayout.CENTER);
		panelPerfil.setLayout(null);
		
		JLabel lblTitulo = new JLabel("PERFIL DEL BENEFICIARIO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(237, 28, 301, 14);
		panelPerfil.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(33, 92, 94, 14);
		panelPerfil.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(137, 89, 346, 20);
		panelPerfil.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDocumentoIdentidad = new JLabel("NUMERO DE DOCUMENTO DE IDENTIDAD:");
		lblDocumentoIdentidad.setBounds(33, 156, 250, 14);
		panelPerfil.add(lblDocumentoIdentidad);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setEditable(false);
		txtDocIdentidad.setBounds(278, 153, 205, 20);
		panelPerfil.add(txtDocIdentidad);
		txtDocIdentidad.setColumns(10);
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setBounds(33, 207, 46, 14);
		panelPerfil.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(99, 204, 86, 20);
		panelPerfil.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setBounds(237, 207, 46, 14);
		panelPerfil.add(lblSexo);
		
		JRadioButton rdbtnSexoFemenino = new JRadioButton("F");
		rdbtnSexoFemenino.setEnabled(false);
		panelPerfil.add(rdbtnSexoFemenino);
		rdbtnSexoFemenino.setBounds(278, 207, 46, 14);
		JRadioButton rdbtnSexoMasculino = new JRadioButton("M");
		rdbtnSexoMasculino.setEnabled(false);
		rdbtnSexoMasculino.setBounds(350, 207, 46, 14);
		panelPerfil.add(rdbtnSexoMasculino);
		
		JRadioButton rdbtnSexoOtro = new JRadioButton("OTRO");
		rdbtnSexoOtro.setEnabled(false);
		rdbtnSexoOtro.setBounds(413, 207, 70, 14);
		panelPerfil.add(rdbtnSexoOtro);
		
		ButtonGroup buttonGroupSexo = new ButtonGroup();
        buttonGroupSexo.add(rdbtnSexoFemenino);
        buttonGroupSexo.add(rdbtnSexoMasculino);
        buttonGroupSexo.add(rdbtnSexoOtro);
        
        JLabel lblPaisOrigen = new JLabel("PAIS D ORIGEN:");
        lblPaisOrigen.setBounds(33, 255, 94, 14);
        panelPerfil.add(lblPaisOrigen);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(137, 252, 146, 20);
        panelPerfil.add(textField);
        textField.setColumns(10);
        
        JButton btnRegistro = new JButton("FORMULARIO DE REGISTRO COMPLETO");
        btnRegistro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Registro_perfil frame = new Registro_perfil();   // te lleva aun registro no editable
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
        	}
        });
        btnRegistro.setBounds(88, 372, 275, 23);
        panelPerfil.add(btnRegistro);
        
        JButton btnHoja_Ruta = new JButton("HOJA DE RUTA P.M.H.");
        btnHoja_Ruta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Hoja_ruta_acciones frame = new Hoja_ruta_acciones();
                frame.setTitle("Hoja de ruta P.M.H.");
                frame.setVisible(true);
                setVisible(false);
        	}
        });
        btnHoja_Ruta.setBounds(472, 372, 252, 23);
        panelPerfil.add(btnHoja_Ruta);
		
		
		
	}

}
