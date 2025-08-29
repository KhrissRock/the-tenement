package br.jus.tream.restlib.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


@Entity
@Table(name = "LIVRO")
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Livro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String isbn;

	@Enumerated(EnumType.STRING)
    private LivroStatus status = LivroStatus.DISPONIVEL;


	@ManyToOne
	@JoinColumn(name="id_autor")
    private Autor autor;
}
