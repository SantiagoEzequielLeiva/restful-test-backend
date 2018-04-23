package com.sl.sbdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.sbdemo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);
}