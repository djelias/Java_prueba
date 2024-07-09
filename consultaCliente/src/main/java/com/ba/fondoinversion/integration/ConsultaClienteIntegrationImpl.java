package com.ba.fondoinversion.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.ba.fondoinversion.common.utils.Utils;
//import com.ba.fondoinversion.models.common.ClienteBusqueda;
import com.ba.fondoinversion.models.common.ClienteEntradaDatos;
//import com.ba.fondoinversion.models.dto.ConsultaClienteRequest;

@Component
public class ConsultaClienteIntegrationImpl implements ConsultaClienteIntegration {
    private final ResourceLoader resourceLoader;

    public ConsultaClienteIntegrationImpl(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public String clienteDatosEntrada(ClienteEntradaDatos clienteEntradaDatos, String nombreArchivo) {
		Resource resource = resourceLoader.getResource("classpath:"+nombreArchivo);
		StringBuilder contenido;
		
		contenido = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            reader.lines().forEach(linea ->{
            	String[] registro = obtenerRegistro(linea);
				if (Utils.existeNumero(clienteEntradaDatos.getNumeroRIN(), registro[0])) {
					contenido.append(linea);
				}
            });
        }
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		return contenido.toString();
	}
	
    private String[] obtenerRegistro(String datos) {
		return datos.split("\\|");
	}
}
