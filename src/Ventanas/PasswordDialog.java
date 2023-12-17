package Ventanas;




import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class PasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JPasswordField passwordField;
    private boolean isPasswordCorrect = false;
	public static void main(String[] args) {
		try {
			PasswordDialog dialog = new PasswordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PasswordDialog() {
		getContentPane().setBackground(new Color(23, 74, 131));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PasswordDialog.class.getResource("/imagenes_help/iconCaritas.png")));
        setTitle("Ingrese la contraseña de administrador");
        setModal(true);
        setBounds(100, 100, 400, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBackground(new Color(255, 255, 255));
        lblPassword.setBounds(20, 43, 100, 30);
        getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(121, 43, 241, 30);
        getContentPane().add(passwordField);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(new Color(255, 255, 255));
        btnAceptar.setBounds(139, 98, 100, 30);
        getContentPane().add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                String enteredPassword = new String(password);
                isPasswordCorrect = enteredPassword.equals("tu_contrasena"); // Cambia 'tu_contrasena' por la contraseña real

                dispose();
            }
        });
    }

    public boolean isPasswordCorrect() {
        return isPasswordCorrect;
    }
}









