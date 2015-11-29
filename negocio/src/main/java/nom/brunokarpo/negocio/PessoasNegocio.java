package nom.brunokarpo.negocio;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;

import nom.brunokarpo.criptografia.GerenciadorChaves;
import nom.brunokarpo.entidade.Pessoa;
import nom.brunokarpo.repositorio.Pessoas;

public class PessoasNegocio {

	private Pessoas repositorio;
	private GerenciadorChaves gerenciador;

	public PessoasNegocio() throws NoSuchAlgorithmException {
		repositorio = new Pessoas();
		gerenciador = GerenciadorChaves.getInstanceOf();
	}

	public String guardarSeguro(Pessoa pessoa) {
		byte[] pessoaCriptada = gerenciador.criptografar(pessoa.toString(), gerenciador.getChavePublica());

		repositorio.guardar(pessoaCriptada);

		return new String(pessoaCriptada);
	}

	public String retornarDetalhesDaProximaPessoa() throws UnsupportedEncodingException, BadPaddingException {
		byte[] detalhesPessoa = repositorio.get(0);

		return gerenciador.descriptografar(detalhesPessoa, gerenciador.getChavePrivada());
	}

}
