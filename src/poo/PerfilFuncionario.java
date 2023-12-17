package src.poo;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class PerfilFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCi;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldFechaNac;
	private JLabel lblTelefono;
	private JButton btnEditar;
	private JTextField textFieldContrasenia;
	private JLabel lblContrasenia;
	private JLabel lblCiudad;
	private JTextField textFieldCiudad;
	private JLabel lblDireccion;
	private JTextField textFieldDireccion;
	private boolean edit;
	private JLabel lblAdmin;
	private JButton btnBorrar;

	public PerfilFuncionario(Funcionario f, boolean admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		edit = false;
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
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
		textFieldCi.setEditable(false);
		textFieldCi.setColumns(10);
		textFieldCi.setBounds(149, 66, 307, 19);
		contentPane.add(textFieldCi);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(84, 217, 45, 13);
		contentPane.add(lblCorreo);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(149, 214, 307, 19);
		contentPane.add(textFieldCorreo);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(84, 255, 45, 13);
		contentPane.add(lblTelefono);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(149, 252, 307, 19);
		contentPane.add(textFieldTelefono);

		JLabel lblfechaNacimiento = new JLabel("Fecha nacimiento(dd/mm/aaaa)");
		lblfechaNacimiento.setBounds(84, 294, 176, 13);
		contentPane.add(lblfechaNacimiento);

		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setEditable(false);
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(280, 291, 176, 19);
		contentPane.add(textFieldFechaNac);
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setEditable(false);
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
		textFieldCiudad.setEditable(false);
		textFieldCiudad.setColumns(10);
		textFieldCiudad.setBounds(149, 135, 307, 19);
		contentPane.add(textFieldCiudad);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(84, 177, 55, 13);
		contentPane.add(lblDireccion);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(149, 174, 307, 19);
		contentPane.add(textFieldDireccion);

		lblAdmin = new JLabel("Empleo: ");
		lblAdmin.setBounds(84, 333, 45, 13);
		contentPane.add(lblAdmin);

		JRadioButton rdbtnAdmin = new JRadioButton("Adminstrador");
		rdbtnAdmin.setEnabled(false);

		rdbtnAdmin.setBounds(149, 329, 103, 21);
		contentPane.add(rdbtnAdmin);

		JRadioButton rdbtnVoluntario = new JRadioButton("Voluntario");
		rdbtnVoluntario.setEnabled(false);
		rdbtnVoluntario.setBounds(280, 329, 103, 21);
		contentPane.add(rdbtnVoluntario);
		if (admin) {
			rdbtnAdmin.setSelected(true);
		} else {
			rdbtnVoluntario.setSelected(true);
		}
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAdmin);
		group.add(rdbtnVoluntario);
		textFieldCi.setText(f.getCi());
		textFieldCiudad.setText(f.getCiudad());
		textFieldContrasenia.setText(f.getContra());
		textFieldCorreo.setText(f.getCorreo());
		textFieldDireccion.setText(f.getDireccion());
		textFieldFechaNac.setText(Extras.fecha(f.getFechaNac()));
		textFieldNombre.setText(f.getNombre());
		textFieldTelefono.setText(f.getTelefono());

		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean confirm = true;

					// Validar que los campos obligatorios no estén vacíos
					if (textFieldNombre.getText().isEmpty() || textFieldCi.getText().isEmpty()
							|| textFieldCorreo.getText().isEmpty() || textFieldContrasenia.getText().isEmpty()
							|| textFieldFechaNac.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Los campos nombre, CI, correo, contraseña y fecha de nacimiento son obligatorios",
								"Error", JOptionPane.ERROR_MESSAGE);
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


					if (!textFieldCi.getText().equals(f.getCi())) {
						confirm = Conexion.confirmar(textFieldCi.getText());
					}

					if (confirm) {

						Funcionario fun = new Funcionario(
								f.getCod(), textFieldNombre.getText(), textFieldCi.getText(), textFieldCorreo.getText(),
								textFieldTelefono.getText(), textFieldCiudad.getText(), textFieldDireccion.getText(),
								textFieldContrasenia.getText(), LocalDate.of(Integer.parseInt(fecha[2]),
										Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0])),
								LocalDate.now(), true, rdbtnAdmin.isSelected());

						try {
							Conexion.actualizar(fun);
							JOptionPane.showMessageDialog(null, "Funcionario actualizado con éxito", "Éxito",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						if (admin) {
							PaginaAdministradores.cambiar();
							PaginaAdministradores.tabla("");
						} else {
							PaginaVoluntarios.cambiar();
							PaginaVoluntarios.tabla("");
						}
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"No puede usar el mismo CI para crear otro usuario de Administrador");
					}

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		btnGuardar.setBounds(371, 356, 85, 21);
		contentPane.add(btnGuardar);

		btnEditar = new JButton("Editar");
		if(!admin) {
			btnEditar.setEnabled(false);
		}
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (edit) {
					edit = false;
					textFieldCi.setEditable(false);
					textFieldCiudad.setEditable(false);
					textFieldContrasenia.setEditable(false);
					textFieldCorreo.setEditable(false);
					textFieldDireccion.setEditable(false);
					textFieldFechaNac.setEditable(false);
					textFieldNombre.setEditable(false);
					textFieldTelefono.setEditable(false);
					rdbtnVoluntario.setEnabled(false);
					rdbtnAdmin.setEnabled(false);

				} else {
					edit = true;
					textFieldCi.setEditable(true);
					textFieldCiudad.setEditable(true);
					textFieldContrasenia.setEditable(true);
					textFieldCorreo.setEditable(true);
					textFieldDireccion.setEditable(true);
					textFieldFechaNac.setEditable(true);
					textFieldNombre.setEditable(true);
					textFieldTelefono.setEditable(true);
					btnGuardar.setEnabled(true);
					rdbtnVoluntario.setEnabled(true);
					rdbtnAdmin.setEnabled(true);
				}

			}
		});

		btnEditar.setBounds(84, 356, 85, 21);
		contentPane.add(btnEditar);

		JButton btnBorrar = new JButton("Eliminar");
		if(!admin) {
			btnBorrar.setEnabled(false);
		}
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Validar otros campos según tus requisitos
					String[] fecha = (textFieldFechaNac.getText()).split("/");
					Funcionario fun = new Funcionario(
							f.getCod(), textFieldNombre.getText(), textFieldCi.getText(), textFieldCorreo.getText(),
							textFieldTelefono.getText(), textFieldCiudad.getText(), textFieldDireccion.getText(),
							textFieldContrasenia.getText(), LocalDate.of(Integer.parseInt(fecha[2]),
									Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0])),
							LocalDate.now(), false, rdbtnAdmin.isSelected());

					try {
						Conexion.actualizar(fun);
						JOptionPane.showMessageDialog(null, "Funcionario eliminado con éxito", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					if (admin) {
						PaginaAdministradores.cambiar();
						PaginaAdministradores.tabla("");
					} else {
						PaginaVoluntarios.cambiar();
						PaginaVoluntarios.tabla("");
					}
					dispose();

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setBounds(220, 356, 85, 21);
		contentPane.add(btnBorrar);

	}
}
