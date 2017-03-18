package domini;

public class JocCercarMines {

	private TaulellCercaMines taulell;
	private boolean fiJoc;
	private String motiuFiJoc;

	//constructor que inicialitza els atributs.
	public JocCercarMines() {
		this.taulell = new TaulellCercaMines();
		this.fiJoc = false;
		this.motiuFiJoc = "Jugador aborta partida";
	}

	/* El jugador vol destapar la casella de coordenades x i y
	 * 1: destapar la casella de les coordenades entrades en l'argument
	 * 2: si la casella destapada té una mina 
	 * 	2.1:cal informar del fet amb els atributs fiJoc i motiuFiJoc
	 * 3: si la casella destapada no té cap mina, 
	 * 	 3.1: cal esbrinar si era la darrera casella per destapar
	 *      (mètode estaTotEllTaulellDestapat)*/
	public void destaparCasella(int x, int y) {
			taulell.destapar(x, y);
			if (!taulell.hiHaMina(x, y)) {// si no hi ha mina
				// comprovar si és final de joc
				this.estaTotElTaulellDestapat();
			} else {// hi ha mina a la casella destapada=>FI JOC
				this.fiJoc = true;
				this.motiuFiJoc = "HAS TOCAT UNA MINA, has perdut.";
			}
	}

	/* El jugador vol marcar la casella de coordenades x i y com a possible mina*/
	public void marcarMina(int x, int y){
			taulell.marcarMina(x, y);
	}

	/* El jugador vol desmarcar la casella com a possible mina de coordenades x i y*/	
	public void desmarcarMina(int x, int y) {
			this.taulell.desmarcarMina(x, y);
		}

	//retorna fiJoc
	public boolean esFiJoc() {
		return this.fiJoc;
	}

	//retorna tot el taulell en una matriu de String
	public String [][] veureTaulell() {
		return this.taulell.veureTaulell();
	}	

	/* Comprova si tot el taulell està destapat, en cas
	 * afirmatiu prepara els atributs fiJoc i motiuFiJoc
	 *  adequadament.*/
	private void estaTotElTaulellDestapat() {
		if (this.taulell.estaTotElTaulellDestapat()) {
			this.fiJoc = true;
			this.motiuFiJoc = "FELICITATS HAS GUANYAT";
		}
	}

	public int getNumFiles() {
		return TaulellCercaMines.getFiles();
	}

	public int getNumColumnes() {
		return TaulellCercaMines.getColumnes();
	}
	
	public void marcarDesmarcarCasella(int fila, int columna) throws Exception {
		this.taulell.marcarDesmarcarCasella (fila, columna);			
	}

	public String getMotiuFiJoc() {
		return this.motiuFiJoc;
	}
}