package com.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Supervisorlogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem miempadd , mntmAddCustomer,mntmAllotService, mntmViewEngineer,mntmServiceStatus,mntmDeliveryStatus, mntmUpdateCustomer,mntmDeleteCustomer ;
	private JMenuItem mntmServiceStatus_1;
	private JMenuItem menuItem ,mntmServiceRequestView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisorlogin frame = new Supervisorlogin();
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
	public Supervisorlogin() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1519, 838);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu empmenu = new JMenu("MANAGE APPLIANCES");
		empmenu.setForeground(Color.BLACK);
		empmenu.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		menuBar.add(empmenu);
		
	     miempadd = new JMenuItem("ADD APPLIANCES");
	     miempadd.setForeground(Color.BLACK);
	     miempadd.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
	     miempadd.addActionListener(this);
		 empmenu.add(miempadd);
		 
		 JMenuItem mntmDeleteAppliances = new JMenuItem("DELETE APPLIANCES");
		 mntmDeleteAppliances.setForeground(Color.BLACK);
		 mntmDeleteAppliances.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		 mntmDeleteAppliances.addActionListener(this);
		 empmenu.add(mntmDeleteAppliances);
		 
		 JLabel label_1 = new JLabel("                                                                                        ");
		 menuBar.add(label_1);
		 
		 JMenu mnManageCustomer = new JMenu("MANAGE CUSTOMER");
		 mnManageCustomer.setForeground(Color.BLACK);
		 mnManageCustomer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		 menuBar.add(mnManageCustomer);
		 
		   mntmAddCustomer = new JMenuItem("ADD CUSTOMER");
		   mntmAddCustomer.setForeground(Color.BLACK);
		   mntmAddCustomer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		  mntmAddCustomer.addActionListener(this);
		 mnManageCustomer.add(mntmAddCustomer);
		 
		  mntmUpdateCustomer = new JMenuItem("UPDATE CUSTOMER");
		  mntmUpdateCustomer.setForeground(Color.BLACK);
		  mntmUpdateCustomer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		  mntmUpdateCustomer.addActionListener(this);
		 mnManageCustomer.add(mntmUpdateCustomer);
		 
		  mntmDeleteCustomer = new JMenuItem("DELETE CUSTOMER");
		  mntmDeleteCustomer.setForeground(Color.BLACK);
		  mntmDeleteCustomer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		  mntmDeleteCustomer.addActionListener(this);
		 mnManageCustomer.add(mntmDeleteCustomer);
		 
		 JLabel label_2 = new JLabel("                                                                   ");
		 menuBar.add(label_2);
		 
		 JMenu mnManageServices = new JMenu("MANAGE SERVICES");
		 mnManageServices.setForeground(Color.BLACK);
		 mnManageServices.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		 menuBar.add(mnManageServices);
		 
		  mntmViewEngineer = new JMenuItem("VIEW ENGINEER DETAIL");
		  mntmViewEngineer.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		  mntmViewEngineer.setForeground(Color.BLACK);
		  mntmViewEngineer.addActionListener(this);
		 mnManageServices.add(mntmViewEngineer);
		 
		   mntmServiceStatus = new JMenuItem("VIEW CUSTOMER DETAIL");
		   mntmServiceStatus.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		   mntmServiceStatus.setForeground(Color.BLACK);
		   mntmServiceStatus.addActionListener(this);
		 mnManageServices.add(mntmServiceStatus);
		 
		   mntmDeliveryStatus = new JMenuItem("DELIVERY STATUS");
		   mntmDeliveryStatus.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		   mntmDeliveryStatus.setForeground(Color.BLACK);
		   mntmDeliveryStatus.addActionListener(this);
		 mnManageServices.add(mntmDeliveryStatus);
		 
		 mntmServiceStatus_1 = new JMenuItem("SERVICE STATUS");
		 mntmServiceStatus_1.setForeground(Color.BLACK);
		 mntmServiceStatus_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		 mntmServiceStatus_1.addActionListener(this);
		 mnManageServices.add(mntmServiceStatus_1);
		 
		 menuItem = new JMenuItem("ADD SERVICE");
		 menuItem.setForeground(Color.BLACK);
		 menuItem.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		 menuItem.addActionListener(this);
		 mnManageServices.add(menuItem);
		 
		  mntmAllotService = new JMenuItem("ALLOT SERVICE");
		 mntmAllotService.setForeground(Color.BLACK);
		 mntmAllotService.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		 mntmAllotService.addActionListener(this);
		 mnManageServices.add(mntmAllotService);
		 
		 mntmServiceRequestView = new JMenuItem("SERVICE REQUEST");
		 mntmServiceRequestView.setForeground(Color.BLACK);
		 mntmServiceRequestView.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		 mntmServiceRequestView.addActionListener(this);
		 mnManageServices.add(mntmServiceRequestView);
		 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("                                                                  ");
		label.setIcon(new ImageIcon(Supervisorlogin.class.getResource("/com/image/IMG_20190725_225707.jpg")));
		label.setBounds(0, 0, 1577, 779);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "Welcome");
		
		String caption = e.getActionCommand();
		System.out.println(caption);
		
		if(caption.equalsIgnoreCase("ADD APPLIANCES")) {
			Addappliance ac = new Addappliance();
			ac.setVisible(true);
		}
		if(caption.equalsIgnoreCase("ADD CUSTOMER")) {
			Addcustomer ad = new Addcustomer();
			ad.setVisible(true);
		}
		
		if(caption.equalsIgnoreCase("VIEW ENGINEER DETAIL")) {
			Viewengg ad = new Viewengg();
			ad.setVisible(true);
		}
		
		if(caption.equalsIgnoreCase("SERVICE STATUS")) {
			updateservice us = new updateservice();
			us.setVisible(true);
	}
		if(caption.equalsIgnoreCase("DELIVERY STATUS")) {
		updatedelivery ud = new updatedelivery();
			ud.setVisible(true);
       }
		if(caption.equalsIgnoreCase("UPDATE CUSTOMER")) {
			Updatecustomer ud = new Updatecustomer();
				ud.setVisible(true);
	       }
		
		if(caption.equalsIgnoreCase("DELETE CUSTOMER")) {
			 Deletecustomer dc = new Deletecustomer();
				dc.setVisible(true);
	       }
		if(caption.equalsIgnoreCase("ADD SERVICE")) {
			Servicereqst sr = new Servicereqst();
			sr.setVisible(true);
		}
		if(caption.equalsIgnoreCase("VIEW CUSTOMER DETAIL")) {
			Viewcustomer vc = new Viewcustomer();
			vc.setVisible(true);
		}
		if(caption.equalsIgnoreCase("DELETE APPLIANCES")) {
			Deleteappliance da = new Deleteappliance();
			da.setVisible(true);
		}
		if(caption.equalsIgnoreCase("ALLOT SERVICE")) {
			 allotservice as = new allotservice();
			as.setVisible(true);
		}
		if(caption.equalsIgnoreCase("SERVICE REQUEST")) {
			 serviceview as = new serviceview();
			as.setVisible(true);
		}
		
	}
}

