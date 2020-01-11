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
		list.setBorder(BorderFactory.createLineBorder(Color.red));
		scrollPane.setViewportView(list);
		
		DefaultListModel model = new DefaultListModel();
		list.setModel(model);
		//TODO Añadir cositas
		ArrayList<File> array = Functions.loadFiles(dir);
		
		for( File f : array ) {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			model.addElement(line);
		}
		
		JButton openFile = new JButton( "Open File :D" );
		openFile.setBounds( 0 , 410 , 370 , 40 );
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int object_position = list.getSelectedIndex();
				if( object_position < 0 ) {
					JOptionPane.showMessageDialog(null, "You must select a ticket");
				}else {
					System.out.println(object_position);
					File doc = array.get(object_position);
					Desktop fileTOopen = Desktop.getDesktop();
					try {
						fileTOopen.open(doc);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		getContentPane().add(openFile);
		getContentPane().add(scrollPane);
		
	}
	
	public static void main(String[] args) {
		VHistory vhi;
		try {
			vhi = new VHistory("Users/admin");
			vhi.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
