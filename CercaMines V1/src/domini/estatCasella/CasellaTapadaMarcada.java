package domini.estatCasella;

import domini.Casella;

public class CasellaTapadaMarcada extends EstatCasella {

	@Override
	public	boolean getMarcadaPossibleMina() {
		return true;
	}

	@Override
	public	boolean getDestapada() {
		return false;
	}

	@Override
	/*Si l'argument és nul, cal llençar  una excepció
	 * d'argument il·legal, altrament fer el canvi d'estat*/
	public	void destapar(Casella casella){
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no vàlid");
		else casella.setEstat(new CasellaDestapada());
		
	}

	@Override
	//Cal informar que la casella ja està marcada
	public	void marcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols marcar ja està marcada");
		// NO fer res, no canvia l'estat de la casella
	}

	@Override
	/*Si l'argument és nul, cal llençar  una excepció
	 * d'argument il·legal, altrament fer el canvi d'estat*/
	public	void desmarcarPossibleMina(Casella casella){
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no vàlid");
		else casella.setEstat(new CasellaTapadaDesmarcada());
	}
}
