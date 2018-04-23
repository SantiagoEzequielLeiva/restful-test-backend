package com.sl.sbdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.sbdemo.dao.UsuarioRepository;
import com.sl.sbdemo.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
}