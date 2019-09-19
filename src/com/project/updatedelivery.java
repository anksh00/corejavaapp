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
import java.awt.Frame;
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

public class updatedelivery extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String>comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatedelivery frame = new updatedelivery();
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
	public updatedelivery() {
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
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllotId = new JLabel("Request Id");
		lblAllotId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAllotId.setBounds(91, 165, 149, 58);
		contentPane.add(lblAllotId);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Id"}));
		fillCombo();
		comboBox.setBounds(323, 174, 175, 41);
		contentPane.add(comboBox);
		
		JLabel lblDeliveryStatusUpdation = new JLabel(" DELIVERY UPDATION");
		lblDeliveryStatusUpdation.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblDeliveryStatusUpdation.setBounds(126, 43, 354, 49);
		contentPane.add(lblDeliveryStatusUpdation);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 20));
		
		btnUpdate.setBounds(206, 330, 175, 41);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(updatedelivery.class.getResource("/com/image/pexels-photo-988872.jpeg")));
		label.setBounds(0, 0, 646, 493);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmbalt=(String) comboBox.getSelectedItem();
		try 
		{
			String strupdate="update servicerequest set deliverysatus=? where id=?";
			ps=con.prepareStatement(strupdate);
			ps.setString(1, "Delivered");
			ps.setString(2, cmbalt);
			
			int row=ps.executeUpdate();
			if(row>0)
			{
				JOptionPane.showMessageDialog(this, "UPDATED");
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
}
}