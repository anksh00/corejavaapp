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
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Deleteappliance extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteappliance frame = new Deleteappliance();
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
	public Deleteappliance() {
		con=CrudOperation.createConnection();
		createGui();
	}
	public void fillCombo()
	{
		try {
		String strsql="select applianceid from appliancesdetail";
		ps=con.prepareStatement(strsql);
		rs=ps.executeQuery();
		while(rs.next()==true)
		{
			String appid=rs.getString("ApplianceId");
			comboBox.addItem(appid);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Appliance Id"}));
		comboBox.setBounds(305, 151, 178, 43);
		fillCombo();
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 20));
		btnDelete.setBounds(205, 268, 155, 35);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
		JLabel lblApplianceId = new JLabel("APPLIANCE ID");
		lblApplianceId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApplianceId.setBounds(49, 149, 208, 43);
		contentPane.add(lblApplianceId);
		
		JLabel lblDeleteAppliance = new JLabel("DELETE APPLIANCE");
		lblDeleteAppliance.setForeground(Color.WHITE);
		lblDeleteAppliance.setFont(new Font("Viner Hand ITC", Font.BOLD, 33));
		lblDeleteAppliance.setBounds(29, 27, 487, 43);
		contentPane.add(lblDeleteAppliance);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Deleteappliance.class.getResource("/com/image/IMG_20190725_230042.jpg")));
		label.setBounds(0, 0, 646, 1035);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		System.out.println(caption);
		
		if(caption.equalsIgnoreCase("DELETE"))
		{
		String appid=(String) comboBox.getSelectedItem();
		if(appid.equals("Select Appliance Id"))
				{
			      JOptionPane.showMessageDialog(this, "Please Select Valid Id");
				}
		else {
		String strdel="delete from appliancesdetail where applianceid=?";
		try
		{
			ps=con.prepareStatement(strdel);
			ps.setString(1, appid);
			int row=ps.executeUpdate();
			if(row>0)
			{
				JOptionPane.showConfirmDialog(this, "Are u Sure Want To Delete");
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
