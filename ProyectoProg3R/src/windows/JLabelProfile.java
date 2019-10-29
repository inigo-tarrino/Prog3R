package windows;

import javax.swing.*;

public class JLabelProfile extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public JLabelProfile() {
		setSize(500 , 300);
	}

	public void Meter_img (String ruta) {
		//TODO
		setIcon( new ImageIcon(ruta));
	}
}
