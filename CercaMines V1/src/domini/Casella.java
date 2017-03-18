package domini;

import domini.estatCasella.EstatCasella;
import domini.tipusCasella.CasellaSenseMina;

//cada objecte d'aquesta classe representar� una casella del taulell del joc
public abstract class Casella {
	
	//-1=mina, de 0 a 8=numero mines ve�nes
	protected int contingut;		
	//indica en quina posici� es troba la casella dins el taulell de joc
	protected Coordenada posicio;
	/*contindr� un dels tres possibles estats d'una casella:
	 * Inicialment tapada i desmarcada o b�
	 * Tapada i marcada com a possible mina o b�
	 * Destapada */
	protected EstatCasella estat;

	//Si l'argument �s null, llen�ar una IllegalArgumentException.
	//Altrament inicialitzar els atributs necesaris.
	public Casella(Coordenada coordenada) {
		//Implementat
		if(coordenada == null) throw new IllegalArgumentException("Argument no v�lid");
		else{
			//contingut = 0;
			posicio = coordenada;
			estat= EstatCasella.getEstatInicial();
			
		}
	}	
	
	//incrementa amb 1 el n�mero de mines a prop
	public abstract void modificarVeiAmbMina();

	//Retorna cert si la casella t� una mina, i fals altrament
	public abstract boolean hiHaMina(); 
	
	//Retorna el contingut de la casella
	public int getContingut() {
		return this.contingut;
	}

	//Retrona cert si la casella est� destapada, fals altrament
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
	
	//Retorna si la casella est� o no marcada
	public boolean estaMarcadaPosibleMina() {
		return this.estat.getMarcadaPossibleMina();
	}
	
	//Retorna les coordenades de la casella
	public Coordenada getPosicio() {
		return this.posicio;
	}

	/*Retorna cert si la casella no t� cap ve� amb mina 
	 * ni ella cont� una mina, altrament retorna fals.*/
	public abstract boolean esBuida();
	
	/*Actualitzar l'estat de la casella*/
	//Cal validar que l'argument no sigui null.
	public void setEstat (EstatCasella nouEstat)  {
		//Implementat
		if(nouEstat == null) throw new IllegalArgumentException("Argument no v�lid");
		else estat = nouEstat;
		
	}
	
	/* Si la casella �s de tipus CasellaSenseMina, aquest m�tode crear� 
	 * i retornar� un objecte de la classe CasellaAmbMina. 
	 * Altrament no ha de fer res de res*/
	public abstract Casella collocarMina(Casella[] cercarCasellesVeines);
	
	//Crea i retorna un objecte de la classe CasellaSenseMina
	public static Casella crearCasellaSenseMina(Coordenada coordenada){
		return new CasellaSenseMina(coordenada);
	}		
}