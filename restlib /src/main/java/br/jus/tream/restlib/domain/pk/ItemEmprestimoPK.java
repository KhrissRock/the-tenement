package br.jus.tream.restlib.domain.pk;

import br.jus.tream.restlib.domain.Emprestimo;
import br.jus.tream.restlib.domain.Livro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Embeddable
public class ItemEmprestimoPK implements Serializable {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="emprestimo_id")
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name="livro_id")
    private Livro livro;
}
