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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class allotservice extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> cmbengid,cmbreqid;
	private JDateChooser dc;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allotservice frame = new allotservice();
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
	public allotservice() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo() {
		try
		{
			String strinsert="select id from enggdetails";
			ps=con.prepareStatement(strinsert);
			rs=ps.executeQuery();
			
			while(rs.next()==true)
			{
				String engid=rs.getString("id");
				cmbengid.addItem(engid);
				
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	
	public void fillCombo1() {
		try
		{
			String strinsert="select id from servicerequest";
			ps=con.prepareStatement(strinsert);
			rs=ps.executeQuery();
			
			while(rs.next()==true)
			{
				String reqid=rs.getString("id");
				cmbreqid.addItem(reqid);
				
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
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllotid = new JLabel("Allot Id");
		lblAllotid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAllotid.setBounds(105, 135, 117, 40);
		contentPane.add(lblAllotid);
		
		cmbengid = new JComboBox();
		cmbengid.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cmbengid.setModel(new DefaultComboBoxModel(new String[] {"Engineer Id"}));
		fillCombo();
		cmbengid.setBounds(308, 207, 172, 29);
		contentPane.add(cmbengid);
		
		cmbreqid = new JComboBox();
		cmbreqid.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cmbreqid.setModel(new DefaultComboBoxModel(new String[] {"Request Id"}));
		fillCombo1();
		cmbreqid.setBounds(311, 275, 169, 29);
		contentPane.add(cmbreqid);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Verdana", Font.BOLD, 20));
		btnSubmit.setBounds(216, 402, 129, 40);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(105, 330, 96, 40);
		contentPane.add(lblDate);
		
		JLabel lblEnggid = new JLabel("Engineer Id");
		lblEnggid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnggid.setBounds(105, 202, 145, 39);
		contentPane.add(lblEnggid);
		
		dc = new JDateChooser();
		dc.setBounds(308, 334, 172, 25);
		dc.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dc);
		
		JLabel lblRequestid = new JLabel("Request Id");
		lblRequestid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequestid.setBounds(105, 265, 121, 48);
		contentPane.add(lblRequestid);
		
		txtid = new JTextField();
		txtid.setBounds(308, 145, 172, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblServiceAllotment = new JLabel(" SERVICE ALLOTMENT");
		lblServiceAllotment.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblServiceAllotment.setBounds(160, 21, 443, 75);
		contentPane.add(lblServiceAllotment);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(allotservice.class.getResource("/com/image/IMG_20190725_230042.jpg")));
		label.setBounds(-449, 0, 1095, 493);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		java.util.Date d = dc.getDate();
		System.out.println(d);
		
		long t = d.getTime();
		java.sql.Date sd = new java.sql.Date(t);
		System.out.println(sd);
		
		String allotid=txtid.getText();
		String engid=(String) cmbengid.getSelectedItem();
		String reqid=(String)cmbreqid.getSelectedItem();
		String date=dc.getDateFormatString();
		
		if(allotid.isEmpty()|engid.isEmpty()|reqid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "fill the details");
		}
		else
		{
			try
			{
				String strinsert = "insert into allotservice values(?,?,?,?)";
				ps = con.prepareStatement(strinsert);  
				ps.setString(1, allotid);
				ps.setString(2, engid);
				ps.setString(3, reqid);
				ps.setDate(4, sd);
				 int row=ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "record added");
				}
		
			}
		
			catch(SQLException se)
			{
				System.out.println(se);
			}
			
	
		  
			try
			{
			
				
			
				String strupdate="update servicerequest set assignedstatus=? where id=?";
				ps=con.prepareStatement(strupdate);
				ps.setString(1, "Assign");
				ps.setString(2, reqid);
				int row=ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "updated");
				}
				
			}
			catch(SQLException ee)
			{
				System.out.println(ee);
			}
		}
		
		
		}
} 

