package com.github.erodriguezg.springreactiveangular.repository;

import com.github.erodriguezg.springreactiveangular.documents.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, BigInteger> {


}
