package com.ba.fondoinversion.common.constantes;

public enum MensajeServicioEnum {
    OK(0, "OK"),
	ERROR_PARAMETRIZACION(1, "Error de parametrización"),
	ERROR_COMUNICACION(2, "Error de comunicación en servicio"),
	TIME_OUT(3, "TimeOut"),
	ERROR_SISTEMA(99, "Error en el sistema");
	
	private int status;
	private String mensajeServicio;
	
	private MensajeServicioEnum(int status, String mensajeServicio) {
		this.status = status;
		this.mensajeServicio = mensajeServicio;
	}

	public int getStatus() {
		return status;
	}

	public String getMensajeServicio() {
		return mensajeServicio;
	}

}
