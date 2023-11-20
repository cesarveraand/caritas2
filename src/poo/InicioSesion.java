package poo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCI;
    private JPasswordField passwordField;
    private JToggleButton toggleButtonMostrarContrasena;

    public InicioSesion() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 571, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        textFieldCI = new JTextField();
        textFieldCI.setBounds(160, 145, 220, 19);
        contentPane.add(textFieldCI);
        textFieldCI.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(163, 197, 160, 19);
        contentPane.add(passwordField);

        toggleButtonMostrarContrasena = new JToggleButton("Mostrar");
        toggleButtonMostrarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (toggleButtonMostrarContrasena.isSelected()) {
                    // Si está seleccionado, muestra el texto
                    passwordField.setEchoChar((char) 0);
                } else {
                    // Si no está seleccionado, oculta el texto
                    passwordField.setEchoChar('\u2022');
                }
            }
        });
        toggleButtonMostrarContrasena.setBounds(333, 196, 89, 21);
        contentPane.add(toggleButtonMostrarContrasena);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldCI.getText() != null && passwordField.getPassword() != null) {
                    String password = new String(passwordField.getPassword());
                    if (Main.ingresar(textFieldCI.getText(), password)) {
                        dispose();
                        if (Main.isAdmin()) {
                            PaginaUsuarioA pagA = new PaginaUsuarioA();
                            pagA.setVisible(true);
                        } else {
                            PaginaUsuarioV pagV = new PaginaUsuarioV();
                            pagV.setVisible(true);
                        }
                    } else {
                        // Muestra un mensaje de error si el inicio de sesión falla
                        JOptionPane.showMessageDialog(InicioSesion.this,
                                "Inicio de sesión inválido. Verifica tu CI y contraseña.", "Error de inicio de sesión",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnIngresar.setBounds(424, 270, 85, 21);
        contentPane.add(btnIngresar);

        JLabel lblCI = new JLabel("CI");
        lblCI.setBounds(85, 148, 45, 13);
        contentPane.add(lblCI);

        JLabel lblContrasena = new JLabel("Contraseña");
        lblContrasena.setBounds(85, 200, 69, 13);
        contentPane.add(lblContrasena);
    }
}
