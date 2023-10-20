package centralpet.modelo.dao.fotosPet;

import java.util.List;

import centralpet.modelo.entidade.fotosPet.FotosPet;

public interface FotosPetDAO {

	 void inserirFotosPet(FotosPet fotos);
	
	 void deletarFotosPet(FotosPet fotos);
	 
	 List<FotosPet> recuperarFotosPet(Long id);
	 
	 FotosPet recuperarFotoId(Long id);
	 
	 List<FotosPet> recuperarTodasFotos();
}
