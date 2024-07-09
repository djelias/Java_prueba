package com.ba.fondoinversion.integration;

import com.ba.fondoinversion.models.common.ClienteEntradaDatos;
//import com.ba.fondoinversion.models.dto.ConsultaClienteRequest;

public interface ConsultaClienteIntegration {
    //String obtenerResultado(ConsultaClienteRequest consultaClienteRequest, String nombreArchivo) throws Exception;
	String clienteDatosEntrada(ClienteEntradaDatos clienteEntradaDatos, String nombreArchivo);
}
