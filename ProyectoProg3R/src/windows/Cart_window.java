package windows;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import classes.Functions;
import classes.Product;
import classes.User;


public class Cart_window extends JFrame{

	/**
	 * Clase de la ventana 
	 * del carrito de compra.
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNewLabel;
	private User us;
	
	public Cart_window(Point dim , ArrayList<Product> prods , double prec , User usuario) {
		us = usuario;
		setTitle("Cart");
		setSize(200 , 500);
		setLocation(dim.x , dim.y);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 194, 345);
		getContentPane().add(scrollPane);
		
		String str[] = new String[prods.size()];
		System.out.println(prods.size());
		
		JList list = new JList(str);
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
		
		//Añade los productos del ArrayList a la lista.
		for (int i = 0; i < prods.size(); i++) {
			listModel.addElement( prods.get(i).getName() + " " + prods.get(i).getPrize() + " €" );
		}
		
		scrollPane.setViewportView(list);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 355, 118, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFocusPainted(false);
		btnDelete.setBounds(49, 430, 92, 23);
		getContentPane().add(btnDelete);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBounds(49, 397, 92, 23);
		getContentPane().add(btnConfirm);
		
		btnDelete.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Borra el indice de la lista seleccionado.
				System.out.println(list.getModel().getSize());
				int in = list.getSelectedIndex();
				System.out.println(in);
				if(in != -1) {
					listModel.remove(in);
					VMain.cart.remove_item(in);
				}
			}
		});
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = "Users/"+us.getNickName();
				//Crea el directorio con el path de arriba.
				boolean ok = Functions.createDirectory(path);
				System.out.println(ok);
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
					Date date = new Date(System.currentTimeMillis());
					String path2 = path+"/"+dateFormat.format(date)+".txt";
					System.out.println(path2);
					//Escribe en el fichero con el path y la lista del carrito.
					Functions.writeToFile(path2, list);
				}catch (Exception e2) {
					System.out.println(e2);
					System.out.println("Couldn't create the file");
				}
			}
		});
		
		/** Hilo que actualiza el precio del carrito 
		 * en tiempo real al borrar un articulo */
		
		Thread updateData = new Thread() {
			@Override
			public void run () {
				while(this.isAlive()) {
				double prec = VMain.cart.update_prize();
				lblNewLabel.setText(""+prec);
				}
			}
		};
		updateData.start();
		
		
		
	}
}
