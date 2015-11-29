package nom.brunokarpo.main;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;

import nom.brunokarpo.entidades.Pessoa;
import nom.brunokarpo.exceptions.IdadeInvalidaException;
import nom.brunokarpo.exceptions.NomeInvalidoException;
import nom.brunokarpo.exceptions.SexoInvalidoException;
import nom.brunokarpo.negocio.PessoasNegocio;

public class CriptografiaMain {

	public static void main(String[] args) throws UnsupportedEncodingException, BadPaddingException, NoSuchAlgorithmException {
		Scanner entrada = new Scanner(System.in);
		PessoasNegocio negocio = new PessoasNegocio();

		for(int i = 0; i < 5; i++) {
			Pessoa p = new Pessoa();

			capturarNome(entrada, p);
			capturarIdade(entrada, p);
			capturarSexo(entrada, p);

			negocio.guardarSeguro(p);
		}

		for(int i = 0; i < 5; i++) {
			System.out.println(negocio.retornarDetalhesDaProximaPessoa());
			System.out.println();
		}
	}

	private static void capturarSexo(Scanner entrada, Pessoa p) {
		System.out.println("Digite o nome da Sexo: ");
		String nome = entrada.nextLine();

		try {
			p.setSexo(nome);
		} catch(SexoInvalidoException e) {
			capturarSexo(entrada, p);
		}


	}

	private static void capturarIdade(Scanner entrada, Pessoa p) {
		System.out.println("Digite a idade da pessoa: ");
		Integer idade = entrada.nextInt();
		entrada.nextLine();

		try {
			p.setIdade(idade);
		} catch(IdadeInvalidaException e) {
			capturarIdade(entrada, p);
		}
	}

	private static void capturarNome(Scanner entrada, Pessoa p) {
		System.out.println("Digite o nome da Pessoa: ");
		String nome = entrada.nextLine();

		try {
			p.setNome(nome);
		} catch(NomeInvalidoException e) {
			capturarNome(entrada, p);
		}
	}

}
