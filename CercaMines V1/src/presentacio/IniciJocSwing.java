package presentacio;

import javax.swing.JFrame;

import domini.JocCercarMines;

public class IniciJocSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	private CasellaGrafica [][] taulellGrafic; //Matriu d'objectes que hereten de JButton.
	private JocCercarMines joc;//atribut per comunicar-se amb la lògica del joc cercar mines

	public static void main(String[] args) {
			new IniciJocSwing();				
	}

	private IniciJocSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Que passa si premem l'aspa
		setBounds(100, 100, 600, 600);		
		setTitle("JOC DEL CERCA MINES.     Butó dret=marcar/desmarcar. Butó esquerra=destapar");
		inicialitzarJoc();
	}
	
	private void inicialitzarJoc() {
		//PENDENT IMPLEMENTAR
		/*1- inicialitzar l'atribut joc. Si dóna error informar i finalitzar
		* 2- Crear un nou objecte de la interfície MouseListener redefinint el mètode 
		*    mouseClicked(MouseEvent mouseEvent) de la classe abstracta MouseAdapter.
		*    Per fer-ho podeu utilitzar una classe anònima. La implementació del mètode
		*    redefinit haurà de:
		*    2.1 obtenir la casellaGrafica que ha provocat l'event (getComponent).
		*    2.2 Esbrinar quin botó del mouse s'ha premut
		*    2.2.1 Si és el botó esquerre, cridar el mètode destaparCasella()
		*    2.2.2 Si és el botó dret, cridar el mètode marcarDesmarcarCasella()
		* 3- Crear l'atribut taulellGrafic
		* 4- Definir i crear una variable panell del tipus ContentPane
		* 5- Definir i crear una variable GridLayout de les mides del taulell del joc
		* 6- setejar el layout del panell amb el gridLayout
		* 7- inicialitzar l'atribut taulellGrafic amb 100 objectes CasellaGrafica.
		*    Per cada nou objecte
		*    7.1 afegir-hi l'escoltador (addMouseListener()) creat en el pas 2
		*    7.2 afegir el nou objecte al panell
		*    7.3 afegir el nou objete al taulellGrafic
		* 8- setegjr el ContentPane del JFrame amb el nostre panell
		* 9- Fer visible el JFrame
		*/		
	}

	/* Li demana a l'atribut joc que marqui o desmarqui la casella fila columna
	 * un cop fet, mostra el taulell gràfic (mostrarTaulellGrafic()) */
	private void marcarDesmarcarCasella(int fila, int columna) {
		//PENDENT IMPLEMENTAR	
	}

	/* Li demana a l'atribut joc que destapi la casella fila columna
	 * un cop fet mostra el taulell gràfic (mostrarTaulellGrafic())
	 * i si és final de joc, mostra el motiu (guanyat o perdut) */
	private void destaparCasella(int fila, int columna) {
		//PENDENT IMPLEMENTAR		
	}

	/* Obté l'estat actual del taulell de l'atribut joc
	 * i actualitza el text dels 100 objectes CasellaGrafica
	 *  amb els valors obtinguts */
	private void mostrarTaulellGrafic (){
		//PENDENT IMPLEMENTAR
	}
}