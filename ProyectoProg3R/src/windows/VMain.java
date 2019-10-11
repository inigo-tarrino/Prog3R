package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VMain {

	JFrame ventanaMain;
	private final Action actionHome = new SwingActionHome();
	private final Action actionShop = new SwingActionShop();
	private final Action actionAccount = new SwingActionAccount();
	private final Action actionHistory = new SwingActionHistory();
	private final Action actionPreferences = new SwingActionPreferences();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMain window = new VMain();
					window.ventanaMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaMain = new JFrame();
		ventanaMain.setBounds(100, 100, 1280, 720);
		ventanaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMain.getContentPane().setLayout(null);
		
		JPanel pBotonera= new JPanel();
		pBotonera.setBounds(0, 0, 350, 698);
		ventanaMain.getContentPane().add(pBotonera);
		pBotonera.setLayout(null);
		
		JButton bHome = new JButton("Home");
		bHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHome = new JPanel();
				pHome.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHome);
				pHome.setLayout(null);
				System.out.println("pHome");
			}
		});
		bHome.setAction(actionHome);
		bHome.setBounds(10, 10, 250, 50);
		pBotonera.add(bHome);
		
		JButton bShop = new JButton("Shop");
		bShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pShop = new JPanel();
				pShop.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pShop);
				pShop.setLayout(null);
				System.out.println("pShop");
			}
		});
		bShop.setAction(actionShop);
		bShop.setBounds(10, 70, 250, 50);
		pBotonera.add(bShop);
		
		JButton bAccount = new JButton("Account");
		bAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pAccount = new JPanel();
				pAccount.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pAccount);
				pAccount.setLayout(null);
				System.out.println("pAccount");
			}
		});
		bAccount.setAction(actionAccount);
		bAccount.setBounds(10, 510, 250, 50);
		pBotonera.add(bAccount);
		
		JButton bHistory = new JButton("History");
		bHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHistory = new JPanel();
				pHistory.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHistory);
				pHistory.setLayout(null);
				System.out.println("pHistory");
			}
		});
		bHistory.setAction(actionHistory);
		bHistory.setBounds(10, 570, 250, 50);
		pBotonera.add(bHistory);
		
		JButton bPreferences = new JButton("Preferences");
		bPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pPreferences = new JPanel();
				pPreferences.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pPreferences);
				pPreferences.setLayout(null);
				System.out.println("pPreferences");
			}
		});
		bPreferences.setAction(actionPreferences);
		bPreferences.setBounds(10, 630, 250, 50);
		pBotonera.add(bPreferences);
	}
	private class SwingActionHome extends AbstractAction {
		public SwingActionHome() {
			putValue(NAME, "Home");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionShop extends AbstractAction {
		public SwingActionShop() {
			putValue(NAME, "Shop");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionAccount extends AbstractAction {
		public SwingActionAccount() {
			putValue(NAME, "Account");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionHistory extends AbstractAction {
		public SwingActionHistory() {
			putValue(NAME, "History");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionPreferences extends AbstractAction {
		public SwingActionPreferences() {
			putValue(NAME, "Preferences");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
