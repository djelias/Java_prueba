package com.ba.fondoinversion.models.common;

public class ClienteEntradaDatos {

    private String numeroRIN;

    public String getNumeroRIN() {
		return numeroRIN;
	}

	public void setNumeroRIN(String numeroRIN) {
		this.numeroRIN = numeroRIN;
	}

    public static ClienteEntradaDatosBuilder builder() {
		return new ClienteEntradaDatosBuilder();
	}
	
    public static class ClienteEntradaDatosBuilder {
		private ClienteEntradaDatos clienteEntradaDatos = new ClienteEntradaDatos();
		
		private ClienteEntradaDatosBuilder() {}
		
		public ClienteEntradaDatosBuilder numeroRIN(String numeroRIN) {
			clienteEntradaDatos.setNumeroRIN(numeroRIN);
			return this;
		}
		
		public ClienteEntradaDatos build() {
			return clienteEntradaDatos;
		}
	}

}
