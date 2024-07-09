package com.ba.fondoinversion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.fondoinversion.common.utils.MicroservicioConsultaClienteLoggers;
import com.ba.fondoinversion.models.dto.ConsultaClienteRequest;
import com.ba.fondoinversion.models.dto.ConsultaClienteResponse;
import com.ba.fondoinversion.models.dto.ExcepcionesResponse;
import com.ba.fondoinversion.service.ConsultaClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
	name = "ConsultaCliente",
	description = "Endpoints de consulta cliente BA"
)

@RestController
@RequestMapping("/api/v1/consulta-cliente")
public class ConsultaClienteController {

	private final ConsultaClienteService consultaClienteService;
	
	public ConsultaClienteController(ConsultaClienteService consultaClienteService) {
		this.consultaClienteService = consultaClienteService;
	}

    @Operation(summary = "Validar si cliente exite en core BA", description = "Valida si cliente existe en core BA, obtiene informacion basica")
    @ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta obtenida cuando el procesamiento se realiza con exito", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsultaClienteResponse.class))),
		@ApiResponse(responseCode = "400", description = "Respuesta obtenida cuando hay errores en los datos enviados o faltan campos por completar", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExcepcionesResponse.class))),
		@ApiResponse(responseCode = "500", description = "Respuesta obtenida cuando ocurre un error en el sistema", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsultaClienteResponse.class))),
	})
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConsultaClienteResponse> consultarCliente(@Valid @RequestBody(required = true) ConsultaClienteRequest consultaClienteRequest) throws Exception {
		MicroservicioConsultaClienteLoggers.logger.info("Atendiendo petición en el controlador ConsultaClienteController -> Método consultarCliente");
		MicroservicioConsultaClienteLoggers.logInfo("Datos de petición recibidos desde el controlador ConsultaClienteController -> Método consultarCliente", consultaClienteRequest);
		
		ConsultaClienteResponse response = consultaClienteService.validarCliente(consultaClienteRequest);
		
		MicroservicioConsultaClienteLoggers.logger.info("Respondiendo en el controlador ConsultaClienteController -> Método consultarCliente");
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}

}
