package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.users.DAO.ChangePasswordDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

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
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void changePassword()
	{
		String userid = usrid.getText();
		String password = new String(passwordField.getPassword());
		
		ChangePasswordDAO cpd = new ChangePasswordDAO();
		try {
			cpd.changePass(userid, password);
			AdminView adminview =  new AdminView();
			adminview.setExtendedState(MAXIMIZED_BOTH);
			adminview.setVisible(true);
			this.setVisible(false);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 250, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usrid = new JTextField();
		usrid.setBounds(118, 48, 190, 20);
		contentPane.add(usrid);
		usrid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setBounds(30, 51, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 84, 101, 17);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 82, 190, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		btnNewButton.setBounds(48, 135, 147, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Change Your Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(122, 11, 167, 14);
		contentPane.add(lblNewLabel_1);
	}
}
