package br.jus.tream.restlib.domain;

// import java.util.List;
// import br.jus.tream.restlib.domain.*;
import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataEmprestimo;

	private LocalDate dataDevolucao;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "id.emprestimo")
	private Set<ItemEmprestimo> itens = new HashSet<>();

}
