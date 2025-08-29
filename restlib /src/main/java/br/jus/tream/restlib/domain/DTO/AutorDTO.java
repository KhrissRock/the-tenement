package br.jus.tream.restlib.domain.DTO;

import br.jus.tream.restlib.domain.Autor;

public record AutorDTO(Long id, String nome, String nacionalidade) {

    public AutorDTO(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getNacionalidade());
    }
}
