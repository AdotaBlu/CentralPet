package centralpet.util.conversorImagem;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.pet.Pet;

public interface ConverterImagem {

	byte[] obterBytesImagem(Part imagem) throws IOException;
	
	void adicionarImagensArrayFotosPet(List<FotosPet> fotosPet, Pet pet, Collection<Part> parteImagem) throws IOException;
}
