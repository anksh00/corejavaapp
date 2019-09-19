package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
 
public class Adminlogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	 private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin frame = new Adminlogin();
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
	public Adminlogin() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1515, 838);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnManageEngineer = new JMenu("MANAGE ENGINEER");
		mnManageEngineer.setForeground(Color.BLACK);
		mnManageEngineer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		menuBar.add(mnManageEngineer);
		
		JMenuItem mntmAddEengineer = new JMenuItem("ADD ENGINEER");
		mntmAddEengineer.setForeground(Color.BLACK);
		mntmAddEengineer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		mntmAddEengineer.addActionListener(this);
		mnManageEngineer.add(mntmAddEengineer);
		
		JMenuItem mntmUpdateEngineer = new JMenuItem("UPDATE ENGINEER");
		mntmUpdateEngineer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		mntmUpdateEngineer.addActionListener(this);
		mnManageEngineer.add(mntmUpdateEngineer);
		
		JMenuItem mntmDeleteEngineer = new JMenuItem("DELETE ENGINEER");
		mntmDeleteEngineer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		mntmDeleteEngineer.addActionListener(this);
		mnManageEngineer.add(mntmDeleteEngineer);
		
		JLabel label = new JLabel("                                                                                                                                                            ");
		menuBar.add(label);
		
		JMenu mnView = new JMenu("VIEW");
		mnView.setForeground(Color.BLACK);
		mnView.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		menuBar.add(mnView);
		
		JMenuItem mntmViewDetails = new JMenuItem("VIEW ENGINEER DETAILS");
		mntmViewDetails.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		mntmViewDetails.addActionListener(this);
		mnView.add(mntmViewDetails);
		
		 
		
		JLabel label_2 = new JLabel("                                                                                                                                                                 ");
		menuBar.add(label_2);
		
		  JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		btnBack.addActionListener(this);
		
		menuBar.add(btnBack);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("WELCOME ADMIN");
		lblWelcomeAdmin.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 40));
		lblWelcomeAdmin.setBounds(534, 135, 793, 216);
		contentPane.add(lblWelcomeAdmin);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setIcon(new ImageIcon(Adminlogin.class.getResource("/com/image/IMG_20190724_223820.jpg")));
		label_1.setBounds(0, 39, 1526, 917);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "WELCOME");
		String caption = e.getActionCommand();
		System.out.println(caption);
		if(caption.equalsIgnoreCase("ADD ENGINEER")) {
			
			Addengineer ae = new Addengineer();
			ae.setVisible(true);
		}
		if(caption.equalsIgnoreCase("UPDATE ENGINEER")) {
			Updateengineer ue = new Updateengineer();
			ue.setVisible(true);
		}
		if(caption.equalsIgnoreCase("DELETE ENGINEER")) {
			Deleteengg de = new Deleteengg();
			de.setVisible(true);
		}
		if(caption.equalsIgnoreCase("VIEW ENGINEER DETAILS")) {
			Viewengg ve = new Viewengg();
			ve.setVisible(true);
	}
		if(caption.equalsIgnoreCase("BACK")) {
			Welcome ve = new Welcome();
			ve.setVisible(true);
	}
		 
		 
		 
}
}

	 

