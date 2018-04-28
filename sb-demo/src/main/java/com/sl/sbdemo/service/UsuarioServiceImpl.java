package com.sl.sbdemo.service;

import java.util.List;

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

	@Override
	public List<Usuario> findAll() {
		/* ACCEDEMOS DIRECTAMENTE AL METODO DE LA CLASE DE LA CUAL EXTIENDE UsuarioRepository */
		return this.usuarioRepository.findAll();
	}

	@Override
	public void eliminarUsuario(Long id) {
		/* ACCEDEMOS DIRECTAMENTE AL METODO DE LA CLASE DE LA CUAL EXTIENDE UsuarioRepository */
		this.usuarioRepository.deleteById(id);
	}
}