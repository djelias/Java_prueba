package com.ba.fondoinversion.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Schema(
	description = "Modelo de datos de entrada para validar si cliente existe en core BA"
)

public class ConsultaClienteRequest extends ParametrosComunes{

    @Schema(
		description = "Datos de entrada del cliente a validar en core BA",
		nullable = false
	)
	@NotNull(message = "Asegurese de enviar los datos de petición con la estructura correcta")
	@Valid
	private ClienteConsultaClienteRequest cliente;

    public ClienteConsultaClienteRequest getCliente() {
		return cliente;
	}

	public void setCliente(ClienteConsultaClienteRequest cliente) {
		this.cliente = cliente;
	}
}
