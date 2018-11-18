package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bmpl.sms.users.DAO.StudentDAO;
import com.bmpl.sms.users.DAO.StudentDTO;
import com.toedter.calendar.JDateChooser;

public class ReflectStudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReflectStudentDetails frame = new ReflectStudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fiterByDate()
	{
		Date from = dateChooser.getDate();
		Date to = dateChooser_1.getDate();
		list.parallelStream().filter(studentobj->studentobj.getDate()==from);
	}

	ArrayList<StudentDTO> list;
	public void loadDetails() {
		StudentDAO stddao = new StudentDAO();
		try {
			list = stddao.getStudInfo();
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			Object[] rowdata = new Object[11]; 
//			ArrayList<Object> rowdata = new ArrayList<>();
			for(int i=0;i<list.size();i++)
			{
				rowdata[0] = list.get(i).getName();
				rowdata[1] = list.get(i).getFatherName();
				rowdata[2] = list.get(i).getCourse();
				rowdata[3] = list.get(i).getPhoneno();
				rowdata[4] = list.get(i).getEmail();
				rowdata[5] = list.get(i).getDob();
				rowdata[6] = list.get(i).getDate();
				rowdata[7] = list.get(i).getPrefBatchTime();
				rowdata[8] = list.get(i).getCollageName();
				rowdata[9] = list.get(i).getCounselorName();
				rowdata[10] = list.get(i).getStatus();
				
				
//				rowdata.add(0,list.get(i).getName());
//				rowdata.add(1,list.get(i).getFatherName());
//				rowdata.add(2,list.get(i).getCourse());
//				rowdata.add(3,list.get(i).getPhoneno());
//				rowdata.add(4,list.get(i).getEmail());
//				rowdata.add(5,list.get(i).getDob());
//				rowdata.add(6,list.get(i).getDate());
//				rowdata.add(7,list.get(i).getPrefBatchTime());
//				rowdata.add(8,list.get(i).getCollageName());
//				rowdata.add(9,list.get(i).getCounselorName());
//				rowdata.add(10,list.get(i).getStatus());
//				Object rowdata1[] = list.toArray(); 
				dtm.addRow(rowdata);
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
	public ReflectStudentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				int index = table.getSelectedRow();
//				TableModel model = table.getModel();
//				int column =  model.getColumnCount();
//				int row = m
//			}
//		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Name", "Father Name", "Course", "Phoneno", "Email", "DOB", "Inquiry Date", "Pref Batcht Time", "Collage/Comp Name", "Counselor", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(96);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(202);
		table.getColumnModel().getColumn(5).setPreferredWidth(113);
		table.getColumnModel().getColumn(6).setPreferredWidth(110);
		table.getColumnModel().getColumn(7).setPreferredWidth(99);
		table.getColumnModel().getColumn(8).setPreferredWidth(123);
		table.getColumnModel().getColumn(9).setPreferredWidth(94);
		table.setBounds(10, 75, 612, 358);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 758, 293);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/mm/dd");
		dateChooser.setBounds(195, 93, 148, 20);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy/mm/dd");
		dateChooser_1.setBounds(458, 93, 139, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("From :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(126, 93, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To  :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTo.setBounds(405, 93, 76, 14);
		contentPane.add(lblTo);
		
		loadDetails();
	}
}
