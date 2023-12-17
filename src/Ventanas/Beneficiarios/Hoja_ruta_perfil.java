package Ventanas.Beneficiarios;



import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hoja_ruta_perfil extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JTextField txtAsignacion;
    private JTextField textField;
    private JTextField txtFechaAtencion;
    private JTextField textField_1;
    private int contadorAcciones;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hoja_ruta_perfil frame = new Hoja_ruta_perfil();
                    frame.setTitle("Hoja de ruta P.M.H.");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Hoja_ruta_perfil() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Hoja_ruta_perfil.class.getResource("/imagenes_help/iconCaritas.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        imagenCaritas.setIcon(new ImageIcon(Hoja_ruta_perfil.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setBackground(new Color(23, 74, 131));
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        btnPerfil.setBackground(Color.WHITE);
        ImageIcon iconOriginal = new ImageIcon(Hoja_ruta_perfil.class.getResource("/imagenes_help/perfilpersona.png"));
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

        String s = "Nombre persona 1\nNombre persona dos "; // Deberían ser los nombres de las personas ingresadas en la hoja de registro.
        JTextArea txtNombresBenef = new JTextArea();
        txtNombresBenef.setEditable(false);
        txtNombresBenef.setWrapStyleWord(true);
        txtNombresBenef.setLineWrap(false);
        txtNombresBenef.setText(s);
        JScrollPane scrollNombres = new JScrollPane(txtNombresBenef); // Por si son muchos nombres de personas
        scrollNombres.setBounds(63, 187, 343, 289);
        panelLlenado.add(scrollNombres);

        int personas = 2; // Debería ser la misma ingresada en la hoja de registro (no se debería volver a llenar)
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

        JTextArea txtObservaciones = new JTextArea();
        txtObservaciones.setEditable(false);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);

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
        panelLlenado.add(panelAcRealizada1);
        panelAcRealizada1.setLayout(null);
        
        JLabel lblFechaAccion = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion.setBounds(27, 25, 119, 14);
        panelAcRealizada1.add(lblFechaAccion);
        
        txtFechaAtencion = new JTextField();
        txtFechaAtencion.setEditable(false);
        txtFechaAtencion.setBounds(160, 22, 110, 20);
        panelAcRealizada1.add(txtFechaAtencion);
        txtFechaAtencion.setColumns(10);
        
        JLabel lblAccionRealizada = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada.setBounds(25, 50, 121, 14);
        panelAcRealizada1.add(lblAccionRealizada);
        
        JComboBox comboBoxAcciones = new JComboBox();
        comboBoxAcciones.setEnabled(false);
        comboBoxAcciones.setBounds(160, 53, 110, 22);
        panelAcRealizada1.add(comboBoxAcciones);
        
        JLabel lblDerivado = new JLabel("DERIVADO A:");
        lblDerivado.setBounds(317, 50, 110, 14);
        panelAcRealizada1.add(lblDerivado);
        
        JComboBox comboDerivados = new JComboBox();
        comboDerivados.setEnabled(false);
        comboDerivados.setBounds(412, 53, 110, 22);
        panelAcRealizada1.add(comboDerivados);
        
        JLabel lblInstruccion = new JLabel("INSTRUCCIÖN:");
        lblInstruccion.setBounds(27, 94, 119, 14);
        panelAcRealizada1.add(lblInstruccion);
        
        JLabel lblObservacionAccion = new JLabel("OBSERVACIONES:");
        lblObservacionAccion.setBounds(27, 152, 152, 14);
        panelAcRealizada1.add(lblObservacionAccion);
        
        JTextArea txtInstrucciones = new JTextArea();
        txtInstrucciones.setEditable(false);
        JScrollPane scrollInstrucciones = new JScrollPane(txtInstrucciones); // Por si son muchas observaciones
        scrollInstrucciones.setBounds(133, 94, 294, 48);
        panelAcRealizada1.add( scrollInstrucciones);
        
        JTextArea txtObservacionAccion = new JTextArea();
        JScrollPane scrollObservacionesAccion = new JScrollPane(txtObservacionAccion); // Por si son muchas observaciones
        scrollObservacionesAccion.setBounds(133, 165, 294, 48);
        panelAcRealizada1.add( scrollObservacionesAccion);
        
        JLabel lblAcciones = new JLabel("ACCIONES REALIZADAS");
        lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAcciones.setBounds(52, 498, 199, 14);
        panelLlenado.add(lblAcciones);
        
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
        panelLlenado.add(panelAcRealizada2);
        
        JLabel lblFechaAccion_1 = new JLabel("FECHA DE ATENCION:");
        lblFechaAccion_1.setBounds(27, 25, 119, 14);
        panelAcRealizada2.add(lblFechaAccion_1);
        
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(160, 22, 110, 20);
        panelAcRealizada2.add(textField_1);
        
        JLabel lblAccionRealizada_1 = new JLabel("ACCIÓN REALIZADA:");
        lblAccionRealizada_1.setBounds(25, 50, 121, 14);
        panelAcRealizada2.add(lblAccionRealizada_1);
        
        JComboBox comboBoxAcciones_1 = new JComboBox();
        comboBoxAcciones_1.setEnabled(false);
        comboBoxAcciones_1.setBounds(160, 53, 110, 22);
        panelAcRealizada2.add(comboBoxAcciones_1);
        
        JLabel lblDerivado_1 = new JLabel("DERIVADO A:");
        lblDerivado_1.setBounds(317, 50, 110, 14);
        panelAcRealizada2.add(lblDerivado_1);
        
        JComboBox comboDerivados_1 = new JComboBox();
        comboDerivados_1.setEnabled(false);
        comboDerivados_1.setBounds(412, 53, 110, 22);
        panelAcRealizada2.add(comboDerivados_1);
        
        JLabel lblInstruccion_1 = new JLabel("INSTRUCCIÖN:");
        lblInstruccion_1.setBounds(27, 94, 119, 14);
        panelAcRealizada2.add(lblInstruccion_1);
        
        JLabel lblObservacionAccion_1 = new JLabel("OBSERVACIONES:");
        lblObservacionAccion_1.setBounds(27, 152, 152, 14);
        panelAcRealizada2.add(lblObservacionAccion_1);
        
        
        JTextArea txtInstrucciones2 = new JTextArea();
        txtInstrucciones2.setEditable(false);
        JScrollPane scrollInstrucciones_1 = new JScrollPane(txtInstrucciones2 );
        scrollInstrucciones_1.setBounds(133, 94, 294, 48);
        panelAcRealizada2.add(scrollInstrucciones_1);
        
        JTextArea txtObservacionAccion2 = new JTextArea();
        txtObservacionAccion2.setEditable(false);
        JScrollPane scrollObservacionesAccion_1 = new JScrollPane( txtObservacionAccion2 );
        scrollObservacionesAccion_1.setBounds(133, 165, 294, 48);
        panelAcRealizada2.add(scrollObservacionesAccion_1);
        contadorAcciones = 0;
    }
}
