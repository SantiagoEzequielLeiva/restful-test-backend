package com.sl.sbdemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.sbdemo.model.Usuario;
import com.sl.sbdemo.service.UsuarioService;
import com.sl.sbdemo.util.RestResponse;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public RestResponse save(@RequestBody String usuarioJson) throws JsonParseException, JsonMappingException, IOException{
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if ( isValid(usuario) ) {
			this.usuarioService.save(usuario);
			
			return new RestResponse(HttpStatus.OK.value(), "El usuario ha sido guardado.");
		} else {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El usuario no cumple con todos los campos requeridos.");
		}
	}
	
	private Boolean isValid(Usuario usuario){
		
		if ( usuario.getUsername().equals(null)
				|| (!usuario.getUsername().equals(null) && usuario.getUsername().equals("")) )
			return false;
		
		if ( usuario.getPassword().equals(null)
				|| (!usuario.getPassword().equals(null) && usuario.getPassword().equals("")) )
			return false;
		
		return true;
	}
}