package br.jus.tream.restlib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.jus.tream.restlib.domain.Usuario;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

	List<Usuario> findByNomeLike(String nome);

	// Removed duplicate method declaration for findAllLikeNomeAndEmail

	Usuario findByEmail(String email);

	boolean existsByEmail(String email);


	@Query("SELECT c FROM Usuario c WHERE c.nome LIKE %:#{#params.nome}% OR c.email LIKE %:#{#params.email}%")
	List<Usuario> findAllLikeNomeAndEmail(@Param("params") ParamsDTO params);

	// List<Usuario> findAll(Specification<Usuario> specs, Sort sort);
	// List<Usuario> findAll(Specification<Usuario> specs);
	// List<Usuario> findAll(Specification<Usuario> specs, Pageable pageable);
	// long count(Specification<Usuario> specs);
	// boolean exists(Specification<Usuario> specs);
	// Optional<Usuario> findOne(Specification<Usuario> specs);
	// Page<Usuario> findAll(Specification<Usuario> specs, Pageable pageable);
	// List<Usuario> findAll(Specification<Usuario> specs, Sort sort);
	// long count(Specification<Usuario> specs);
	// boolean exists(Specification<Usuario> specs);
	// Optional<Usuario> findOne(Specification<Usuario> specs);	
	
}
