package nom.brunokarpo.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class GerenciadorChaves {

	private static GerenciadorChaves instance;

	private static final String ALGORITMO = "RSA";
	private static final String CHARSET = "UTF8";
	private KeyPair keyPair;

	private PrivateKey privateKey;
	private PublicKey publicKey;

	private GerenciadorChaves() throws NoSuchAlgorithmException {
		final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITMO);
		keyGen.initialize(1024);
		keyPair = keyGen.generateKeyPair();
	}

	public static GerenciadorChaves getInstanceOf()
			throws NoSuchAlgorithmException {
		if (instance == null) {
			instance = new GerenciadorChaves();
		}

		return instance;
	}

	public String getAlgoritmo() {
		return ALGORITMO;
	}

	public PrivateKey getChavePrivada() {
		if (privateKey == null) {
			privateKey = keyPair.getPrivate();
		}
		return privateKey;
	}

	public PublicKey getChavePublica() {
		if (publicKey == null) {
			publicKey = keyPair.getPublic();
		}
		return publicKey;
	}

	public byte[] criptografar(String texto, Key chave) {
		byte[] cipherText = null;

		Cipher cipher;
		try {
			cipher = Cipher.getInstance(ALGORITMO);

			cipher.init(Cipher.ENCRYPT_MODE, chave);
			cipherText = cipher.doFinal(texto.getBytes(CHARSET));

		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cipherText;

	}

	public String descriptografar(byte[] cipherText, Key chave) throws UnsupportedEncodingException, BadPaddingException {
		 byte[] dectyptedText = null;

	      try {
	        final Cipher cipher = Cipher.getInstance(ALGORITMO);

	        cipher.init(Cipher.DECRYPT_MODE, chave);
	        dectyptedText = cipher.doFinal(cipherText,0 , 128);

	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }

	      return new String(dectyptedText, CHARSET);
	}

}
