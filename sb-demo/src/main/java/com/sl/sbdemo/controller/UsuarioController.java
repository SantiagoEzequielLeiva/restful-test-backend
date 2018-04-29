package com.sl.sbdemo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	private ObjectMapper mapper;

	@GetMapping
	public List<Usuario> usuarios() {
		return this.usuarioService.findAll();
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public RestResponse save(@RequestBody String usuarioJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if ( isValid(usuario) ) {
			this.usuarioService.save(usuario);
			
			return new RestResponse(HttpStatus.OK.value(), "El usuario ha sido guardado.");
		} else {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El usuario no cumple con todos los campos requeridos.");
		}
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public void delete(@RequestBody String usuarioJson) throws Exception {
		this.mapper = new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if ( usuario.getId() != null ) {
			this.usuarioService.eliminarUsuario(usuario.getId());
		} else {
			throw new Exception("El ID es nulo.");
		}
	}
	
	private Boolean isValid(Usuario usuario){
		
		if ( usuario.getUsername().equals(null) || usuario.getUsername().equals("") )
			return false;
		
		if ( usuario.getPassword().equals(null) || usuario.getPassword().equals("") )
			return false;
		
		return true;
	}
}