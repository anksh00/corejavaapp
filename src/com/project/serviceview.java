 package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutils.CrudOperation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class serviceview extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;

	String[]colNames= {"RequestId"," CustomerId ", "ApplianceModelNumber", "ApplianceId", "InDate", "DueDate", "TotalAmoumt", "Deliverystatus", "Assignedstatus", "Servicestatus"};
	String [][]data;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serviceview frame = new serviceview();
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
	public serviceview() {
		
		con=CrudOperation.createConnection();
		createGui();
	}
	
	
	public void  populateArray()
	{
		try {
			int rowcnt=0;
			String strcount="select count(*) from servicerequest";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next())
			{
				rowcnt=rscount.getInt(1);
				System.out.println(rowcnt);
				
				data=new String[rowcnt][10];//double dmesion array create
				
			}
			
		String strsql="select * from servicerequest";
		psdata=con.prepareStatement(strsql);
			int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				String RequestId=rsdata.getString("id");
				String CustomerId=rsdata.getString("customerid");
				String ApplianceModelNumbr=rsdata.getString("appliancemodel");
				String ApplianceId=rsdata.getString("applianceid");
				String InDate=rsdata.getString("indate");
				String DueId=rsdata.getString("duedate");
				String TotalAmount=rsdata.getString("totalamount");
				String Deliverystatus=rsdata.getString("deliverysatus");
				String Assignedstatus=rsdata.getString("assignedstatus");
				String Servicestatus=rsdata.getString("servicestatus");


				data[row][0]=RequestId;
				data[row][1]=CustomerId;
				data[row][2]=ApplianceModelNumbr;
				data[row][3]=ApplianceId;
				data[row][4]=InDate;
				data[row][5]=DueId;
				data[row][6]=TotalAmount;
				data[row][7]=Deliverystatus;
				data[row][8]=Assignedstatus;
				data[row][9]=Servicestatus;
				row++;
				
				
				
				
				
			}
			
			
			
			
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
		}
		
		
	}
	
	
	
	
	public void createGui()
	{
		setTitle("requestview");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 826, 549);
		contentPane.add(scrollPane);
		
		JButton btnShowDetail = new JButton("Show Detail");
		btnShowDetail.setBounds(144, 11, 89, 23);
		btnShowDetail.addActionListener(this);
		contentPane.add(btnShowDetail);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(370, 11, 89, 23);
		btnGoBack.addActionListener(this);
		contentPane.add(btnGoBack);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(Color.RED);
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		
		
		 populateArray();//data populate
	     table.setModel(new DefaultTableModel(data,colNames)  );
	     
	     
		scrollPane.setViewportView(table);
		
		String caption=ar.getActionCommand();
		System.out.println(caption);
		
		 
	}
}
