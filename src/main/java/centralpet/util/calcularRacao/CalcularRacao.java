package centralpet.util.calcularRacao;

import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;

public class CalcularRacao {

	public int calcularRacaoCachorroPorteGramasPorMes(Pet pet) {
		
		PortePet portePet = pet.getPortePet();
		int gramasPorMes = 0;
		switch(portePet) {
		
		case MINI:
			gramasPorMes = 75 * 30;
			break;
			
		case PEQUENO:
			gramasPorMes = 125 * 30;
			break;
			
		case MEDIO:
			gramasPorMes = 240 * 30;
			break;
			
		case GRANDE:
			gramasPorMes = 425 * 30;
			break;
			
		case GIGANTE:
			gramasPorMes = 670 * 30;
			break;
		}
		
		return gramasPorMes;
	}
	
}
