package br.jus.tream.restlib.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.jus.tream.restlib.domain.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long>, JpaSpecificationExecutor<Autor> {

	List<Autor> findByNomeLike(String nome);

	@Query("SELECT c FROM Autor c WHERE UPPER(c.nome) LIKE CONCAT('%', UPPER(:nome), '%')")
	List<Autor> findAllLikeNome(@Param("nome") String nome);

	@Query("SELECT a FROM Autor a WHERE UPPER(a.nome) LIKE CONCAT('%', UPPER(:nome), '%') OR UPPER(a.nacionalidade) LIKE CONCAT('%', UPPER(:nacionalidade), '%')")
	List<Autor> findAllLikeNomeOrNacionalidade(@Param("nome") String nome, @Param("nacionalidade") String nacionalidade);

	@Query("SELECT a FROM Autor a WHERE UPPER(a.nome) LIKE CONCAT('%', UPPER(:nome), '%') AND UPPER(a.nacionalidade) LIKE CONCAT('%', UPPER(:nacionalidade), '%')")
	List<Autor> findAllLikeNomeAndNacionalidade(@Param("nome") String nome
			, @Param("nacionalidade") String nacionalidade);
	// List<Autor> findAll(Specification<Autor> specs, Sort sort);
	// List<Autor> findAll(Specification<Autor> specs);
	// List<Autor> findAll(Specification<Autor> specs, Pageable pageable);
	// long count(Specification<Autor> specs);
	// boolean exists(Specification<Autor> specs);
	// Optional<Autor> findOne(Specification<Autor> specs);
	// Page<Autor> findAll(Specification<Autor> specs, Pageable pageable);
	// List<Autor> findAll(Specification<Autor> specs, Sort sort);
	// long count(Specification<Autor> specs);
	// boolean exists(Specification<Autor> specs);
	// Optional<Autor> findOne(Specification<Autor> specs);
}

