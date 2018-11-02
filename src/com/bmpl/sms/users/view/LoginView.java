package com.bmpl.sms.users.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.bmpl.sms.test.DashBoard;
import com.bmpl.sms.users.UserDAO.UserDAO;
import com.bmpl.sms.users.UserDTO.UserDTO;
import java.awt.SystemColor;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usrid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
    //method to pass the entered login details to the userdao on the click of the loginbutton.
	private void checkLogin() {
		String userid = usrid.getText();
		String password = new String(passwordField.getPassword());
		
		UserDAO userDAO = new UserDAO();
		try {
			
		UserDTO userdto = userDAO.doLogin(userid, password);
		
		
		if(userdto != null)
		{

			if(userdto.isChecklogin())
			{
				ChangePassword changepass = new ChangePassword();
				changepass.setVisible(true);
//				System.out.println("change your password");
			}
			else {
			JOptionPane.showMessageDialog(this, "login Successfully", "login", JOptionPane.INFORMATION_MESSAGE);
			AdminView adminview =  new AdminView();
			adminview.setVisible(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "login fail", "login", JOptionPane.INFORMATION_MESSAGE);
		}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Login View");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 633, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 617, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login ");
		lblUserLogin.setForeground(SystemColor.textHighlight);
		lblUserLogin.setBounds(386, 34, 230, 48);
		panel.add(lblUserLogin);
		lblUserLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(295, 208, 97, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		usrid = new JTextField();
		usrid.setBounds(295, 151, 279, 34);
		panel.add(usrid);
		usrid.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(367, 328, 165, 34);
		panel.add(btnNewButton);
		
		JLabel lblUserid = new JLabel("USERNAME");
		lblUserid.setBounds(295, 119, 97, 14);
		panel.add(lblUserid);
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(295, 238, 279, 34);
		panel.add(passwordField);
		
		JLabel securitylogo = new JLabel("");
		securitylogo.setIcon(new ImageIcon(LoginView.class.getResource("/images/icons8-protect-48.png")));
		securitylogo.setBounds(304, 34, 48, 48);
		panel.add(securitylogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/img3.jpeg")));
		lblNewLabel.setBounds(0, 0, 285, 429);
		panel.add(lblNewLabel);

		ImageIcon img = new ImageIcon((LoginView.class.getResource("/images/loginwall2.jpg")));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUserLogin, lblPassword, usrid, btnNewButton, lblUserid, passwordField, securitylogo}));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
	}
}
