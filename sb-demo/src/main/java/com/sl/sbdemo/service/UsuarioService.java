package com.sl.sbdemo.service;

import java.util.List;

import com.sl.sbdemo.model.Usuario;

public interface UsuarioService {

	/**
	 * Se obtiene por su Id
	 * @param id
	 * @return Usuario
	 */
	Usuario get(Long id);
	
	/**
	 * Se crea el usuario en caso que no exista y se actualiza si existe.
	 * @param usuario
	 * @return Usuario
	 */
	Usuario save(Usuario usuario);
	
	/**
	 * Se obtiene el listado de usuarios guardados.
	 * @return List<Usuario>
	 */
	List<Usuario> findAll();

	/**
	 * Elimina al usuario correspondiente al id recibido.
	 * @param id
	 */
	void eliminarUsuario(Long id);
}
