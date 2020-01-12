package windows;
import javax.swing.*;

import classes.Functions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VHistory extends JFrame {
	/**
	 * 
	 * Eneko Valero
	 * 
	 * Clase que muestra 
	 * los tickets de 
	 * compra de cada usuario.
	 */
	private static final long serialVersionUID = 1L;

	public VHistory(String dir) throws IOException {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(720 , 480);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 0 , 0 , 720 , 410 );
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel model = new DefaultListModel();
		list.setModel(model);
		ArrayList<File> array = Functions.loadFiles(dir);
		
		//Lee las lineas de los ficheros.
		for(File f : array) {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			model.addElement(line);
		}
		
		JButton openFile = new JButton( "Open Ticket" );
		openFile.setBounds( 0 , 410 , 706 , 33 );
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ticketPosition = list.getSelectedIndex();
				if(ticketPosition < 0) {
					JOptionPane.showMessageDialog(null, "You must select a ticket");
				}else {
					System.out.println(ticketPosition);
					//Busca el path del fichero y lo abre con la clase de java Desktop.
					File doc = array.get(ticketPosition);
					Desktop fileToOpen = Desktop.getDesktop();
					try {
						fileToOpen.open(doc);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		getContentPane().add(openFile);
		getContentPane().add(scrollPane);
		
	}
	
}
