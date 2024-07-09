package com.ba.fondoinversion.service;

import com.ba.fondoinversion.models.dto.ConsultaClienteRequest;
import com.ba.fondoinversion.models.dto.ConsultaClienteResponse;

public interface ConsultaClienteService {
    ConsultaClienteResponse validarCliente(ConsultaClienteRequest consultaClienteRequest) throws Exception;
}
