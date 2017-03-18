package domini;

import java.util.Random;

import domini.estatCasella.CasellaTapadaMarcada;
import domini.tipusCasella.CasellaAmbMina;

public class TaulellCercaMines {

	private Casella[][] taulell;// taulell pel joc del cercamines
	private static final int MAX_FILES = 10;// Número de files del taulell
	private static final int MAX_COLUMNES = 10;// Número de columnes del taulell
	private final int MAX_MINES; // % de mines com a màxim
	private final int MIN_MINES; // % de mines com a mínim
	private static Random random = new Random();

	public TaulellCercaMines() {
		MAX_MINES = 50;
		MIN_MINES = 10;
		this.taulell = new Casella[MAX_FILES][MAX_COLUMNES];
		this.inicialitzarTaulell();
		this.collocarMines();
	}

	/* Inicialitzar el taulell creant totes les caselles buides i sense mina */
	private void inicialitzarTaulell() {
		// IMPLEMENTAT
		for (int f = 0; f < MAX_FILES; f++) {
			for (int c = 0; c < MAX_COLUMNES; c++) {
				Coordenada coordenada = new Coordenada(f, c);
				this.taulell[f][c] = Casella.crearCasellaSenseMina(coordenada);
			}
		}
	}

	/*
	 * Col·locar mines en el taulell de forma aleatoria, per fer-ho caldrà: 1:
	 * calcular el nombre de mines que cal col·locar 1.1: generar un número
	 * aleatori entre MIN_MINES i MAX_MINES 1.2: el número obtingut en el pas
	 * anterior és el % de mines que ha de tenir el taulell 2: col·locar cada
	 * mina en una casella especifica 2.1: obtenir les coordenades de la casella
	 * de forma aleatoria 2.2: si la casella de la coordenada obtinguda NO té
	 * cap mina 2.2.1: col·locar una mina a la casella i informar a tots els
	 * veins de la casella, de què hi ha una mina veina (mètode
	 * cercarCasellesVeines()) 2.2.2: col·locar següent mina (tornar al pas 2)
	 * 2.2: si la casella de la coordenada obtinguda ja té una mina 2.2.1:
	 * tornar al pas 2.1
	 */
	private void collocarMines() {
		// IMPLEMENTAT
		int minesAColocar = generarNumAleatori(MIN_MINES, MAX_MINES)*MAX_FILES*MAX_COLUMNES/100;
		int fila, columna;
		boolean colocada = false;
		while (minesAColocar > 0) {
			while (!colocada) {
				//coordX = random.nextInt(MAX_FILES + 1);
				//coordY = random.nextInt(MAX_COLUMNES + 1);
				fila = generarNumAleatori(0, MAX_FILES-1);
				columna = generarNumAleatori(0, MAX_COLUMNES-1);
				if (!taulell[fila][columna].hiHaMina()) {
					this.taulell[fila][columna] = this.taulell[fila][columna].collocarMina(this.cercarCasellesVeines(this.taulell[fila][columna]));
					colocada = true;
				}
			}
			minesAColocar--;
			colocada = false;
		}
		
	}

	/*
	 * Retorna un vector amb les caselles que son veïnes a la casella de
	 * l'argument: 1: obtenir les coordenades de la casella de l'argument 2:
	 * obtenir totes les coordenades veïnes a la coordenada obtinguda al pas 1
	 * utilitzant el mètode cercarCoordenadesVeines() de la classe Coordenada 3:
	 * obtenir i retornar les caselles de les coordenades calculades en el pas 2
	 */
	private Casella[] cercarCasellesVeines(Casella casella) {
		//Implementat
				//Coordenada coordenada = new Coordenada(casella.getPosicio().getFila(), casella.getPosicio().getColumna());

				Coordenada coordenada = casella.getPosicio();
				Coordenada [] coordenadesVeines = coordenada.cercarCoordenadesVeines();
				Casella[] veines= new Casella[coordenadesVeines.length];
					for(int i = 0; i < coordenadesVeines.length; i++)
					{
						veines[i] = taulell[coordenadesVeines[i].getFila()][coordenadesVeines[i].getColumna()];
					}
				
				return veines;
	}

	/*
	 * Generador de nombres aleatoris retorna un enter entre min i max ambdós
	 * inclosos
	 */
	private int generarNumAleatori(int min, int max) {
		double aleatori = random.nextDouble();
		int retorn = (int) Math.floor(aleatori * (max - min + 1) + min);
		return retorn;
	}

	/* Retorna el número de files del taulell */
	public static int getFiles() {
		return MAX_FILES;
	}

	/* Retorna el número de columnes del taulell */
	public static int getColumnes() {
		return MAX_COLUMNES;
	}

	/* Retorna el taulell en una matriu de String */
	public String[][] veureTaulell() {
		String[][] retorn = new String[MAX_FILES][MAX_COLUMNES];
		Casella casella;
		String valor;
		// Recòrrer tot el taulell
		for (int i = 0; i < MAX_FILES; i++) {// Per tota fila
			for (int j = 0; j < MAX_COLUMNES; j++) {// Per cada columna
				casella = this.taulell[i][j];
				if (casella.estaDestapada()) {
					if (casella.hiHaMina()) {
						valor = "M";// si la casella està destapada i hi ha una
									// mina posem una "M"
					} else {
						// si la casella està destapada i NO hi ha una mina
						// posem el nombre de caselles veïnes amb mina
						valor = String.valueOf(casella.getContingut());
					}
				} else {// casella tapada
					if (casella.estaMarcadaPosibleMina()) {
						valor = "X";
					} else {
						valor = "";
					}
				}
				retorn[i][j] = valor;
			}
		}
		return retorn;
	}

	/*
	 * Prepara totes les caselles per mostrar el seu contingut, per fer-ho
	 * destapa les caselles que no ho estan
	 */
	private void destaparTotElTaulell() {
		// IMPLEMENTAT
		for (int f = 0; f < MAX_FILES; f++) {
			for (int c = 0; c < MAX_COLUMNES; c++) {
				// Si NO esta destapada, la destapa
				if (!(this.taulell[f][c].estaDestapada()))
					this.taulell[f][c].destapar();

			}
		}
	}

	/*
	 * Retorna cert si totes les caselles sense mina estan destapades i fals
	 * altrament. Si està tot destapat, abans de fer el retorn crida a
	 * destaparTotElTaulell()
	 */
	public boolean estaTotElTaulellDestapat() {
		// Implementat

		for (int f = 0; f < MAX_FILES; f++) {
			for (int c = 0; c < MAX_COLUMNES; c++) {
				//Si NO te mina, entra al bloc
				if (!(this.taulell[f][c] instanceof CasellaAmbMina)) {
					// Si la casella que estem mirant NO esta destapada, retorna fals
					if (!((this.taulell[f][c].estaDestapada())))
						return false;
				}
			}
		}
		destaparTotElTaulell();
		return true;
	}

	/*
	 * Valida la fila i columna i retorna cert si a la casella hi ha una mina, i
	 * fals altrament
	 */
	public boolean hiHaMina(int fila, int columna) {
		// Implementat
		Coordenada.validarCoordenades(fila, columna);
		if (taulell[fila][columna].hiHaMina())
			return true;
		else
			return false;
	}

	/*
	 * Valida la coordenada i marca la casella com a possible mina utilitzant
	 * marcarMinaCoordenadesValidades()
	 */
	public void marcarMina(int fila, int columna) {
		// Implementat
		Coordenada.validarCoordenades(fila, columna);
		marcarMinaCoordenadesValidades(fila, columna);
	}

	/* marcar una casella com a possible mina */
	private void marcarMinaCoordenadesValidades(int fila, int columna) {
		// Implementat??
		taulell[fila][columna].setPosibleMina(true);
	}

	/*
	 * Valida la coordenada i desmarca la casella com a possible mina utilitzant
	 * desmarcarMinaCoordenadesValidades()
	 */
	public void desmarcarMina(int fila, int columna) {
		// IMPLEMENTAT
		Coordenada.validarCoordenades(fila, columna);
		desmarcarMinaCoordenadesValidades(fila, columna);
	}

	/* desmarcar una casella com a possible mina */
	private void desmarcarMinaCoordenadesValidades(int fila, int columna) {
		// Implementat?
		taulell[fila][columna].setPosibleMina(false);

	}

	/*
	 * Si la casella està marcada com a possible mina la desmarca i si no està
	 * marcada, la marca. Cal tenir en compte de només validar les coordenades
	 * una vegada
	 */
	public void marcarDesmarcarCasella(int fila, int columna) {
		// Implementat
		if (taulell[fila][columna].estaMarcadaPosibleMina()) {
			desmarcarMina(fila, columna);
		} else
			marcarMina(fila, columna);
	}

	/*
	 * El jugador vol destapar una casella, hi ha dues situacions: A: Hi ha una
	 * mina a la casella que vol destapar, aleshores es destaparà tot el
	 * taulell, situació de fi de joc. B: altrament B1: destapar la casella B2:
	 * destapar de forma recursiva, totes les caselles veines (mètode
	 * destaparVeinsBuits()).
	 */
	public void destapar(int fila, int columna) {
		// Implementat
		if (taulell[fila][columna].hiHaMina()) {
			destaparTotElTaulell();
		}else{
			taulell[fila][columna].destapar();
			destaparVeinsBuits(taulell[fila][columna]);
		}
	}

	/*
	 * Donada una casella destapada sense mina, destapa totes les caselles
	 * veïnes de forma recursiva (mètode que es crida a ell mateix). Es podrà
	 * destapar una casella veina si es compleixen totes les següents
	 * condicions: 1: no estar destapada 2: no estar marcada com a possible mina
	 * (tant si hi ha mina com si no) 3: no tenir una mina En el supòsit que
	 * finalment la casella és destapada, si no té cap mina veina caldrà cridar
	 * el mateix mètode, essent l'argument d'entrada la casella destapada (això
	 * és la recursivitat)
	 */
	private void destaparVeinsBuits(Casella casella) {
		Casella[] veins = this.cercarCasellesVeines(casella);
		for (Casella c : veins) {
			if (!c.estaDestapada() && !c.estaMarcadaPosibleMina() && !c.hiHaMina()) {
				c.destapar();
				if (c.esBuida()) {
					this.destaparVeinsBuits(c);// recursivitat
				}
			}
		}
	}
}