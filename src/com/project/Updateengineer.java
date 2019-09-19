package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Updateengineer extends JFrame implements  ActionListener {
	private Connection con;
	private PreparedStatement pssearch,psupdate;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtname;
    private JTextArea  txtaddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateengineer frame = new Updateengineer();
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
	public Updateengineer() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateEngineer = new JLabel("UPDATE   ENGINEER");
		lblUpdateEngineer.setForeground(Color.WHITE);
		lblUpdateEngineer.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblUpdateEngineer.setBounds(67, 20, 394, 84);
		contentPane.add(lblUpdateEngineer);
		
		JLabel lblNewLabel = new JLabel("ENGINEERID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 154, 151, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 240, 101, 35);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(10, 295, 101, 32);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(10, 337, 101, 35);
		contentPane.add(lblAddress);
		
		txtid = new JTextField();
		txtid.setBounds(188, 154, 165, 27);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(188, 248, 165, 27);
		contentPane.add(txtemail);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(188, 298, 165, 29);
		contentPane.add(txtphone);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(166, 411, 165, 35);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 20));
		btnSearch.setBounds(392, 154, 126, 40);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(10, 203, 130, 27);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(188, 207, 165, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel label = new JLabel(" ");
		label.setBounds(44, 55, 96, 49);
		contentPane.add(label);
		
		 txtaddress = new JTextArea();
		txtaddress.setBounds(188, 346, 165, 26);
		contentPane.add(txtaddress);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setIcon(new ImageIcon(Updateengineer.class.getResource("/com/image/pexels-photo-785429.jpeg")));
		label_1.setBounds(-275, 0, 829, 456);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		String id=txtid.getText();
	
	if(caption.equals("SEARCH"))
	{
		
	
		if(id.isEmpty())
		{
			
			JOptionPane.showMessageDialog(this, "Engineer Id Needed");
		}
		else {
			
		String strsql="select * from enggdetails where id=?";
		try {
			
			pssearch=con.prepareStatement(strsql);
			pssearch.setString(1, id);
			ResultSet rs=pssearch.executeQuery();
				if(rs.next())//record exists
				{
					String email=rs.getString("Email");
					String phone=rs.getString("Phone");
					String address=rs.getString("Address");
					String name=rs.getString("Name");
					txtemail.setText(email);
					txtphone.setText(phone);
					txtaddress.setText(address);
					txtname.setText(name );
					
				}
				else {
					
					JOptionPane.showMessageDialog(this, "No Id Found"); 
				}
		 
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		}	
	}	
			
		 
	if(caption.equals("UPDATE"))
	{
	
		String email=txtemail.getText();
		String phone=txtphone.getText();
		String address=txtaddress.getText();
		 
		try {
			
	    String strupdate="update enggdetails set email=?,phone=?,address=? where id=?";
		psupdate=con.prepareStatement(strupdate);
		psupdate.setString(1, email);
		psupdate.setString(2, phone);
		psupdate.setString(3, address);
		psupdate.setString(4, id);
		
	int row=psupdate.executeUpdate();
	if(row>0)
	{
		
		JOptionPane.showMessageDialog(this, "Successfully Record Updated", "updation", JOptionPane.WARNING_MESSAGE);
	}
	 
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
			
			
		}
	}
	}
}
		
	 