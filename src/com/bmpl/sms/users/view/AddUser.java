package com.bmpl.sms.users.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser extends JWindow {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 430, 304, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(119, 32, 153, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 75, 153, 27);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setBounds(97, 136, 62, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTeacher = new JRadioButton("teacher");
		rdbtnTeacher.setBounds(161, 136, 75, 23);
		contentPane.add(rdbtnTeacher);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserid.setBounds(21, 38, 55, 21);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(21, 81, 67, 21);
		contentPane.add(lblPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRole.setBounds(21, 135, 67, 21);
		contentPane.add(lblRole);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCreate.setBounds(63, 200, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(161, 200, 89, 23);
		contentPane.add(btnBack);
	}
}
