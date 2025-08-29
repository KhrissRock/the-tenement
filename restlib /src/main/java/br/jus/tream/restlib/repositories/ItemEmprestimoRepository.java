package br.jus.tream.restlib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.jus.tream.restlib.domain.ItemEmprestimo;
import br.jus.tream.restlib.domain.pk.ItemEmprestimoPK;

public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, ItemEmprestimoPK> {
    @Query("SELECT ie.id.livro AS livro, COUNT(ie) AS totalEmprestimos " +
           "FROM ItemEmprestimo ie " +
           "GROUP BY ie.id.livro " +
           "ORDER BY totalEmprestimos DESC")
    List<Object[]> findLivrosMaisEmprestados();
}
