package br.jus.tream.restlib.domain.DTO;


import br.jus.tream.restlib.domain.Livro;

public record LivroDTO(Long id, String titulo) {
    public LivroDTO(Livro livro){
        this(livro.getId(), livro.getTitulo());
    }
}
