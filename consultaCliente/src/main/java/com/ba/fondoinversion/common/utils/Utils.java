package com.ba.fondoinversion.common.utils;

public class Utils {
    private Utils() {}
	
	public static boolean existeNumero(String numero, String numeroResponse) {
		if (numeroResponse == null) {
			return false;
		}
		return convertirEnteros(numero.trim()) == convertirEnteros(numeroResponse.trim()) || numero.trim().equals(numeroResponse.trim());
	}
	  
	 public static String quitarEspacios(String texto) {
		if (texto != null) {
			texto = texto.trim();
		}
		return texto;
	}
	 
	private static long convertirEnteros(String valor) {
		if (valor.trim().length() == 0) {
			return 0;
		}
		return Long.parseLong(valor);
	}

}
