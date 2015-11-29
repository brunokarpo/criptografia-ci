package nom.brunokarpo.entidades;

import static org.junit.Assert.*;
import nom.brunokarpo.exceptions.IdadeInvalidaException;
import nom.brunokarpo.exceptions.NomeInvalidoException;
import nom.brunokarpo.exceptions.SexoInvalidoException;

import org.junit.Before;
import org.junit.Test;

public class PessoaTeste {

	// Stub Under Test (SUT)
	private Pessoa sut;

	@Before
	public void init() throws Exception {
		sut = new Pessoa();

		sut.setNome("Bruno");
		sut.setIdade(25);
		sut.setSexo("M");
	}

	@Test
	public void deveValidarPessoaCriada() throws Exception {
		assertEquals("Bruno", sut.getNome());
		assertEquals(25, sut.getIdade(), 0.00001);
		assertEquals("M", sut.getSexo());
	}

	@Test(expected=NomeInvalidoException.class)
	public void naoDeveTerNomeVazio() throws Exception {
		sut.setNome("");
	}

	@Test(expected=NomeInvalidoException.class)
	public void naoDeveAceitarNomeNulo() throws Exception {
		sut.setNome(null);
	}

	@Test(expected=IdadeInvalidaException.class)
	public void naoDeveAceitarMenoresDeIdade() throws Exception {
		sut.setIdade(17);
	}

	@Test(expected=SexoInvalidoException.class)
	public void nao_deve_aceitar_sexo_diferente_de_M_ou_F() throws Exception {
		sut.setSexo("V");
	}

	@Test
	public void deve_retornar_estrutura_properties_ao_chamar_toString() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("nome=Bruno\n")
			.append("idade=25\n")
			.append("sexo=M");

		assertEquals(sb.toString(), sut.toString());
	}

}
