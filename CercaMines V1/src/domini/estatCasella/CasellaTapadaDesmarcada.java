package domini.estatCasella;

import domini.Casella;

public class CasellaTapadaDesmarcada extends EstatCasella {

	@Override
	public	boolean getMarcadaPossibleMina() {
		return false;
	}

	@Override
	public	boolean getDestapada() {
		return false;
	}

	@Override
	/*Si l'argument �s null, llen�ar l'excepci� d'argument il�legal,
	 * altrament fer al canvi d'estat*/
	public	void destapar(Casella casella) {
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no v�lid");
		else casella.setEstat(new CasellaDestapada());
	}

	@Override
	/*Si l'argument �s null, llen�ar l'excepci� d'argument il�legal,
	 * altrament fer al canvi d'estat*/
	public	void marcarPossibleMina(Casella casella)  {
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no v�lid");
		else casella.setEstat(new CasellaTapadaMarcada());
	}

	@Override
	//Cal informar de qu� la casella ja est� desmarcada
	public	void desmarcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols desmarcar ja est� desmarcada");
		// NO fer res, no canviar l'estat de la casella
	}
}
