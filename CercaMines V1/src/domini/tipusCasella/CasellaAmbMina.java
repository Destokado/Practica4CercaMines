package domini.tipusCasella;

import domini.Casella;
import domini.Coordenada;
import domini.estatCasella.ExcepcionsPersonalitzades;

public class CasellaAmbMina extends Casella {

	// valor de l'atribut contingut que representar� que la casella cont� una
	// mina
	private final int MINA = -1;

	public CasellaAmbMina(Coordenada coordenada, Casella[] casellesVeines) {
		super(coordenada);
		this.contingut = MINA;
		this.modificarVeinsNovaMina(casellesVeines);
	}

	@Override
	// Cal informar que aquesta casella t� una mina,
	// i no es pot modificar el seu contingut.
	public void modificarVeiAmbMina() {
		// Implementat
		throw new ExcepcionsPersonalitzades("Aquesta casella ja te una mina i no es pot modificar el seu contingut");
	}

	@Override
	public boolean hiHaMina() {
		return true;
	}

	@Override
	public boolean esBuida() {
		return false;
	}

	@Override
	// Cal informar que aquesta casella ja t� una mina.
	public Casella collocarMina(Casella[] cercarCasellesVeines) {
		// Implementat
		throw new ExcepcionsPersonalitzades("Aquesta casella ja te una mina");
	}

	/*
	 * Si l'argument �s nul o si el nombre de veins no �s 3, 5 o 8, generar una
	 * excepci� del tipus argument il�legal. Altrament cada cop que es col�loca
	 * una mina en una casella, cal informar a tos els seus veins que no tinguin
	 * mina, que hi ha un nou ve� amb mina. Caldr� doncs incrementar el nombre
	 * de veins amb mina de cada ve�.
	 */
	private void modificarVeinsNovaMina(Casella[] veins) {
		// Implementat
		if ((veins == null) || (veins.length != 3) || (veins.length != 5) || (veins.length != 8))
			throw new IllegalArgumentException("Argument no v�lid");
		else {
			for (int i = 0; i<veins.length; i++)
			{
				if(!veins[i].hiHaMina())
					((CasellaSenseMina) veins[i]).modificarVeiAmbMina();
			}
		}	
		}
	}
