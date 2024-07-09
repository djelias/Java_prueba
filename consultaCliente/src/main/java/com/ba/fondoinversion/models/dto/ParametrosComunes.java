package com.ba.fondoinversion.models.dto;

import com.ba.fondoinversion.common.utils.annotation.ValidarCamposNoObligatorios;

import io.swagger.v3.oas.annotations.media.Schema;

public class ParametrosComunes {
    @Schema(
		description = "Parámetro comodín para futuros usos",
		type = "string",
		minLength = 0,
		maxLength = 150
	)
	@ValidarCamposNoObligatorios(maximoCaracteres = 150, message = "El parámetro comment debe contener como máximo 150 caracteres")
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
