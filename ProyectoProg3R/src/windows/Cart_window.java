package windows;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import classes.Product;


public class Cart_window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNewLabel;
	
	public Cart_window(Point dim , ArrayList<Product> prods , double prec) {
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
		
		for (int i = 0; i < prods.size(); i++) {
			listModel.addElement( prods.get(i).getName() + " " + prods.get(i).getPrize() + " €" );
		}
		
		scrollPane.setViewportView(list);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(111, 356, 83, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(48, 400, 89, 23);
		getContentPane().add(btnDelete);
		
		///////////////////////
		
		btnDelete.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(list.getModel().getSize());
				int in = list.getSelectedIndex();
				System.out.println(in);
				if(in != -1) {
					listModel.remove(in);
					VMain.cart.remove_item(in);
				}
			}
		});
		
		Thread update_data = new Thread() {
			@Override
			public void run () {
				while(this.isAlive()) {
				double prec = VMain.cart.update_prize();
				lblNewLabel.setText(""+prec);
				}
			}
		};
		update_data.start();
		
		
		
	}
}
