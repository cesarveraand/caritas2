package poo;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Hoja_ruta_acciones extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JTextField txtAsignacion;
    private JTextField textField;
    private JTextField txtFechaAtencion;
    private JTextField textField_1;
    private int contadorAcciones;
    public Hoja_ruta_acciones(Hoja_de_ruta hhh) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1554, 801);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        //imagenCaritas.setIcon(new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
       // ImageIcon iconOriginal = new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/perfilpersona.png"));
       // Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        //Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
       // ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
       // btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        contentPane.add(panelFormulario, BorderLayout.CENTER);
        panelFormulario.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("HOJA DE RUTA P.M.H.");
        lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelFormulario.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelLlenado = new JPanel();
        panelFormulario.add(panelLlenado, BorderLayout.CENTER);
        panelLlenado.setLayout(null);

        JLabel lblN = new JLabel("Nº:");
        lblN.setBounds(52, 41, 61, 16);
        panelLlenado.add(lblN);

        JLabel lblFecha = new JLabel("Fecha de atencion:");
        lblFecha.setBounds(52, 78, 134, 16);
        panelLlenado.add(lblFecha);

        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);

        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblCantPesonas = new JLabel("Número de personas:");
        lblCantPesonas.setBounds(52, 117, 134, 16);
        panelLlenado.add(lblCantPesonas);

        JLabel lblNombresPersonas = new JLabel("Nombre(s) Apellidos:");
        lblNombresPersonas.setBounds(52, 158, 134, 16);
        panelLlenado.add(lblNombresPersonas);
        FormlarioRegistro fm=hhh.getForm();

        String s="";
        for(Beneficiarios i:fm.getFam().getFamilia()) {
            s = s+i.getNombre()+"\n"; // Deberían ser los nombres de las personas ingresadas en la hoja de registro.

        }        
       
        JTextArea txtNombresBenef = new JTextArea();
        txtNombresBenef.setEditable(false);
        txtNombresBenef.setWrapStyleWord(true);
        txtNombresBenef.setLineWrap(false);
        txtNombresBenef.setText(s);
        JScrollPane scrollNombres = new JScrollPane(txtNombresBenef); // Por si son muchos nombres de personas
        scrollNombres.setBounds(63, 187, 343, 289);
        panelLlenado.add(scrollNombres);

        int personas = fm.getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(588, 47, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setEnabled(false);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setEnabled(false);
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setEnabled(false);
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);
        
        
        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setEnabled(false);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setEnabled(false);
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setEnabled(false);
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setEnabled(false);
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setEnabled(false);
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setEnabled(false);
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);
       
        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setEditable(false);
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textField);
        textField.setColumns(10);
       
        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones2 = new JTextArea();
        txtObservaciones2.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones2); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);
        Hoja_de_ruta hj=hhh;
        txtNumero.setText(hj.getNumero());
        txtFecha.setText(hj.getFechaReg()+"");
        chckbxAseLegal.setSelected(hj.isLegal());
        chckbxSoliRefugio.setSelected(hj.isRefugio());
        chckbxAtenSocial.setSelected(hj.isAtencion());
        chckbxAlbergue.setSelected(hj.isAccionAlbergue());
        chckbxServiciosMedicos.setSelected(hj.isAccionSerMedico());
        chckbxAyudaHumanitaria.setSelected(hj.isAccionAyudaHum());
        chckbxPasajes.setSelected(hj.isAccionPasajes());
        chckbxInfCondonación.setSelected(hj.isAccionCondonacion());
        chckbxAimentacion.setSelected(hj.isAccionAlimentacion());
        txtAsignacion.setText(hj.getAsignacion());
        textField.setText(hj.getFechaAsig()+"");
        txtObservaciones2.setText(hj.getObs());
        JButton btnImprimir = new JButton("IMPRIMIR HOJA DE RUTA P.M.H.");
        btnImprimir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimir.setBounds(1666, 506, 218, 29);
        panelLlenado.add(btnImprimir);
        
        JPanel panelAcRealizada1 = new JPanel();
        panelAcRealizada1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada1.setBounds(55, 529, 650, 224);
        panelAcRealizada1.setVisible(false);
        panelAcRealizada1.setLayout(null);
        
        
        
        
       
        
        
        
        JLabel lblFechaAccion = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion.setBounds(27, 25, 119, 14);
        panelAcRealizada1.add(lblFechaAccion);
        
        txtFechaAtencion = new JTextField();
        txtFechaAtencion.setBounds(160, 22, 130, 20);
        panelAcRealizada1.add(txtFechaAtencion);
        txtFechaAtencion.setColumns(10);
        
        JLabel lblAccionRealizada = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada.setBounds(25, 50, 121, 14);
        panelAcRealizada1.add(lblAccionRealizada);
        
        JTextField txtAcciones  = new JTextField();
        txtAcciones.setColumns(15);
        txtAcciones.setBounds(160, 53, 150, 22);
        panelAcRealizada1.add(txtAcciones);
       
        
        JLabel lblDerivado = new JLabel("DERIVADO A:");
        lblDerivado.setBounds(317, 50, 110, 14);
        panelAcRealizada1.add(lblDerivado);
        
        JComboBox<String> comboDerivados = new JComboBox<String>();
        comboDerivados.setBounds(412, 53, 110, 22);
        panelAcRealizada1.add(comboDerivados);
        comboDerivados.addItem("Encargado 1");
        JLabel lblInstruccion = new JLabel("INSTRUCCIÖN:");
        lblInstruccion.setBounds(27, 94, 119, 14);
        panelAcRealizada1.add(lblInstruccion);
        
        JLabel lblObservacionAccion = new JLabel("OBSERVACIONES:");
        lblObservacionAccion.setBounds(27, 152, 152, 14);
        panelAcRealizada1.add(lblObservacionAccion);
        
        JTextArea txtInstrucciones = new JTextArea();
        JScrollPane scrollInstrucciones = new JScrollPane(txtInstrucciones); // Por si son muchas observaciones
        scrollInstrucciones.setBounds(133, 94, 294, 48);
        panelAcRealizada1.add( scrollInstrucciones);
        
        JTextArea txtObservacionAccion = new JTextArea();
        JScrollPane scrollObservacionesAccion = new JScrollPane(txtObservacionAccion); // Por si son muchas observaciones
        scrollObservacionesAccion.setBounds(133, 165, 294, 48);
        panelAcRealizada1.add( scrollObservacionesAccion);
        
        JButton btnGuardarAccion = new JButton("REGISTRAR ACCIÓN");
        btnGuardarAccion.setBounds(452, 190, 152, 23);
        panelAcRealizada1.add(btnGuardarAccion);
        btnGuardarAccion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones.getText().equals("")&& !txtInstrucciones.getText().equals("")&& !txtObservacionAccion.getText().equals("")&&!txtFechaAtencion.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones.getText(), (String) comboDerivados.getSelectedItem(), txtInstrucciones.getText(), txtObservacionAccion.getText(), Extras.fechas(txtFechaAtencion.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.registrarHojaDeRutaAcciones(hjr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion.setBounds(452, 148, 152, 23);
        panelAcRealizada1.add(btnImprimirAccion);
        
        JLabel lblAcciones = new JLabel("ACCIONES REALIZADAS");
        lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAcciones.setBounds(52, 498, 199, 14);
        panelLlenado.add(lblAcciones);
        
        JButton btnAñadirAccion = new JButton("AÑADIR ACCION REALIZADA");
        
        btnAñadirAccion.setBounds(288, 495, 230, 23);
        panelLlenado.add(btnAñadirAccion);
JButton btnQuitarAccion = new JButton("QUITAR ACCION REALIZADA");
        
        btnQuitarAccion.setBounds(500, 495, 230, 23);
        panelLlenado.add(btnQuitarAccion);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 485, 1894, 2);
        panelLlenado.add(separator_1);
        
        JButton btnImprimirAcciones = new JButton("IMPRIMIR ACCIONES REALIZADAS");
        btnImprimirAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimirAcciones.setBounds(1666, 548, 218, 29);
        panelLlenado.add(btnImprimirAcciones);
        
        JPanel panelAcRealizada2 = new JPanel();
        panelAcRealizada2.setLayout(null);
        panelAcRealizada2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada2.setBounds(807, 529, 650, 224);
        panelAcRealizada2.setVisible(false);
        

        JLabel lblFechaAccion_1 = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion_1.setBounds(27, 25, 119, 14);
        panelAcRealizada2.add(lblFechaAccion_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(15);
        textField_1.setBounds(160, 22, 130, 20);
        panelAcRealizada2.add(textField_1);
        
        JLabel lblAccionRealizada_1 = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada_1.setBounds(25, 50, 121, 14);
        panelAcRealizada2.add(lblAccionRealizada_1);
        
        JTextField txtAcciones_1  = new JTextField();
        txtAcciones_1.setColumns(10);
        txtAcciones_1.setBounds(160, 53, 150, 22);
        panelAcRealizada2.add(txtAcciones_1);
       
        
        JLabel lblDerivado_1 = new JLabel("DERIVADO A:");
        lblDerivado_1.setBounds(317, 50, 110, 14);
        panelAcRealizada2.add(lblDerivado_1);
        
        JComboBox<String> comboDerivados_1 = new JComboBox<String>();
        comboDerivados_1.setBounds(412, 53, 110, 22);
        panelAcRealizada2.add(comboDerivados_1);
        comboDerivados_1.addItem("Encargado 1");
        
        JLabel lblInstruccion_1 = new JLabel("INSTRUCCIÖN:");
        lblInstruccion_1.setBounds(27, 94, 119, 14);
        panelAcRealizada2.add(lblInstruccion_1);
        
        JLabel lblObservacionAccion_1 = new JLabel("OBSERVACIONES:");
        lblObservacionAccion_1.setBounds(27, 152, 152, 14);
        panelAcRealizada2.add(lblObservacionAccion_1);
        
        JTextArea txtInstrucciones2 = new JTextArea();
        JScrollPane scrollInstrucciones_1 = new JScrollPane(txtInstrucciones2 );
        scrollInstrucciones_1.setBounds(133, 94, 294, 48);
        panelAcRealizada2.add(scrollInstrucciones_1);
        
        JTextArea txtObservacionAccion2 = new JTextArea();
        JScrollPane scrollObservacionesAccion_1 = new JScrollPane( txtObservacionAccion2 );
        scrollObservacionesAccion_1.setBounds(133, 165, 294, 48);
        panelAcRealizada2.add(scrollObservacionesAccion_1);
        
        JButton btnGuardarAccion_1 = new JButton("REGISTRAR ACCIÓN");
        btnGuardarAccion_1.setBounds(452, 190, 152, 23);
        panelAcRealizada2.add(btnGuardarAccion_1);
        btnGuardarAccion_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones_1.getText().equals("")&& !txtInstrucciones2.getText().equals("")&& !txtObservacionAccion2.getText().equals("")&&!textField_1.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones_1.getText(), (String) comboDerivados_1.getSelectedItem(), txtInstrucciones2.getText(), txtObservacionAccion2.getText(), Extras.fechas(textField_1.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.registrarHojaDeRutaAcciones(hjr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion_1 = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion_1.setBounds(452, 148, 152, 23);
        panelAcRealizada2.add(btnImprimirAccion_1);
        contadorAcciones = 0; // la cantidad de acciones realizadas hasta el momento
        
        panelAcRealizada1.setPreferredSize(new Dimension(600, 250)); 
        panelAcRealizada2.setPreferredSize(new Dimension(600, 250));
        
        
        JScrollPane mainScrollPane = new JScrollPane(contentPane);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(mainScrollPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = screenSize.width; 
        int preferredHeight = screenSize.height; 
        contentPane.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        
        
        JScrollPane scrollPane = new JScrollPane(panelAcRealizada1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(55, 529, 650, 250);
        scrollPane.setVisible(false);
        scrollPane.setMinimumSize(new Dimension(200, 100)); // Set the minimum size
        panelLlenado.add(scrollPane);


        
        JScrollPane scrollPane2 = new JScrollPane(panelAcRealizada2);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(807, 529, 644, 250);
        scrollPane2.setVisible(false);
        scrollPane2.setMinimumSize(new Dimension(200, 200)); // Set the minimum size
        panelLlenado.add(scrollPane2);

        btnAñadirAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 0) {
                	scrollPane.setVisible(true);
                    panelAcRealizada1.setVisible(true);
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane2.setVisible(true);
                        panelAcRealizada2.setVisible(true);
                        contadorAcciones = 2;
                    }
                }
            }
        });
        btnQuitarAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 2) {
                	scrollPane2.setVisible(false);
                    panelAcRealizada2.setVisible(false);
                	
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane.setVisible(false);
                        panelAcRealizada1.setVisible(false);
                        contadorAcciones = 0;
                    }
                }
            }
        });
    }
    public Hoja_ruta_acciones() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1554, 801);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        //imagenCaritas.setIcon(new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
       // ImageIcon iconOriginal = new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/perfilpersona.png"));
       // Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        //Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
       // ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
       // btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        contentPane.add(panelFormulario, BorderLayout.CENTER);
        panelFormulario.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("HOJA DE RUTA P.M.H.");
        lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelFormulario.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelLlenado = new JPanel();
        panelFormulario.add(panelLlenado, BorderLayout.CENTER);
        panelLlenado.setLayout(null);

        JLabel lblN = new JLabel("Nº:");
        lblN.setBounds(52, 41, 61, 16);
        panelLlenado.add(lblN);

        JLabel lblFecha = new JLabel("Fecha de atencion:");
        lblFecha.setBounds(52, 78, 134, 16);
        panelLlenado.add(lblFecha);

        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);

        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblCantPesonas = new JLabel("Número de personas:");
        lblCantPesonas.setBounds(52, 117, 134, 16);
        panelLlenado.add(lblCantPesonas);

        JLabel lblNombresPersonas = new JLabel("Nombre(s) Apellidos:");
        lblNombresPersonas.setBounds(52, 158, 134, 16);
        panelLlenado.add(lblNombresPersonas);
        FormlarioRegistro fm=Main.getUltimoForm();

        String s="";
        for(Beneficiarios i:fm.getFam().getFamilia()) {
            s = s+i.getNombre()+"\n"; // Deberían ser los nombres de las personas ingresadas en la hoja de registro.

        }        
       
        JTextArea txtNombresBenef = new JTextArea();
        txtNombresBenef.setEditable(false);
        txtNombresBenef.setWrapStyleWord(true);
        txtNombresBenef.setLineWrap(false);
        txtNombresBenef.setText(s);
        JScrollPane scrollNombres = new JScrollPane(txtNombresBenef); // Por si son muchos nombres de personas
        scrollNombres.setBounds(63, 187, 343, 289);
        panelLlenado.add(scrollNombres);

        int personas = fm.getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(588, 47, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setEnabled(false);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setEnabled(false);
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setEnabled(false);
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);
        
        
        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setEnabled(false);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setEnabled(false);
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setEnabled(false);
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setEnabled(false);
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setEnabled(false);
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setEnabled(false);
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);
       
        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setEditable(false);
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textField);
        textField.setColumns(10);
       
        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones2 = new JTextArea();
        txtObservaciones2.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones2); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);
        Hoja_de_ruta hj=Main.getUltimaHojar();
        txtNumero.setText(hj.getNumero());
        txtFecha.setText(hj.getFechaReg()+"");
        chckbxAseLegal.setSelected(hj.isLegal());
        chckbxSoliRefugio.setSelected(hj.isRefugio());
        chckbxAtenSocial.setSelected(hj.isAtencion());
        chckbxAlbergue.setSelected(hj.isAccionAlbergue());
        chckbxServiciosMedicos.setSelected(hj.isAccionSerMedico());
        chckbxAyudaHumanitaria.setSelected(hj.isAccionAyudaHum());
        chckbxPasajes.setSelected(hj.isAccionPasajes());
        chckbxInfCondonación.setSelected(hj.isAccionCondonacion());
        chckbxAimentacion.setSelected(hj.isAccionAlimentacion());
        txtAsignacion.setText(hj.getAsignacion());
        textField.setText(hj.getFechaAsig()+"");
        txtObservaciones2.setText(hj.getObs());
        JButton btnImprimir = new JButton("IMPRIMIR HOJA DE RUTA P.M.H.");
        btnImprimir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimir.setBounds(1666, 506, 218, 29);
        panelLlenado.add(btnImprimir);
        
        JPanel panelAcRealizada1 = new JPanel();
        panelAcRealizada1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada1.setBounds(55, 529, 650, 224);
        panelAcRealizada1.setVisible(false);
        panelAcRealizada1.setLayout(null);
        
        
        
        
       
        
        
        
        JLabel lblFechaAccion = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion.setBounds(27, 25, 119, 14);
        panelAcRealizada1.add(lblFechaAccion);
        
        txtFechaAtencion = new JTextField();
        txtFechaAtencion.setBounds(160, 22, 130, 20);
        panelAcRealizada1.add(txtFechaAtencion);
        txtFechaAtencion.setColumns(10);
        
        JLabel lblAccionRealizada = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada.setBounds(25, 50, 121, 14);
        panelAcRealizada1.add(lblAccionRealizada);
        
        JTextField txtAcciones  = new JTextField();
        txtAcciones.setColumns(15);
        txtAcciones.setBounds(160, 53, 150, 22);
        panelAcRealizada1.add(txtAcciones);
       
        
        JLabel lblDerivado = new JLabel("DERIVADO A:");
        lblDerivado.setBounds(317, 50, 110, 14);
        panelAcRealizada1.add(lblDerivado);
        
        JComboBox<String> comboDerivados = new JComboBox<String>();
        comboDerivados.setBounds(412, 53, 110, 22);
        panelAcRealizada1.add(comboDerivados);
        comboDerivados.addItem("Encargado 1");
        JLabel lblInstruccion = new JLabel("INSTRUCCIÖN:");
        lblInstruccion.setBounds(27, 94, 119, 14);
        panelAcRealizada1.add(lblInstruccion);
        
        JLabel lblObservacionAccion = new JLabel("OBSERVACIONES:");
        lblObservacionAccion.setBounds(27, 152, 152, 14);
        panelAcRealizada1.add(lblObservacionAccion);
        
        JTextArea txtInstrucciones = new JTextArea();
        JScrollPane scrollInstrucciones = new JScrollPane(txtInstrucciones); // Por si son muchas observaciones
        scrollInstrucciones.setBounds(133, 94, 294, 48);
        panelAcRealizada1.add( scrollInstrucciones);
        
        JTextArea txtObservacionAccion = new JTextArea();
        JScrollPane scrollObservacionesAccion = new JScrollPane(txtObservacionAccion); // Por si son muchas observaciones
        scrollObservacionesAccion.setBounds(133, 165, 294, 48);
        panelAcRealizada1.add( scrollObservacionesAccion);
        
        JButton btnGuardarAccion = new JButton("REGISTRAR ACCIÓN");
        btnGuardarAccion.setBounds(452, 190, 152, 23);
        panelAcRealizada1.add(btnGuardarAccion);
        btnGuardarAccion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones.getText().equals("")&& !txtInstrucciones.getText().equals("")&& !txtObservacionAccion.getText().equals("")&&!txtFechaAtencion.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones.getText(), (String) comboDerivados.getSelectedItem(), txtInstrucciones.getText(), txtObservacionAccion.getText(), Extras.fechas(txtFechaAtencion.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.registrarHojaDeRutaAcciones(hjr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion.setBounds(452, 148, 152, 23);
        panelAcRealizada1.add(btnImprimirAccion);
        
        JLabel lblAcciones = new JLabel("ACCIONES REALIZADAS");
        lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAcciones.setBounds(52, 498, 199, 14);
        panelLlenado.add(lblAcciones);
        
        JButton btnAñadirAccion = new JButton("AÑADIR ACCION REALIZADA");
        
        btnAñadirAccion.setBounds(288, 495, 230, 23);
        panelLlenado.add(btnAñadirAccion);
JButton btnQuitarAccion = new JButton("QUITAR ACCION REALIZADA");
        
        btnQuitarAccion.setBounds(500, 495, 230, 23);
        panelLlenado.add(btnQuitarAccion);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 485, 1894, 2);
        panelLlenado.add(separator_1);
        
        JButton btnImprimirAcciones = new JButton("IMPRIMIR ACCIONES REALIZADAS");
        btnImprimirAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimirAcciones.setBounds(1666, 548, 218, 29);
        panelLlenado.add(btnImprimirAcciones);
        
        JPanel panelAcRealizada2 = new JPanel();
        panelAcRealizada2.setLayout(null);
        panelAcRealizada2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada2.setBounds(807, 529, 650, 224);
        panelAcRealizada2.setVisible(false);
        

        JLabel lblFechaAccion_1 = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion_1.setBounds(27, 25, 119, 14);
        panelAcRealizada2.add(lblFechaAccion_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(15);
        textField_1.setBounds(160, 22, 130, 20);
        panelAcRealizada2.add(textField_1);
        
        JLabel lblAccionRealizada_1 = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada_1.setBounds(25, 50, 121, 14);
        panelAcRealizada2.add(lblAccionRealizada_1);
        
        JTextField txtAcciones_1  = new JTextField();
        txtAcciones_1.setColumns(10);
        txtAcciones_1.setBounds(160, 53, 150, 22);
        panelAcRealizada2.add(txtAcciones_1);
       
        
        JLabel lblDerivado_1 = new JLabel("DERIVADO A:");
        lblDerivado_1.setBounds(317, 50, 110, 14);
        panelAcRealizada2.add(lblDerivado_1);
        
        JComboBox<String> comboDerivados_1 = new JComboBox<String>();
        comboDerivados_1.setBounds(412, 53, 110, 22);
        panelAcRealizada2.add(comboDerivados_1);
        comboDerivados_1.addItem("Encargado 1");
        
        JLabel lblInstruccion_1 = new JLabel("INSTRUCCIÖN:");
        lblInstruccion_1.setBounds(27, 94, 119, 14);
        panelAcRealizada2.add(lblInstruccion_1);
        
        JLabel lblObservacionAccion_1 = new JLabel("OBSERVACIONES:");
        lblObservacionAccion_1.setBounds(27, 152, 152, 14);
        panelAcRealizada2.add(lblObservacionAccion_1);
        
        JTextArea txtInstrucciones2 = new JTextArea();
        JScrollPane scrollInstrucciones_1 = new JScrollPane(txtInstrucciones2 );
        scrollInstrucciones_1.setBounds(133, 94, 294, 48);
        panelAcRealizada2.add(scrollInstrucciones_1);
        
        JTextArea txtObservacionAccion2 = new JTextArea();
        JScrollPane scrollObservacionesAccion_1 = new JScrollPane( txtObservacionAccion2 );
        scrollObservacionesAccion_1.setBounds(133, 165, 294, 48);
        panelAcRealizada2.add(scrollObservacionesAccion_1);
        
        JButton btnGuardarAccion_1 = new JButton("REGISTRAR ACCIÓN");
        btnGuardarAccion_1.setBounds(452, 190, 152, 23);
        panelAcRealizada2.add(btnGuardarAccion_1);
        btnGuardarAccion_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones_1.getText().equals("")&& !txtInstrucciones2.getText().equals("")&& !txtObservacionAccion2.getText().equals("")&&!textField_1.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones_1.getText(), (String) comboDerivados_1.getSelectedItem(), txtInstrucciones2.getText(), txtObservacionAccion2.getText(), Extras.fechas(textField_1.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.registrarHojaDeRutaAcciones(hjr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion_1 = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion_1.setBounds(452, 148, 152, 23);
        panelAcRealizada2.add(btnImprimirAccion_1);
        contadorAcciones = 0; // la cantidad de acciones realizadas hasta el momento
        
        panelAcRealizada1.setPreferredSize(new Dimension(600, 250)); 
        panelAcRealizada2.setPreferredSize(new Dimension(600, 250));
        
        
        JScrollPane mainScrollPane = new JScrollPane(contentPane);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(mainScrollPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = screenSize.width; 
        int preferredHeight = screenSize.height; 
        contentPane.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        
        
        JScrollPane scrollPane = new JScrollPane(panelAcRealizada1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(55, 529, 650, 250);
        scrollPane.setVisible(false);
        scrollPane.setMinimumSize(new Dimension(200, 100)); // Set the minimum size
        panelLlenado.add(scrollPane);


        
        JScrollPane scrollPane2 = new JScrollPane(panelAcRealizada2);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(807, 529, 644, 250);
        scrollPane2.setVisible(false);
        scrollPane2.setMinimumSize(new Dimension(200, 200)); // Set the minimum size
        panelLlenado.add(scrollPane2);

        btnAñadirAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 0) {
                	scrollPane.setVisible(true);
                    panelAcRealizada1.setVisible(true);
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane2.setVisible(true);
                        panelAcRealizada2.setVisible(true);
                        contadorAcciones = 2;
                    }
                }
            }
        });
        btnQuitarAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 2) {
                	scrollPane2.setVisible(false);
                    panelAcRealizada2.setVisible(false);
                	
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane.setVisible(false);
                        panelAcRealizada1.setVisible(false);
                        contadorAcciones = 0;
                    }
                }
            }
        });
    }
    public Hoja_ruta_acciones(HojaRutaAcciones hhhd,HojaRutaAcciones hhhd_1) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1554, 801);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        //imagenCaritas.setIcon(new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
       // ImageIcon iconOriginal = new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/perfilpersona.png"));
       // Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        //Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
       // ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
       // btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        contentPane.add(panelFormulario, BorderLayout.CENTER);
        panelFormulario.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("HOJA DE RUTA P.M.H.");
        lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelFormulario.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelLlenado = new JPanel();
        panelFormulario.add(panelLlenado, BorderLayout.CENTER);
        panelLlenado.setLayout(null);

        JLabel lblN = new JLabel("Nº:");
        lblN.setBounds(52, 41, 61, 16);
        panelLlenado.add(lblN);

        JLabel lblFecha = new JLabel("Fecha de atencion:");
        lblFecha.setBounds(52, 78, 134, 16);
        panelLlenado.add(lblFecha);

        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);

        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblCantPesonas = new JLabel("Número de personas:");
        lblCantPesonas.setBounds(52, 117, 134, 16);
        panelLlenado.add(lblCantPesonas);

        JLabel lblNombresPersonas = new JLabel("Nombre(s) Apellidos:");
        lblNombresPersonas.setBounds(52, 158, 134, 16);
        panelLlenado.add(lblNombresPersonas);
        FormlarioRegistro fm=hhhd.getHjr().getForm();

        String s="";
        for(Beneficiarios i:fm.getFam().getFamilia()) {
            s = s+i.getNombre()+"\n"; // Deberían ser los nombres de las personas ingresadas en la hoja de registro.

        }        
       
        JTextArea txtNombresBenef = new JTextArea();
        txtNombresBenef.setEditable(false);
        txtNombresBenef.setWrapStyleWord(true);
        txtNombresBenef.setLineWrap(false);
        txtNombresBenef.setText(s);
        JScrollPane scrollNombres = new JScrollPane(txtNombresBenef); // Por si son muchos nombres de personas
        scrollNombres.setBounds(63, 187, 343, 289);
        panelLlenado.add(scrollNombres);

        int personas = fm.getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(588, 47, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setEnabled(false);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setEnabled(false);
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setEnabled(false);
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);
        
        
        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setEnabled(false);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setEnabled(false);
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setEnabled(false);
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setEnabled(false);
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setEnabled(false);
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setEnabled(false);
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);
       
        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setEditable(false);
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textField);
        textField.setColumns(10);
       
        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones2 = new JTextArea();
        txtObservaciones2.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones2); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);
        Hoja_de_ruta hj=hhhd.getHjr();
        txtNumero.setText(hj.getNumero());
        txtFecha.setText(hj.getFechaReg()+"");
        chckbxAseLegal.setSelected(hj.isLegal());
        chckbxSoliRefugio.setSelected(hj.isRefugio());
        chckbxAtenSocial.setSelected(hj.isAtencion());
        chckbxAlbergue.setSelected(hj.isAccionAlbergue());
        chckbxServiciosMedicos.setSelected(hj.isAccionSerMedico());
        chckbxAyudaHumanitaria.setSelected(hj.isAccionAyudaHum());
        chckbxPasajes.setSelected(hj.isAccionPasajes());
        chckbxInfCondonación.setSelected(hj.isAccionCondonacion());
        chckbxAimentacion.setSelected(hj.isAccionAlimentacion());
        txtAsignacion.setText(hj.getAsignacion());
        textField.setText(hj.getFechaAsig()+"");
        txtObservaciones2.setText(hj.getObs());
        JButton btnImprimir = new JButton("IMPRIMIR HOJA DE RUTA P.M.H.");
        btnImprimir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimir.setBounds(1666, 506, 218, 29);
        panelLlenado.add(btnImprimir);
        
        JPanel panelAcRealizada1 = new JPanel();
        panelAcRealizada1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada1.setBounds(55, 529, 650, 224);
        panelAcRealizada1.setVisible(false);
        panelAcRealizada1.setLayout(null);
        
        
        
        
       
        
        
        
        JLabel lblFechaAccion = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion.setBounds(27, 25, 119, 14);
        panelAcRealizada1.add(lblFechaAccion);
        
        txtFechaAtencion = new JTextField();
        txtFechaAtencion.setBounds(160, 22, 130, 20);
        panelAcRealizada1.add(txtFechaAtencion);
        txtFechaAtencion.setColumns(10);
        
        JLabel lblAccionRealizada = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada.setBounds(25, 50, 121, 14);
        panelAcRealizada1.add(lblAccionRealizada);
        
        JTextField txtAcciones  = new JTextField();
        txtAcciones.setColumns(15);
        txtAcciones.setBounds(160, 53, 150, 22);
        panelAcRealizada1.add(txtAcciones);
        
        
        
        JLabel lblDerivado = new JLabel("DERIVADO A:");
        lblDerivado.setBounds(317, 50, 110, 14);
        panelAcRealizada1.add(lblDerivado);
        
        JComboBox<String> comboDerivados = new JComboBox<String>();
        comboDerivados.setBounds(412, 53, 110, 22);
        panelAcRealizada1.add(comboDerivados);
        comboDerivados.addItem("Encargado 1");
        JLabel lblInstruccion = new JLabel("INSTRUCCIÖN:");
        lblInstruccion.setBounds(27, 94, 119, 14);
        panelAcRealizada1.add(lblInstruccion);
        
        JLabel lblObservacionAccion = new JLabel("OBSERVACIONES:");
        lblObservacionAccion.setBounds(27, 152, 152, 14);
        panelAcRealizada1.add(lblObservacionAccion);
        
        JTextArea txtInstrucciones = new JTextArea();
        JScrollPane scrollInstrucciones = new JScrollPane(txtInstrucciones); // Por si son muchas observaciones
        scrollInstrucciones.setBounds(133, 94, 294, 48);
        panelAcRealizada1.add( scrollInstrucciones);
        
        JTextArea txtObservacionAccion = new JTextArea();
        JScrollPane scrollObservacionesAccion = new JScrollPane(txtObservacionAccion); // Por si son muchas observaciones
        scrollObservacionesAccion.setBounds(133, 165, 294, 48);
        panelAcRealizada1.add( scrollObservacionesAccion);
        txtFechaAtencion.setText(hhhd.getFechaAccion()+"");
        comboDerivados.setSelectedItem(hhhd.getDerivado());
        txtInstrucciones.setText(hhhd.getInstruccion());
        txtObservacionAccion.setText(hhhd.getObservaciones());
        txtAcciones.setText(hhhd.getAccionRealizada());
        JButton btnGuardarAccion = new JButton("ACTUALIZAR ACCIÓN");
        btnGuardarAccion.setBounds(452, 190, 152, 23);
        panelAcRealizada1.add(btnGuardarAccion);
      
        btnGuardarAccion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones.getText().equals("")&& !txtInstrucciones.getText().equals("")&& !txtObservacionAccion.getText().equals("")&&!txtFechaAtencion.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones.getText(), (String) comboDerivados.getSelectedItem(), txtInstrucciones.getText(), txtObservacionAccion.getText(), Extras.fechas(txtFechaAtencion.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.actualizarHojaDeRutaAcciones(hjr,hhhd);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion.setBounds(452, 148, 152, 23);
        panelAcRealizada1.add(btnImprimirAccion);
        
        JLabel lblAcciones = new JLabel("ACCIONES REALIZADAS");
        lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAcciones.setBounds(52, 498, 199, 14);
        panelLlenado.add(lblAcciones);
        
        JButton btnAñadirAccion = new JButton("AÑADIR ACCION REALIZADA");
        
        btnAñadirAccion.setBounds(288, 495, 230, 23);
        panelLlenado.add(btnAñadirAccion);
JButton btnQuitarAccion = new JButton("QUITAR ACCION REALIZADA");
        
        btnQuitarAccion.setBounds(500, 495, 230, 23);
        panelLlenado.add(btnQuitarAccion);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 485, 1894, 2);
        panelLlenado.add(separator_1);
        
        JButton btnImprimirAcciones = new JButton("IMPRIMIR ACCIONES REALIZADAS");
        btnImprimirAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimirAcciones.setBounds(1666, 548, 218, 29);
        panelLlenado.add(btnImprimirAcciones);
        
        JPanel panelAcRealizada2 = new JPanel();
        panelAcRealizada2.setLayout(null);
        panelAcRealizada2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada2.setBounds(807, 529, 650, 224);
        panelAcRealizada2.setVisible(false);
        

        JLabel lblFechaAccion_1 = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion_1.setBounds(27, 25, 119, 14);
        panelAcRealizada2.add(lblFechaAccion_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(15);
        textField_1.setBounds(160, 22, 130, 20);
        panelAcRealizada2.add(textField_1);
        
        JLabel lblAccionRealizada_1 = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada_1.setBounds(25, 50, 121, 14);
        panelAcRealizada2.add(lblAccionRealizada_1);
        
        JTextField txtAcciones_1  = new JTextField();
        txtAcciones_1.setColumns(10);
        txtAcciones_1.setBounds(160, 53, 150, 22);
        panelAcRealizada2.add(txtAcciones_1);
       
        
        JLabel lblDerivado_1 = new JLabel("DERIVADO A:");
        lblDerivado_1.setBounds(317, 50, 110, 14);
        panelAcRealizada2.add(lblDerivado_1);
        
        JComboBox<String> comboDerivados_1 = new JComboBox<String>();
        comboDerivados_1.setBounds(412, 53, 110, 22);
        panelAcRealizada2.add(comboDerivados_1);
        comboDerivados_1.addItem("Encargado 1");
        
        JLabel lblInstruccion_1 = new JLabel("INSTRUCCIÖN:");
        lblInstruccion_1.setBounds(27, 94, 119, 14);
        panelAcRealizada2.add(lblInstruccion_1);
        
        JLabel lblObservacionAccion_1 = new JLabel("OBSERVACIONES:");
        lblObservacionAccion_1.setBounds(27, 152, 152, 14);
        panelAcRealizada2.add(lblObservacionAccion_1);
        
        JTextArea txtInstrucciones2 = new JTextArea();
        JScrollPane scrollInstrucciones_1 = new JScrollPane(txtInstrucciones2 );
        scrollInstrucciones_1.setBounds(133, 94, 294, 48);
        panelAcRealizada2.add(scrollInstrucciones_1);
        
        JTextArea txtObservacionAccion2 = new JTextArea();
        JScrollPane scrollObservacionesAccion_1 = new JScrollPane( txtObservacionAccion2 );
        scrollObservacionesAccion_1.setBounds(133, 165, 294, 48);
        panelAcRealizada2.add(scrollObservacionesAccion_1);
        textField_1.setText(hhhd_1.getFechaAccion()+"");
        comboDerivados_1.setSelectedItem(hhhd_1.getDerivado());
        txtInstrucciones2.setText(hhhd_1.getInstruccion());
        txtObservacionAccion2.setText(hhhd_1.getObservaciones());
        txtAcciones_1.setText(hhhd_1.getAccionRealizada());
        JButton btnGuardarAccion_1 = new JButton("ACTUALIZAR ACCIÓN");
        btnGuardarAccion_1.setBounds(452, 190, 152, 23);
        panelAcRealizada2.add(btnGuardarAccion_1);
        btnGuardarAccion_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones_1.getText().equals("")&& !txtInstrucciones2.getText().equals("")&& !txtObservacionAccion2.getText().equals("")&&!textField_1.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones_1.getText(), (String) comboDerivados_1.getSelectedItem(), txtInstrucciones2.getText(), txtObservacionAccion2.getText(), Extras.fechas(textField_1.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.actualizarHojaDeRutaAcciones(hjr,hhhd_1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion_1 = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion_1.setBounds(452, 148, 152, 23);
        panelAcRealizada2.add(btnImprimirAccion_1);
        contadorAcciones = 0; // la cantidad de acciones realizadas hasta el momento
        
        panelAcRealizada1.setPreferredSize(new Dimension(600, 250)); 
        panelAcRealizada2.setPreferredSize(new Dimension(600, 250));
        
        
        JScrollPane mainScrollPane = new JScrollPane(contentPane);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(mainScrollPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = screenSize.width; 
        int preferredHeight = screenSize.height; 
        contentPane.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        
        
        JScrollPane scrollPane = new JScrollPane(panelAcRealizada1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(55, 529, 650, 250);
        scrollPane.setVisible(false);
        scrollPane.setMinimumSize(new Dimension(200, 100)); // Set the minimum size
        panelLlenado.add(scrollPane);


        
        JScrollPane scrollPane2 = new JScrollPane(panelAcRealizada2);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(807, 529, 644, 250);
        scrollPane2.setVisible(false);
        scrollPane2.setMinimumSize(new Dimension(200, 200)); // Set the minimum size
        panelLlenado.add(scrollPane2);
        scrollPane.setVisible(true);
        panelAcRealizada1.setVisible(true);
        contadorAcciones = 1;
   
        	scrollPane2.setVisible(true);
            panelAcRealizada2.setVisible(true);
           
        
        
        
        btnAñadirAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 0) {
                	scrollPane.setVisible(true);
                    panelAcRealizada1.setVisible(true);
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane2.setVisible(true);
                        panelAcRealizada2.setVisible(true);
                        contadorAcciones = 2;
                    }
                }
            }
        });
        btnQuitarAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 2) {
                	scrollPane2.setVisible(false);
                    panelAcRealizada2.setVisible(false);
                	
                    contadorAcciones = 1;
                } else {
                    if (contadorAcciones == 1) {
                    	scrollPane.setVisible(false); 
                        panelAcRealizada1.setVisible(false);
                        contadorAcciones = 0;
                    }
                }
            }
        });
    }
    public Hoja_ruta_acciones(HojaRutaAcciones hhhd) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1554, 801);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        //imagenCaritas.setIcon(new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
       // ImageIcon iconOriginal = new ImageIcon(Hoja_ruta_acciones.class.getResource("/imagenes_help/perfilpersona.png"));
       // Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        //Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
       // ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
       // btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        contentPane.add(panelFormulario, BorderLayout.CENTER);
        panelFormulario.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("HOJA DE RUTA P.M.H.");
        lblTitulo.setFont(new Font("Baskerville", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelFormulario.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelLlenado = new JPanel();
        panelFormulario.add(panelLlenado, BorderLayout.CENTER);
        panelLlenado.setLayout(null);

        JLabel lblN = new JLabel("Nº:");
        lblN.setBounds(52, 41, 61, 16);
        panelLlenado.add(lblN);

        JLabel lblFecha = new JLabel("Fecha de atencion:");
        lblFecha.setBounds(52, 78, 134, 16);
        panelLlenado.add(lblFecha);

        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);

        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblCantPesonas = new JLabel("Número de personas:");
        lblCantPesonas.setBounds(52, 117, 134, 16);
        panelLlenado.add(lblCantPesonas);

        JLabel lblNombresPersonas = new JLabel("Nombre(s) Apellidos:");
        lblNombresPersonas.setBounds(52, 158, 134, 16);
        panelLlenado.add(lblNombresPersonas);
        FormlarioRegistro fm=hhhd.getHjr().getForm();

        String s="";
        for(Beneficiarios i:fm.getFam().getFamilia()) {
            s = s+i.getNombre()+"\n"; // Deberían ser los nombres de las personas ingresadas en la hoja de registro.

        }        
       
        JTextArea txtNombresBenef = new JTextArea();
        txtNombresBenef.setEditable(false);
        txtNombresBenef.setWrapStyleWord(true);
        txtNombresBenef.setLineWrap(false);
        txtNombresBenef.setText(s);
        JScrollPane scrollNombres = new JScrollPane(txtNombresBenef); // Por si son muchos nombres de personas
        scrollNombres.setBounds(63, 187, 343, 289);
        panelLlenado.add(scrollNombres);

        int personas = fm.getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(588, 47, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setEnabled(false);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setEnabled(false);
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setEnabled(false);
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);
        
        
        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setEnabled(false);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setEnabled(false);
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setEnabled(false);
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setEnabled(false);
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setEnabled(false);
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setEnabled(false);
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);
       
        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setEditable(false);
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textField);
        textField.setColumns(10);
       
        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones2 = new JTextArea();
        txtObservaciones2.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones2); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);
        Hoja_de_ruta hj=hhhd.getHjr();
        txtNumero.setText(hj.getNumero());
        txtFecha.setText(hj.getFechaReg()+"");
        chckbxAseLegal.setSelected(hj.isLegal());
        chckbxSoliRefugio.setSelected(hj.isRefugio());
        chckbxAtenSocial.setSelected(hj.isAtencion());
        chckbxAlbergue.setSelected(hj.isAccionAlbergue());
        chckbxServiciosMedicos.setSelected(hj.isAccionSerMedico());
        chckbxAyudaHumanitaria.setSelected(hj.isAccionAyudaHum());
        chckbxPasajes.setSelected(hj.isAccionPasajes());
        chckbxInfCondonación.setSelected(hj.isAccionCondonacion());
        chckbxAimentacion.setSelected(hj.isAccionAlimentacion());
        txtAsignacion.setText(hj.getAsignacion());
        textField.setText(hj.getFechaAsig()+"");
        txtObservaciones2.setText(hj.getObs());
        JButton btnImprimir = new JButton("IMPRIMIR HOJA DE RUTA P.M.H.");
        btnImprimir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimir.setBounds(1666, 506, 218, 29);
        panelLlenado.add(btnImprimir);
        
        JPanel panelAcRealizada1 = new JPanel();
        panelAcRealizada1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelAcRealizada1.setBounds(55, 529, 650, 224);
        panelAcRealizada1.setVisible(false);
        panelAcRealizada1.setLayout(null);
        
        
        
        
       
        
        
        
        JLabel lblFechaAccion = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion.setBounds(27, 25, 119, 14);
        panelAcRealizada1.add(lblFechaAccion);
        
        txtFechaAtencion = new JTextField();
        txtFechaAtencion.setBounds(160, 22, 130, 20);
        panelAcRealizada1.add(txtFechaAtencion);
        txtFechaAtencion.setColumns(10);
        
        JLabel lblAccionRealizada = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada.setBounds(25, 50, 121, 14);
        panelAcRealizada1.add(lblAccionRealizada);
        
        JTextField txtAcciones  = new JTextField();
        txtAcciones.setColumns(15);
        txtAcciones.setBounds(160, 53, 150, 22);
        panelAcRealizada1.add(txtAcciones);
        
        
        
        JLabel lblDerivado = new JLabel("DERIVADO A:");
        lblDerivado.setBounds(317, 50, 110, 14);
        panelAcRealizada1.add(lblDerivado);
        
        JComboBox<String> comboDerivados = new JComboBox<String>();
        comboDerivados.setBounds(412, 53, 110, 22);
        panelAcRealizada1.add(comboDerivados);
        comboDerivados.addItem("Encargado 1");
        JLabel lblInstruccion = new JLabel("INSTRUCCIÖN:");
        lblInstruccion.setBounds(27, 94, 119, 14);
        panelAcRealizada1.add(lblInstruccion);
        
        JLabel lblObservacionAccion = new JLabel("OBSERVACIONES:");
        lblObservacionAccion.setBounds(27, 152, 152, 14);
        panelAcRealizada1.add(lblObservacionAccion);
        
        JTextArea txtInstrucciones = new JTextArea();
        JScrollPane scrollInstrucciones = new JScrollPane(txtInstrucciones); // Por si son muchas observaciones
        scrollInstrucciones.setBounds(133, 94, 294, 48);
        panelAcRealizada1.add( scrollInstrucciones);
        
        JTextArea txtObservacionAccion = new JTextArea();
        JScrollPane scrollObservacionesAccion = new JScrollPane(txtObservacionAccion); // Por si son muchas observaciones
        scrollObservacionesAccion.setBounds(133, 165, 294, 48);
        panelAcRealizada1.add( scrollObservacionesAccion);
        txtFechaAtencion.setText(hhhd.getFechaAccion()+"");
        comboDerivados.setSelectedItem(hhhd.getDerivado());
        txtInstrucciones.setText(hhhd.getInstruccion());
        txtObservacionAccion.setText(hhhd.getObservaciones());
        txtAcciones.setText(hhhd.getAccionRealizada());
        JButton btnGuardarAccion = new JButton("ACTUALIZAR ACCIÓN");
        btnGuardarAccion.setBounds(452, 190, 152, 23);
        panelAcRealizada1.add(btnGuardarAccion);
      
        btnGuardarAccion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cod=0;
				try {
					cod = Conexion.ultimaHojaRutaAcciones();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if(!txtAcciones.getText().equals("")&& !txtInstrucciones.getText().equals("")&& !txtObservacionAccion.getText().equals("")&&!txtFechaAtencion.getText().equals("")) {
        			HojaRutaAcciones hjr=new HojaRutaAcciones(cod, txtAcciones.getText(), (String) comboDerivados.getSelectedItem(), txtInstrucciones.getText(), txtObservacionAccion.getText(), Extras.fechas(txtFechaAtencion.getText()),Main.getUltimaHojar(),true);
        			try {
						Conexion.actualizarHojaDeRutaAcciones(hjr,hhhd);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        	}
        });
        JButton btnImprimirAccion = new JButton("IMPRIMIR ACCIÓN");
        btnImprimirAccion.setBounds(452, 148, 152, 23);
        panelAcRealizada1.add(btnImprimirAccion);
        
        JLabel lblAcciones = new JLabel("ACCIONES REALIZADAS");
        lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAcciones.setBounds(52, 498, 199, 14);
        panelLlenado.add(lblAcciones);
        
        JButton btnAñadirAccion = new JButton("AÑADIR ACCION REALIZADA");
        
        btnAñadirAccion.setBounds(288, 495, 230, 23);
        panelLlenado.add(btnAñadirAccion);
        JButton btnQuitarAccion = new JButton("QUITAR ACCION REALIZADA");
        
        btnQuitarAccion.setBounds(500, 495, 230, 23);
        panelLlenado.add(btnQuitarAccion);
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 485, 1894, 2);
        panelLlenado.add(separator_1);
        
        JButton btnImprimirAcciones = new JButton("IMPRIMIR ACCIONES REALIZADAS");
        btnImprimirAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnImprimirAcciones.setBounds(1666, 548, 218, 29);
        panelLlenado.add(btnImprimirAcciones);

        JScrollPane mainScrollPane = new JScrollPane(contentPane);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(mainScrollPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = screenSize.width; 
        int preferredHeight = screenSize.height; 
        contentPane.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        
        
        JScrollPane scrollPane = new JScrollPane(panelAcRealizada1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(55, 529, 650, 250);
        scrollPane.setVisible(false);
        scrollPane.setMinimumSize(new Dimension(200, 100)); // Set the minimum size
        panelLlenado.add(scrollPane);
        scrollPane.setVisible(true);
        panelAcRealizada1.setVisible(true);
        contadorAcciones = 1;
        
        
        btnAñadirAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 0) {
                	scrollPane.setVisible(true);
                    panelAcRealizada1.setVisible(true);
                    contadorAcciones = 1;
                } 
            }
        });
        btnQuitarAccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contadorAcciones == 1) {
                	scrollPane.setVisible(false);
                    panelAcRealizada1.setVisible(false);
                    contadorAcciones = 0;
                } 
            }
        });
    }
}