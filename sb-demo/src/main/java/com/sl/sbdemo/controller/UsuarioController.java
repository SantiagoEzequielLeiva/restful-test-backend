package com.sl.sbdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.sbdemo.model.Usuario;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	@GetMapping
	public List<Usuario> usuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		return usuarios;
	}
}
