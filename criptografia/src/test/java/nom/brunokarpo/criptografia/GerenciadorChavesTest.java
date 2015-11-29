package nom.brunokarpo.criptografia;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.junit.BeforeClass;
import org.junit.Test;

public class GerenciadorChavesTest {

	private static GerenciadorChaves sut;
	private static String mensagem = "Oi, eu sou o Goku!";
	private byte[] criptado;

	@BeforeClass
	public static void init() throws NoSuchAlgorithmException {
		sut = GerenciadorChaves.getInstanceOf();
	}

	@Test
	public void deve_validar_se_algoritmo_de_criptografia_e_RSA() throws Exception {
		assertEquals("RSA", sut.getAlgoritmo());
	}

	@Test
	public void deve_gerar_chave_privada() throws Exception {
		assertNotNull(sut.getChavePrivada());
		assertTrue(sut.getChavePrivada() instanceof PrivateKey);
	}

	@Test
	public void deve_gerar_chave_publica() throws Exception {
		assertNotNull(sut.getChavePublica());
		assertTrue(sut.getChavePublica() instanceof PublicKey);
	}

	@Test
	public void deve_criptografar_mensagem_com_chave_publica_e_decriptar_com_chave_privada() throws Exception {
		criptado = sut.criptografar(mensagem, sut.getChavePublica());

		assertNotNull(criptado);

		assertEquals(mensagem, sut.descriptografar(criptado, sut.getChavePrivada()));
	}

	@Test
	public void deve_criptografar_mensagem_com_chave_privada_e_decriptar_com_chave_publica() throws Exception {
		criptado = sut.criptografar(mensagem, sut.getChavePrivada());

		assertNotNull(criptado);

		assertEquals(mensagem, sut.descriptografar(criptado, sut.getChavePublica()));
	}
}
