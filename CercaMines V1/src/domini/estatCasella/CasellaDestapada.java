package domini.estatCasella;

import domini.Casella;

public class CasellaDestapada extends EstatCasella {	
	
	@Override
	public boolean getMarcadaPossibleMina() {
		return false;
	}

	@Override
	public boolean getDestapada() {
		return true;
	}

	@Override
	//Cal informar que la casella ja est� destapada
	//amb una nova classe de run time
	public void destapar(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols destapar ja est� destapada");
		// NO fer res, no canvia l'estat de la casella

	}

	@Override
	//Cal informar que la casella ja est� destapada
	// i no es pot marcar amb una nova classe de run time
	public	void marcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols marcar ja est� destapada");
		// No canvia l'estat de la casella		
	}

	@Override
	//Cal informar que la casella ja est� destapada
	// i no es pot desmarcar amb una nova classe de run time
	public	void desmarcarPossibleMina(Casella casella) {
		//Implementat
		throw new ExcepcionsPersonalitzades("La casella que vols desmarcar ja est� destapada");
		// No canvia l'estat de la casella
	}
}
