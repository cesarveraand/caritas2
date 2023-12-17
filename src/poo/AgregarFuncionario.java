package src.poo;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AgregarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCi;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldFechaNac;
	private JLabel lblTelefono;
	private JButton btnLimpiar;
	private JTextField textFieldContrasenia;
	private JLabel lblContrasenia;
	private JLabel lblCiudad;
	private JTextField textFieldCiudad;
	private JLabel lblDireccion;
	private JTextField textFieldDireccion;

	public AgregarFuncionario(boolean admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(149, 33, 307, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(84, 36, 45, 13);
		contentPane.add(lblNombre);

		JLabel lblCi = new JLabel("CI");
		lblCi.setHorizontalAlignment(SwingConstants.LEFT);
		lblCi.setBounds(84, 69, 45, 13);
		contentPane.add(lblCi);

		textFieldCi = new JTextField();
		textFieldCi.setColumns(10);
		textFieldCi.setBounds(149, 66, 307, 19);
		contentPane.add(textFieldCi);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(84, 217, 45, 13);
		contentPane.add(lblCorreo);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(149, 214, 307, 19);
		contentPane.add(textFieldCorreo);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(84, 255, 45, 13);
		contentPane.add(lblTelefono);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(149, 252, 307, 19);
		contentPane.add(textFieldTelefono);

		JLabel lblfechaNacimiento = new JLabel("Fecha nacimiento(dd/mm/aaaa)");
		lblfechaNacimiento.setBounds(84, 294, 176, 13);
		contentPane.add(lblfechaNacimiento);

		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(288, 291, 168, 19);
		contentPane.add(textFieldFechaNac);
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setColumns(10);
		textFieldContrasenia.setBounds(149, 100, 307, 19);
		contentPane.add(textFieldContrasenia);

		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(84, 103, 55, 13);
		contentPane.add(lblContrasenia);

		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(84, 138, 55, 13);
		contentPane.add(lblCiudad);

		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(149, 135, 307, 19);
		contentPane.add(textFieldCiudad);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(84, 177, 55, 13);
		contentPane.add(lblDireccion);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(149, 174, 307, 19);
		contentPane.add(textFieldDireccion);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Validar que los campos obligatorios no estén vacíos
		            if (textFieldNombre.getText().isEmpty() || textFieldCi.getText().isEmpty()
		                    || textFieldCorreo.getText().isEmpty() || textFieldContrasenia.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error",
		                        JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Validar que la fecha de nacimiento sea válida
		            String[] fecha = textFieldFechaNac.getText().split("/");
		            if (fecha.length >= 3) {
		                try {
		                    LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]),
		                            Integer.parseInt(fecha[0]));
		                } catch (NumberFormatException | DateTimeException ex) {
		                    JOptionPane.showMessageDialog(null,
		                            "Ingrese una fecha de nacimiento válida en el formato dd/mm/aaaa",
		                            "Error en fecha de nacimiento", JOptionPane.ERROR_MESSAGE);
		                    return;
		                }
		            } else {
		                // Mostrar mensaje de error porque no hay suficientes partes en la fecha
		                JOptionPane.showMessageDialog(null,
		                        "Ingrese una fecha de nacimiento válida en el formato dd/mm/aaaa",
		                        "Error en fecha de nacimiento", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Validar otros campos según tus requisitos

		            if (Conexion.confirmar(textFieldCi.getText())) {
		                int cod = 0;
		                try {
		                    cod = Conexion.ultimoFuncionario();
		                } catch (SQLException e1) {
		                    e1.printStackTrace();
		                }
		                Funcionario fun = new Funcionario(
		                        textFieldNombre.getText(), textFieldCi.getText(), textFieldCorreo.getText(),
		                        textFieldTelefono.getText(), textFieldCiudad.getText(), textFieldDireccion.getText(),
		                        textFieldContrasenia.getText(), LocalDate.of(Integer.parseInt(fecha[2]),
		                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0])),
		                        LocalDate.now(), true, admin);

		                if (admin) {
		                    PaginaAdministradores.agregarFun(fun);
		                } else {
		                    PaginaVoluntarios.agregarFun(fun);
		                }
		                try {
		                    Conexion.agregarAdmin(fun);
		                } catch (SQLException e1) {
		                    e1.printStackTrace();
		                }
		                if (admin) {
		                    PaginaAdministradores.tabla("");
		                } else {
		                    PaginaVoluntarios.tabla("");
		                }
		                dispose();
		                
		                // Mensaje de éxito
		                JOptionPane.showMessageDialog(null, "Funcionario agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "El CI que introdujo ya está registrado", "Error",
		                        JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (NumberFormatException | HeadlessException | SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		btnAgregar.setBounds(371, 333, 85, 21);
		contentPane.add(btnAgregar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCi.setText("");
				textFieldNombre.setText("");
				textFieldCorreo.setText("");
				textFieldFechaNac.setText("");
				textFieldTelefono.setText("");
				textFieldCiudad.setText("");
				textFieldTelefono.setText("");
				textFieldContrasenia.setText("");

			}
		});
		btnLimpiar.setBounds(84, 333, 85, 21);
		contentPane.add(btnLimpiar);

	}
}
