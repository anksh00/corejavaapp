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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Deleteengg extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> cmbid;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteengg frame = new Deleteengg();
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
	public Deleteengg() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo() {
		try {

			String strsql = "select id from enggdetails";

			ps = con.prepareStatement(strsql);
			rs = ps.executeQuery();// select query

			while (rs.next() == true) {

				String enggid = rs.getString("id");
				cmbid.addItem(enggid);

			}

		} 
		catch (SQLException se) 
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
		
	     cmbid = new JComboBox();
	     cmbid.setFont(new Font("Verdana", Font.BOLD, 15));
		cmbid.setModel(new DefaultComboBoxModel(new String[] { "Select Engineerid" }));
		cmbid.setBounds(287, 137, 204, 31);
		fillCombo();
		contentPane.add(cmbid);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(210, 236, 137, 32);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
		JLabel lblEngineerId = new JLabel("Engineer Id");
		lblEngineerId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEngineerId.setBounds(70, 137, 154, 32);
		contentPane.add(lblEngineerId);
		
		JLabel lblNewLabel_1 = new JLabel(" DELETE ENGINEER");
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(80, 20, 411, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(Deleteengg.class.getResource("/com/image/IMG_20190724_223820.jpg")));
		lblNewLabel.setBounds(-708, 0, 1354, 493);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int option=JOptionPane.showConfirmDialog(this, "Are u sure u wish to delete record");
		System.out.println(option);
		if(option==0)
		{
				String employeeid=(String)cmbid.getSelectedItem(); 
				
				if(employeeid.equals("Select EmployeeID"))
				{
					
					JOptionPane.showMessageDialog(this, "Pls Select Valid Id");
				}
				
				else {
					String strdelete="delete from enggdetails where id=?";
					try {
						
						ps=con.prepareStatement(strdelete);
						ps.setString(1, employeeid);
					int row=	ps.executeUpdate();//insert/upadte/delete
					if(row>0)
					{
						
						JOptionPane.showMessageDialog(this, "Record Delelted Sucessfully");
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
		 