 package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Addcustomer extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtcustomid;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcustomer frame = new Addcustomer();
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
	public Addcustomer() {
		con=CrudOperation.createConnection();
		
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Id");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(147, 131, 179, 30);
		contentPane.add(lblNewLabel);
		
		txtcustomid = new JTextField();
		txtcustomid.setBounds(392, 137, 137, 30);
		contentPane.add(txtcustomid);
		txtcustomid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblName.setBounds(147, 184, 137, 31);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(392, 184, 137, 30);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblEmail.setBounds(147, 238, 141, 29);
		contentPane.add(lblEmail);
		
		txtmail = new JTextField();
		txtmail.setBounds(392, 238, 137, 29);
		contentPane.add(txtmail);
		txtmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblPhone.setBounds(147, 277, 141, 30);
		contentPane.add(lblPhone);
		
		txtphone = new JTextField();
		txtphone.setBounds(392, 278, 137, 29);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSubmit.setBounds(233, 354, 156, 31);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		JLabel lblAddCustomerDetail = new JLabel("ADD CUSTOMER DETAIL");
		lblAddCustomerDetail.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblAddCustomerDetail.setBounds(135, 23, 447, 71);
		contentPane.add(lblAddCustomerDetail);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.setBounds(663, 139, 84, 19);
		btnReset.addActionListener(this);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Addcustomer.class.getResource("/com/image/pexels-photo-1036808.jpeg")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 646, 493);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(27, 390, 163, 13);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		
		if(caption.equalsIgnoreCase("Submit"))
		{
		String customid=txtcustomid.getText().trim();
		String name=txtname.getText().trim();
		String email=txtmail.getText().trim();
		String phone=txtphone.getText().trim();
		
		if(customid.isEmpty()|name.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else
		{
			try
			{
				String strinsert="insert into customerdetail values(?,?,?,?)";
				ps=con.prepareStatement(strinsert);
				ps.setString(1, customid);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, phone);
				
				int row=ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "Record Added Successfully");
				   
				}
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
		}
		
	}
		if(caption.equalsIgnoreCase("Reset"))
		{
			    txtcustomid.setText(" ");
			    txtname.setText("");
			    txtmail.setText("");
			    txtphone.setText("");
		}
		 
}
}
