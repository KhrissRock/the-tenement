package br.jus.tream.restlib.repositories;

import org.springframework.data.jpa.domain.Specification;
import br.jus.tream.restlib.domain.Usuario;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;
import jakarta.persistence.criteria.Predicate;

public class UsuarioSpecification {
    public static Specification<Usuario> filterByParams(ParamsDTO params) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (params.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), params.getId()));
            }else {
                if ( !params.getNome().isBlank()) {
                    predicate = criteriaBuilder.and(
                            predicate, criteriaBuilder.like(root.get("nome"), "%" + params.getNome().toUpperCase() + "%")
                    );
                }
                if (!params.getEmail().isBlank()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("email"), "%" + params.getEmail() + "%"));
                }
            }
            return predicate;
        };
    }
}
