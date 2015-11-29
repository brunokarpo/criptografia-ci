package nom.brunokarpo.entidade;

import static org.junit.Assert.*;
import nom.brunokarpo.exceptions.IdadeInvalidaException;
import nom.brunokarpo.exceptions.NomeInvalidoException;
import nom.brunokarpo.exceptions.SexoInvalidoException;

import org.junit.Before;
import org.junit.Test;

public class PessoaTest {

	//SUT - Stub under test
	private Pessoa sut;

	@Before
	public void init() throws Exception {
		sut = new Pessoa();

		sut.setNome("Bruno");
		sut.setIdade(25);
		sut.setSexo("M");
	}

	@Test(expected=NomeInvalidoException.class)
	public void nome_nao_pode_ser_nulo_ou_vazio() throws Exception {
		sut.setNome("");
	}

	@Test(expected=IdadeInvalidaException.class)
	public void pessoa_nao_pode_ser_menor_de_idade() throws Exception {
		sut.setIdade(17);
	}

	@Test(expected=SexoInvalidoException.class)
	public void sexo_deve_ser_m_ou_f() throws Exception {
		sut.setSexo("V");
	}

	@Test
	public void deve_retornar_dados_pessoa_em_formato_properties() throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append("nome=Bruno\n")
			.append("idade=25\n")
			.append("sexo=M");

		assertEquals(sb.toString(), sut.toString());
	}
}
