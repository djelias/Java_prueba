package com.ba.fondoinversion.common.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ba.fondoinversion.common.utils.impl.CamposNoObligatoriosValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CamposNoObligatoriosValidation.class)

public @interface ValidarCamposNoObligatorios {
    int maximoCaracteres() default 0;
	String message() default "";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
