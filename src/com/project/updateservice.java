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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class updateservice extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String>comboBox;
	private JLabel lblServiceUpdation;
	private JLabel label;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateservice frame = new updateservice();
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
	public updateservice() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo()
	{
		try
		{
			String strselect="select id from servicerequest";
			ps=con.prepareStatement(strselect);
			rs=ps.executeQuery();
			while(rs.next()==true)
			{
				String reqid=rs.getString("id");
				comboBox.addItem(reqid);
				
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRequestId = new JLabel("Request Id");
		lblRequestId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequestId.setBounds(157, 187, 137, 40);
		contentPane.add(lblRequestId);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Request Id"}));
		fillCombo();
		comboBox.setBounds(348, 187, 249, 40);
		contentPane.add(comboBox);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 20));
		btnUpdate.setBounds(248, 303, 164, 42);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		lblServiceUpdation = new JLabel("SERVICE UPDATION");
		lblServiceUpdation.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblServiceUpdation.setBounds(149, 42, 374, 49);
		contentPane.add(lblServiceUpdation);
		
		label = new JLabel(" ");
		label.setIcon(new ImageIcon(updateservice.class.getResource("/com/image/pexels-photo-1036808.jpeg")));
		label.setBounds(-456, -529, 1102, 1022);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmbreq=(String) comboBox.getSelectedItem();
		try 
		{
			String strupdate="update servicerequest set Servicestatus=? where id=?";
			ps=con.prepareStatement(strupdate);
			ps.setString(1, "Done");
			ps.setString(2, cmbreq);
			
			int row=ps.executeUpdate();
			if(row>0)
			{
				JOptionPane.showMessageDialog(this, "Updated");
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

}
