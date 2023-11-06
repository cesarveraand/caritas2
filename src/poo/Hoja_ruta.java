package poo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Hoja_ruta extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JTextField txtAsignacion;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hoja_ruta frame = new Hoja_ruta();
                    frame.setTitle("Hoja de ruta P.M.H.");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Hoja_ruta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        txtNumero = new JTextField();
        txtNumero.setBounds(189, 36, 130, 26);
        panelLlenado.add(txtNumero);
        txtNumero.setColumns(10);

        txtFecha = new JTextField();
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

        textField = new JTextField();
        textField.setBounds(453, 233, 130, 26);
        panelAsesoramientos.add(textField);
        textField.setColumns(10);

        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        lblObservaciones.setBounds(23, 284, 139, 16);
        panelAsesoramientos.add(lblObservaciones);

        JTextArea txtObservaciones = new JTextArea();
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones); // Por si son muchas observaciones
        scrollObservaciones.setBounds(23, 316, 1025, 71);
        panelAsesoramientos.add(scrollObservaciones);

        JButton btnRegistrar = new JButton("REGISTRAR");
        btnRegistrar.setBounds(1555, 468, 117, 29);
        panelLlenado.add(btnRegistrar);

        JButton btnImprimir = new JButton("IMPRIMIR");
        btnImprimir.setBounds(1426, 468, 117, 29);
        panelLlenado.add(btnImprimir);
    }
}