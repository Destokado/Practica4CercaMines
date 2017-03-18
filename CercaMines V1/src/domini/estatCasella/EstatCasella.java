package domini.estatCasella;

import domini.Casella;

public abstract class EstatCasella {

	public static EstatCasella getEstatInicial() {
		return new CasellaTapadaDesmarcada();
	}
	
	public abstract boolean getMarcadaPossibleMina();
	public abstract boolean getDestapada();

	public abstract void destapar(Casella casella);
	public abstract void marcarPossibleMina(Casella casella);
	public abstract void desmarcarPossibleMina(Casella casella);
}