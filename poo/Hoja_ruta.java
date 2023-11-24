package poo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Hoja_ruta extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JTextField txtAsignacion;
    private JTextField textFieldFechaAsigacion;
    private int cod;
    private boolean isRegistrado=false;
    public Hoja_ruta() {
		

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        ImageIcon iconOriginal = new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/perfilpersona.png"));
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnPerfil.setIcon(iconRedimensionadoPerfil);
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
        try {
			 cod=Conexion.ultimoNumero();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);
        txtNumero.setText(cod+"");
        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);
        txtFecha.setText(LocalDate.now()+"");
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

        int personas = Main.getUltimoForm().getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(436, 41, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setSelected(true);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);

        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setSelected(true);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);

        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textFieldFechaAsigacion = new JTextField();
        textFieldFechaAsigacion.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textFieldFechaAsigacion);
        textFieldFechaAsigacion.setColumns(10);

        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones = new JTextArea();
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);

        JButton btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Hoja_de_ruta hj=null;
        		if(!txtNombresBenef.getText().equals("")&&!txtObservaciones.getText().equals("")) {
        			if(!txtAsignacion.getText().equals("") ||!textFieldFechaAsigacion.getText().equals("") ) {
        				if(!textFieldFechaAsigacion.getText().equals("")&&!txtAsignacion.getText().equals("")) {
                    		hj=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(), txtAsignacion.getText(),Extras.fechas(textFieldFechaAsigacion.getText()),Main.getUltimoForm(),true);

        				}else {
                			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos de asignacion");

        				}
        			}else {
                		hj=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(),Main.getUltimoForm(),true);

        			}

        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        		try {
					Conexion.registrarHojaDeRuta(hj);
	        		isRegistrado=true;

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			JOptionPane.showMessageDialog(null, "Registro Exitoso");
        		Main.setUltimaHojar(hj);
        	}
        });
        btnRegistrar.setBounds(1390, 460, 117, 29);
        panelLlenado.add(btnRegistrar);

        JButton btnImprimir = new JButton("IMPRIMIR");
        btnImprimir.setBounds(1136, 460, 117, 29);
        btnImprimir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        panelLlenado.add(btnImprimir);
        
        JButton btnAcciones = new JButton("ACCIONES");
        btnAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!isRegistrado) {
        			Hoja_de_ruta hj=null;
            		if(!txtNombresBenef.getText().equals("")&&!txtObservaciones.getText().equals("")) {
            			if(!txtAsignacion.getText().equals("") ||!textFieldFechaAsigacion.getText().equals("") ) {
            				if(!textFieldFechaAsigacion.getText().equals("")&&!txtAsignacion.getText().equals("")) {
                        		hj=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(), txtAsignacion.getText(),Extras.fechas(textFieldFechaAsigacion.getText()),Main.getUltimoForm(),true);

            				}else {
                    			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos de asignacion");

            				}
            			}else {
                    		hj=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(),Main.getUltimoForm(),true);

            			}

            		}else {
            			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            		}
            		try {
    					Conexion.registrarHojaDeRuta(hj);
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            		Main.setUltimaHojar(hj);
        		}
        		Hoja_ruta_acciones jhr=new Hoja_ruta_acciones();
        		jhr.setVisible(true);
        		dispose();
        	}
        });
        btnAcciones.setBounds(1263, 460, 117, 29);
        panelLlenado.add(btnAcciones);
        // Hacer que la ventana se abra en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public Hoja_ruta(Hoja_de_ruta hj) {
		

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        ImageIcon iconOriginal = new ImageIcon(Hoja_ruta.class.getResource("/imagenes_help/perfilpersona.png"));
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnPerfil.setIcon(iconRedimensionadoPerfil);
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
        try {
			 cod=Conexion.ultimoNumero();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);
        txtNumero.setText(cod+"");
        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        txtFecha.setBounds(189, 73, 130, 26);
        panelLlenado.add(txtFecha);
        txtFecha.setColumns(10);
        txtFecha.setText(LocalDate.now()+"");
        JLabel lblCantPesonas = new JLabel("Número de personas:");
        lblCantPesonas.setBounds(52, 117, 134, 16);
        panelLlenado.add(lblCantPesonas);

        JLabel lblNombresPersonas = new JLabel("Nombre(s) Apellidos:");
        lblNombresPersonas.setBounds(52, 158, 134, 16);
        panelLlenado.add(lblNombresPersonas);
        FormlarioRegistro fm=hj.getForm();
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

        int personas = hj.getForm().getFam().getCantidad(); // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
        
        String cantidadPersonasRegistro = Integer.toString(personas);
        JLabel lblNumeroPersonas = new JLabel(cantidadPersonasRegistro);
        lblNumeroPersonas.setBounds(190, 117, 61, 16);
        panelLlenado.add(lblNumeroPersonas);

        JPanel panelAsesoramientos = new JPanel();
        panelAsesoramientos.setBounds(436, 41, 1084, 409);
        panelLlenado.add(panelAsesoramientos);
        panelAsesoramientos.setLayout(null);

        JCheckBox chckbxAseLegal = new JCheckBox("ASESORAMIENTO LEGAL");
        chckbxAseLegal.setSelected(true);
        chckbxAseLegal.setBounds(23, 16, 182, 23);
        panelAsesoramientos.add(chckbxAseLegal);

        JCheckBox chckbxSoliRefugio = new JCheckBox("SOLICITUD DE REFUGIO");
        chckbxSoliRefugio.setBounds(380, 16, 208, 23);
        panelAsesoramientos.add(chckbxSoliRefugio);

        JCheckBox chckbxAtenSocial = new JCheckBox("SOLO ATENCIÓN SOCIAL");
        chckbxAtenSocial.setBounds(786, 16, 208, 23);
        panelAsesoramientos.add(chckbxAtenSocial);

        JLabel lblAreaSocial = new JLabel("SE SOLICITA AL ÁREA SOCIAL ANALIZAR LA POSIBILIDAD DE:");
        lblAreaSocial.setBounds(23, 79, 649, 16);
        panelAsesoramientos.add(lblAreaSocial);

        JCheckBox chckbxAlbergue = new JCheckBox("ALBERGUE");
        chckbxAlbergue.setSelected(true);
        chckbxAlbergue.setBounds(23, 122, 128, 23);
        panelAsesoramientos.add(chckbxAlbergue);

        JCheckBox chckbxServiciosMedicos = new JCheckBox("SERVICIOS MÉDICOS");
        chckbxServiciosMedicos.setBounds(380, 122, 182, 23);
        panelAsesoramientos.add(chckbxServiciosMedicos);

        JCheckBox chckbxAimentacion = new JCheckBox("ALIMENTACIÓN");
        chckbxAimentacion.setBounds(786, 122, 147, 23);
        panelAsesoramientos.add(chckbxAimentacion);

        JCheckBox chckbxAyudaHumanitaria = new JCheckBox("AYUDA HUMANITARIA");
        chckbxAyudaHumanitaria.setBounds(23, 172, 257, 23);
        panelAsesoramientos.add(chckbxAyudaHumanitaria);

        JCheckBox chckbxPasajes = new JCheckBox("PASAJES");
        chckbxPasajes.setBounds(380, 172, 128, 23);
        panelAsesoramientos.add(chckbxPasajes);

        JCheckBox chckbxInfCondonación = new JCheckBox("INF. CONDONACIÓN");
        chckbxInfCondonación.setBounds(786, 172, 208, 23);
        panelAsesoramientos.add(chckbxInfCondonación);

        JLabel lblAsignacion = new JLabel("ASIGNACIÓN");
        lblAsignacion.setBounds(23, 238, 97, 16);
        panelAsesoramientos.add(lblAsignacion);

        txtAsignacion = new JTextField();
        txtAsignacion.setBounds(132, 233, 166, 26);
        panelAsesoramientos.add(txtAsignacion);
        txtAsignacion.setColumns(10);

        JLabel lblFechaAsignacion = new JLabel("FECHA");
        lblFechaAsignacion.setBounds(380, 238, 61, 16);
        panelAsesoramientos.add(lblFechaAsignacion);

        textFieldFechaAsigacion = new JTextField();
        textFieldFechaAsigacion.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textFieldFechaAsigacion);
        textFieldFechaAsigacion.setColumns(10);

        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones = new JTextArea();
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);

        JButton btnRegistrar = new JButton("ACTUALIZAR");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Hoja_de_ruta hjn=null;
        		if(!txtNombresBenef.getText().equals("")&&!txtObservaciones.getText().equals("")) {
        			if(!txtAsignacion.getText().equals("") ||!textFieldFechaAsigacion.getText().equals("") ) {
        				if(!textFieldFechaAsigacion.getText().equals("")&&!txtAsignacion.getText().equals("")) {
                    		hjn=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(), txtAsignacion.getText(),Extras.fechas(textFieldFechaAsigacion.getText()),Main.getUltimoForm(),true);

        				}else {
                			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos de asignacion");

        				}
        			}else {
                		hjn=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(),Main.getUltimoForm(),true);

        			}
        			try {
    					Conexion.actualizarHojaDeRuta(hjn,hj);
    	        		isRegistrado=true;

    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        		}else {
        			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        		}
        		
        		dispose();
        	}
        });
        btnRegistrar.setBounds(1390, 460, 117, 29);
        panelLlenado.add(btnRegistrar);
        JButton btnAcciones = new JButton("ACCIONES");
        btnAcciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        			Hoja_de_ruta hjn=null;
            		if(!txtNombresBenef.getText().equals("")&&!txtObservaciones.getText().equals("")) {
            			if(!txtAsignacion.getText().equals("") ||!textFieldFechaAsigacion.getText().equals("") ) {
            				if(!textFieldFechaAsigacion.getText().equals("")&&!txtAsignacion.getText().equals("")) {
                        		hjn=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(), txtAsignacion.getText(),Extras.fechas(textFieldFechaAsigacion.getText()),Main.getUltimoForm(),true);

            				}else {
                    			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos de asignacion");

            				}
            			}else {
                    		hjn=new Hoja_de_ruta(cod, txtNumero.getText(), personas, txtObservaciones.getText(), chckbxAseLegal.isSelected(), chckbxSoliRefugio.isSelected(), chckbxAtenSocial.isSelected(), chckbxAlbergue.isSelected(), chckbxServiciosMedicos.isSelected(), chckbxAimentacion.isSelected(), chckbxAyudaHumanitaria.isSelected(), chckbxPasajes.isSelected(), chckbxInfCondonación.isSelected(),Main.getUltimoForm(),true);

            			}

            		}else {
            			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            		}
            		hjn.setCfhd(hj.getCfhd());
            		Main.setUltimaHojar(hjn);
            		try {
    					Conexion.actualizarHojaDeRuta(hjn,hj);
    	        		isRegistrado=true;

    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            		Hoja_ruta_acciones jhr=new Hoja_ruta_acciones();
            		jhr.setVisible(true);
            		dispose();
        	
        		
        	}
        });
        btnAcciones.setBounds(1263, 460, 117, 29);
        panelLlenado.add(btnAcciones);
        JButton btnImprimir = new JButton("IMPRIMIR");
        btnImprimir.setBounds(1136, 460, 117, 29);
        panelLlenado.add(btnImprimir);
        
    
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
        textFieldFechaAsigacion.setText(hj.getFechaAsig()+"");
        txtObservaciones.setText(hj.getObs());
        // Hacer que la ventana se abra en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}