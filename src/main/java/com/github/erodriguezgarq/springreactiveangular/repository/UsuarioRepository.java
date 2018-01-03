package com.github.erodriguezgarq.springreactiveangular.repository;

import com.github.erodriguezgarq.springreactiveangular.documents.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, BigInteger> {


}
