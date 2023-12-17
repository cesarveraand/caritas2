package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class BusquedaRefugiado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDatoABuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaRefugiado frame = new BusquedaRefugiado();
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
	public BusquedaRefugiado() {
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
        imagenCaritas.setIcon(new ImageIcon(BusquedaRefugiado.class.getResource("/imagenes_help/caritas-bolivia.png")));
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);

        JButton btnPerfil = new JButton("");
        ImageIcon iconOriginal = new ImageIcon(BusquedaRefugiado.class.getResource("/imagenes_help/perfilpersona.png"));
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1896, 205);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Ingrese el dato a buscar:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(20, 100, 282, 30);
        panel_1.add(lblNewLabel);
        
        txtDatoABuscar = new JTextField();
        txtDatoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        txtDatoABuscar.setText("Dato a Buscar");
        txtDatoABuscar.setBounds(20, 141, 1277, 32);
        panel_1.add(txtDatoABuscar);
        txtDatoABuscar.setColumns(10);
        
        JLabel lblSedatoABuscar = new JLabel("Seleccione el tipo de dato:");
        lblSedatoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSedatoABuscar.setBounds(20, 21, 305, 30);
        panel_1.add(lblSedatoABuscar);
        
        JButton btnNewButton = new JButton("Buscar ");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton.setBounds(1362, 138, 170, 39);
        panel_1.add(btnNewButton);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton(" Nombre");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton.setBounds(314, 60, 159, 35);
        panel_1.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(" Apellido");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton_1.setBounds(536, 60, 159, 35);
        panel_1.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnCi = new JRadioButton(" C.I.");
        rdbtnCi.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnCi.setBounds(759, 60, 127, 35);
        panel_1.add(rdbtnCi);
        
        JRadioButton rdbtnNHojaDe = new JRadioButton("# Hoja de ruta");
        rdbtnNHojaDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNHojaDe.setBounds(920, 60, 208, 35);
        panel_1.add(rdbtnNHojaDe);
        
        JRadioButton rdbtnPais = new JRadioButton("Pais");
        rdbtnPais.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnPais.setBounds(1178, 60, 99, 35);
        panel_1.add(rdbtnPais);
        
     // Agrupar los JRadioButtons para permitir solo una selección
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton_1);
        buttonGroup.add(rdbtnCi);
        buttonGroup.add(rdbtnNHojaDe);
        buttonGroup.add(rdbtnPais);

        // Agregar ActionListener a los JRadioButtons
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    txtDatoABuscar.setText("Buscando por Nombre");
                }
            }
        });

        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton_1.isSelected()) {
                    txtDatoABuscar.setText("Buscando por Apellido");
                }
            }
        });

        rdbtnCi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnCi.isSelected()) {
                    txtDatoABuscar.setText("Buscando por C.I.");
                }
            }
        });

        rdbtnNHojaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNHojaDe.isSelected()) {
                    txtDatoABuscar.setText("Buscando por Número de Hoja de Ruta");
                }
            }
        });

        rdbtnPais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnPais.isSelected()) {
                    txtDatoABuscar.setText("Buscando por País");
                }
            }
        });
        

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 204, 1896, 590);
        panel_2.setLayout(new BorderLayout()); // Cambio de layout a BorderLayout
        panel.add(panel_2);

        JPanel panelTarjetas = new JPanel();
        panelTarjetas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Espacio entre tarjetas
        panel_2.add(new JScrollPane(panelTarjetas), BorderLayout.CENTER); // Agregar un JScrollPane con el panel de tarjetas

		
		List<Voluntariod> listaVoluntarios = new ArrayList<>();

		// Simulación de datos para cinco voluntarios
		Voluntariod voluntario1 = new Voluntariod("Juan Pérez", "12345", "Bolivia", 1001);
		Voluntariod voluntario2 = new Voluntariod("María García", "67890", "Argentina", 1002);
		Voluntariod voluntario3 = new Voluntariod("Pedro López", "54321", "Chile", 1003);
		Voluntariod voluntario4 = new Voluntariod("Ana Rodríguez", "98765", "Perú", 1004);
		Voluntariod voluntario5 = new Voluntariod("Luis Martínez", "13579", "Colombia", 1005);
		Voluntariod voluntario6 = new Voluntariod("Carolina Sánchez", "24680", "Venezuela", 1006);
		Voluntariod voluntario7 = new Voluntariod("Diego González", "10101", "Uruguay", 1007);
		Voluntariod voluntario8 = new Voluntariod("Laura Fernandez", "11223", "Paraguay", 1008);
		Voluntariod voluntario9 = new Voluntariod("Sofía Ramirez", "33221", "Ecuador", 1009);
		Voluntariod voluntario10 = new Voluntariod("Mateo Herrera", "55789", "Brasil", 1010);
	
		// Agregar los voluntarios a la lista
		listaVoluntarios.add(voluntario1);
		listaVoluntarios.add(voluntario2);
		listaVoluntarios.add(voluntario3);
		listaVoluntarios.add(voluntario4);
		listaVoluntarios.add(voluntario5);
		listaVoluntarios.add(voluntario6);
		listaVoluntarios.add(voluntario7);
		listaVoluntarios.add(voluntario8);
		listaVoluntarios.add(voluntario9);
		listaVoluntarios.add(voluntario10);

		panelTarjetas.setLayout(new GridLayout(0, 4, 10, 10)); // 4 tarjetas por fila con 10 de espacio entre ellas

		for (Voluntariod voluntario : listaVoluntarios) {
		    JButton buttonVoluntario = new JButton();
		    buttonVoluntario.setLayout(new BorderLayout()); // Diseño para cada "tarjeta"

		    ImageIcon iconPerfil = new ImageIcon(BusquedaRefugiado.class.getResource("/imagenes_help/perfilpersona.png"));
		    JLabel labelImagen = new JLabel(iconPerfil);
		    buttonVoluntario.add(labelImagen, BorderLayout.WEST);

		    JPanel panelDetalles = new JPanel();
		    panelDetalles.setLayout(new GridLayout(0, 1)); // Diseño para los detalles del voluntario

		    JLabel labelNombre = new JLabel("Nombre: " + voluntario.getNombre());
		    JLabel labelCI = new JLabel("C.I.: " + voluntario.getCI());
		    JLabel labelPais = new JLabel("País: " + voluntario.getPais());
		    JLabel labelHojaRuta = new JLabel("N° de Hoja de Ruta: " + voluntario.getNumeroHojaRuta());

		    panelDetalles.add(labelNombre);
		    panelDetalles.add(labelCI);
		    panelDetalles.add(labelPais);
		    panelDetalles.add(labelHojaRuta);

		    buttonVoluntario.add(panelDetalles, BorderLayout.CENTER); // Agregar detalles a la derecha

			    buttonVoluntario.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para los botones
			 //OJO
			    
			    
			    //OJOOOOOOOOOOOOOOOOOOO ESTO SOLO ES PARA VERIFIACR QUE TE LLEVEN A ALGUN LADO LAS TARJETAS SDOIUHFSIHODDFHIOSADFIOJI
			    
			    
			    // Agregar ActionListener para cerrar la ventana al presionar cualquier botón
			    buttonVoluntario.addActionListener(e -> {
			        JFrame frame = (JFrame) SwingUtilities.getRoot(buttonVoluntario);
			        frame.dispose();
			    });
			    
			    //FIIIIIIIIIIIIINNNNNNNNNNNNNNNNNNNNNNN
		    panelTarjetas.add(buttonVoluntario); // Agregar el botón al panel de tarjetas
		}

		JScrollPane scrollPane = new JScrollPane(panelTarjetas);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Desplazamiento vertical
		panel_2.add(scrollPane, BorderLayout.CENTER);

	}
}