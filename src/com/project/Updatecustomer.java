 package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Updatecustomer extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmail;
	private JTextField txtphone;
	private Connection con;
	private PreparedStatement ps,pssearch,psupdate;
	private ResultSet rs;
	private JButton btnSearch;
	private JComboBox<String> comboBox;
	private JLabel lblUpdateCustomerDetail;
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatecustomer frame = new Updatecustomer();
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
	public Updatecustomer() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo()
	{
		try
		{
			String strsql="select id from customerdetail";
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			while(rs.next()==true)
			{
				String cusid=rs.getString("id");
				comboBox.addItem(cusid);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public void createGui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCustomerId.setBounds(64, 178, 192, 33);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblName.setBounds(64, 225, 192, 38);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(294, 238, 177, 25);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmail.setBounds(64, 282, 192, 38);
		contentPane.add(lblEmail);
		
		txtmail = new JTextField();
		txtmail.setBounds(294, 282, 177, 25);
		contentPane.add(txtmail);
		txtmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPhone.setBounds(64, 330, 192, 25);
		contentPane.add(lblPhone);
		
		txtphone = new JTextField();
		txtphone.setBounds(294, 330, 177, 28);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 20));
		btnUpdate.setBounds(194, 390, 156, 38);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSearch.setBounds(505, 178, 112, 33);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Customer Id"}));
		comboBox.setBounds(294, 178, 188, 33);
		fillCombo();
		contentPane.add(comboBox);
		
		lblUpdateCustomerDetail = new JLabel(" UPDATE CUSTOMER DETAIL");
		lblUpdateCustomerDetail.setForeground(Color.BLACK);
		lblUpdateCustomerDetail.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblUpdateCustomerDetail.setBounds(21, 43, 615, 87);
		contentPane.add(lblUpdateCustomerDetail);
		
		label = new JLabel(" ");
		label.setIcon(new ImageIcon(Updatecustomer.class.getResource("/com/image/turntable-top-view-audio-equipment-159376.jpeg")));
		label.setBounds(-390, 6, 1036, 487);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cusid=(String) comboBox.getSelectedItem();
	
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("search"))
		{
			if(cusid.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Select Valid Id");
			}
			else
			{
				String strsql="select * from customerdetail where id=?";
				try
				{
					pssearch=con.prepareStatement(strsql);
				    pssearch.setString(1, cusid);
					rs=pssearch.executeQuery();
					if(rs.next())
					{
					String name=rs.getString("Name");
					String mail=rs.getString("Email");
					String phone=rs.getString("Phone");
					
					txtname.setText(name);
					txtmail.setText(mail);
					txtphone.setText(phone);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "No Id Found");
					}
					
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
		}
		if(caption.equalsIgnoreCase("update"))
		{
			String mail=txtmail.getText();
			String phone=txtphone.getText();
			
			try
			{
				String strupdate="update customerdetail set Email=?,Phone=? where id=?";
				psupdate=con.prepareStatement(strupdate);
				psupdate.setString(1, mail);
				psupdate.setString(2, phone);
				psupdate.setString(3, cusid);
				
				int row=psupdate.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "Record Updated Successfully");
				}
			    txtname.setText("");
			    txtmail.setText("");
			    txtphone.setText("");
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
		}
		 
		}
			
			
		
		
		
	}

