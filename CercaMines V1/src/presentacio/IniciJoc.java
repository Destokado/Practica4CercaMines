package presentacio;

import domini.JocCercarMines;
import jconsole.JConsole;

public class IniciJoc {
	private JocCercarMines joc;
	private JConsole console;

	public static void main(String[] args) {
		new IniciJoc();
	}

	/*
	 * 1: crear una consola 2: crear un controlador del joc 3: mostrar el
	 * taulell tot tapat (amb ?) 4: Mentre el jugador no entri -1 i el joc no
	 * finalitzi: 4.1: llegir entrada de la consola 4.2: validar i executar
	 * l'entrada * 4.3: Si tot és correcte, comprovar si és fi de joc 4.4:
	 * mostrar l'estat del taulell després de l'acció 5. Al final del joc
	 * mostrar el motiu de fi de joc
	 */
	private IniciJoc() {
		console = new JConsole(100, 30);
		try {
			this.joc = new JocCercarMines();
		} catch (Exception e) {
			console.println("No s'ha pogut crear un objecte de la classe JocCercarMines, és un error del programador, el programa s'acaba");
			console.println("Prem qualsevol tecla per sortir...");
			console.readKey(true);
			System.exit(0);

		}
		String entrada = "";

		console.println("Comença el joc");
		while (!joc.esFiJoc() && !entrada.equals("-1")) {
			veureTaulell();
			console.println("Les files i les columnes del 1 al 10. destapar d, marcar m, desmarcar e.");
			console.println(
					"Entra: fila, columna, d=destapar o m=marcar o e=desmarcar (exemple: 3,4,d o bé 3,4,m) o -1 sortir:");
			entrada = console.readString();
			try {
				validarExecutarEntrada(entrada);
			} catch (Exception e) {
				e.getMessage();
			}
			//No cal demanar si és fi de Joc perquè el propi while ja ho comprova
			console.clear();

		}
		//Mostra el taulell al acabar la partida
		veureTaulell();
//Explica el motiu de l'acabament de la partida
		console.println("\nJoc finalitzat: "+ joc.getMotiuFiJoc());
		console.setCursorPosition(0, console.getRows() - 1);
		console.print("Apreta qualsevol tecla per sortir...");
		console.readKey(true);
		System.exit(0);

	}

	/*
	 * Validar l'entrada que ha fet el jugador: 1: Validar que l'entrada té 3
	 * valors separats per coma Si no és correcte, informar de l'error i tornar
	 * a demanar entrada 2: convertir la fila i la columna de text a enter Si no
	 * és correcte, informar de l'error i tornar a demanar entrada 3:
	 * transformar coordenades de 1..10 a 0..9 4: validar tipus acció, ha de ser
	 * d, m o e Si no és correcte, informar de l'error i tornar a demanar
	 * entrada 5: Fer que el joc realitzi l'acció
	 */
	private void validarExecutarEntrada(String entrada) throws Exception {
		// PENDENT IMPLEMENTAR
		int fila = 0, columna = 0;
		String[] ordres = new String[3];
		if (!entrada.equals("-1")) {
			ordres = entrada.split(",");
		}
		if (ordres.length != 3) {
			throw new Exception("Entrada incorrecte, has d'introduir fila, columna i acció separat per comes");
		}
		try {
			fila = Integer.parseInt(ordres[0]) - 1;
			columna = Integer.parseInt(ordres[1]) - 1;

		}

		catch (Exception e) {
			console.println(
					"Error, els dos primers paràmetres han de ser nombres corresponents a coordenades del taulell");
		}
		if (!(ordres[2].equals("m") || (ordres[2].equals("d")) || (ordres[2].equals("d")))) {
			throw new Exception("Caràcter incorrecte, ha de ser d, m o e");
		}
		switch (ordres[2]) {
		case "m":
			joc.marcarMina(fila, columna);
			break;
		case "d":
			joc.destaparCasella(fila, columna);
			break;
		case "e":
			joc.desmarcarMina(fila, columna);
			break;

		}

		// CODI VERSIÓ ANTERIOR
		/*
		 * if (!entrada.equals("-1")) { ordres = entrada.split(","); if
		 * (ordres.length != 3) { return
		 * "Entrada incorrecte, has d'introduir fila, columna i acció separat per comes"
		 * ; } if (this.isNumeric(ordres[0]) && this.isNumeric(ordres[1])) { if
		 * (ordres[2].equals("d")) { return
		 * joc.destaparCasella(Integer.parseInt(ordres[0]) - 1,
		 * Integer.parseInt(ordres[1]) - 1);
		 * 
		 * } else if (ordres[2].equals("m")) { return
		 * joc.marcarMina(Integer.parseInt(ordres[0]) - 1,
		 * Integer.parseInt(ordres[1]) - 1);
		 * 
		 * } else if (ordres[2].equals("e")) { return
		 * joc.desmarcarMina(Integer.parseInt(ordres[0]) - 1,
		 * Integer.parseInt(ordres[1]) - 1); } else { return
		 * "Caràcter incorrecte, ha de ser d, m o e"; } } else { return
		 * "Error, els dos primers paràmetres han de ser nombres corresponents a coordenades del taulell"
		 * ; } } else { return ""; }
		 */

	}

	// Mostrar el taulell a la consola de sortida.
	private void veureTaulell() {
		String[][] taulell = joc.veureTaulell();
		for (int fila = 0; fila < taulell.length; fila++) {
			for (int columna = 0; columna < taulell[0].length; columna++) {
				if (taulell[fila][columna].equals("")) {
					console.print("?\t");
				} else {
					console.print(taulell[fila][columna] + "\t");
				}
			}
			console.println();
		}
		console.println("Les files i les columnes del 1 al 10. destapar d, marcar m, desmercar e i -1 per sortir.");
		console.println(
				"Entra: fila, columna, d=destapar o m=marcar o e=desmarcar (exemple: 3,4,d o bé 3,4,m) o -1 sortir:");
	}
}