package nom.brunokarpo.repositorio;

import java.util.ArrayList;
import java.util.List;

public class Pessoas {

	List<byte[]> pessoasCriptadas = new ArrayList<byte[]>();

	public void guardar(byte[] pessoaCriptada) {
		pessoasCriptadas.add(pessoaCriptada);
	}

	public byte[] get(int i) {
		return pessoasCriptadas.remove(0);
	}

}
