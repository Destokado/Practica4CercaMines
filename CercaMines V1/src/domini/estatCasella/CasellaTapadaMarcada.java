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
	/*Si l'argument �s nul, cal llen�ar  una excepci�
	 * d'argument il�legal, altrament fer el canvi d'estat*/
	public	void destapar(Casella casella){
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no v�lid");
		else casella.setEstat(new CasellaDestapada());
		
	}

	@Override
	//Cal informar que la casella ja est� marcada
	public	void marcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols marcar ja est� marcada");
		// NO fer res, no canvia l'estat de la casella
	}

	@Override
	/*Si l'argument �s nul, cal llen�ar  una excepci�
	 * d'argument il�legal, altrament fer el canvi d'estat*/
	public	void desmarcarPossibleMina(Casella casella){
		//Implementat
		if(casella==null) throw new IllegalArgumentException("Argument no v�lid");
		else casella.setEstat(new CasellaTapadaDesmarcada());
	}
}
