
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
import javax.swing.ImageIcon;
import java.awt.Color;

public class Addappliance extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtappid;
	private JTextField txtname;
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
					Addappliance frame = new Addappliance();
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
	public Addappliance() {
		con=CrudOperation.createConnection();
	    createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApplianceId = new JLabel("Appliance ID");
		lblApplianceId.setForeground(Color.BLACK);
		lblApplianceId.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblApplianceId.setBounds(130, 160, 166, 31);
		contentPane.add(lblApplianceId);
		
		txtappid = new JTextField();
		txtappid.setBounds(348, 165, 158, 25);
		contentPane.add(txtappid);
		txtappid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblName.setBounds(130, 227, 136, 31);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(348, 233, 158, 25);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(246, 291, 109, 29);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		JLabel lblAddAppliances = new JLabel(" ADD APPLIANCES");
		lblAddAppliances.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblAddAppliances.setBounds(143, 31, 404, 81);
		contentPane.add(lblAddAppliances);
		
		JLabel label = new JLabel(" ");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(Addappliance.class.getResource("/com/image/IMG_20190725_170302.jpg")));
		label.setBounds(0, 0, 647, 494);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String  caption=e.getActionCommand();
		
		
		String appid=txtappid.getText().trim();
		String appname=txtname.getText().trim();
		
		if(caption.equalsIgnoreCase("Submit"))
		{
		if(appid.isEmpty()|appname.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else
		{
			try
			{
		
		
		String strinsert="insert into appliancesdetail values(?,?)";
		ps=con.prepareStatement(strinsert);
		ps.setString(1, appid);
		ps.setString(2, appname);
		int row=ps.executeUpdate();
		
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "Record Added Successfully");
			txtappid.setText("");
			txtname.setText("");
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
