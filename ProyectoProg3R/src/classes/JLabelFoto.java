package classes;
import javax.swing.*;

public class JLabelFoto extends JLabel{
	
	/**
	 * Eneko Valero 20/12/2019
	 * 
	 * Clase usada para colocar las fotos de los productos
	 * en la pantalla principal.
	 */
	private static final long serialVersionUID = 1L;
	protected String ruta;
	public JLabelFoto (String Path) {
		this.ruta = Path;
	}
	
	public void setPath (String Path) {
		this.ruta = Path;
	}
	public void PutImage () {
		this.setIcon( new ImageIcon(this.ruta));
	}

}
