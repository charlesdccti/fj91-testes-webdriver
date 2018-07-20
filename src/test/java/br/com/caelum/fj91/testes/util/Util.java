package br.com.caelum.fj91.testes.util;

import java.security.SecureRandom;

public class Util {
	
	private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
	private static final SecureRandom RANDOM = new SecureRandom();
	
	public static String textoAleatorio() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
	}

}
