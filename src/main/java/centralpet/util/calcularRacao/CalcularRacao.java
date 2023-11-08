package centralpet.util.calcularRacao;

import centralpet.modelo.entidade.pet.Pet;
import centralpet.modelo.enumeracao.pet.porte.PortePet;

public class CalcularRacao {

	public double racaoCachorroPorteKilosPorMes(Pet pet) {
		
		PortePet portePet = pet.getPortePet();
		double kilosPorMes = 0;
		switch(portePet) {
		
		case MINI:
			kilosPorMes = 2.25;
			break;
			
		case PEQUENO:
			kilosPorMes = 3.75;
			break;
			
		case MEDIO:
			kilosPorMes = 7.2;
			break;
			
		case GRANDE:
			kilosPorMes = 12.75;
			break;
			
		case GIGANTE:
			kilosPorMes = 20.1;
			break;
		}
		
		return kilosPorMes;
	}
	
	public double valorRacaoCachorroPorteKilosPorMes (Pet pet) {
		
		PortePet portePet = pet.getPortePet();
		double valorRacao = 0;
		switch (portePet) {
		
		case MINI:
			valorRacao = 18;
			break;
			
		case PEQUENO:
			valorRacao = 30;
			break;
			
		case MEDIO:
			valorRacao = 57.6;
			break;
			
		case GRANDE:
			valorRacao = 102;
			break;
			
		case GIGANTE:
			valorRacao = 160.8;
			break;
		}
		
		return valorRacao;
	}
}
