package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.users.DAO.StudentDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentEnquiryView extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField fname;
	private JTextField address;
	private JTextField phoneno;
	private JTextField email;
	private JTextField intcourse;
	private JTextField batchtime;
	private JTextField clgName;
	private JTextField counselorName;
	private JDateChooser date; 
	private JDateChooser dob;
	private String dayPref;
	private String occupation;
	private String aboutbmpl;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEnquiryView frame = new StudentEnquiryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void checkBlankFields()
	{
		
		if(name.getText() == "" && fname.getText() == "" && address.getText() == "" 
				&& phoneno.getText() == "" && email.getText() == "" && 
				batchtime.getText() == "" && intcourse.getText() == "" && 
				clgName.getText() == "" && counselorName.getText() == "" && 
				((JTextField)date.getDateEditor().getUiComponent()).getText() == "" &&
				((JTextField)dob.getDateEditor().getUiComponent()).getText() == "" ) { 
			JOptionPane.showMessageDialog(this,"please fill all the details", "Student inquary" ,JOptionPane.WARNING_MESSAGE );	
		}
		else {
			checkData();
		}
		
	}

	public void checkData()
	{
		String sname = name.getText();
		String faname = fname.getText();
		String addr = address.getText();
		String phone = phoneno.getText();
		String emailid = email.getText();
		String intrcourse = intcourse.getText();
		String prebatchtime = batchtime.getText();
		String colgName = clgName.getText();
		String counsName = counselorName.getText();
		String idate = ((JTextField)date.getDateEditor().getUiComponent()).getText();
		String sdob = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
//		Date idate = date.getDate();
		System.out.println(idate);
//		Date sdob = date.getDate();
		System.out.println(sdob);
		StudentDAO stdao = new StudentDAO();
		try {
			stdao.updateStudInfo(sname,faname,addr,phone,emailid,intrcourse,prebatchtime,colgName,counsName,idate,sdob);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public void dayPrefCheckbox(){
//		String result="";
//		for()
//		
//	}
//	
//	public void occupationCheckbox() {
//		
//	}
//	
//	public void bmplCheckbox()
//	{
//		
//	}
	
	
	/**
	 * Create the frame.
	 */
	public StudentEnquiryView() {
		setTitle("StudentEnquiryView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 10, 708, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 90, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("father's Name");
		lblFathersName.setBounds(21, 127, 109, 14);
		contentPane.add(lblFathersName);
		
		JLabel lblCourseInterested = new JLabel("Course Interested");
		lblCourseInterested.setBounds(21, 292, 128, 14);
		contentPane.add(lblCourseInterested);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(21, 158, 85, 14);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(21, 193, 109, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(21, 228, 85, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("E-mail ID");
		lblEmail.setBounds(21, 259, 64, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(479, 90, 46, 14);
		contentPane.add(lblDate);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				int code = e.getKeyCode()
//				System.out.println(e.getKeyChar());
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					fname.requestFocus();
				}
			}
		});
		name.setFocusable(true);
		name.setBounds(186, 86, 224, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		fname = new JTextField();
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					address.requestFocus();
				}
			}
		});
		fname.setColumns(10);
		fname.setBounds(186, 123, 224, 20);
		contentPane.add(fname);
		
		address = new JTextField();
		address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					phoneno.requestFocus();
				}
				
			}
		});
		address.setColumns(10);
		address.setBounds(186, 154, 339, 20);
		contentPane.add(address);
		
		phoneno = new JTextField();
		phoneno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					email.requestFocus();
				}
				
			}
		});
		phoneno.setColumns(10);
		phoneno.setBounds(186, 224, 224, 20);
		contentPane.add(phoneno);
		
		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					intcourse.requestFocus();
				}
				
			}
		});
		email.setColumns(10);
		email.setBounds(186, 255, 224, 20);
		contentPane.add(email);
		
		JLabel lblBatchTimingsPreference = new JLabel("Batch Timings Preference");
		lblBatchTimingsPreference.setBounds(21, 327, 155, 14);
		contentPane.add(lblBatchTimingsPreference);
		
		intcourse = new JTextField();
		intcourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					batchtime.requestFocus();
				}
				
			}
		});
		intcourse.setColumns(10);
		intcourse.setBounds(186, 288, 224, 20);
		contentPane.add(intcourse);
		
		batchtime = new JTextField();
		batchtime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					clgName.requestFocus();
				}
			}
		});
		batchtime.setColumns(10);
		batchtime.setBounds(186, 323, 224, 20);
		contentPane.add(batchtime);
		
		clgName = new JTextField();
		clgName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					counselorName.requestFocus();
				}
			}
		});
		clgName.setColumns(10);
		clgName.setBounds(186, 439, 224, 20);
		contentPane.add(clgName);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Week Days (Mon-Fri)");
		chckbxNewCheckBox.setBounds(132, 364, 128, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxWeekendsatsun = new JCheckBox("Weekend(Sat-Sun)");
		chckbxWeekendsatsun.setBounds(262, 364, 128, 23);
		contentPane.add(chckbxWeekendsatsun);
		
//		if(chckbxNewCheckBox.isSelected())
//		{
//			dayPref += chckbxNewCheckBox.getText();
//			System.out.println(dayPref);
//		}
//		if(chckbxWeekendsatsun.isSelected())
//		{
//			dayPref += chckbxWeekendsatsun.getText();
//			System.out.println(dayPref);
//		}
		
		JLabel lblDaysPreference = new JLabel("Days Preference");
		lblDaysPreference.setBounds(21, 368, 128, 14);
		contentPane.add(lblDaysPreference);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(21, 406, 85, 14);
		contentPane.add(lblOccupation);
		
		JCheckBox chckbxNewsPaper = new JCheckBox("News Paper");
		chckbxNewsPaper.setBounds(21, 516, 92, 23);
		contentPane.add(chckbxNewsPaper);
		
		JCheckBox chckbxInternet = new JCheckBox("Internet");
		chckbxInternet.setBounds(132, 516, 85, 23);
		contentPane.add(chckbxInternet);
		
		JCheckBox chckbxFriend = new JCheckBox("Friend");
		chckbxFriend.setBounds(262, 516, 76, 23);
		contentPane.add(chckbxFriend);
		
		JLabel lblCollegeCompany = new JLabel("College / Company Name");
		lblCollegeCompany.setBounds(21, 442, 148, 14);
		contentPane.add(lblCollegeCompany);
		
		JLabel lblHowDoYou = new JLabel("How Do You Know about Brain mentores");
		lblHowDoYou.setBounds(21, 479, 218, 14);
		contentPane.add(lblHowDoYou);
		
		JCheckBox chckbxOthers = new JCheckBox("Adertisment");
		chckbxOthers.setBounds(359, 516, 85, 23);
		contentPane.add(chckbxOthers);
		
		JCheckBox checkBox = new JCheckBox("Others");
		checkBox.setBounds(479, 516, 85, 23);
		contentPane.add(checkBox);
		
		JLabel lblStudentEnquiry = new JLabel("Student Enquiry");
		lblStudentEnquiry.setFont(new Font("Arial", Font.BOLD, 18));
		lblStudentEnquiry.setBounds(262, 11, 148, 28);
		contentPane.add(lblStudentEnquiry);
		
		JButton submitbutton = new JButton("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBlankFields();
			}
		});
		
		submitbutton.setBounds(571, 643, 89, 23);
		contentPane.add(submitbutton);
		
		JCheckBox chckbxStudent = new JCheckBox("Student");
		chckbxStudent.setBounds(132, 402, 76, 23);
		contentPane.add(chckbxStudent);
		
		JCheckBox chckbxEmployee = new JCheckBox("Employee");
		chckbxEmployee.setBounds(231, 402, 85, 23);
		contentPane.add(chckbxEmployee);
		
		JCheckBox chckbxSelfEmployee = new JCheckBox("Self Employee");
		chckbxSelfEmployee.setBounds(328, 402, 105, 23);
		contentPane.add(chckbxSelfEmployee);
		
		JCheckBox chckbxOthers_1 = new JCheckBox("Others");
		chckbxOthers_1.setBounds(435, 402, 76, 23);
		contentPane.add(chckbxOthers_1);
		
		JLabel lblCounselorName = new JLabel("Counselor Name");
		lblCounselorName.setBounds(21, 563, 128, 14);
		contentPane.add(lblCounselorName);
		
		counselorName = new JTextField();
		counselorName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					getRootPane().setDefaultButton(submitbutton);
					submitbutton.requestFocus();
				}
				
			}
		});
		counselorName.setColumns(10);
		counselorName.setBounds(186, 560, 224, 20);
		contentPane.add(counselorName);
		
		date = new JDateChooser();
		date.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					phoneno.requestFocus();
				}
				
			}
		});
		date.setDateFormatString("yyyy/mm/dd");
		date.setBounds(535, 90, 128, 20);
		contentPane.add(date);
		
		dob = new JDateChooser();
		dob.setDateFormatString("yyyy/mm/dd");
		dob.setBounds(185, 187, 224, 20);
		contentPane.add(dob);
	}
}
