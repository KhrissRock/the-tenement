package br.jus.tream.restlib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.tream.restlib.domain.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Livro findByTitulo(String titulo);

    List<Livro> findAllByTituloLike(String titulo);
}
