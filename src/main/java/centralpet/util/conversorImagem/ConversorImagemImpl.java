package centralpet.util.conversorImagem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import centralpet.modelo.dao.fotosPet.FotosPetDAO;
import centralpet.modelo.dao.fotosPet.FotosPetDAOImpl;
import centralpet.modelo.entidade.fotosPet.FotosPet;
import centralpet.modelo.entidade.pet.Pet;

public class ConversorImagemImpl implements ConverterImagem {

	public byte[] obterBytesImagem(Part parteImagem) throws IOException {
		InputStream imagemInputstream = parteImagem.getInputStream();
		
		return IOUtils.toByteArray(imagemInputstream);
	}
	
	public void adicionarImagensArrayFotosPet(List<FotosPet> fotosPet, Pet pet, Collection<Part> parteImagem) throws IOException {
		
		FotosPetDAO daoFotosPet;
		
		for(Part partes : parteImagem) {
			byte[] fotos = null;
			
			daoFotosPet = new FotosPetDAOImpl();
			
			fotos = obterBytesImagem(partes);
			
			FotosPet foto = new FotosPet();
		
			foto = new FotosPet(fotos, pet);
			
			pet.adicionarFoto(foto);
			daoFotosPet.inserirFotosPet(foto);
			
		}
		pet.setFotos(fotosPet);
	}
	
}
