package domini.tipusCasella;

import domini.Casella;
import domini.Coordenada;
import domini.estatCasella.ExcepcionsPersonalitzades;

public class CasellaSenseMina extends Casella {

	// valor de l'atribut contingut que representarà que la casella no té cap mina al voltant
	private final int POS_BUIDA = 0;
	private static final int MAX_VEINS_AMB_MINA = 8;

	public CasellaSenseMina(Coordenada coordenada) {
		super(coordenada);
		this.contingut = POS_BUIDA;
	}

	@Override
	//Si el contingut es 8 caldrà generar una excepció tipus run time
	public void modificarVeiAmbMina() {
		//Implementat
		if(contingut == MAX_VEINS_AMB_MINA) throw new ExcepcionsPersonalitzades("S'ha arribat al màxim de veins amb mina");
	}

	@Override
	public boolean hiHaMina() {
		return false;
	}

	@Override
	public boolean esBuida() {
		return this.contingut == this.POS_BUIDA;
	}

	@Override
	public Casella collocarMina(Casella[] casellesVeines) {
		return new CasellaAmbMina(posicio, casellesVeines);
	}
}