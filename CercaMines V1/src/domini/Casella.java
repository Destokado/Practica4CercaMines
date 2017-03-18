package domini;

import domini.estatCasella.EstatCasella;
import domini.tipusCasella.CasellaSenseMina;

//cada objecte d'aquesta classe representarà una casella del taulell del joc
public abstract class Casella {
	
	//-1=mina, de 0 a 8=numero mines veïnes
	protected int contingut;		
	//indica en quina posició es troba la casella dins el taulell de joc
	protected Coordenada posicio;
	/*contindrà un dels tres possibles estats d'una casella:
	 * Inicialment tapada i desmarcada o bé
	 * Tapada i marcada com a possible mina o bé
	 * Destapada */
	protected EstatCasella estat;

	//Si l'argument és null, llençar una IllegalArgumentException.
	//Altrament inicialitzar els atributs necesaris.
	public Casella(Coordenada coordenada) {
		//Implementat
		if(coordenada == null) throw new IllegalArgumentException("Argument no vàlid");
		else{
			//contingut = 0;
			posicio = coordenada;
			estat= EstatCasella.getEstatInicial();
			
		}
	}	
	
	//incrementa amb 1 el número de mines a prop
	public abstract void modificarVeiAmbMina();

	//Retorna cert si la casella té una mina, i fals altrament
	public abstract boolean hiHaMina(); 
	
	//Retorna el contingut de la casella
	public int getContingut() {
		return this.contingut;
	}

	//Retrona cert si la casella està destapada, fals altrament
	public boolean estaDestapada() {
		return this.estat.getDestapada ();
	}

	//Destapa la casella
	public void destapar() {
		this.estat.destapar(this);
	}

	//Actualitzar l'estat de la caella
	public void setPosibleMina(boolean marca){
		if (marca) {
			this.estat.marcarPossibleMina(this);
		} else {
			this.estat.desmarcarPossibleMina(this);
		}
	}
	
	//Retorna si la casella està o no marcada
	public boolean estaMarcadaPosibleMina() {
		return this.estat.getMarcadaPossibleMina();
	}
	
	//Retorna les coordenades de la casella
	public Coordenada getPosicio() {
		return this.posicio;
	}

	/*Retorna cert si la casella no té cap veí amb mina 
	 * ni ella conté una mina, altrament retorna fals.*/
	public abstract boolean esBuida();
	
	/*Actualitzar l'estat de la casella*/
	//Cal validar que l'argument no sigui null.
	public void setEstat (EstatCasella nouEstat)  {
		//Implementat
		if(nouEstat == null) throw new IllegalArgumentException("Argument no vàlid");
		else estat = nouEstat;
		
	}
	
	/* Si la casella és de tipus CasellaSenseMina, aquest mètode crearà 
	 * i retornarà un objecte de la classe CasellaAmbMina. 
	 * Altrament no ha de fer res de res*/
	public abstract Casella collocarMina(Casella[] cercarCasellesVeines);
	
	//Crea i retorna un objecte de la classe CasellaSenseMina
	public static Casella crearCasellaSenseMina(Coordenada coordenada){
		return new CasellaSenseMina(coordenada);
	}		
}