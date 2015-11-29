package nom.brunokarpo.entidade;

import nom.brunokarpo.exceptions.IdadeInvalidaException;
import nom.brunokarpo.exceptions.NomeInvalidoException;
import nom.brunokarpo.exceptions.SexoInvalidoException;

public class Pessoa {

	private String nome;
	private Integer idade;
	private String sexo;

	public void setNome(String nome) throws NomeInvalidoException {
		if(nome == null || "".equals(nome.trim())) {
			throw new NomeInvalidoException();
		}
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) throws IdadeInvalidaException {
		if(idade < 18) {
			throw new IdadeInvalidaException();
		}
		this.idade = idade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setSexo(String sexo) throws SexoInvalidoException {
		if( !"m".equals(sexo.toLowerCase())
				&& !"f".equals(sexo.toLowerCase())) {
			throw new SexoInvalidoException();
		}
		this.sexo = sexo.toUpperCase();
	}

	public String getSexo() {
		return sexo.toUpperCase();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("nome=")
			.append(getNome() + "\n")
			.append("idade=")
			.append(getIdade() + "\n")
			.append("sexo=")
			.append(getSexo());

		return sb.toString();
	}
}
