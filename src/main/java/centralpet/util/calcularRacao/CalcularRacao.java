package centralpet.util.calcularRacao;

import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;

public class CalcularRacao {

	public int calcularRacaoCachorroPorteKilosPorMes(Pet pet) {
		
		PortePet portePet = pet.getPortePet();
		int kilosPorMes = 0;
		switch(portePet) {
		
		case MINI:
			kilosPorMes = (75 * 30) / 1000;
			break;
			
		case PEQUENO:
			kilosPorMes = (125 * 30) / 1000;
			break;
			
		case MEDIO:
			kilosPorMes = (240 * 30) / 1000;
			break;
			
		case GRANDE:
			kilosPorMes = (425 * 30) / 1000;
			break;
			
		case GIGANTE:
			kilosPorMes = (670 * 30) / 1000;
			break;
		}
		
		return kilosPorMes;
	}
	
}
