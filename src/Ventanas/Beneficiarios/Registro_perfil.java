package Ventanas.Beneficiarios;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import java.awt.event.*;

public class Registro_perfil extends JFrame {

	private JPanel contentPane;
    private JTextField txtFecha;
    private JTextField txtTelefono;
    private JPanel panelDatosPersonas; 
    private JTextField txtNombre;
    private JTextField txtDocIdentidad;
    private JTextField txtExpedido;
    private JTextField txtMedioEnvio;
    private JTextField txtComunicacion;
    private JTextField txtFechaIngreso;
    private JTextField txtFechaSalida;
    private int contadorPersonas ;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_perfil frame = new Registro_perfil();
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
	public Registro_perfil() {
		//Todos los campos tiene la edicion desabilitada en cambio los valores son sacados de la BD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(new BorderLayout(0, 0));
		
		JLabel imagenCaritas = new JLabel("");
		imagenCaritas.setIcon(new ImageIcon(Registro_perfil.class.getResource("/imagenes_help/caritas-bolivia.png")));
		panelCabecera.add(imagenCaritas, BorderLayout.WEST);
		
		JPanel panelBotonesCabecera = new JPanel();
		panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
		panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAtras = new JButton("< Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilBeneficiario frame = new PerfilBeneficiario();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		panelBotonesCabecera.add(btnAtras);
		
	

		JButton btnPerfil = new JButton("");
		ImageIcon iconOriginal = new ImageIcon(Registro_perfil.class.getResource("/imagenes_help/perfilpersona.png"));
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
		txtFecha.setEditable(false);
		txtFecha.setBounds(104, 34, 86, 20);
		panelDatosIniciales.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblLugar = new JLabel("LUGAR:");
		lblLugar.setBounds(48, 68, 46, 14);
		panelDatosIniciales.add(lblLugar);
		
		JComboBox comboBoxLugares = new JComboBox();
		comboBoxLugares.setEnabled(false);
		comboBoxLugares.setModel(new DefaultComboBoxModel(new String[] {"Lugar 1", "Lugar 2"})); // se deberia sacar de la base de datos?, si si deberia haber una forma de añadir eso?
		comboBoxLugares.setBounds(104, 64, 86, 22);
		panelDatosIniciales.add(comboBoxLugares);
		
		JCheckBox chckbxTransito = new JCheckBox("TRÁNSITO");
		chckbxTransito.setEnabled(false);
		chckbxTransito.setBounds(292, 20, 97, 23);
		panelDatosIniciales.add(chckbxTransito);
		
		JCheckBox chckbxSolRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
		chckbxSolRefugio.setEnabled(false);
		chckbxSolRefugio.setBounds(292, 45, 228, 23);
		panelDatosIniciales.add(chckbxSolRefugio);
		
		JCheckBox chckbxSolAsistencia = new JCheckBox("SOLICITUD DE OTRO TIPO DE ASISTENCIA");
		chckbxSolAsistencia.setEnabled(false);
		chckbxSolAsistencia.setBounds(292, 70, 289, 23);
		panelDatosIniciales.add(chckbxSolAsistencia);
		
		JLabel lblTelefono = new JLabel("TELÉFONO:");
		lblTelefono.setBounds(292, 100, 115, 14);
		panelDatosIniciales.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(360, 97, 97, 20);
		panelDatosIniciales.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 1894, 13);
		panelDatosIniciales.add(separator_1);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//los cambios que si pueden editar deberian volverse editables aca
				
				
				
			}
		});
		btnEditar.setBounds(1723, 20, 139, 23);
		panelDatosIniciales.add(btnEditar);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBounds(1723, 45, 141, 23);
		panelDatosIniciales.add(btnImprimir);
		
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
		JLabel lblCantidadContador = new JLabel("0");//contador automatico de la cantidad de personas que estan siendo registradas
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
		comboBoxPaisesOrigen.setEnabled(false);
		comboBoxPaisesOrigen.setBounds(136, 7, 102, 22);
		panelInfoO.add(comboBoxPaisesOrigen);
		
		JLabel lblFechaSalida = new JLabel("FECHA SALIDA:");
		lblFechaSalida.setBounds(268, 11, 102, 14);
		panelInfoO.add(lblFechaSalida);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setBounds(383, 8, 86, 20);
		panelInfoO.add(txtFechaSalida);
		txtFechaSalida.setColumns(10);
		
		JLabel lblTransporte = new JLabel("TRANSPORTE:");
		lblTransporte.setBounds(28, 40, 94, 14);
		panelInfoO.add(lblTransporte);
		
		JRadioButton rdbtnTransporteTerrestre = new JRadioButton("TERRESTRE");
		rdbtnTransporteTerrestre.setEnabled(false);
		rdbtnTransporteTerrestre.setBounds(136, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteTerrestre);
		
		JRadioButton rdbtnTransporteAereo = new JRadioButton("AÉREO");
		rdbtnTransporteAereo.setBounds(261, 36, 109, 23);
		panelInfoO.add(rdbtnTransporteAereo);
		
		ButtonGroup buttonGroupTransporte = new ButtonGroup();
	    buttonGroupTransporte.add(rdbtnTransporteTerrestre);
	    buttonGroupTransporte.add(rdbtnTransporteAereo);
		
		JLabel lblRazones = new JLabel("RAZONES POR LAS QUE SALIÓ DE SU PAÍS DE ORIGEN:");
		lblRazones.setBounds(28, 65, 269, 14);
		panelInfoO.add(lblRazones);
		
		JTextArea txtRazones = new JTextArea();
		txtRazones.setEditable(false);
	    JScrollPane scrollRazones = new JScrollPane(txtRazones); 
	    scrollRazones.setBounds(19, 90, 450, 40);
	    panelInfoO.add(scrollRazones);
	    
	    
	    
		JPanel panelEstatusMigra = new JPanel();
		
		JScrollPane scrollEstatusMigra  = new JScrollPane(panelEstatusMigra); 
		panelInfoOrigen.add(scrollEstatusMigra);
		panelEstatusMigra.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JPanel panelAnadirEstatus = new JPanel();
		panelAnadirEstatus.setLayout(null);
		panelAnadirEstatus.setPreferredSize(new Dimension(450, 25));
		panelEstatusMigra.add(panelAnadirEstatus);
		
		
		
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
		txtFechaIngreso.setEditable(false);
		txtFechaIngreso.setBounds(122, 33, 86, 20);
		panelDestino.add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);
		
		JLabel lblFronterIngreso = new JLabel("FRONTERA DE INGRESO:");
		lblFronterIngreso.setBounds(220, 36, 155, 14);
		panelDestino.add(lblFronterIngreso);
		
		JComboBox comboBoxFronterasIngreso = new JComboBox();
		comboBoxFronterasIngreso.setEnabled(false);
		comboBoxFronterasIngreso.setBounds(385, 32, 93, 22);
		panelDestino.add(comboBoxFronterasIngreso);
		
		JLabel lblDocumentoIngreso = new JLabel("DOCUMENTO DE INGRESO:");
		lblDocumentoIngreso.setBounds(10, 61, 153, 20);
		panelDestino.add(lblDocumentoIngreso);
		
		JComboBox comboBoxDocumentosIngreso = new JComboBox();
		comboBoxDocumentosIngreso.setEnabled(false);
		comboBoxDocumentosIngreso.setModel(new DefaultComboBoxModel(new String[] {"Cédula", "Pasaporte", "Tarjeta Andina"}));
		comboBoxDocumentosIngreso.setBounds(183, 60, 131, 22);
		panelDestino.add(comboBoxDocumentosIngreso);
		
		JLabel lblPermanenciaMigracion = new JLabel("DIAS DE PERMANENCIA MIGRACIÓN:");
		lblPermanenciaMigracion.setBounds(10, 92, 182, 14);
		panelDestino.add(lblPermanenciaMigracion);
		
		JRadioButton rdbtn30dias = new JRadioButton("30");
		rdbtn30dias.setEnabled(false);
		rdbtn30dias.setBounds(208, 89, 52, 23);
		panelDestino.add(rdbtn30dias);
		
		JRadioButton rdbtn60dias = new JRadioButton("60");
		rdbtn60dias.setEnabled(false);
		rdbtn60dias.setBounds(262, 89, 52, 23);
		panelDestino.add(rdbtn60dias);
		
		JRadioButton rdbtn90dias = new JRadioButton("90");
		rdbtn90dias.setEnabled(false);
		rdbtn90dias.setBounds(316, 88, 52, 23);
		panelDestino.add(rdbtn90dias);
		
		ButtonGroup buttonGroupPermanenciaMigracion = new ButtonGroup();
	    buttonGroupPermanenciaMigracion.add(rdbtn30dias);
	    buttonGroupPermanenciaMigracion.add(rdbtn60dias);
	    buttonGroupPermanenciaMigracion.add(rdbtn90dias);

		
		JLabel lblBoliviaDestinoFinal = new JLabel("SU DESTINO FINAL ES BOLIVIA?:");
		lblBoliviaDestinoFinal.setBounds(10, 117, 182, 14);
		panelDestino.add(lblBoliviaDestinoFinal);
		
		JRadioButton rdbtnSiBolivia = new JRadioButton("SI");
		rdbtnSiBolivia.setEnabled(false);
		
		rdbtnSiBolivia.setBounds(208, 113, 52, 23);
		panelDestino.add(rdbtnSiBolivia);
		
		JRadioButton rdbtnNoBolivia = new JRadioButton("NO");
		rdbtnNoBolivia.setEnabled(false);
		
		rdbtnNoBolivia.setBounds(262, 115, 52, 23);
		panelDestino.add(rdbtnNoBolivia);
		
		ButtonGroup buttonGroupBoliviaFinal = new ButtonGroup();
	    buttonGroupBoliviaFinal.add(rdbtnSiBolivia);
	    buttonGroupBoliviaFinal.add(rdbtnNoBolivia);
		
		JLabel lblPaisSiguiente = new JLabel("A QUÉ PAÍS PIENSA SEGUIR?:");
		lblPaisSiguiente.setBounds(10, 148, 204, 14);
		lblPaisSiguiente.setVisible(false);
		panelDestino.add(lblPaisSiguiente);
		
		JComboBox comboBoxPaisesSiguientes = new JComboBox();
		comboBoxPaisesSiguientes.setEnabled(false);
		comboBoxPaisesSiguientes.setBounds(183, 142, 131, 22);
		comboBoxPaisesSiguientes.setVisible(false);
		panelDestino.add(comboBoxPaisesSiguientes);
		
		JLabel lblPqBolivia = new JLabel("POR QUÉ ESOCOGIO BOLIVIA COMO DESTINO FINAL?:");
		lblPqBolivia.setBounds(10, 176, 370, 14);
		lblPqBolivia.setVisible(false);
		panelDestino.add(lblPqBolivia);
		
		JTextArea txtPqBolivia = new JTextArea();
		txtPqBolivia.setEditable(false);
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
		comboBoxAlojamiento.setEnabled(false);
		comboBoxAlojamiento.setModel(new DefaultComboBoxModel(new String[] {"Alquiler", "Acogido", "Alojamiento", "Situación de calle", "Otro "}));
		comboBoxAlojamiento.setBounds(136, 80, 111, 22);
		panelFormadeVida.add(comboBoxAlojamiento);
		
		JLabel lblSustento = new JLabel("CUÁL ES SU MEDIO DE SUSTENTO?:");
		lblSustento.setBounds(10, 141, 214, 14);
		panelFormadeVida.add(lblSustento);
		
		JRadioButton rdbtnSustentoInformal = new JRadioButton("INFORMAL");
		rdbtnSustentoInformal.setEnabled(false);
		rdbtnSustentoInformal.setBounds(219, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoInformal);
		
		JRadioButton rdbtnSustentoFormal = new JRadioButton("FORMAL");
		rdbtnSustentoFormal.setEnabled(false);
		rdbtnSustentoFormal.setBounds(331, 137, 109, 23);
		panelFormadeVida.add(rdbtnSustentoFormal);
		
		ButtonGroup buttonGroupSustento = new ButtonGroup();
	    buttonGroupSustento.add(rdbtnSustentoInformal);
	    buttonGroupSustento.add(rdbtnSustentoFormal);
	    
	    JLabel lblEnviaDinero = new JLabel("ENVIA DINERO A SU FAMILIA?:");
	    lblEnviaDinero.setBounds(10, 197, 174, 14);
	    panelFormadeVida.add(lblEnviaDinero);
	    
	    JRadioButton rdbtnSiEnvia = new JRadioButton("SI");
	    rdbtnSiEnvia.setEnabled(false);
	    rdbtnSiEnvia.setBounds(219, 193, 57, 23);
	    panelFormadeVida.add(rdbtnSiEnvia);
	    
	    JRadioButton rdbtnNoEnvia = new JRadioButton("NO");
	    rdbtnNoEnvia.setEnabled(false);
	    rdbtnNoEnvia.setBounds(331, 193, 109, 23);
	    panelFormadeVida.add(rdbtnNoEnvia);
	    
	    ButtonGroup buttonGroupEnviaDinero = new ButtonGroup();
	    buttonGroupEnviaDinero.add(rdbtnSiEnvia);
	    buttonGroupEnviaDinero.add(rdbtnNoEnvia);
	    
	    JLabel lblLeEnvianDinero = new JLabel("SU FAMILIA LE ENVIA DINERO?:");
	    lblLeEnvianDinero.setBounds(10, 253, 184, 14);
	    panelFormadeVida.add(lblLeEnvianDinero);
	    
	    JRadioButton rdbtnSiLeEnvian = new JRadioButton("SI");
	    rdbtnSiLeEnvian.setEnabled(false);
	    
	    rdbtnSiLeEnvian.setBounds(219, 249, 57, 23);
	    panelFormadeVida.add(rdbtnSiLeEnvian);
	    
	    JRadioButton rdbtnNoLeEnvian = new JRadioButton("NO");
	    rdbtnNoLeEnvian.setEnabled(false);
	  
	    rdbtnNoLeEnvian.setBounds(331, 249, 109, 23);
	    panelFormadeVida.add(rdbtnNoLeEnvian);
	    
	    ButtonGroup buttonGroupLeEnvianDinero = new ButtonGroup();
	    buttonGroupLeEnvianDinero.add(rdbtnSiLeEnvian);
	    buttonGroupLeEnvianDinero.add(rdbtnNoLeEnvian);
	    
	    JLabel lblMedioEnvio = new JLabel("POR QUÉ MEDIO?:");
	    txtMedioEnvio = new JTextField();
	    txtMedioEnvio.setEditable(false);
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
	    txtComunicacion.setEditable(false);
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
	    txtObservaciones.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones); 
        scrollObservaciones.setBounds(20, 472, 450, 71);
        panelFormadeVida.add(scrollObservaciones);
        
        JSeparator separator_3_1 = new JSeparator();
        separator_3_1.setBounds(0, 585, 500, 2);
        panelFormadeVida.add(separator_3_1);


		
		
	}
	
	
}