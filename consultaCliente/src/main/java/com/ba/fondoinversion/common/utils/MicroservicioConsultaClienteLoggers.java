package com.ba.fondoinversion.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MicroservicioConsultaClienteLoggers {

    public static final Logger logger = LogManager.getLogger();
	
	private MicroservicioConsultaClienteLoggers() {}
	
	public static <T> void logInfo(String mensaje, T obj) throws JsonProcessingException {
		String dataObj;
		
		try {
			dataObj = new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.warn("No se pudo realizar la serialización del objeto a JSON");
			throw e;
		}
		
		mensaje += ": " + dataObj;
		
		logger.info(mensaje);
	}
	
	public static void logError(Exception excepcion) {
		try (StringWriter mensajeTrace = new StringWriter(); PrintWriter errorTrace = new PrintWriter(mensajeTrace)) {
			excepcion.printStackTrace(errorTrace);
			
			logger.error(mensajeTrace);
		} catch (IOException e) {
			logger.error(e);
		}
	}

}
