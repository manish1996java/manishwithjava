package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bmpl.sms.users.DAO.UserRoleDAO;
import com.bmpl.sms.users.DTO.UserRoleDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void userRoleRowdata()
	{
		UserRoleDAO urdao = new UserRoleDAO();
		try {
			ArrayList<UserRoleDTO> list = urdao.userRole();
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			String[] rowData = new String[2];
			
			for(int i=0;i<list.size();i++){
				rowData[0] = list.get(i).getUser();
				rowData[1] = list.get(i).getRole();
				dtm.addRow(rowData);
			}
			
			
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
	public AdminView() {
		setTitle("AdminView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 593);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("About");
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 214, 1021, 309);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User", "role"
			}
		));
		table.setBounds(10, 11, 850, 229);
//		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 996, 229);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnAdduser = new JButton("AddUser");
		btnAdduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser adduser = new AddUser();
				adduser.setVisible(true);
			}
		});
		btnAdduser.setBounds(903, 11, 89, 23);
		panel.add(btnAdduser);
		
		JButton btnNewButton_1 = new JButton("Enable");
		btnNewButton_1.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnDesable = new JButton("Disable");
		btnDesable.setBounds(111, 11, 89, 23);
		panel.add(btnDesable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setToolTipText("");
		panel_5.setBounds(10, 58, 207, 152);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(31, 28, 143, 23);
		panel_5.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(31, 54, 143, 23);
		panel_5.add(btnEdit);
		
		JButton btnDelete = new JButton("Clear");
		btnDelete.setBounds(31, 79, 143, 23);
		panel_5.add(btnDelete);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(31, 105, 143, 23);
		panel_5.add(btnDelete_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setToolTipText("");
		panel_6.setBounds(227, 58, 433, 152);
		contentPane.add(panel_6);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(795, 187, 89, 23);
		contentPane.add(btnNext);
		userRoleRowdata();
	}
}
