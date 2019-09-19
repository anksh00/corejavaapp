package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Welcome extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JLabel lbl;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private Connection con;
	private PreparedStatement pse;
	private ResultSet rs;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con = CrudOperation.createConnection();
		
		createGui();
	}
	public void createGui()
	{
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JMenuItem mntmContact = new JMenuItem("CONTACT US");
		mntmContact.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 20));
		mntmContact.addActionListener(this);
		getContentPane().setLayout(null);
		setBounds(100, 100, 814, 695);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("USER ID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserid.setBounds(713, 332, 129, 30);
		contentPane.add(lblUserid);
		
		txtid = new JTextField();
		txtid.setBounds(831, 332, 201, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		lbl = new JLabel("WELCOME TO APPLIANCES SERVICING MANAGMENT SYSTEM");
		lbl.setForeground(new Color(0, 0, 0));
		lbl.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lbl.setBounds(689, 183, 677, 78);
		contentPane.add(lbl);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblLogin.setBounds(878, 255, 238, 40);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(713, 399, 111, 30);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("SUBMIT");
		btnLogin.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		btnLogin.setBounds(861, 469, 129, 30);
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(826, 399, 206, 30);
		contentPane.add(txtpass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/com/image/pexels-photo-205316.jpg")));
		lblNewLabel.setBounds(27, 0, 1510, 918);
		contentPane.add(lblNewLabel);
		
		JMenuItem mntmContact1 = new JMenuItem("CONTACT US");
		mntmContact1.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 20));
		mntmContact1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String usrid=txtid.getText().trim();
		String usrpass=txtpass.getText().trim();
		
		
	
		if(usrid.isEmpty()|usrpass.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else 
		{
			try 
			{
			String strsql="select * from login where UserId=? and Userpass=? ";
			pse=con.prepareStatement(strsql);
			pse.setString(1, usrid);
			pse.setString(2, usrpass);
			rs=pse.executeQuery();
			if(rs.next())
			{
				String usrtype=rs.getString("Usertype");
				if(usrtype.equalsIgnoreCase("admin"))
				{
					Adminlogin ad=new Adminlogin();
					ad.setVisible(true);
					 
				}
				else if(usrtype.equalsIgnoreCase("supervisor"))
				{
					Supervisorlogin sup=new Supervisorlogin();
					sup.setVisible(true);
				 
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid id/pass");
			}
			
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog(this, se);
			}
		}
		
				
	}
}