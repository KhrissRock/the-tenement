package br.jus.tream.restlib.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.jus.tream.restlib.domain.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

	@Query("SELECT DISTINCT YEAR(p.dataEmprestimo) FROM Emprestimo p")
	List<Integer> findDistinctAno();

	List<Emprestimo> findByUsuario_Id(Long idUsuario);

	Long countByDataEmprestimoBetween(LocalDate ini, LocalDate fim);
}
