package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

import negozioLogika.Login;
import negozioLogika.Login1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Aurkezpena3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private  ButtonGroup buttonGroup = new ButtonGroup();
	private Login negozioLogika;
	private JPasswordField pwdPassword;
	private JButton btnSistemanSartu;
	private JTextArea textArea;
	private DefaultListModel erabiltzaileak = new DefaultListModel();
	private JList list;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aurkezpena frame = new Aurkezpena();
					Login1 nl=new Login1();
					frame.setNeogozioLogica(nl);
					
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
	public Aurkezpena3() {
		setTitle("Erabilpen kasua: Login egin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setText("login");
		txtLogin.setBounds(233, 23, 134, 28);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblErabiltzaileIzenaSartu = new JLabel("Erabiltzaile izena sartu");
		lblErabiltzaileIzenaSartu.setBounds(50, 29, 165, 16);
		contentPane.add(lblErabiltzaileIzenaSartu);
		
		JLabel lblPasahitzaSartu = new JLabel("Pasahitza sartu");
		lblPasahitzaSartu.setBounds(50, 72, 145, 16);
		contentPane.add(lblPasahitzaSartu);
		
		JLabel lblErabiltzaileMotaAukeratu = new JLabel("Erabiltzaile mota aukeratu");
		lblErabiltzaileMotaAukeratu.setBounds(30, 118, 165, 16);
		contentPane.add(lblErabiltzaileMotaAukeratu);
		
		btnSistemanSartu = new JButton("Sisteman sartu");
		btnSistemanSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String izena=txtLogin.getText();
				String pass=new String(pwdPassword.getPassword());
				String mota=list.getSelectedValue().toString();
				
				boolean b=negozioLogika.loginEgin(izena, pass, mota);
				if (b) textArea.setText("Aurrera");
				else textArea.setText("Errorea");
				 
			}
		});
		btnSistemanSartu.setBounds(178, 158, 117, 29);
		contentPane.add(btnSistemanSartu);
		
		textArea = new JTextArea();
		textArea.setBounds(94, 199, 290, 55);
		contentPane.add(textArea);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setBounds(233, 66, 134, 28);
		contentPane.add(pwdPassword);
		
		list = new JList();
		list.setBounds(246, 118, 117, 37);
		contentPane.add(list);
		list.setModel(erabiltzaileak);
		erabiltzaileak.addElement("Ikaslea");
		erabiltzaileak.addElement("Irakaslea");

	}
	public void setNeogozioLogica (Login nl){
		negozioLogika=nl;
	}
}

