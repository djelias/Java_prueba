package com.ba.fondoinversion.common.utils.impl;

import com.ba.fondoinversion.common.utils.annotation.ValidarCamposNoObligatorios;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CamposNoObligatoriosValidation implements ConstraintValidator<ValidarCamposNoObligatorios, String>{

    private int maximoCaracteres;

	@Override
	public void initialize(ValidarCamposNoObligatorios constraintAnnotation) {
		this.maximoCaracteres = constraintAnnotation.maximoCaracteres();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		int cantidadCaracteres = value == null ? 0 : value.length();
		
		return cantidadCaracteres <= maximoCaracteres;
	}

}
