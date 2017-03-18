package domini;

public class Coordenada {//cada objecte representarà una coordenada del taulell

	private int fila;//número de la fila dins el taulell (0..9)
	private int columna;//número de la columna dins el taulell (0..9)

	/*Un cop validades la fila i la columna (mètode validarCoordenada)
	 * inicialitza els  atributs*/
	public Coordenada(int fila, int columna) {
		//Implementat
		validarCoordenades(fila,columna);
		this.fila = fila;
		this.columna = columna;
	}
	
	/*Aquest mètode de classe té com a missió validar que les coordenades
	 * siguin correctes (IllegalArgumentException).*/
	public static void validarCoordenades (int fila, int columna) {
		//IMPLEMENTAT
		if(!((0<=fila&& fila<=9)||(0<=columna&& columna<=9))){
			throw new IllegalArgumentException("Les Coordenades no son válides");
		}
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	/*Una casella, segons la seva situació en el taulell, pot tenir 2, 5 o 8 veins.
	 * Aquest mètode retorna en un array les coordenades  veïnes a l'objecte actual.
	 * Cal tenir en compte que una coordenada no és veina de si mateixa.*/
	public Coordenada [] cercarCoordenadesVeines() {
		//IMPLEMENTAT
				
				//EL nombre de veins marca la dimensió de l'array.
				Coordenada[] veines;
				int casella = 0;
				int veins = 0;
				
				if(fila%(TaulellCercaMines.getFiles()-1) == 0 && columna%(TaulellCercaMines.getColumnes()-1) == 0)
					veins = 3;
				else if (fila%(TaulellCercaMines.getFiles()-1) == 0 || columna%(TaulellCercaMines.getColumnes()-1) == 0)
					veins = 5;
				else
					veins = 8;

				veines = new Coordenada [veins];
					
				for(int f = -1; f<=1; f++)
				{
					for(int c = -1; c<=1;c++)
					{
						if(f+fila>=0 && f+fila<TaulellCercaMines.getFiles() && c+columna>=0 && c+columna<TaulellCercaMines.getColumnes())
						{
							if(!(f == 0 && c == 0))
							{
								veines[casella] =  new Coordenada(fila +f,columna +c);
								System.out.println((fila+f) + "," + (columna+c));
								casella++;
							}
						}
					}	
				}
				
				return veines;	
	}
}