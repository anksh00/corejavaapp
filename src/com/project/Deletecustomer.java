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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Deletecustomer extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> comboBox;
	private JLabel lblDeleteCustomerDetails;
	private JLabel lblCustomerId;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletecustomer frame = new Deletecustomer();
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
	public Deletecustomer() {
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
				String customid=rs.getString("id");
				comboBox.addItem(customid);
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
		contentPane.setBackground(new Color(153, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Id"}));
		comboBox.setBounds(287, 151, 212, 32);
		fillCombo();
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.setBounds(220, 256, 117, 42);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
		lblDeleteCustomerDetails = new JLabel("DELETE CUSTOMER DETAILS");
		lblDeleteCustomerDetails.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblDeleteCustomerDetails.setBounds(90, 39, 492, 50);
		contentPane.add(lblDeleteCustomerDetails);
		
		lblCustomerId = new JLabel("Customer Id");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCustomerId.setBounds(59, 151, 192, 33);
		contentPane.add(lblCustomerId);
		
		label = new JLabel(" ");
		label.setIcon(new ImageIcon(Deletecustomer.class.getResource("/com/image/IMG_20190724_223810.jpg")));
		label.setBounds(-1211, 0, 1857, 493);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("delete"))
		{
		String cusid=(String) comboBox.getSelectedItem();
		
		if(cusid.equalsIgnoreCase("Select Id"))
		{
			JOptionPane.showMessageDialog(this, "Please select valid id");
		}
		else
		{
			String strdelete="delete from customerdetail where id=?";
			try
			{
				ps=con.prepareStatement(strdelete);
				ps.setString(1, cusid);
				int row = ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showConfirmDialog(this, " Are u Sure Want To Delete");
					
					  
					 
					
				}
				
			}
				catch(SQLException se)
				{
					System.out.println(se);
				}
				
				
			}
		}
		 
		}
	}
		
	


