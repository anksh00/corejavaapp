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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Addengineer extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextArea txtaddress;
	private Connection con;
	private JRadioButton rdmale,rdfemale;
	private ButtonGroup gender;
	private PreparedStatement ps;
	private JLabel lblGender;
	private ResultSet rs;
	private JComboBox txtappid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addengineer frame = new Addengineer();
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
	public Addengineer() {
		 
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo() {
		try
		{
			String strinsert="select applianceid from appliancesdetail";
			ps=con.prepareStatement(strinsert);
			rs=ps.executeQuery();
			
			while(rs.next()==true)
			{
				String engid=rs.getString("applianceid");
				txtappid.addItem(engid);
				
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("ENGINEER ID");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(61, 93, 161, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(61, 147, 121, 25);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(61, 182, 121, 27);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhone.setBounds(61, 235, 105, 27);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(40, 329, 142, 40);
		contentPane.add(lblAddress);
		
		JLabel lblAppliancesid = new JLabel("APPLIANCESID");
		lblAppliancesid.setForeground(Color.BLACK);
		lblAppliancesid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAppliancesid.setBounds(47, 379, 161, 35);
		contentPane.add(lblAppliancesid);
		
		txtid = new JTextField();
		txtid.setBounds(271, 101, 215, 27);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(271, 151, 215, 25);
		contentPane.add(txtname);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(271, 186, 215, 27);
		contentPane.add(txtemail);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(268, 235, 218, 27);
		contentPane.add(txtphone);
		
		JLabel lblAddEngineer = new JLabel("ADD ENGINEER");
		lblAddEngineer.setForeground(Color.BLACK);
		lblAddEngineer.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblAddEngineer.setBounds(148, 10, 370, 49);
		contentPane.add(lblAddEngineer);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(192, 448, 152, 35);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		 rdfemale = new JRadioButton("FEMALE");
		 rdfemale.setFont(new Font("Dialog", Font.BOLD, 20));
		rdfemale.setBounds(400, 280, 161, 35);
		contentPane.add(rdfemale);
		
		gender=new ButtonGroup();
		gender.add(rdfemale);
		
		lblGender = new JLabel("GENDER");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(61, 284, 121, 27);
		contentPane.add(lblGender);
		 
		  rdmale = new JRadioButton("MALE");
		  rdmale.setFont(new Font("Dialog", Font.BOLD, 20));
		  rdmale.setBounds(249, 280, 114, 35);
		  contentPane.add(rdmale);
		  gender.add(rdmale);
		
		 txtaddress = new JTextArea();
		txtaddress.setBounds(271, 333, 215, 28);
		contentPane.add(txtaddress);
		
		 txtappid = new JComboBox();
		 txtappid.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtappid.setBounds(271, 379, 180, 35);
		txtappid.setModel(new DefaultComboBoxModel(new String[] {"Appliance Id"}));
		fillCombo();
		contentPane.add(txtappid);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Addengineer.class.getResource("/com/image/pexels-photo-262488.jpeg")));
		label.setBounds(0, 0, 646, 493);
		contentPane.add(label);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String enggid = txtid.getText().trim();
		String enggname = txtname.getText().trim();
		String enggemail = txtemail.getText().trim();
		String enggphone = txtphone.getText().trim();
        String enggadd=txtaddress.getText();
        String enggappid=(String) txtappid.getSelectedItem();
       
		String gen = null; 
		if (rdmale.isSelected())
			gen = rdmale.getText();
		if (rdfemale.isSelected())
			gen = rdfemale.getText();

		if (enggid.isEmpty() || enggname.isEmpty() || enggemail.isEmpty() || enggphone.isEmpty() || gen.isEmpty() ||enggadd.isEmpty()|| enggappid.isEmpty()){
			JOptionPane.showMessageDialog(this, "Data Needed");
		} 
		else
		{
			try {
				String strinsert = "insert into enggdetails values(?,?,?,?,?,?,?)";
				ps = con.prepareStatement(strinsert); // dbms compiles this query
				ps.setString(1, enggid);
				ps.setString(2, enggname);
				ps.setString(3, enggemail);
				ps.setString(4, enggphone);
				ps.setString(5, gen);
				ps.setString(6, enggadd);
				ps.setString(7, enggappid);
				

				int row = ps.executeUpdate();
				if (row > 0) {
					System.out.println("row inserted successfully");
					JOptionPane.showMessageDialog(this, "Record Added Successfully");
					txtid.setText(" ");
					txtname.setText("");
					txtemail.setText("");
					txtphone.setText(" ");
					txtaddress.setText(" ");
					 
				}

			} catch (SQLException se) {
				System.out.println(se);
			}
			finally {
				if(ps!=null)
					try {
					ps.close();
					}
				catch(SQLException se) {
					System.out.println(se);
				}
			
				}
			}
		}
	}

