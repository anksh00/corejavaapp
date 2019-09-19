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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Servicereqst extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnum;
	private JTextField txtamount;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> cmbid,cmbapid;
	private JDateChooser dc,dc1;
	private JLabel lblServiceRequest;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicereqst frame = new Servicereqst();
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
	public Servicereqst() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillcombo()
	{
	try
	{
		String strsql="select id from customerdetail";
		ps=con.prepareStatement(strsql);
		rs=ps.executeQuery();
		
		while(rs.next()==true) {
			
			String cusid=rs.getString("id");
			cmbid.addItem(cusid);
		}
	}
	catch (SQLException se) {
		System.out.println(se);
		 
	}
	}
	public void fillcombo1()
	{
	try
	{
		String strsql="select appid from enggdetails";
		ps=con.prepareStatement(strsql);
		rs=ps.executeQuery();
		
		while(rs.next()==true) {
			
			String appid=rs.getString("appid");
			cmbapid.addItem(appid);
		}
	}
	catch (SQLException e) {
		System.out.println(e);
		 
	}
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRequestid = new JLabel("Request Id");
		lblRequestid.setForeground(Color.WHITE);
		lblRequestid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequestid.setBounds(52, 128, 134, 25);
		contentPane.add(lblRequestid);
		
		txtid = new JTextField();
		txtid.setBounds(280, 119, 228, 25);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblCustomerid = new JLabel("Customer Id");
		lblCustomerid.setForeground(Color.WHITE);
		lblCustomerid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerid.setBounds(52, 171, 134, 29);
		contentPane.add(lblCustomerid);
		
	     cmbid = new JComboBox();
	     cmbid.setFont(new Font("Verdana", Font.BOLD, 19));
	     cmbid.setModel(new DefaultComboBoxModel(new String[] { "Select Customer Id" }));
		cmbid.setBounds(280, 162, 228, 29);
		fillcombo();
		contentPane.add(cmbid);
		
		JLabel lblAppliancesmodelnumber = new JLabel("Appliance Number");
		lblAppliancesmodelnumber.setForeground(Color.WHITE);
		lblAppliancesmodelnumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAppliancesmodelnumber.setBounds(52, 225, 205, 32);
		contentPane.add(lblAppliancesmodelnumber);
		
		txtnum = new JTextField();
		txtnum.setBounds(280, 217, 228, 25);
		contentPane.add(txtnum);
		txtnum.setColumns(10);
		
		JLabel lblAppliancesid = new JLabel("Appliances Id");
		lblAppliancesid.setForeground(Color.WHITE);
		lblAppliancesid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAppliancesid.setBounds(52, 267, 205, 32);
		contentPane.add(lblAppliancesid);
		
		cmbapid = new JComboBox();
		cmbapid.setFont(new Font("Verdana", Font.BOLD, 19));
		cmbapid.setModel(new DefaultComboBoxModel(new String[] { "Select Appliancesid" }));
		cmbapid.setBounds(280, 258, 228, 32);
		fillcombo1();
		contentPane.add(cmbapid);
		
		JLabel lblIndate = new JLabel("In Date");
		lblIndate.setForeground(Color.WHITE);
		lblIndate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIndate.setBounds(52, 319, 111, 25);
		contentPane.add(lblIndate);
		
		JLabel lblDuedate = new JLabel("Due Date");
		lblDuedate.setForeground(Color.WHITE);
		lblDuedate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDuedate.setBounds(52, 354, 111, 25);
		contentPane.add(lblDuedate);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalAmount.setBounds(52, 389, 181, 25);
		contentPane.add(lblTotalAmount);
		
		txtamount = new JTextField();
		txtamount.setBounds(280, 389, 228, 22);
		contentPane.add(txtamount);
		txtamount.setColumns(10);
		
		JButton btnSave = new JButton("ADD REQUSEST");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(179, 424, 212, 44);
		btnSave.addActionListener(this);
		contentPane.add(btnSave);
		
		 dc = new JDateChooser();
		dc.setBounds(280, 310, 228, 19);
		dc.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dc);
		
		  dc1 = new JDateChooser();
		dc1.setBounds(285, 354, 223, 19);
		dc1.setDateFormatString("YYYYY-MM-DD");
		contentPane.add(dc1);
		
		lblServiceRequest = new JLabel("SERVICE REQUEST");
		lblServiceRequest.setForeground(Color.WHITE);
		lblServiceRequest.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblServiceRequest.setBounds(111, 10, 417, 59);
		contentPane.add(lblServiceRequest);
		
		label = new JLabel(" ");
		label.setIcon(new ImageIcon(Servicereqst.class.getResource("/com/image/IMG_20190725_225707.jpg")));
		label.setBounds(-11, 0, 657, 493);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		java.util.Date d = dc.getDate();
		System.out.println(d);
		
		long t = d.getTime();
		java.sql.Date sd = new java.sql.Date(t);
		System.out.println(sd);
		
		java.util.Date d1 = dc1.getDate();
		System.out.println(d);
		
		long t1 = d.getTime();
		java.sql.Date sd1 = new java.sql.Date(t);
		System.out.println(sd1);
		
		
		String reqstid=txtid.getText();
		String custid=(String) cmbid.getSelectedItem();
		String appmodel=txtnum.getText();
		String appid=(String)cmbapid.getSelectedItem();
		String indate=dc.getDateFormatString();
		String duedate=dc1.getDateFormatString();
		String totalamt=txtamount.getText();
		
		if(reqstid.isEmpty()||custid.isEmpty()||appmodel.isEmpty()||appid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "fill the detail");
		}
		else {
			try {
				String strinsert="insert into servicerequest value(?,?,?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(strinsert);
				ps.setString(1, reqstid);
				ps.setString(2, custid);
				ps.setString(3, appmodel);
				ps.setString(4, appid);
				ps.setDate(5, sd);
				ps.setDate(6, sd1);
				ps.setString(7, totalamt);
				ps.setString(8, "taken");
				ps.setString(9, "notassign");
				ps.setString(10, "pending");
				
				
					int row=ps.executeUpdate();
					if(row>0)
					{
						JOptionPane.showMessageDialog(this, "record added successfully");
						txtid.setText("  ");
						txtnum.setText("  ");
						 
						txtamount.setText("  ");
					}
				
			}
				catch (SQLException se)
			{
					 System.out.println(se);
				}
			
		}
		
	 
		
	}
}
