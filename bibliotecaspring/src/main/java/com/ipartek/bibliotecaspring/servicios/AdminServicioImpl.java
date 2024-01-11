package com.ipartek.bibliotecaspring.servicios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class AdminServicioImpl extends UsuarioServicioImpl implements AdminServicio {

}
