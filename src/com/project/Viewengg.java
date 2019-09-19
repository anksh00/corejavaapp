package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Viewengg extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable enggtable;
	private Connection con;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;
	
	String[]colNames= {"EnggineerId","Name","Email","Phone","Gender","Address","Appliances Id"};
	String [][]data;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewengg frame = new Viewengg();
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
	public Viewengg() {
		con=CrudOperation.createConnection();
		
		createGui();
	}
	
	public void  populateArray()
	{
		try {
			int rowcnt=0;
			String strcount="select count(*) from   enggdetails";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next())
			{
				rowcnt=rscount.getInt(1);
				System.out.println(rowcnt);
				data=new String[rowcnt][8]; 
				
			}
			
			
			
		String strsql="select * from  enggdetails";
		psdata=con.prepareStatement(strsql);
			int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				String engid=rsdata.getString("id");
				String name=rsdata.getString("Name");
				String email=rsdata.getString("Email");
				String phone=rsdata.getString("Phone");
				String gender=rsdata.getString("Gender");
				String address=rsdata.getString("Address");
				String appid=rsdata.getString("appid");
				 
				
				data[row][0]=engid;
				data[row][1]=name;
				data[row][2]=email;
				data[row][3]=phone;
				data[row][4]=gender;
				data[row][5]=address;
				data[row][6]=appid;
				 
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 851, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 826, 543);
		contentPane.add(scrollPane);
		
		 enggtable = new JTable();
		 enggtable.setFont(new Font("Tahoma", Font.BOLD, 16));
		 enggtable.setForeground(Color.BLACK);
		
		
		JTableHeader header =  enggtable.getTableHeader();
	      header.setBackground(Color.BLACK);
	      header.setForeground(Color.WHITE);
	      header.setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 20));
	    
		JButton btnShow = new JButton("CLICK ON IT");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShow.addActionListener(this);
		btnShow.setBounds(604, 564, 140, 30);
		contentPane.add(btnShow);
		
		JLabel lblIfYouWant = new JLabel("If You Want To See The Details Of Engineer");
		lblIfYouWant.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblIfYouWant.setBounds(114, 570, 400, 24);
		contentPane.add(lblIfYouWant);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  populateArray();//data populate
		     enggtable.setModel(new DefaultTableModel(data,colNames)  );
		     
		     
			scrollPane.setViewportView(enggtable);
		
	}
}
