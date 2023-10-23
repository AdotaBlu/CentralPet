package centralpet.util.conversorImagem;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.Part;

import centralpet.modelo.entidade.pet.Pet;

public interface ConverterImagem {

	byte[] obterBytesImagem(Part imagem) throws IOException;
	
	void adicionarImagensArrayFotosPet(Pet pet, Collection<Part> parteImagem) throws IOException;
}
