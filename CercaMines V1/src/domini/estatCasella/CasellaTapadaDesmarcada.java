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
	/*Si l'argument és null, llençar l'excepció d'argument il·legal,
	 * altrament fer al canvi d'estat*/
	public	void destapar(Casella casella) {
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no vàlid");
		else casella.setEstat(new CasellaDestapada());
	}

	@Override
	/*Si l'argument és null, llençar l'excepció d'argument il·legal,
	 * altrament fer al canvi d'estat*/
	public	void marcarPossibleMina(Casella casella)  {
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no vàlid");
		else casella.setEstat(new CasellaTapadaMarcada());
	}

	@Override
	//Cal informar de què la casella ja està desmarcada
	public	void desmarcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols desmarcar ja està desmarcada");
		// NO fer res, no canviar l'estat de la casella
	}
}
