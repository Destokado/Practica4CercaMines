package presentacio;

import javax.swing.JButton;

public class CasellaGrafica extends JButton{

	private static final long serialVersionUID = 1L;
	private int fila;
	private int columna;
	
	public CasellaGrafica (int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
}