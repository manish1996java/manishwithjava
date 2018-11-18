package com.bmpl.sms.test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
//import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ScreenTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenTest frame = new ScreenTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public String[] getImage()
	{
		File file = new File("D://Java Files//StudentManagementsys//src//images");
//		File file = new File("D://wall");
//		File file = new File(ScreenTest.class.getResource("/images").getFile());
		String imagelist[] = file.list();
		
//		System.out.println(imagelist[1]);
//		for(String str : imagelist)
//		{
//			System.out.println(str);
//		}
		return imagelist;
	}
	
	JLabel lblNewLabel = new JLabel("");
	public void showImage(int index)
	{
		String[] imagelist = getImage();
		String imageName = imagelist[index];
		System.out.println(imageName);
		ImageIcon imageicon = new ImageIcon(ScreenTest.class.getResource("/images/")+imageName);
		Image image = imageicon.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(image));
	}
	
	static int pos = 0;
	
	public void positionInc() {
		pos++;
	}
	public void positionDec()
	{
		pos--;
	}
	/**
	 * Create the frame.
	 */
	public ScreenTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		showImage(pos);
//		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 655, 342);
		contentPane.add(lblNewLabel);
		
		JButton btnNext = new JButton("next >\r\n");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionInc();
			}
		});
		btnNext.setFont(new Font("Arial", Font.BOLD, 18));
		btnNext.setBounds(328, 361, 87, 35);
		contentPane.add(btnNext);
		
		JButton button_1 = new JButton("< prev");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionDec();
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 18));
		button_1.setBounds(236, 361, 89, 35);
		contentPane.add(button_1);
	}
}
