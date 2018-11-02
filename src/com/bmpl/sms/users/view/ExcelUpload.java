package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.CommonGenricDAO.CommonGenricDAO;
import com.bmpl.sms.CommonGenricDTO.CommonGenricDTO;
import com.bmpl.sms.utils.ExcelReader;

public class ExcelUpload extends JFrame {

	private JPanel contentPane;
	private String browsepath;
	
	public String getBrowsepath() {
		return browsepath;
	}

	public void setBrowsepath(String browsepath) {
		this.browsepath = browsepath;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcelUpload frame = new ExcelUpload();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel lblNewLabel = new JLabel("");
	
	
	//to upload the selected excel file from the dialog box to database.
	private void upload() throws IOException, ClassNotFoundException, SQLException
	{
		ArrayList<CommonGenricDTO> exceldata = ExcelReader.readExcel(browsepath);
		CommonGenricDAO dao = new CommonGenricDAO();
		
		boolean isupload = dao.isUploaded(exceldata);
		String msg = isupload?"Uploade successfully....":"Note Uploaded...";
		JOptionPane.showMessageDialog(this, msg, "Upload", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	JButton btnNewButton = new JButton("Upload");
	
	//to choose the excel file from the opened dialog box.
	private void browse()
	{
		
		JFileChooser jchooser = new JFileChooser();
		jchooser.showOpenDialog(this);
		
		try {
			
		File file = jchooser.getSelectedFile();
		browsepath = file.getAbsolutePath();
		
		lblNewLabel.setText(browsepath);
		if(browsepath.trim().length()>0)
		{
			btnNewButton.setEnabled(true);
		}
		
		
		}catch(Exception e) {
			e.fillInStackTrace();
		}
		
	}
	
	
	//to ask the user whether the user want to exit or not.
	private void asktoClose()
	{
		int cnfrm = JOptionPane.showConfirmDialog(this, "Do you want to close", "Upload", JOptionPane.YES_NO_OPTION);
		if(cnfrm == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			this.dispose();
		}
	}
	/**
	 * Create the frame.
	 */
	public ExcelUpload() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				asktoClose();
			}
			
		});
		setTitle("ExcelUpload");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					upload();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(315, 228, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		
		lblNewLabel.setBounds(145, 105, 206, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Browse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browse();
			}
		});
		btnNewButton_1.setBounds(31, 105, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Browse and select the the Excel file  :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(20, 32, 304, 23);
		contentPane.add(lblNewLabel_1);
	}
}
