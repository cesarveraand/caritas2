package poo;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputFilter.Status;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtTelefono;
	private JPanel panelDatosPersonas;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private static boolean panel1 = false;
	private JTextField txtDocIdentidad;
	private JTextField txtExpedido;
	private JTextField txtMedioEnvio;
	private JTextField txtComunicacion;
	private JTextField txtFechaIngreso;
	private JTextField txtFechaSalida;
	private int contadorPersonas;
	private static List<JTextField> nombres = new ArrayList<>();
	private static List<JTextField> edades = new ArrayList<>();
	private static List<JTextField> docIdentidad = new ArrayList<>();
	private static List<JTextField> expedidos = new ArrayList<>();
	private static List<JComboBox<String>> educaciones = new ArrayList<>();
	private static List<ButtonGroup> sexos = new ArrayList<>();
	private static List<ButtonGroup> ingresos = new ArrayList<>();
	private static List<JTextField> permanencia = new ArrayList<>();
	private static List<JTextField> estatus = new ArrayList<>();
	private static List<JComboBox<String>> paisesPaso = new ArrayList<>();
	private static List<JPanel> panelesPaises = new ArrayList<>();
	private static List<JPanel> panelesPersonas = new ArrayList<>();
	private static boolean ventanaAbierta=false;
	private static boolean isRegistro = false;

	public Registro() {
		nombres.clear();
		edades.clear();
		docIdentidad.clear();
		expedidos.clear();
		educaciones.clear();
		sexos.clear();
		ingresos.clear();
		permanencia.clear();
		estatus.clear();
		paisesPaso.clear();
		panelesPaises.clear();
		panelesPersonas.clear();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(new BorderLayout(0, 0));

		JLabel imagenCaritas = new JLabel("");
		imagenCaritas.setIcon(new ImageIcon(Registro.class.getResource("/imagenes_help/caritas-bolivia.png")));
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
				
				PerfilFuncionario pf = new PerfilFuncionario(Main.getFun(), Main.getFun().isAdmin());
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
		JPanel panelFormulario = new JPanel();
		contentPane.add(panelFormulario, BorderLayout.CENTER);
		panelFormulario.setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("FORMULARIO DE REGISTRO");
		lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormulario.add(lblTitulo, BorderLayout.NORTH);

		JPanel panelLlenado = new JPanel();
		panelFormulario.add(panelLlenado, BorderLayout.CENTER);
		panelLlenado.setLayout(new BorderLayout(0, 0));

		JPanel panelDatosIniciales = new JPanel();
		panelLlenado.add(panelDatosIniciales, BorderLayout.NORTH);
		panelDatosIniciales.setLayout(null);
		panelDatosIniciales.setPreferredSize(new Dimension(1920, 130));

		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setBounds(48, 37, 46, 14);
		panelDatosIniciales.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(104, 34, 86, 20);
		panelDatosIniciales.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblLugar = new JLabel("LUGAR:");
		lblLugar.setBounds(48, 68, 46, 14);
		panelDatosIniciales.add(lblLugar);

		JComboBox comboBoxLugares = new JComboBox();
		comboBoxLugares.setModel(new DefaultComboBoxModel(new String[] { "Lugar 1", "Lugar 2" })); // se deberia sacar
																									// de la base de
																									// datos?, si si
																									// deberia haber una
																									// forma de añadir
																									// eso? nah, van a
																									// haber una
																									// cantidad finita
																									// de lugares
																									// supongo
		comboBoxLugares.setBounds(104, 64, 86, 22);
		panelDatosIniciales.add(comboBoxLugares);

		JCheckBox chckbxTransito = new JCheckBox("TRÁNSITO");
		chckbxTransito.setBounds(292, 20, 97, 23);
		panelDatosIniciales.add(chckbxTransito);

		JCheckBox chckbxSolRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
		chckbxSolRefugio.setBounds(292, 45, 228, 23);
		panelDatosIniciales.add(chckbxSolRefugio);

		JCheckBox chckbxSolAsistencia = new JCheckBox("SOLICITUD DE OTRO TIPO DE ASISTENCIA");
		chckbxSolAsistencia.setBounds(292, 70, 289, 23);
		panelDatosIniciales.add(chckbxSolAsistencia);

		JLabel lblTelefono = new JLabel("TELÉFONO:");
		lblTelefono.setBounds(292, 100, 115, 14);
		panelDatosIniciales.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(360, 97, 97, 20);
		panelDatosIniciales.add(txtTelefono);
		txtTelefono.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 1894, 13);
		panelDatosIniciales.add(separator_1);

		JPanel panelIdentificación = new JPanel();
		panelLlenado.add(panelIdentificación, BorderLayout.CENTER);
		panelIdentificación.setLayout(new BorderLayout(0, 0));

		JPanel panelCantidadPersonas = new JPanel();
		panelCantidadPersonas.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panelCantidadPersonas.getLayout();
		panelIdentificación.add(panelCantidadPersonas, BorderLayout.NORTH);

		JLabel lblCantidadPersonas = new JLabel("CANTIDAD DE PERSONAS:");
		panelCantidadPersonas.add(lblCantidadPersonas);

		contadorPersonas = 0;
		JLabel lblCantidadContador = new JLabel("0");// contador automatico de la cantidad de personas que estan siendo
														// registradas
		panelCantidadPersonas.add(lblCantidadContador);

		panelDatosPersonas = new JPanel();
		panelDatosPersonas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JScrollPane scrollPanePersonas = new JScrollPane(panelDatosPersonas);
		panelIdentificación.add(scrollPanePersonas, BorderLayout.CENTER);
		panelDatosPersonas.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panelAgregarPersona = new JPanel();
		panelDatosPersonas.add(panelAgregarPersona);
		panelAgregarPersona.setPreferredSize(new Dimension(850, 25));
		panelAgregarPersona.setLayout(null);

		JLabel lblIdentificacion = new JLabel("IDENTIFICACIÓN");
		lblIdentificacion.setBounds(394, 8, 100, 16);
		lblIdentificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
		panelAgregarPersona.add(lblIdentificacion);

		JButton btnAgregarPersona = new JButton("+AÑADIR PERSONA");
		btnAgregarPersona.setBounds(681, 6, 183, 23);
		panelAgregarPersona.add(btnAgregarPersona);

		JButton btnQuitarPersona = new JButton("-Quitar PERSONA");
		btnQuitarPersona.setBounds(500, 6, 183, 23);
		panelAgregarPersona.add(btnQuitarPersona);

		JPanel panelOrigenDestino = new JPanel();
		panelLlenado.add(panelOrigenDestino, BorderLayout.WEST);
		panelOrigenDestino.setPreferredSize(new Dimension(500, 400));
		panelOrigenDestino.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelOrigen = new JPanel();
		panelOrigenDestino.add(panelOrigen);
		panelOrigen.setLayout(new BorderLayout(0, 0));

		JLabel lblOrigen = new JLabel("ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelOrigen.add(lblOrigen, BorderLayout.NORTH);

		JPanel panelInfoOrigen = new JPanel();
		panelOrigen.add(panelInfoOrigen, BorderLayout.CENTER);
		panelInfoOrigen.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelInfoO = new JPanel();
		panelInfoOrigen.add(panelInfoO);
		panelInfoO.setLayout(null);

		JLabel lblPaisOrigen = new JLabel("PAÍS DE ORIGEN:");
		lblPaisOrigen.setBounds(28, 11, 112, 14);
		panelInfoO.add(lblPaisOrigen);

		JComboBox comboBoxPaisesOrigen = new JComboBox();
		comboBoxPaisesOrigen.setBounds(136, 7, 102, 22);
		comboBoxPaisesOrigen.addItem("Pais 1");
		comboBoxPaisesOrigen.setSelectedItem(0);
		panelInfoO.add(comboBoxPaisesOrigen);

		JLabel lblFechaSalida = new JLabel("FECHA SALIDA:");
		lblFechaSalida.setBounds(268, 11, 102, 14);
		panelInfoO.add(lblFechaSalida);

		txtFechaSalida = new JTextField();
		txtFechaSalida.setBounds(383, 8, 86, 20);
		panelInfoO.add(txtFechaSalida);
		txtFechaSalida.setColumns(10);

		JLabel lblTransporte = new JLabel("TRANSPORTE:");
		lblTransporte.setBounds(28, 40, 94, 14);
		panelInfoO.add(lblTransporte);

		JRadioButton rdbtnTransporteTerrestre = new JRadioButton("TERRESTRE");
		rdbtnTransporteTerrestre.setActionCommand("TERRESTRE");
		rdbtnTransporteTerrestre.setBounds(136, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteTerrestre);
		rdbtnTransporteTerrestre.setSelected(true);
		JRadioButton rdbtnTransporteAereo = new JRadioButton("AÉREO");
		rdbtnTransporteAereo.setActionCommand("AÉREO");
		rdbtnTransporteAereo.setBounds(261, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteAereo);

		ButtonGroup buttonGroupTransporte = new ButtonGroup();
		buttonGroupTransporte.add(rdbtnTransporteTerrestre);
		buttonGroupTransporte.add(rdbtnTransporteAereo);

		JLabel lblRazones = new JLabel("RAZONES POR LAS QUE SALIÓ DE SU PAÍS DE ORIGEN:");
		lblRazones.setBounds(28, 65, 269, 14);
		panelInfoO.add(lblRazones);

		JTextArea txtRazones = new JTextArea();
		JScrollPane scrollRazones = new JScrollPane(txtRazones);
		scrollRazones.setBounds(19, 90, 450, 40);
		panelInfoO.add(scrollRazones);

		JPanel panelEstatusMigra = new JPanel();

		JScrollPane scrollEstatusMigra = new JScrollPane(panelEstatusMigra);
		panelInfoOrigen.add(scrollEstatusMigra);
		panelEstatusMigra.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelAnadirEstatus = new JPanel();
		panelAnadirEstatus.setLayout(null);
		panelAnadirEstatus.setPreferredSize(new Dimension(450, 25));
		panelEstatusMigra.add(panelAnadirEstatus);

		JButton btnAnadirEstatus = new JButton("+ AÑADIR ESTATUS MIGRATORIO");

		btnAnadirEstatus.setBounds(250, 0, 251, 23);
		panelAnadirEstatus.add(btnAnadirEstatus);
		JButton btnQuitarEstatus = new JButton("- QUITAR ESTATUS MIGRATORIO");

		btnQuitarEstatus.setBounds(0, 0, 251, 23);
		panelAnadirEstatus.add(btnQuitarEstatus);

		JPanel panelDestino = new JPanel();
		panelOrigenDestino.add(panelDestino);
		panelDestino.setLayout(null);

		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestino.setBounds(220, 13, 104, 14);
		panelDestino.add(lblDestino);

		JLabel lblFechaIngreso = new JLabel("FECHA DE INGRESO:");
		lblFechaIngreso.setBounds(10, 36, 119, 14);
		panelDestino.add(lblFechaIngreso);

		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setBounds(122, 33, 86, 20);
		panelDestino.add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);

		JLabel lblFronterIngreso = new JLabel("FRONTERA DE INGRESO:");
		lblFronterIngreso.setBounds(220, 36, 155, 14);
		panelDestino.add(lblFronterIngreso);

		JComboBox comboBoxFronterasIngreso = new JComboBox();
		comboBoxFronterasIngreso.setBounds(385, 32, 93, 22);
		comboBoxFronterasIngreso.addItem("frontera 1");
		comboBoxFronterasIngreso.setSelectedIndex(0);
		panelDestino.add(comboBoxFronterasIngreso);

		JLabel lblDocumentoIngreso = new JLabel("DOCUMENTO DE INGRESO:");
		lblDocumentoIngreso.setBounds(10, 61, 153, 20);
		panelDestino.add(lblDocumentoIngreso);

		JComboBox comboBoxDocumentosIngreso = new JComboBox();
		comboBoxDocumentosIngreso
				.setModel(new DefaultComboBoxModel(new String[] { "Cédula", "Pasaporte", "Tarjeta Andina" }));
		comboBoxDocumentosIngreso.setBounds(183, 60, 131, 22);
		panelDestino.add(comboBoxDocumentosIngreso);

		JLabel lblPermanenciaMigracion = new JLabel("DIAS DE PERMANENCIA MIGRACIÓN:");
		lblPermanenciaMigracion.setBounds(10, 92, 182, 14);
		panelDestino.add(lblPermanenciaMigracion);

		JRadioButton rdbtn30dias = new JRadioButton("30");
		rdbtn30dias.setActionCommand("30");
		rdbtn30dias.setBounds(208, 89, 52, 23);
		panelDestino.add(rdbtn30dias);

		JRadioButton rdbtn60dias = new JRadioButton("60");
		rdbtn60dias.setActionCommand("60");
		rdbtn60dias.setBounds(262, 89, 52, 23);
		panelDestino.add(rdbtn60dias);

		JRadioButton rdbtn90dias = new JRadioButton("90");
		rdbtn90dias.setActionCommand("90");
		rdbtn90dias.setBounds(316, 88, 52, 23);
		panelDestino.add(rdbtn90dias);
		rdbtn30dias.setSelected(true);
		ButtonGroup buttonGroupPermanenciaMigracion = new ButtonGroup();
		buttonGroupPermanenciaMigracion.add(rdbtn30dias);
		buttonGroupPermanenciaMigracion.add(rdbtn60dias);
		buttonGroupPermanenciaMigracion.add(rdbtn90dias);

		JLabel lblBoliviaDestinoFinal = new JLabel("SU DESTINO FINAL ES BOLIVIA?:");
		lblBoliviaDestinoFinal.setBounds(10, 117, 182, 14);
		panelDestino.add(lblBoliviaDestinoFinal);

		JRadioButton rdbtnSiBolivia = new JRadioButton("SI");
		rdbtnSiBolivia.setActionCommand("SI");
		rdbtnSiBolivia.setBounds(208, 113, 52, 23);
		panelDestino.add(rdbtnSiBolivia);

		JRadioButton rdbtnNoBolivia = new JRadioButton("NO");
		rdbtnNoBolivia.setActionCommand("NO");
		rdbtnNoBolivia.setSelected(true);
		rdbtnNoBolivia.setBounds(262, 115, 52, 23);
		panelDestino.add(rdbtnNoBolivia);

		ButtonGroup buttonGroupBoliviaFinal = new ButtonGroup();
		buttonGroupBoliviaFinal.add(rdbtnSiBolivia);
		buttonGroupBoliviaFinal.add(rdbtnNoBolivia);

		JLabel lblPaisSiguiente = new JLabel("A QUÉ PAÍS PIENSA SEGUIR?:");
		lblPaisSiguiente.setBounds(10, 148, 204, 14);
		lblPaisSiguiente.setVisible(true);
		panelDestino.add(lblPaisSiguiente);

		JComboBox comboBoxPaisesSiguientes = new JComboBox();
		comboBoxPaisesSiguientes.setBounds(183, 142, 131, 22);
		comboBoxPaisesSiguientes.addItem("pais 1");
		comboBoxPaisesSiguientes.setSelectedIndex(0);
		comboBoxPaisesSiguientes.setVisible(true);
		panelDestino.add(comboBoxPaisesSiguientes);

		JLabel lblPqBolivia = new JLabel("POR QUÉ ESOCOGIO BOLIVIA COMO DESTINO FINAL?:");
		lblPqBolivia.setBounds(10, 176, 370, 14);
		lblPqBolivia.setVisible(false);
		panelDestino.add(lblPqBolivia);

		JTextArea txtPqBolivia = new JTextArea();
		JScrollPane scrollPqBolivia = new JScrollPane(txtPqBolivia);
		scrollPanePersonas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanePersonas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPqBolivia.setBounds(20, 194, 450, 71);
		scrollPqBolivia.setVisible(false);
		panelDestino.add(scrollPqBolivia);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 0, 500, 2);
		panelDestino.add(separator_4);

		rdbtnSiBolivia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPaisSiguiente.setVisible(false);
				comboBoxPaisesSiguientes.setVisible(false);
				lblPqBolivia.setVisible(true);
				scrollPqBolivia.setVisible(true);
			}
		});

		rdbtnNoBolivia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPaisSiguiente.setVisible(true);
				comboBoxPaisesSiguientes.setVisible(true);
				lblPqBolivia.setVisible(false);
				scrollPqBolivia.setVisible(false);
			}
		});

		JPanel panelFormadeVida = new JPanel();
		panelLlenado.add(panelFormadeVida, BorderLayout.EAST);

		panelFormadeVida.setPreferredSize(new Dimension(500, 400));
		panelFormadeVida.setLayout(null);

		JLabel lblFormaVida = new JLabel("FORMA DE VIDA");
		lblFormaVida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormaVida.setBounds(10, 34, 133, 14);
		panelFormadeVida.add(lblFormaVida);

		JLabel lblAlojamiento = new JLabel("DÓNDE SE ALOJA?:");
		lblAlojamiento.setBounds(10, 84, 111, 14);
		panelFormadeVida.add(lblAlojamiento);

		JComboBox comboBoxAlojamiento = new JComboBox();
		comboBoxAlojamiento.setModel(new DefaultComboBoxModel(
				new String[] { "Alquiler", "Acogido", "Alojamiento", "Situación de calle", "Otro " }));
		comboBoxAlojamiento.setBounds(136, 80, 111, 22);
		panelFormadeVida.add(comboBoxAlojamiento);

		JLabel lblSustento = new JLabel("CUÁL ES SU MEDIO DE SUSTENTO?:");
		lblSustento.setBounds(10, 141, 214, 14);
		panelFormadeVida.add(lblSustento);

		JRadioButton rdbtnSustentoInformal = new JRadioButton("INFORMAL");
		rdbtnSustentoInformal.setActionCommand("INFORMAL");
		rdbtnSustentoInformal.setBounds(219, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoInformal);

		JRadioButton rdbtnSustentoFormal = new JRadioButton("FORMAL");
		rdbtnSustentoFormal.setActionCommand("FORMAL");
		rdbtnSustentoFormal.setBounds(331, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoFormal);
		rdbtnSustentoFormal.setSelected(true);
		ButtonGroup buttonGroupSustento = new ButtonGroup();
		buttonGroupSustento.add(rdbtnSustentoInformal);
		buttonGroupSustento.add(rdbtnSustentoFormal);

		JLabel lblEnviaDinero = new JLabel("ENVIA DINERO A SU FAMILIA?:");
		lblEnviaDinero.setBounds(10, 197, 174, 14);
		panelFormadeVida.add(lblEnviaDinero);

		JRadioButton rdbtnSiEnvia = new JRadioButton("SI");
		rdbtnSiEnvia.setActionCommand("SI");
		rdbtnSiEnvia.setBounds(219, 193, 57, 23);
		panelFormadeVida.add(rdbtnSiEnvia);
		rdbtnSiEnvia.setSelected(true);
		JRadioButton rdbtnNoEnvia = new JRadioButton("NO");
		rdbtnNoEnvia.setActionCommand("NO");
		rdbtnNoEnvia.setBounds(331, 193, 109, 23);
		panelFormadeVida.add(rdbtnNoEnvia);
		rdbtnNoEnvia.setSelected(true);
		ButtonGroup buttonGroupEnviaDinero = new ButtonGroup();
		buttonGroupEnviaDinero.add(rdbtnSiEnvia);
		buttonGroupEnviaDinero.add(rdbtnNoEnvia);

		JLabel lblLeEnvianDinero = new JLabel("SU FAMILIA LE ENVIA DINERO?:");
		lblLeEnvianDinero.setBounds(10, 253, 184, 14);
		panelFormadeVida.add(lblLeEnvianDinero);

		JRadioButton rdbtnSiLeEnvian = new JRadioButton("SI");
		rdbtnSiLeEnvian.setActionCommand("SI");
		rdbtnSiLeEnvian.setBounds(219, 249, 57, 23);
		panelFormadeVida.add(rdbtnSiLeEnvian);

		JRadioButton rdbtnNoLeEnvian = new JRadioButton("NO");
		rdbtnNoLeEnvian.setActionCommand("NO");
		rdbtnNoLeEnvian.setSelected(true);
		rdbtnNoLeEnvian.setBounds(331, 249, 109, 23);
		panelFormadeVida.add(rdbtnNoLeEnvian);

		ButtonGroup buttonGroupLeEnvianDinero = new ButtonGroup();
		buttonGroupLeEnvianDinero.add(rdbtnSiLeEnvian);
		buttonGroupLeEnvianDinero.add(rdbtnNoLeEnvian);

		JLabel lblMedioEnvio = new JLabel("POR QUÉ MEDIO?:");
		txtMedioEnvio = new JTextField();
		lblMedioEnvio.setVisible(false);
		txtMedioEnvio.setVisible(false);
		lblMedioEnvio.setBounds(10, 305, 111, 14);
		panelFormadeVida.add(lblMedioEnvio);
		txtMedioEnvio.setBounds(242, 302, 124, 20);
		panelFormadeVida.add(txtMedioEnvio);
		txtMedioEnvio.setColumns(10);

		rdbtnSiLeEnvian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMedioEnvio.setVisible(true);
				txtMedioEnvio.setVisible(true);
			}
		});

		rdbtnNoLeEnvian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMedioEnvio.setVisible(false);
				txtMedioEnvio.setVisible(false);
			}
		});

		JLabel lblComunicacion = new JLabel("COMO SE COMUNICA CON SU FAMILIA?:");
		lblComunicacion.setBounds(10, 361, 222, 14);
		panelFormadeVida.add(lblComunicacion);

		txtComunicacion = new JTextField();
		txtComunicacion.setBounds(242, 358, 124, 20);
		panelFormadeVida.add(txtComunicacion);
		txtComunicacion.setColumns(10);

		JLabel lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObservaciones.setBounds(10, 445, 161, 14);
		panelFormadeVida.add(lblObservaciones);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 416, 500, 2);
		panelFormadeVida.add(separator_3);

		JTextArea txtObservaciones = new JTextArea();
		JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones);
		scrollObservaciones.setBounds(20, 472, 450, 71);
		panelFormadeVida.add(scrollObservaciones);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(0, 585, 500, 2);
		panelFormadeVida.add(separator_3_1);

		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				masPersona(lblCantidadContador);

			}
		});
		btnQuitarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menosPersona(lblCantidadContador);

			}
		});
		btnAnadirEstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masEstatusMigratorio(panelEstatusMigra);
			}
		});
		btnQuitarEstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menosEstatusMigratorio(panelEstatusMigra);
			}
		});
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean band = true;
				if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
					if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
							&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
							&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")
							&& alMenosUnCheckBoxSeleccionado(chckbxTransito, chckbxSolRefugio, chckbxSolAsistencia)) {
						if (validarFecha(txtFechaSalida.getText()) && validarFecha(txtFechaIngreso.getText())
								&& validarFecha(txtExpedido.getText()) && validarFecha(txtFecha.getText())) {
							ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
							Beneficiarios aux = null;
							ArrayList<PaisVisita> paises = new ArrayList<>();
							PaisVisita auxPais = null;
							int uB = 0, uP = 0, uR = 0, uF = 0;
							try {
								uP = Conexion.ultimoPaisVisita();
								uB = Conexion.ultimoBeneficiario();
								uR = Conexion.ultimoFormularioRegistro();
								uF = Conexion.ultimaFamilia();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int i = 0; i < estatus.size(); i++) {
								if (!permanencia.get(i).getText().equals("") && !estatus.get(i).getText().equals("")) {

									auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
											Integer.parseInt(permanencia.get(i).getText()), estatus.get(i).getText(),
											true);
									paises.add(auxPais);
									uP++;

								}
							}
							System.out.println(auxPais.toString());
							for (int i = 0; i < nombres.size(); i++) {
								if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
										&& !docIdentidad.get(i).getText().equals("")
										&& !expedidos.get(i).getText().equals("")) {
									aux = new Beneficiarios(uB, nombres.get(i).getText(),
											Integer.parseInt(edades.get(i).getText()),
											sexos.get(i).getSelection().getActionCommand(),
											docIdentidad.get(i).getText(), Extras.fechas(expedidos.get(i).getText()),
											ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
											(String) educaciones.get(i).getSelectedItem(), paises, true);
									beneficiarios.add(aux);
									uB++;

									band = band && Conexion.isCIRegistrado(docIdentidad.get(i).getText());
								}

							}

							System.out.println(aux.toString());
							if (band) {
								Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0),
										beneficiarios, true);
								FormlarioRegistro form = new FormlarioRegistro(uR,
										(String) comboBoxLugares.getSelectedItem(), txtTelefono.getText(),
										(String) comboBoxPaisesOrigen.getSelectedItem(),
										Extras.fechas(txtFechaSalida.getText()),
										buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
										txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
										(String) comboBoxFronterasIngreso.getSelectedItem(),
										(String) comboBoxDocumentosIngreso.getSelectedItem(),
										buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
										buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
										(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
										(String) comboBoxAlojamiento.getSelectedItem(),
										buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
										buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
										buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
										txtMedioEnvio.getText(), txtComunicacion.getText(), txtObservaciones.getText(),
										chckbxTransito.isSelected(), chckbxSolRefugio.isSelected(),
										chckbxSolAsistencia.isSelected(), fam, true);
								Main.setUltimoForm(form);
								System.out.println(form);
								Conexion.registrarFormBD(form);
								isRegistro = true;

								band = true;
								JOptionPane.showMessageDialog(null, "Registro exitoso.");

							} else {
								JOptionPane.showMessageDialog(null, "Documento de identidad ya fue registrado.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Ingrese fechas en formato dd/MM/yyyy.");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe llenar todos losa datos del formulario para poder registrarlo");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
				}

			}

		});
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean band = true;
				FormlarioRegistro form = null;
				if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
					if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
							&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
							&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")
							&& alMenosUnCheckBoxSeleccionado(chckbxTransito, chckbxSolRefugio, chckbxSolAsistencia)) {
						if (validarFecha(txtFechaSalida.getText()) && validarFecha(txtFechaIngreso.getText())
								&& validarFecha(txtExpedido.getText()) && validarFecha(txtFecha.getText())) {
							ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
							Beneficiarios aux = null;
							ArrayList<PaisVisita> paises = new ArrayList<>();
							PaisVisita auxPais = null;
							int uB = 0, uP = 0, uR = 0, uF = 0;
							try {
								uP = Conexion.ultimoPaisVisita();
								uB = Conexion.ultimoBeneficiario();
								uR = Conexion.ultimoFormularioRegistro();
								uF = Conexion.ultimaFamilia();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int i = 0; i < estatus.size(); i++) {
								if (!permanencia.get(i).getText().equals("") && !estatus.get(i).getText().equals("")) {

									auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
											Integer.parseInt(permanencia.get(i).getText()), estatus.get(i).getText(),
											true);
									paises.add(auxPais);
									uP++;

								}
							}
							System.out.println(auxPais.toString());
							for (int i = 0; i < nombres.size(); i++) {
								if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
										&& !docIdentidad.get(i).getText().equals("")
										&& !expedidos.get(i).getText().equals("")) {
									aux = new Beneficiarios(uB, nombres.get(i).getText(),
											Integer.parseInt(edades.get(i).getText()),
											sexos.get(i).getSelection().getActionCommand(),
											docIdentidad.get(i).getText(), Extras.fechas(expedidos.get(i).getText()),
											ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
											(String) educaciones.get(i).getSelectedItem(), paises, true);
									beneficiarios.add(aux);
									uB++;

									band = band && Conexion.isCIRegistrado(docIdentidad.get(i).getText());
								}

							}

							System.out.println(aux.toString());
							Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0), beneficiarios,
									true);
							form = new FormlarioRegistro(uR, (String) comboBoxLugares.getSelectedItem(),
									txtTelefono.getText(), (String) comboBoxPaisesOrigen.getSelectedItem(),
									Extras.fechas(txtFechaSalida.getText()),
									buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
									txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
									(String) comboBoxFronterasIngreso.getSelectedItem(),
									(String) comboBoxDocumentosIngreso.getSelectedItem(),
									buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
									buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
									(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
									(String) comboBoxAlojamiento.getSelectedItem(),
									buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
									buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
									buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
									txtMedioEnvio.getText(), txtComunicacion.getText(), txtObservaciones.getText(),
									chckbxTransito.isSelected(), chckbxSolRefugio.isSelected(),
									chckbxSolAsistencia.isSelected(), fam, true);
							// Main.setUltimoForm(form);
							System.out.println(form);
							// Conexion.registrarFormBD(form);
							isRegistro = true;

							band = true;
							JOptionPane.showMessageDialog(null, "Registro exitoso.");

						} else {
							JOptionPane.showMessageDialog(null, "Ingrese fechas en formato dd/MM/yyyy.");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe llenar todos losa datos del formulario para poder registrarlo");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
				}

				try {
					// Especifica la ruta donde quieres guardar el PDF
					String rutaPDF = "Archivos pdf registro/Registro_" + form.getCfr() + ".pdf";

					// Crea un documento PDF
					Document document = new Document();

					// Crea un escritor PDF
					try {
						PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Abre el documento para agregar contenido
					document.open();

					// Crea una fuente en negrita
					com.itextpdf.text.Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

					// Crea un párrafo centrado y en negrita
					Paragraph paragraph = new Paragraph("FORMULARIO DE REGISTRO", fontBold);
					paragraph.setAlignment(Element.ALIGN_CENTER);

					// Agrega el párrafo al documento
					document.add(paragraph);
					// line2
					paragraph = new Paragraph(
							"Fecha: " + form.getFechaRegistro() + "            Lugar: " + form.getLugar());
					paragraph.setSpacingAfter(0);
					document.add(paragraph);

					if (form.isTransito()) {
						Paragraph paragraph1 = new Paragraph("Transito");
						paragraph1.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph1);

					}

					// Agrega el párrafo al documento

					// line3

					if (form.isRefugio()) {
						paragraph = new Paragraph("Solicitud refugio ");
						paragraph.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph);

					}

					// Agrega el párrafo al documento
					// line4

					if (form.isAtencion()) {
						paragraph = new Paragraph("Solicitud de otro tipo de asistencia ");
						paragraph.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph);

					}

					// Agrega el párrafo al documento
					// line5
					paragraph = new Paragraph("Telefono: " + form.getTelefono());
					paragraph.setAlignment(Element.ALIGN_RIGHT);

					// Agrega el párrafo al documento
					document.add(paragraph);
					// line6
					paragraph = new Paragraph("IDENTIFICACIÓN", fontBold);
					paragraph.setAlignment(Element.ALIGN_LEFT);

					// Agrega el párrafo al documento
					document.add(paragraph);

					for (Beneficiarios i : form.getFam().getFamilia()) {
						// linea 1 identificacion
						paragraph = new Paragraph("Nombre: " + i.getNombre() + "         Edad: " + i.getEdad());

						// Agrega el párrafo al documento
						document.add(paragraph);
						// linea 2 identicacion
						paragraph = new Paragraph("Número de Documento de identidad: " + i.getCi()
								+ "            Expedido en: " + i.getFechaExpedido() + "       Sexo: " + i.getSexo());

						// Agrega el párrafo al documento
						document.add(paragraph);
						// linea 3 identicacion
						paragraph = new Paragraph("Nivel educación: " + i.getEducacion() + "             Ingreso: ");
						if (i.isIngreso()) {
							paragraph.add("Irregular");
						} else {
							paragraph.add("Regular");

						}

						// Agrega el párrafo al documento
						document.add(paragraph);
					}

					// line8
					paragraph = new Paragraph("ORÍGEN", fontBold);
					paragraph.setAlignment(Element.ALIGN_LEFT);
					document.add(paragraph);

					// line9
					paragraph = new Paragraph(
							"Pais origen: " + form.getPaisOrigen() + "                   Fecha salida: "
									+ form.getFechaSalida() + "                     Transporte: ");
					if (form.isTransporte()) {
						paragraph.add("Tierra");
					} else {
						paragraph.add("Aéreo");

					}
					document.add(paragraph);
					for (PaisVisita i : form.getFam().getFamilia().get(0).getPais()) {
						// linea 1 pais
						paragraph = new Paragraph("Paises por los que paso: " + i.getPais()
								+ "            Tiempo permanencia: " + i.getTiempoDias()
								+ "            Estatus migratorio: " + i.getEstadoMigratorioString());

						// Agrega el párrafo al documento
						document.add(paragraph);
					}
					paragraph = new Paragraph("EXPLIQUE LAS RAZONES POR LAS QUE SALIÓ DE SU PAÍS DE ORIGEN: ");
					document.add(paragraph);
					paragraph = new Paragraph(form.getRazon());
					document.add(paragraph);

					// linea 10
					paragraph = new Paragraph("DESTINO", fontBold);
					document.add(paragraph);
					// linea 11
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					String horaFormateada = form.getHoraRegistro().format(formatter);
					paragraph = new Paragraph("Fecha de ingreso a Bolivia: " + form.getFechaIngreso()
							+ "                 Hora ingreso: " + horaFormateada
							+ "                    Frontera ingreso: " + form.getFronteraIngreso());
					document.add(paragraph);
					// linea 12
					paragraph = new Paragraph("Documento de ingreso: " + form.getDocumentoIngreso()
							+ "            Dias de permanencia: " + form.getDiasPermanencia());
					document.add(paragraph);
					// linea 13
					paragraph = new Paragraph("Bolivia es su destino final: ");
					if (form.isDestinoFinal()) {
						paragraph.add("si");
						paragraph.add("SI BOLIVA ES SU DESTINO FINAL, ¿POR QUÉ ESCOGIÓ ESTE PAÍS? \n");
						paragraph.add(form.getPorquePais());
					} else {
						paragraph.add("no");
						paragraph.add("A que pais seguira: " + form.getPaisSiguiente());
					}

					document.add(paragraph);
					// linea 14
					paragraph = new Paragraph("FORMA DE VIDA", fontBold);
					document.add(paragraph);
					// linea 15
					paragraph = new Paragraph(
							"Donde se aloja: " + form.getAlojamiento() + "                   Hora ingreso: ");
					if (form.getSustento()) {
						paragraph.add("Informal");
					} else {
						paragraph.add("formal");
					}
					document.add(paragraph);
					// linea 16
					paragraph = new Paragraph("Envia dinero a su familia: ");
					if (form.isEnviaDinero()) {
						paragraph.add("si");
					} else {
						paragraph.add("no");
					}
					document.add(paragraph);
					// linea 16
					paragraph = new Paragraph("Le envia dinero su familia ");
					if (form.isLeEnviaDienro()) {
						paragraph.add("si");
						paragraph.add("Medio envio: " + form.getMedioEvniaDinero());
					} else {
						paragraph.add("no");
					}
					document.add(paragraph);
					// linea 17
					paragraph = new Paragraph("Como se comunica con su familia: " + form.getComunicaFamilia());

					document.add(paragraph);

					paragraph = new Paragraph("OBSERVACIONES", fontBold);
					document.add(paragraph);

					paragraph = new Paragraph(form.getObs());
					document.add(paragraph);

					paragraph = new Paragraph("AUTORIZACIÓN Y COMPROMISO", fontBold);
					document.add(paragraph);
					paragraph = new Paragraph(
							"Yo declaro que todos los datos que se encuentran en el presente documento son verdaderos y autorizo a que la PMH de Cáritas Bolivia archive mis datos y los utilice para los fines que corresponda, cuidando mi privacidad, y en beneficio de mi persona.\r\n"
									+ "\r\n"
									+ "Asimismo me comprometo a observar un buen comportamiento dentro de las instalaciones de Caritas y en todos los lugares a los que ésta me derive.\n\n");
					document.add(paragraph);
					paragraph = new Paragraph("____________________________");
					paragraph.setAlignment(Element.ALIGN_CENTER);

					document.add(paragraph);

					// Cierra el documento
					document.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnImprimir.setBounds(723, 45, 141, 23);

		panelDatosIniciales.add(btnImprimir);
		btnRegistrar.setBounds(723, 20, 139, 23);
		panelDatosIniciales.add(btnRegistrar);
		JButton btnHojaRuta = new JButton("IR HOJA DE RUTA");
		btnHojaRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isRegistro) {
					boolean band = true;
					if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
						if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
								&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
								&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")
								&& alMenosUnCheckBoxSeleccionado(chckbxTransito, chckbxSolRefugio,
										chckbxSolAsistencia)) {
							if (validarFecha(txtFechaSalida.getText()) && validarFecha(txtFechaIngreso.getText())
									&& validarFecha(txtExpedido.getText()) && validarFecha(txtFecha.getText())) {
								ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
								Beneficiarios aux = null;
								ArrayList<PaisVisita> paises = new ArrayList<>();
								PaisVisita auxPais = null;
								int uB = 0, uP = 0, uR = 0, uF = 0;
								try {
									uP = Conexion.ultimoPaisVisita();
									uB = Conexion.ultimoBeneficiario();
									uR = Conexion.ultimoFormularioRegistro();
									uF = Conexion.ultimaFamilia();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								for (int i = 0; i < estatus.size(); i++) {
									if (!permanencia.get(i).getText().equals("")
											&& !estatus.get(i).getText().equals("")) {

										auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
												Integer.parseInt(permanencia.get(i).getText()),
												estatus.get(i).getText(), true);
										paises.add(auxPais);
										uP++;

									}
								}
								System.out.println(auxPais.toString());
								for (int i = 0; i < nombres.size(); i++) {
									if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
											&& !docIdentidad.get(i).getText().equals("")
											&& !expedidos.get(i).getText().equals("")) {
										aux = new Beneficiarios(uB, nombres.get(i).getText(),
												Integer.parseInt(edades.get(i).getText()),
												sexos.get(i).getSelection().getActionCommand(),
												docIdentidad.get(i).getText(),
												Extras.fechas(expedidos.get(i).getText()),
												ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
												(String) educaciones.get(i).getSelectedItem(), paises, true);
										beneficiarios.add(aux);
										uB++;

										band = band && Conexion.isCIRegistrado(docIdentidad.get(i).getText());
									}

								}

								System.out.println(aux.toString());
								if (band) {
									Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0),
											beneficiarios, true);
									FormlarioRegistro form = new FormlarioRegistro(uR,
											(String) comboBoxLugares.getSelectedItem(), txtTelefono.getText(),
											(String) comboBoxPaisesOrigen.getSelectedItem(),
											Extras.fechas(txtFechaSalida.getText()),
											buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
											txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
											(String) comboBoxFronterasIngreso.getSelectedItem(),
											(String) comboBoxDocumentosIngreso.getSelectedItem(),
											buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
											buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
											(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
											(String) comboBoxAlojamiento.getSelectedItem(),
											buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
											buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
											buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
											txtMedioEnvio.getText(), txtComunicacion.getText(),
											txtObservaciones.getText(), chckbxTransito.isSelected(),
											chckbxSolRefugio.isSelected(), chckbxSolAsistencia.isSelected(), fam, true);
									Main.setUltimoForm(form);
									System.out.println(form);
									Conexion.registrarFormBD(form);
									isRegistro = true;

									band = true;
									JOptionPane.showMessageDialog(null, "Registro exitoso.");

								} else {
									JOptionPane.showMessageDialog(null, "Documento de identidad ya fue registrado.");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Ingrese fechas en formato dd/MM/yyyy.");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Debe llenar todos losa datos del formulario para poder registrarlo");

						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
					}

				}
				Hoja_ruta dj = new Hoja_ruta(null,true);
				dj.setVisible(true);
				dispose();
			}
		});
		btnHojaRuta.setBounds(723, 70, 139, 23);
		panelDatosIniciales.add(btnHojaRuta);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = LocalDate.now().format(dateFormatter);
		txtFecha.setText(fechaFormateada);
		txtFecha.setEditable(false);
		// Hacer que la ventana se abra en pantalla completa
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	// Método para validar fechas
	private boolean validarFecha(String fecha) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(fecha, formatter);
			// La fecha se ha parseado correctamente, ahora puedes realizar otras
			// validaciones si es necesario
			return true;
		} catch (DateTimeParseException e) {
			// La fecha no pudo ser parseada correctamente
			return false;
		}
	}

	// Método para validar si al menos un checkbox está seleccionado
	private static boolean alMenosUnCheckBoxSeleccionado(JCheckBox... checkboxes) {
		for (JCheckBox checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				return true; // Al menos un checkbox está seleccionado
			}
		}
		return false; // Ningún checkbox está seleccionado
	}

	public Registro(FormlarioRegistro reg) {

		nombres.clear();
		edades.clear();
		docIdentidad.clear();
		expedidos.clear();
		educaciones.clear();
		sexos.clear();
		ingresos.clear();
		permanencia.clear();
		estatus.clear();
		paisesPaso.clear();
		panelesPaises.clear();
		panelesPersonas.clear();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(new BorderLayout(0, 0));

		JLabel imagenCaritas = new JLabel("");
		imagenCaritas.setIcon(new ImageIcon(Registro.class.getResource("/imagenes_help/caritas-bolivia.png")));
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
				
				PerfilFuncionario pf = new PerfilFuncionario(Main.getFun(), Main.getFun().isAdmin());
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
		JPanel panelFormulario = new JPanel();
		contentPane.add(panelFormulario, BorderLayout.CENTER);
		panelFormulario.setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("FORMULARIO DE REGISTRO");
		lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormulario.add(lblTitulo, BorderLayout.NORTH);

		JPanel panelLlenado = new JPanel();
		panelFormulario.add(panelLlenado, BorderLayout.CENTER);
		panelLlenado.setLayout(new BorderLayout(0, 0));

		JPanel panelDatosIniciales = new JPanel();
		panelLlenado.add(panelDatosIniciales, BorderLayout.NORTH);
		panelDatosIniciales.setLayout(null);
		panelDatosIniciales.setPreferredSize(new Dimension(1920, 130));

		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setBounds(48, 37, 46, 14);
		panelDatosIniciales.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(104, 34, 86, 20);
		panelDatosIniciales.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblLugar = new JLabel("LUGAR:");
		lblLugar.setBounds(48, 68, 46, 14);
		panelDatosIniciales.add(lblLugar);

		JComboBox comboBoxLugares = new JComboBox();
		comboBoxLugares.setModel(new DefaultComboBoxModel(new String[] { "Lugar 1", "Lugar 2" })); // se deberia sacar
																									// de la base de
																									// datos?, si si
																									// deberia haber una
																									// forma de añadir
																									// eso? nah, van a
																									// haber una
																									// cantidad finita
																									// de lugares
																									// supongo
		comboBoxLugares.setBounds(104, 64, 86, 22);
		panelDatosIniciales.add(comboBoxLugares);

		JCheckBox chckbxTransito = new JCheckBox("TRÁNSITO");
		chckbxTransito.setBounds(292, 20, 97, 23);
		panelDatosIniciales.add(chckbxTransito);

		JCheckBox chckbxSolRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
		chckbxSolRefugio.setBounds(292, 45, 228, 23);
		panelDatosIniciales.add(chckbxSolRefugio);

		JCheckBox chckbxSolAsistencia = new JCheckBox("SOLICITUD DE OTRO TIPO DE ASISTENCIA");
		chckbxSolAsistencia.setBounds(292, 70, 289, 23);
		panelDatosIniciales.add(chckbxSolAsistencia);

		JLabel lblTelefono = new JLabel("TELÉFONO:");
		lblTelefono.setBounds(292, 100, 115, 14);
		panelDatosIniciales.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(360, 97, 97, 20);
		panelDatosIniciales.add(txtTelefono);
		txtTelefono.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 1894, 13);
		panelDatosIniciales.add(separator_1);

		JPanel panelIdentificación = new JPanel();
		panelLlenado.add(panelIdentificación, BorderLayout.CENTER);
		panelIdentificación.setLayout(new BorderLayout(0, 0));

		JPanel panelCantidadPersonas = new JPanel();
		panelCantidadPersonas.setBackground(SystemColor.control);
		FlowLayout flowLayout = (FlowLayout) panelCantidadPersonas.getLayout();
		panelIdentificación.add(panelCantidadPersonas, BorderLayout.NORTH);

		JLabel lblCantidadPersonas = new JLabel("CANTIDAD DE PERSONAS:");
		panelCantidadPersonas.add(lblCantidadPersonas);

		contadorPersonas = 0;
		JLabel lblCantidadContador = new JLabel("0");// contador automatico de la cantidad de personas que estan siendo
														// registradas
		panelCantidadPersonas.add(lblCantidadContador);

		panelDatosPersonas = new JPanel();
		panelDatosPersonas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JScrollPane scrollPanePersonas = new JScrollPane(panelDatosPersonas);
		panelIdentificación.add(scrollPanePersonas, BorderLayout.CENTER);
		panelDatosPersonas.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panelAgregarPersona = new JPanel();
		panelDatosPersonas.add(panelAgregarPersona);
		panelAgregarPersona.setPreferredSize(new Dimension(850, 25));
		panelAgregarPersona.setLayout(null);

		JLabel lblIdentificacion = new JLabel("IDENTIFICACIÓN");
		lblIdentificacion.setBounds(394, 8, 100, 16);
		lblIdentificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
		panelAgregarPersona.add(lblIdentificacion);

		JButton btnAgregarPersona = new JButton("+AÑADIR PERSONA");
		btnAgregarPersona.setBounds(681, 6, 183, 23);
		panelAgregarPersona.add(btnAgregarPersona);

		JButton btnQuitarPersona = new JButton("-Quitar PERSONA");
		btnQuitarPersona.setBounds(500, 6, 183, 23);
		panelAgregarPersona.add(btnQuitarPersona);

		JPanel panelOrigenDestino = new JPanel();
		panelLlenado.add(panelOrigenDestino, BorderLayout.WEST);
		panelOrigenDestino.setPreferredSize(new Dimension(500, 400));
		panelOrigenDestino.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelOrigen = new JPanel();
		panelOrigenDestino.add(panelOrigen);
		panelOrigen.setLayout(new BorderLayout(0, 0));

		JLabel lblOrigen = new JLabel("ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelOrigen.add(lblOrigen, BorderLayout.NORTH);

		JPanel panelInfoOrigen = new JPanel();
		panelOrigen.add(panelInfoOrigen, BorderLayout.CENTER);
		panelInfoOrigen.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelInfoO = new JPanel();
		panelInfoOrigen.add(panelInfoO);
		panelInfoO.setLayout(null);

		JLabel lblPaisOrigen = new JLabel("PAÍS DE ORIGEN:");
		lblPaisOrigen.setBounds(28, 11, 112, 14);
		panelInfoO.add(lblPaisOrigen);

		JComboBox comboBoxPaisesOrigen = new JComboBox();
		comboBoxPaisesOrigen.setBounds(136, 7, 102, 22);
		comboBoxPaisesOrigen.addItem("Pais 1");
		comboBoxPaisesOrigen.setSelectedItem(0);
		panelInfoO.add(comboBoxPaisesOrigen);

		JLabel lblFechaSalida = new JLabel("FECHA SALIDA:");
		lblFechaSalida.setBounds(268, 11, 102, 14);
		panelInfoO.add(lblFechaSalida);

		txtFechaSalida = new JTextField();
		txtFechaSalida.setBounds(383, 8, 86, 20);
		panelInfoO.add(txtFechaSalida);
		txtFechaSalida.setColumns(10);

		JLabel lblTransporte = new JLabel("TRANSPORTE:");
		lblTransporte.setBounds(28, 40, 94, 14);
		panelInfoO.add(lblTransporte);

		JRadioButton rdbtnTransporteTerrestre = new JRadioButton("TERRESTRE");
		rdbtnTransporteTerrestre.setActionCommand("TERRESTRE");
		rdbtnTransporteTerrestre.setBounds(136, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteTerrestre);
		rdbtnTransporteTerrestre.setSelected(true);
		JRadioButton rdbtnTransporteAereo = new JRadioButton("AÉREO");
		rdbtnTransporteAereo.setActionCommand("AÉREO");
		rdbtnTransporteAereo.setBounds(261, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteAereo);

		ButtonGroup buttonGroupTransporte = new ButtonGroup();
		buttonGroupTransporte.add(rdbtnTransporteTerrestre);
		buttonGroupTransporte.add(rdbtnTransporteAereo);

		JLabel lblRazones = new JLabel("RAZONES POR LAS QUE SALIÓ DE SU PAÍS DE ORIGEN:");
		lblRazones.setBounds(28, 65, 269, 14);
		panelInfoO.add(lblRazones);

		JTextArea txtRazones = new JTextArea();
		JScrollPane scrollRazones = new JScrollPane(txtRazones);
		scrollRazones.setBounds(19, 90, 450, 40);
		panelInfoO.add(scrollRazones);

		JPanel panelEstatusMigra = new JPanel();

		JScrollPane scrollEstatusMigra = new JScrollPane(panelEstatusMigra);
		panelInfoOrigen.add(scrollEstatusMigra);
		panelEstatusMigra.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelAnadirEstatus = new JPanel();
		panelAnadirEstatus.setLayout(null);
		panelAnadirEstatus.setPreferredSize(new Dimension(450, 25));
		panelEstatusMigra.add(panelAnadirEstatus);

		JButton btnAnadirEstatus = new JButton("+ AÑADIR ESTATUS MIGRATORIO");

		btnAnadirEstatus.setBounds(176, 0, 251, 23);
		panelAnadirEstatus.add(btnAnadirEstatus);
		JButton btnQuitarEstatus = new JButton("- QUITAR ESTATUS MIGRATORIO");

		btnQuitarEstatus.setBounds(0, 0, 251, 23);
		panelAnadirEstatus.add(btnQuitarEstatus);

		JPanel panelDestino = new JPanel();
		panelOrigenDestino.add(panelDestino);
		panelDestino.setLayout(null);

		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestino.setBounds(220, 13, 104, 14);
		panelDestino.add(lblDestino);

		JLabel lblFechaIngreso = new JLabel("FECHA DE INGRESO:");
		lblFechaIngreso.setBounds(10, 36, 119, 14);
		panelDestino.add(lblFechaIngreso);

		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setBounds(122, 33, 86, 20);
		panelDestino.add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);

		JLabel lblFronterIngreso = new JLabel("FRONTERA DE INGRESO:");
		lblFronterIngreso.setBounds(220, 36, 155, 14);
		panelDestino.add(lblFronterIngreso);

		JComboBox comboBoxFronterasIngreso = new JComboBox();
		comboBoxFronterasIngreso.setBounds(385, 32, 93, 22);
		comboBoxFronterasIngreso.addItem("frontera 1");
		comboBoxFronterasIngreso.setSelectedIndex(0);
		panelDestino.add(comboBoxFronterasIngreso);

		JLabel lblDocumentoIngreso = new JLabel("DOCUMENTO DE INGRESO:");
		lblDocumentoIngreso.setBounds(10, 61, 153, 20);
		panelDestino.add(lblDocumentoIngreso);

		JComboBox comboBoxDocumentosIngreso = new JComboBox();
		comboBoxDocumentosIngreso
				.setModel(new DefaultComboBoxModel(new String[] { "Cédula", "Pasaporte", "Tarjeta Andina" }));
		comboBoxDocumentosIngreso.setBounds(183, 60, 131, 22);
		panelDestino.add(comboBoxDocumentosIngreso);

		JLabel lblPermanenciaMigracion = new JLabel("DIAS DE PERMANENCIA MIGRACIÓN:");
		lblPermanenciaMigracion.setBounds(10, 92, 182, 14);
		panelDestino.add(lblPermanenciaMigracion);

		JRadioButton rdbtn30dias = new JRadioButton("30");
		rdbtn30dias.setActionCommand("30");
		rdbtn30dias.setBounds(208, 89, 52, 23);
		panelDestino.add(rdbtn30dias);

		JRadioButton rdbtn60dias = new JRadioButton("60");
		rdbtn60dias.setActionCommand("60");
		rdbtn60dias.setBounds(262, 89, 52, 23);
		panelDestino.add(rdbtn60dias);

		JRadioButton rdbtn90dias = new JRadioButton("90");
		rdbtn90dias.setActionCommand("90");
		rdbtn90dias.setBounds(316, 88, 52, 23);
		panelDestino.add(rdbtn90dias);
		rdbtn30dias.setSelected(true);
		ButtonGroup buttonGroupPermanenciaMigracion = new ButtonGroup();
		buttonGroupPermanenciaMigracion.add(rdbtn30dias);
		buttonGroupPermanenciaMigracion.add(rdbtn60dias);
		buttonGroupPermanenciaMigracion.add(rdbtn90dias);

		JLabel lblBoliviaDestinoFinal = new JLabel("SU DESTINO FINAL ES BOLIVIA?:");
		lblBoliviaDestinoFinal.setBounds(10, 117, 182, 14);
		panelDestino.add(lblBoliviaDestinoFinal);

		JRadioButton rdbtnSiBolivia = new JRadioButton("SI");
		rdbtnSiBolivia.setActionCommand("SI");
		rdbtnSiBolivia.setBounds(208, 113, 52, 23);
		panelDestino.add(rdbtnSiBolivia);

		JRadioButton rdbtnNoBolivia = new JRadioButton("NO");
		rdbtnNoBolivia.setActionCommand("NO");
		rdbtnNoBolivia.setSelected(true);
		rdbtnNoBolivia.setBounds(262, 115, 52, 23);
		panelDestino.add(rdbtnNoBolivia);

		ButtonGroup buttonGroupBoliviaFinal = new ButtonGroup();
		buttonGroupBoliviaFinal.add(rdbtnSiBolivia);
		buttonGroupBoliviaFinal.add(rdbtnNoBolivia);

		JLabel lblPaisSiguiente = new JLabel("A QUÉ PAÍS PIENSA SEGUIR?:");
		lblPaisSiguiente.setBounds(10, 148, 204, 14);
		lblPaisSiguiente.setVisible(true);
		panelDestino.add(lblPaisSiguiente);

		JComboBox comboBoxPaisesSiguientes = new JComboBox();
		comboBoxPaisesSiguientes.setBounds(183, 142, 131, 22);
		comboBoxPaisesSiguientes.addItem("pais 1");
		comboBoxPaisesSiguientes.setSelectedIndex(0);
		comboBoxPaisesSiguientes.setVisible(true);
		panelDestino.add(comboBoxPaisesSiguientes);

		JLabel lblPqBolivia = new JLabel("POR QUÉ ESOCOGIO BOLIVIA COMO DESTINO FINAL?:");
		lblPqBolivia.setBounds(10, 176, 370, 14);
		lblPqBolivia.setVisible(false);
		panelDestino.add(lblPqBolivia);

		JTextArea txtPqBolivia = new JTextArea();
		JScrollPane scrollPqBolivia = new JScrollPane(txtPqBolivia);
		scrollPanePersonas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanePersonas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPqBolivia.setBounds(20, 194, 450, 71);
		scrollPqBolivia.setVisible(false);
		panelDestino.add(scrollPqBolivia);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 0, 500, 2);
		panelDestino.add(separator_4);

		rdbtnSiBolivia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPaisSiguiente.setVisible(false);
				comboBoxPaisesSiguientes.setVisible(false);
				lblPqBolivia.setVisible(true);
				scrollPqBolivia.setVisible(true);
			}
		});

		rdbtnNoBolivia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPaisSiguiente.setVisible(true);
				comboBoxPaisesSiguientes.setVisible(true);
				lblPqBolivia.setVisible(false);
				scrollPqBolivia.setVisible(false);
			}
		});

		JPanel panelFormadeVida = new JPanel();
		panelLlenado.add(panelFormadeVida, BorderLayout.EAST);

		panelFormadeVida.setPreferredSize(new Dimension(500, 400));
		panelFormadeVida.setLayout(null);

		JLabel lblFormaVida = new JLabel("FORMA DE VIDA");
		lblFormaVida.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormaVida.setBounds(10, 34, 133, 14);
		panelFormadeVida.add(lblFormaVida);

		JLabel lblAlojamiento = new JLabel("DÓNDE SE ALOJA?:");
		lblAlojamiento.setBounds(10, 84, 111, 14);
		panelFormadeVida.add(lblAlojamiento);

		JComboBox comboBoxAlojamiento = new JComboBox();
		comboBoxAlojamiento.setModel(new DefaultComboBoxModel(
				new String[] { "Alquiler", "Acogido", "Alojamiento", "Situación de calle", "Otro " }));
		comboBoxAlojamiento.setBounds(136, 80, 111, 22);
		panelFormadeVida.add(comboBoxAlojamiento);

		JLabel lblSustento = new JLabel("CUÁL ES SU MEDIO DE SUSTENTO?:");
		lblSustento.setBounds(10, 141, 214, 14);
		panelFormadeVida.add(lblSustento);

		JRadioButton rdbtnSustentoInformal = new JRadioButton("INFORMAL");
		rdbtnSustentoInformal.setActionCommand("INFORMAL");
		rdbtnSustentoInformal.setBounds(219, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoInformal);

		JRadioButton rdbtnSustentoFormal = new JRadioButton("FORMAL");
		rdbtnSustentoFormal.setActionCommand("FORMAL");
		rdbtnSustentoFormal.setBounds(331, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoFormal);
		rdbtnSustentoFormal.setSelected(true);
		ButtonGroup buttonGroupSustento = new ButtonGroup();
		buttonGroupSustento.add(rdbtnSustentoInformal);
		buttonGroupSustento.add(rdbtnSustentoFormal);

		JLabel lblEnviaDinero = new JLabel("ENVIA DINERO A SU FAMILIA?:");
		lblEnviaDinero.setBounds(10, 197, 174, 14);
		panelFormadeVida.add(lblEnviaDinero);

		JRadioButton rdbtnSiEnvia = new JRadioButton("SI");
		rdbtnSiEnvia.setActionCommand("SI");
		rdbtnSiEnvia.setBounds(219, 193, 57, 23);
		panelFormadeVida.add(rdbtnSiEnvia);
		rdbtnSiEnvia.setSelected(true);
		JRadioButton rdbtnNoEnvia = new JRadioButton("NO");
		rdbtnNoEnvia.setActionCommand("NO");
		rdbtnNoEnvia.setBounds(331, 193, 109, 23);
		panelFormadeVida.add(rdbtnNoEnvia);
		rdbtnNoEnvia.setSelected(true);
		ButtonGroup buttonGroupEnviaDinero = new ButtonGroup();
		buttonGroupEnviaDinero.add(rdbtnSiEnvia);
		buttonGroupEnviaDinero.add(rdbtnNoEnvia);

		JLabel lblLeEnvianDinero = new JLabel("SU FAMILIA LE ENVIA DINERO?:");
		lblLeEnvianDinero.setBounds(10, 253, 184, 14);
		panelFormadeVida.add(lblLeEnvianDinero);

		JRadioButton rdbtnSiLeEnvian = new JRadioButton("SI");
		rdbtnSiLeEnvian.setActionCommand("SI");
		rdbtnSiLeEnvian.setBounds(219, 249, 57, 23);
		panelFormadeVida.add(rdbtnSiLeEnvian);

		JRadioButton rdbtnNoLeEnvian = new JRadioButton("NO");
		rdbtnNoLeEnvian.setActionCommand("NO");
		rdbtnNoLeEnvian.setSelected(true);
		rdbtnNoLeEnvian.setBounds(331, 249, 109, 23);
		panelFormadeVida.add(rdbtnNoLeEnvian);

		ButtonGroup buttonGroupLeEnvianDinero = new ButtonGroup();
		buttonGroupLeEnvianDinero.add(rdbtnSiLeEnvian);
		buttonGroupLeEnvianDinero.add(rdbtnNoLeEnvian);

		JLabel lblMedioEnvio = new JLabel("POR QUÉ MEDIO?:");
		txtMedioEnvio = new JTextField();
		lblMedioEnvio.setVisible(false);
		txtMedioEnvio.setVisible(false);
		lblMedioEnvio.setBounds(10, 305, 111, 14);
		panelFormadeVida.add(lblMedioEnvio);
		txtMedioEnvio.setBounds(242, 302, 124, 20);
		panelFormadeVida.add(txtMedioEnvio);
		txtMedioEnvio.setColumns(10);

		rdbtnSiLeEnvian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMedioEnvio.setVisible(true);
				txtMedioEnvio.setVisible(true);
			}
		});

		rdbtnNoLeEnvian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMedioEnvio.setVisible(false);
				txtMedioEnvio.setVisible(false);
			}
		});

		JLabel lblComunicacion = new JLabel("COMO SE COMUNICA CON SU FAMILIA?:");
		lblComunicacion.setBounds(10, 361, 222, 14);
		panelFormadeVida.add(lblComunicacion);

		txtComunicacion = new JTextField();
		txtComunicacion.setBounds(242, 358, 124, 20);
		panelFormadeVida.add(txtComunicacion);
		txtComunicacion.setColumns(10);

		JLabel lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObservaciones.setBounds(10, 445, 161, 14);
		panelFormadeVida.add(lblObservaciones);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 416, 500, 2);
		panelFormadeVida.add(separator_3);

		JTextArea txtObservaciones = new JTextArea();
		JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones);
		scrollObservaciones.setBounds(20, 472, 450, 71);
		panelFormadeVida.add(scrollObservaciones);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(0, 585, 500, 2);
		panelFormadeVida.add(separator_3_1);

		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				masPersona(lblCantidadContador);

			}
		});
		btnQuitarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menosPersona(lblCantidadContador);

			}
		});
		btnAnadirEstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masEstatusMigratorio(panelEstatusMigra);
			}
		});
		btnQuitarEstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menosEstatusMigratorio(panelEstatusMigra);
			}
		});
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean band = true;
				FormlarioRegistro form = null;
				if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
					if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
							&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
							&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")
							&& alMenosUnCheckBoxSeleccionado(chckbxTransito, chckbxSolRefugio, chckbxSolAsistencia)) {
						if (validarFecha(txtFechaSalida.getText()) && validarFecha(txtFechaIngreso.getText())
								&& validarFecha(txtExpedido.getText()) && validarFecha(txtFecha.getText())) {
							ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
							Beneficiarios aux = null;
							ArrayList<PaisVisita> paises = new ArrayList<>();
							PaisVisita auxPais = null;
							int uB = 0, uP = 0, uR = 0, uF = 0;
							try {
								uP = Conexion.ultimoPaisVisita();
								uB = Conexion.ultimoBeneficiario();
								uR = Conexion.ultimoFormularioRegistro();
								uF = Conexion.ultimaFamilia();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int i = 0; i < estatus.size(); i++) {
								if (!permanencia.get(i).getText().equals("") && !estatus.get(i).getText().equals("")) {

									auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
											Integer.parseInt(permanencia.get(i).getText()), estatus.get(i).getText(),
											true);
									paises.add(auxPais);
									uP++;

								}
							}
							System.out.println(auxPais.toString());
							for (int i = 0; i < nombres.size(); i++) {
								if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
										&& !docIdentidad.get(i).getText().equals("")
										&& !expedidos.get(i).getText().equals("")) {
									aux = new Beneficiarios(uB, nombres.get(i).getText(),
											Integer.parseInt(edades.get(i).getText()),
											sexos.get(i).getSelection().getActionCommand(),
											docIdentidad.get(i).getText(), Extras.fechas(expedidos.get(i).getText()),
											ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
											(String) educaciones.get(i).getSelectedItem(), paises, true);
									beneficiarios.add(aux);
									uB++;

									band = band && Conexion.isCIRegistrado(docIdentidad.get(i).getText());
								}

							}

							System.out.println(aux.toString());
							
								Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0),
										beneficiarios, true);
								form = new FormlarioRegistro(uR, (String) comboBoxLugares.getSelectedItem(),
										txtTelefono.getText(), (String) comboBoxPaisesOrigen.getSelectedItem(),
										Extras.fechas(txtFechaSalida.getText()),
										buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
										txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
										(String) comboBoxFronterasIngreso.getSelectedItem(),
										(String) comboBoxDocumentosIngreso.getSelectedItem(),
										buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
										buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
										(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
										(String) comboBoxAlojamiento.getSelectedItem(),
										buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
										buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
										buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
										txtMedioEnvio.getText(), txtComunicacion.getText(), txtObservaciones.getText(),
										chckbxTransito.isSelected(), chckbxSolRefugio.isSelected(),
										chckbxSolAsistencia.isSelected(), fam, true);
								// Main.setUltimoForm(form);
								System.out.println(form);
								// Conexion.registrarFormBD(form);
								isRegistro = true;

								band = true;
								JOptionPane.showMessageDialog(null, "Registro exitoso.");

							
						} else {
							JOptionPane.showMessageDialog(null, "Ingrese fechas en formato dd/MM/yyyy.");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe llenar todos losa datos del formulario para poder registrarlo");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
				}

				try {
					// Especifica la ruta donde quieres guardar el PDF
					String rutaPDF = "Archivos pdf registro/Registro_" + form.getCfr() + ".pdf";

					// Crea un documento PDF
					Document document = new Document();

					// Crea un escritor PDF
					try {
						PdfWriter.getInstance(document, new FileOutputStream(rutaPDF));
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Abre el documento para agregar contenido
					document.open();

					// Crea una fuente en negrita
					com.itextpdf.text.Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

					// Crea un párrafo centrado y en negrita
					Paragraph paragraph = new Paragraph("FORMULARIO DE REGISTRO", fontBold);
					paragraph.setAlignment(Element.ALIGN_CENTER);

					// Agrega el párrafo al documento
					document.add(paragraph);
					// line2
					paragraph = new Paragraph(
							"Fecha: " + form.getFechaRegistro() + "            Lugar: " + form.getLugar());
					paragraph.setSpacingAfter(0);
					document.add(paragraph);

					if (form.isTransito()) {
						Paragraph paragraph1 = new Paragraph("Transito");
						paragraph1.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph1);

					}

					// Agrega el párrafo al documento

					// line3

					if (form.isRefugio()) {
						paragraph = new Paragraph("Solicitud refugio ");
						paragraph.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph);

					}

					// Agrega el párrafo al documento
					// line4

					if (form.isAtencion()) {
						paragraph = new Paragraph("Solicitud de otro tipo de asistencia ");
						paragraph.setAlignment(Element.ALIGN_RIGHT);
						document.add(paragraph);

					}

					// Agrega el párrafo al documento
					// line5
					paragraph = new Paragraph("Telefono: " + form.getTelefono());
					paragraph.setAlignment(Element.ALIGN_RIGHT);

					// Agrega el párrafo al documento
					document.add(paragraph);
					// line6
					paragraph = new Paragraph("IDENTIFICACIÓN", fontBold);
					paragraph.setAlignment(Element.ALIGN_LEFT);

					// Agrega el párrafo al documento
					document.add(paragraph);

					for (Beneficiarios i : form.getFam().getFamilia()) {
						// linea 1 identificacion
						paragraph = new Paragraph("Nombre: " + i.getNombre() + "         Edad: " + i.getEdad());

						// Agrega el párrafo al documento
						document.add(paragraph);
						// linea 2 identicacion
						paragraph = new Paragraph("Número de Documento de identidad: " + i.getCi()
								+ "            Expedido en: " + i.getFechaExpedido() + "       Sexo: " + i.getSexo());

						// Agrega el párrafo al documento
						document.add(paragraph);
						// linea 3 identicacion
						paragraph = new Paragraph("Nivel educación: " + i.getEducacion() + "             Ingreso: ");
						if (i.isIngreso()) {
							paragraph.add("Irregular");
						} else {
							paragraph.add("Regular");

						}

						// Agrega el párrafo al documento
						document.add(paragraph);
					}

					// line8
					paragraph = new Paragraph("ORÍGEN", fontBold);
					paragraph.setAlignment(Element.ALIGN_LEFT);
					document.add(paragraph);

					// line9
					paragraph = new Paragraph(
							"Pais origen: " + form.getPaisOrigen() + "                   Fecha salida: "
									+ form.getFechaSalida() + "                     Transporte: ");
					if (form.isTransporte()) {
						paragraph.add("Tierra");
					} else {
						paragraph.add("Aéreo");

					}
					document.add(paragraph);
					for (PaisVisita i : form.getFam().getFamilia().get(0).getPais()) {
						// linea 1 pais
						paragraph = new Paragraph("Paises por los que paso: " + i.getPais()
								+ "            Tiempo permanencia: " + i.getTiempoDias()
								+ "            Estatus migratorio: " + i.getEstadoMigratorioString());

						// Agrega el párrafo al documento
						document.add(paragraph);
					}
					paragraph = new Paragraph("EXPLIQUE LAS RAZONES POR LAS QUE SALIÓ DE SU PAÍS DE ORIGEN: ");
					document.add(paragraph);
					paragraph = new Paragraph(form.getRazon());
					document.add(paragraph);

					// linea 10
					paragraph = new Paragraph("DESTINO", fontBold);
					document.add(paragraph);
					// linea 11
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					String horaFormateada = form.getHoraRegistro().format(formatter);
					paragraph = new Paragraph("Fecha de ingreso a Bolivia: " + form.getFechaIngreso()
							+ "                 Hora ingreso: " + horaFormateada
							+ "                    Frontera ingreso: " + form.getFronteraIngreso());
					document.add(paragraph);
					// linea 12
					paragraph = new Paragraph("Documento de ingreso: " + form.getDocumentoIngreso()
							+ "            Dias de permanencia: " + form.getDiasPermanencia());
					document.add(paragraph);
					// linea 13
					paragraph = new Paragraph("Bolivia es su destino final: ");
					if (form.isDestinoFinal()) {
						paragraph.add("si");
						paragraph.add("SI BOLIVA ES SU DESTINO FINAL, ¿POR QUÉ ESCOGIÓ ESTE PAÍS? \n");
						paragraph.add(form.getPorquePais());
					} else {
						paragraph.add("no");
						paragraph.add("A que pais seguira: " + form.getPaisSiguiente());
					}

					document.add(paragraph);
					// linea 14
					paragraph = new Paragraph("FORMA DE VIDA", fontBold);
					document.add(paragraph);
					// linea 15
					paragraph = new Paragraph(
							"Donde se aloja: " + form.getAlojamiento() + "                   Hora ingreso: ");
					if (form.getSustento()) {
						paragraph.add("Informal");
					} else {
						paragraph.add("formal");
					}
					document.add(paragraph);
					// linea 16
					paragraph = new Paragraph("Envia dinero a su familia: ");
					if (form.isEnviaDinero()) {
						paragraph.add("si");
					} else {
						paragraph.add("no");
					}
					document.add(paragraph);
					// linea 16
					paragraph = new Paragraph("Le envia dinero su familia ");
					if (form.isLeEnviaDienro()) {
						paragraph.add("si");
						paragraph.add("Medio envio: " + form.getMedioEvniaDinero());
					} else {
						paragraph.add("no");
					}
					document.add(paragraph);
					// linea 17
					paragraph = new Paragraph("Como se comunica con su familia: " + form.getComunicaFamilia());

					document.add(paragraph);

					paragraph = new Paragraph("OBSERVACIONES", fontBold);
					document.add(paragraph);

					paragraph = new Paragraph(form.getObs());
					document.add(paragraph);

					paragraph = new Paragraph("AUTORIZACIÓN Y COMPROMISO", fontBold);
					document.add(paragraph);
					paragraph = new Paragraph(
							"Yo declaro que todos los datos que se encuentran en el presente documento son verdaderos y autorizo a que la PMH de Cáritas Bolivia archive mis datos y los utilice para los fines que corresponda, cuidando mi privacidad, y en beneficio de mi persona.\r\n"
									+ "\r\n"
									+ "Asimismo me comprometo a observar un buen comportamiento dentro de las instalaciones de Caritas y en todos los lugares a los que ésta me derive.\n\n");
					document.add(paragraph);
					paragraph = new Paragraph("____________________________");
					paragraph.setAlignment(Element.ALIGN_CENTER);

					document.add(paragraph);

					// Cierra el documento
					document.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnImprimir.setBounds(723, 45, 141, 23);
		panelDatosIniciales.add(btnImprimir);
		JButton btnHojaRuta = new JButton("IR HOJA DE RUTA");
		btnHojaRuta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if (!isRegistro) {
					if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
						if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
								&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
								&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")) {
							ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
							Beneficiarios aux = null;
							ArrayList<PaisVisita> paises = new ArrayList<>();
							PaisVisita auxPais = null;
							int uB = 0, uP = 0, uR = 0, uF = 0;
							try {
								uP = Conexion.ultimoPaisVisita();
								uB = Conexion.ultimoBeneficiario();
								uR = Conexion.ultimoFormularioRegistro();
								uF = Conexion.ultimaFamilia();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int i = 0; i < estatus.size(); i++) {
								if (!permanencia.get(i).getText().equals("") && !estatus.get(i).getText().equals("")) {

									auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
											Integer.parseInt(permanencia.get(i).getText()), estatus.get(i).getText(),
											true);
									paises.add(auxPais);
									uP++;
								}

							}

							for (int i = 0; i < nombres.size(); i++) {
								if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
										&& !docIdentidad.get(i).getText().equals("")
										&& !expedidos.get(i).getText().equals("")) {
									aux = new Beneficiarios(uB, nombres.get(i).getText(),
											Integer.parseInt(edades.get(i).getText()),
											sexos.get(i).getSelection().getActionCommand(),
											docIdentidad.get(i).getText(), Extras.fechas(expedidos.get(i).getText()),
											ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
											(String) educaciones.get(i).getSelectedItem(), paises, true);
									beneficiarios.add(aux);
									uB++;
								}

							}

							System.out.println(aux.toString());
							Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0), beneficiarios,
									true);
							FormlarioRegistro form = new FormlarioRegistro(uR,
									(String) comboBoxLugares.getSelectedItem(), txtTelefono.getText(),
									(String) comboBoxPaisesOrigen.getSelectedItem(),
									Extras.fechas(txtFechaSalida.getText()),
									buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
									txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
									(String) comboBoxFronterasIngreso.getSelectedItem(),
									(String) comboBoxDocumentosIngreso.getSelectedItem(),
									buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
									buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
									(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
									(String) comboBoxAlojamiento.getSelectedItem(),
									buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
									buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
									buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
									txtMedioEnvio.getText(), txtComunicacion.getText(), txtObservaciones.getText(),
									chckbxTransito.isSelected(), chckbxSolRefugio.isSelected(),
									chckbxSolAsistencia.isSelected(), fam, true);
							form.setCfr(reg.getCfr());
							Main.setUltimoForm(form);
							System.out.println(form);
							try {
								Conexion.actualizarFormBD(form, reg);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Debe llenar todos losa datos del formulario para poder registrarlo");

						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
					}

				}
				Hoja_ruta dj = new Hoja_ruta(null,true);
				dj.setVisible(true);
				dispose();
			}
		});

		btnHojaRuta.setBounds(723, 70, 139, 23);
		panelDatosIniciales.add(btnHojaRuta);
		JButton btnRegistrar = new JButton("ACTUALIZAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean band = true;

				if (Integer.parseInt(lblCantidadContador.getText()) > 0) {
					if (!txtTelefono.getText().equals("") && !txtFechaSalida.getText().equals("")
							&& !txtRazones.getText().equals("") && !txtFechaIngreso.getText().equals("")
							&& !txtComunicacion.getText().equals("") && !txtObservaciones.getText().equals("")
							&& alMenosUnCheckBoxSeleccionado(chckbxTransito, chckbxSolRefugio, chckbxSolAsistencia)) {
						if (validarFecha(txtFechaSalida.getText()) && validarFecha(txtFechaIngreso.getText())
								&& validarFecha(txtExpedido.getText()) && validarFecha(txtFecha.getText())) {

							ArrayList<Beneficiarios> beneficiarios = new ArrayList<>();
							Beneficiarios aux = null;
							ArrayList<PaisVisita> paises = new ArrayList<>();
							PaisVisita auxPais = null;
							int uB = 0, uP = 0, uR = 0, uF = 0;
							try {
								uP = Conexion.ultimoPaisVisita();
								uB = Conexion.ultimoBeneficiario();
								uR = Conexion.ultimoFormularioRegistro();
								uF = Conexion.ultimaFamilia();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int i = 0; i < estatus.size(); i++) {
								if (!permanencia.get(i).getText().equals("") && !estatus.get(i).getText().equals("")) {

									auxPais = new PaisVisita(uP, (String) paisesPaso.get(i).getSelectedItem(),
											Integer.parseInt(permanencia.get(i).getText()), estatus.get(i).getText(),
											true);
									paises.add(auxPais);
									uP++;
								}

							}

							for (int i = 0; i < nombres.size(); i++) {
								if (!nombres.get(i).getText().equals("") && !edades.get(i).getText().equals("")
										&& !docIdentidad.get(i).getText().equals("")
										&& !expedidos.get(i).getText().equals("")) {
									aux = new Beneficiarios(uB, nombres.get(i).getText(),
											Integer.parseInt(edades.get(i).getText()),
											sexos.get(i).getSelection().getActionCommand(),
											docIdentidad.get(i).getText(), Extras.fechas(expedidos.get(i).getText()),
											ingresos.get(i).getSelection().getActionCommand() == "IRREGULAR",
											(String) educaciones.get(i).getSelectedItem(), paises, true);
									beneficiarios.add(aux);
									uB++;
									// band = band && Conexion.isCIRegistrado(docIdentidad.get(i).getText());

								}

							}

							System.out.println(aux.toString());
							if (band) {
								Familias fam = new Familias(uF, beneficiarios.size(), beneficiarios.get(0),
										beneficiarios, true);
								FormlarioRegistro form = new FormlarioRegistro(uR,
										(String) comboBoxLugares.getSelectedItem(), txtTelefono.getText(),
										(String) comboBoxPaisesOrigen.getSelectedItem(),
										Extras.fechas(txtFechaSalida.getText()),
										buttonGroupTransporte.getSelection().getActionCommand() == "TERRESTRE",
										txtRazones.getText(), Extras.fechas(txtFechaIngreso.getText()),
										(String) comboBoxFronterasIngreso.getSelectedItem(),
										(String) comboBoxDocumentosIngreso.getSelectedItem(),
										buttonGroupPermanenciaMigracion.getSelection().getActionCommand(),
										buttonGroupBoliviaFinal.getSelection().getActionCommand() == "SI",
										(String) comboBoxPaisesSiguientes.getSelectedItem(), txtPqBolivia.getText(),
										(String) comboBoxAlojamiento.getSelectedItem(),
										buttonGroupEnviaDinero.getSelection().getActionCommand() == "SI",
										buttonGroupSustento.getSelection().getActionCommand() == "FORMAL",
										buttonGroupLeEnvianDinero.getSelection().getActionCommand() == "SI",
										txtMedioEnvio.getText(), txtComunicacion.getText(), txtObservaciones.getText(),
										chckbxTransito.isSelected(), chckbxSolRefugio.isSelected(),
										chckbxSolAsistencia.isSelected(), fam, true);

								// Main.setUltimoForm(form);
								// System.out.println(form);

								try {
									Conexion.actualizarFormBD(form, reg);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								dispose();

								isRegistro = true;
								band = true;

								JOptionPane.showMessageDialog(null, "Registro exitoso.");
							} else {
								JOptionPane.showMessageDialog(null, "El documento de identidad ya fue registrado.");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Ingrese fechas en formato dd/MM/yyyy.");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Debe llenar todos losa datos del formulario para poder registrarlo");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe registrar minimimamente a un Beneficiario para poder registrar el formulario");
				}
			}
		});

		btnRegistrar.setBounds(723, 20, 139, 23);
		panelDatosIniciales.add(btnRegistrar);

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		txtFecha.setText(reg.getFechaRegistro().format(dateFormatter) + "");
		comboBoxLugares.setSelectedItem(reg.getLugar());
		txtTelefono.setText(reg.getTelefono());
		chckbxSolAsistencia.setSelected(reg.isAtencion());
		chckbxSolRefugio.setSelected(reg.isRefugio());
		chckbxTransito.setSelected(reg.isTransito());
		comboBoxPaisesOrigen.setSelectedItem(reg.getPaisOrigen());
		txtFechaSalida.setText(reg.getFechaSalida().format(dateFormatter) + "");
		rdbtnTransporteAereo.setSelected(!reg.isTransporte());
		rdbtnTransporteTerrestre.setSelected(reg.isTransporte());
		txtRazones.setText(reg.getRazon());
		txtFechaIngreso.setText(reg.getFechaIngreso().format(dateFormatter) + "");
		comboBoxFronterasIngreso.setSelectedItem(reg.getFronteraIngreso());
		comboBoxDocumentosIngreso.setSelectedItem(reg.getDocumentoIngreso());
		rdbtn30dias.setSelected(reg.getDiasPermanencia().equals("30"));
		rdbtn60dias.setSelected(reg.getDiasPermanencia().equals("60"));
		rdbtn90dias.setSelected(reg.getDiasPermanencia().equals("90"));
		rdbtnSiBolivia.setSelected(reg.isDestinoFinal());
		rdbtnNoBolivia.setSelected(reg.isDestinoFinal());

		txtPqBolivia.setText(reg.getPorquePais());
		comboBoxPaisesSiguientes.setSelectedItem(reg.getPaisSiguiente());
		comboBoxAlojamiento.setSelectedItem(reg.getAlojamiento());
		rdbtnSustentoFormal.setSelected(!reg.getSustento());
		rdbtnSustentoInformal.setSelected(reg.getSustento());
		rdbtnSiEnvia.setSelected(reg.isEnviaDinero());
		rdbtnNoEnvia.setSelected(!reg.isEnviaDinero());
		rdbtnSiLeEnvian.setSelected(reg.isLeEnviaDienro());
		rdbtnNoLeEnvian.setSelected(!reg.isLeEnviaDienro());
		txtMedioEnvio.setText(reg.getMedioEvniaDinero());
		txtComunicacion.setText(reg.getComunicaFamilia());
		txtObservaciones.setText(reg.getObs());
		for (PaisVisita i : reg.getFam().getFamilia().get(0).getPais()) {
			masEstatusMigratorio(panelEstatusMigra, i);

		}
		for (Beneficiarios i : reg.getFam().getFamilia()) {
			masPersona(lblCantidadContador, i);
		}

		// txtDocIdentidad.setEditable(false);

		// Hacer que la ventana se abra en pantalla completa
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	public void menosPersona(JLabel lblCantidadContador) {
		if (panelesPersonas.size() > 1) {
			panelDatosPersonas.remove(panelesPersonas.size() - 1);

			panelesPersonas.remove(panelesPersonas.size() - 1);

			nombres.remove(nombres.size() - 1);
			edades.remove(edades.size() - 1);
			docIdentidad.remove(docIdentidad.size() - 1);
			expedidos.remove(expedidos.size() - 1);
			educaciones.remove(educaciones.size() - 1);
			sexos.remove(sexos.size() - 1);

			ingresos.remove(ingresos.size() - 1);

			contadorPersonas -= 1;
			lblCantidadContador.setText(Integer.toString(contadorPersonas));

			panelDatosPersonas.revalidate();
			panelDatosPersonas.repaint();

		}

	}

	public void masPersona(JLabel lblCantidadContador) {

		JPanel panelPorPersona = new JPanel();
		panelPorPersona.setLayout(new FlowLayout());

		panelDatosPersonas.add(panelPorPersona);
		panelesPersonas.add(panelPorPersona);
		panelPorPersona.setPreferredSize(new Dimension(380, 100));

		JLabel lblNombre = new JLabel("NOMBRE:");
		panelPorPersona.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panelPorPersona.add(txtNombre);

		JLabel lblEdad = new JLabel("EDAD:");

		panelPorPersona.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setColumns(5);

		panelPorPersona.add(txtEdad);

		JLabel lblDocIdentidad = new JLabel("NÚMERO DE DOCUMENTO DE IDENTIDAD:");

		panelPorPersona.add(lblDocIdentidad);

		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		panelPorPersona.add(txtDocIdentidad);

		JLabel lblExpedido = new JLabel("EXPEDIDO EN:");
		panelPorPersona.add(lblExpedido);

		txtExpedido = new JTextField();
		txtExpedido.setColumns(10);
		panelPorPersona.add(txtExpedido);

		JLabel lblEducacion = new JLabel("NIVEL DE EDUCACION:");
		panelPorPersona.add(lblEducacion);

		JComboBox comboBoxEducacion = new JComboBox();
		comboBoxEducacion.setModel(new DefaultComboBoxModel(
				new String[] { "Primaria", "Secundaria", "Técnico Superior", "Universitario " }));

		panelPorPersona.add(comboBoxEducacion);

		JLabel lblSexo = new JLabel("SEXO:");
		panelPorPersona.add(lblSexo);

		JRadioButton rdbtnSexoFemenino = new JRadioButton("F");
		rdbtnSexoFemenino.setActionCommand("F");
		panelPorPersona.add(rdbtnSexoFemenino);
		rdbtnSexoFemenino.setSelected(true);
		JRadioButton rdbtnSexoMasculino = new JRadioButton("M");
		rdbtnSexoMasculino.setActionCommand("M");
		panelPorPersona.add(rdbtnSexoMasculino);

		JRadioButton rdbtnSexoOtro = new JRadioButton("OTRO");
		rdbtnSexoOtro.setActionCommand("OTRO");
		panelPorPersona.add(rdbtnSexoOtro);

		ButtonGroup buttonGroupSexo = new ButtonGroup();

		buttonGroupSexo.add(rdbtnSexoFemenino);
		buttonGroupSexo.add(rdbtnSexoMasculino);
		buttonGroupSexo.add(rdbtnSexoOtro);

		JLabel lblIngreso = new JLabel("INGRESO:");
		panelPorPersona.add(lblIngreso);

		JRadioButton rdbtnIngresoRegular = new JRadioButton("REGULAR");
		rdbtnIngresoRegular.setActionCommand("REGULAR");
		panelPorPersona.add(rdbtnIngresoRegular);

		JRadioButton rdbtnIngresoIrregular = new JRadioButton("IRREGULAR");
		rdbtnIngresoIrregular.setActionCommand("IRREGULAR");
		panelPorPersona.add(rdbtnIngresoIrregular);
		rdbtnIngresoRegular.setSelected(true);
		ButtonGroup buttonGroupIngreso = new ButtonGroup();
		buttonGroupIngreso.add(rdbtnIngresoRegular);
		buttonGroupIngreso.add(rdbtnIngresoIrregular);

		nombres.add(txtNombre);
		edades.add(txtEdad);
		docIdentidad.add(txtDocIdentidad);
		expedidos.add(txtExpedido);
		educaciones.add(comboBoxEducacion);

		sexos.add(buttonGroupSexo);

		ingresos.add(buttonGroupIngreso);
		JSeparator separator_2 = new JSeparator();
		panelPorPersona.add(separator_2);
		contadorPersonas += 1;
		lblCantidadContador.setText(Integer.toString(contadorPersonas));
		panelDatosPersonas.revalidate();
		panelDatosPersonas.repaint();

		txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});

	}

	public void masPersona(JLabel lblCantidadContador, Beneficiarios ben) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		JPanel panelPorPersona = new JPanel();
		panelPorPersona.setLayout(new FlowLayout());

		panelDatosPersonas.add(panelPorPersona);
		panelesPersonas.add(panelPorPersona);

		panelPorPersona.setPreferredSize(new Dimension(380, 100));

		JLabel lblNombre = new JLabel("NOMBRE:");
		panelPorPersona.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panelPorPersona.add(txtNombre);
		txtNombre.setText(ben.getNombre() + "");
		JLabel lblEdad = new JLabel("EDAD:");

		panelPorPersona.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setColumns(5);
		txtEdad.setText(ben.getEdad() + "");
		panelPorPersona.add(txtEdad);

		JLabel lblDocIdentidad = new JLabel("NÚMERO DE DOCUMENTO DE IDENTIDAD:");

		panelPorPersona.add(lblDocIdentidad);

		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		panelPorPersona.add(txtDocIdentidad);
		txtDocIdentidad.setText(ben.getCi());
		JLabel lblExpedido = new JLabel("EXPEDIDO EN:");
		panelPorPersona.add(lblExpedido);

		txtExpedido = new JTextField();
		txtExpedido.setColumns(10);
		panelPorPersona.add(txtExpedido);
		txtExpedido.setText(ben.getFechaExpedido().format(dateFormatter) + "");
		JLabel lblEducacion = new JLabel("NIVEL DE EDUCACION:");
		panelPorPersona.add(lblEducacion);

		JComboBox comboBoxEducacion = new JComboBox();
		comboBoxEducacion.setModel(new DefaultComboBoxModel(
				new String[] { "Primaria", "Secundaria", "Técnico Superior", "Universitario " }));
		comboBoxEducacion.setSelectedItem(ben.getEducacion());
		panelPorPersona.add(comboBoxEducacion);

		JLabel lblSexo = new JLabel("SEXO:");
		panelPorPersona.add(lblSexo);

		JRadioButton rdbtnSexoFemenino = new JRadioButton("F");
		rdbtnSexoFemenino.setActionCommand("F");
		panelPorPersona.add(rdbtnSexoFemenino);
		rdbtnSexoFemenino.setSelected(true);
		JRadioButton rdbtnSexoMasculino = new JRadioButton("M");
		rdbtnSexoMasculino.setActionCommand("M");
		panelPorPersona.add(rdbtnSexoMasculino);

		JRadioButton rdbtnSexoOtro = new JRadioButton("OTRO");
		rdbtnSexoOtro.setActionCommand("OTRO");
		panelPorPersona.add(rdbtnSexoOtro);

		ButtonGroup buttonGroupSexo = new ButtonGroup();

		buttonGroupSexo.add(rdbtnSexoFemenino);
		buttonGroupSexo.add(rdbtnSexoMasculino);
		buttonGroupSexo.add(rdbtnSexoOtro);

		rdbtnSexoFemenino.setSelected(ben.getSexo().equals("F"));
		rdbtnSexoMasculino.setSelected(ben.getSexo().equals("M"));
		rdbtnSexoOtro.setSelected(ben.getSexo().equals("OTRO"));

		JLabel lblIngreso = new JLabel("INGRESO:");
		panelPorPersona.add(lblIngreso);

		JRadioButton rdbtnIngresoRegular = new JRadioButton("REGULAR");
		rdbtnIngresoRegular.setActionCommand("REGULAR");
		panelPorPersona.add(rdbtnIngresoRegular);

		JRadioButton rdbtnIngresoIrregular = new JRadioButton("IRREGULAR");
		rdbtnIngresoIrregular.setActionCommand("IRREGULAR");
		panelPorPersona.add(rdbtnIngresoIrregular);
		rdbtnIngresoRegular.setSelected(true);
		ButtonGroup buttonGroupIngreso = new ButtonGroup();
		buttonGroupIngreso.add(rdbtnIngresoRegular);
		buttonGroupIngreso.add(rdbtnIngresoIrregular);
		rdbtnIngresoRegular.setSelected(ben.isIngreso());
		rdbtnIngresoIrregular.setSelected(!ben.isIngreso());

		nombres.add(txtNombre);
		edades.add(txtEdad);
		docIdentidad.add(txtDocIdentidad);
		expedidos.add(txtExpedido);
		educaciones.add(comboBoxEducacion);

		sexos.add(buttonGroupSexo);

		ingresos.add(buttonGroupIngreso);
		JSeparator separator_2 = new JSeparator();
		panelPorPersona.add(separator_2);
		contadorPersonas += 1;
		lblCantidadContador.setText(Integer.toString(contadorPersonas));
		panelDatosPersonas.revalidate();
		panelDatosPersonas.repaint();
		txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});

	}

	public void masEstatusMigratorio(JPanel panelEstatusMigra) {

		JPanel panelPorEstatus = new JPanel();

		panelEstatusMigra.add(panelPorEstatus);
		panelesPaises.add(panelPorEstatus);
		panelPorEstatus.setLayout(new FlowLayout());

		JLabel lblPaisPaso = new JLabel("PAÍS:");
		panelPorEstatus.add(lblPaisPaso);
		JComboBox comboBoxPaisesPaso = new JComboBox();
		comboBoxPaisesPaso.setModel(new DefaultComboBoxModel(new String[] { "pais 1" })); // paises
		panelPorEstatus.add(comboBoxPaisesPaso);
		paisesPaso.add(comboBoxPaisesPaso);
		JLabel lblPermanencia = new JLabel("PERMANENCIA:");
		panelPorEstatus.add(lblPermanencia);

		JTextField txtPermanencia = new JTextField();
		txtPermanencia.setText("");
		panelPorEstatus.add(txtPermanencia);
		txtPermanencia.setColumns(10);
		permanencia.add(txtPermanencia);
		JLabel lblEstatus = new JLabel("ESTATUS:");
		panelPorEstatus.add(lblEstatus);

		JTextField txtEstatus = new JTextField();
		panelPorEstatus.add(txtEstatus);
		txtEstatus.setColumns(10);
		estatus.add(txtEstatus);

		panelEstatusMigra.revalidate();
		panelEstatusMigra.repaint();
		txtPermanencia.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});
	}

	public void menosEstatusMigratorio(JPanel panelEstatusMigra) {
		if (panelesPaises.size() > 1) {

			panelEstatusMigra.remove(panelesPaises.size() - 1);
			panelesPaises.remove(panelesPaises.size() - 1);
			paisesPaso.remove(paisesPaso.size() - 1);
			permanencia.remove(permanencia.size() - 1);
			estatus.remove(estatus.size() - 1);

			panelEstatusMigra.revalidate();
			panelEstatusMigra.repaint();
		}

	}

	public void masEstatusMigratorio(JPanel panelEstatusMigra, PaisVisita pv) {
		JPanel panelPorEstatus = new JPanel();

		panelEstatusMigra.add(panelPorEstatus);
		panelPorEstatus.setLayout(new FlowLayout());
		panelesPaises.add(panelPorEstatus);

		JLabel lblPaisPaso = new JLabel("PAÍS:");
		panelPorEstatus.add(lblPaisPaso);
		JComboBox comboBoxPaisesPaso = new JComboBox();
		comboBoxPaisesPaso.setModel(new DefaultComboBoxModel(new String[] { "pais 1" })); // paises
		panelPorEstatus.add(comboBoxPaisesPaso);
		paisesPaso.add(comboBoxPaisesPaso);
		JLabel lblPermanencia = new JLabel("PERMANENCIA:");
		panelPorEstatus.add(lblPermanencia);

		JTextField txtPermanencia = new JTextField();
		txtPermanencia.setText("");
		panelPorEstatus.add(txtPermanencia);
		txtPermanencia.setColumns(10);
		permanencia.add(txtPermanencia);
		JLabel lblEstatus = new JLabel("ESTATUS:");
		panelPorEstatus.add(lblEstatus);

		JTextField txtEstatus = new JTextField();
		panelPorEstatus.add(txtEstatus);
		txtEstatus.setColumns(10);
		estatus.add(txtEstatus);
		panelEstatusMigra.revalidate();
		panelEstatusMigra.repaint();
		comboBoxPaisesPaso.setSelectedItem(pv.getPais());
		txtPermanencia.setText(pv.getTiempoDias() + "");
		txtEstatus.setText(pv.getEstadoMigratorioString());
		txtPermanencia.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});

	}

}