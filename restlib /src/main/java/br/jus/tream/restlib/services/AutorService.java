package br.jus.tream.restlib.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.jus.tream.restlib.domain.Autor;
import br.jus.tream.restlib.domain.DTO.AutorDTO;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;
import br.jus.tream.restlib.repositories.AutorRepository;
import br.jus.tream.restlib.repositories.AutorSpecification;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AutorService {

    @Autowired
    private final AutorRepository autorRepo;

    @Transactional
    public Autor save(Autor autor) {
        return autorRepo.save(autor);
    }

    @Transactional
    public void delete(Autor autor) {
        autorRepo.delete(autor);
    }

    @Transactional
    public void deleteById(Long id) {
        autorRepo.deleteById(id);
    }

    public List<Autor> findAll() {
        return autorRepo.findAll();
    }

    public List<Autor> findByNomeLike(String nome) {
        return autorRepo.findByNomeLike(nome);
    }

    // public List<Autor> findAllLikeNomeAndNacionalidade(AutorDTO params) {
    //     String nome = params.getNome();
    //     String nacionalidade = params.getNacionalidade();
    //     return autorRepo.findAllLikeNomeAndNacionalidade(nome, nacionalidade);
    // }

    // public List<Autor> filterBySpecification(ParamsDTO params) {
    //     Specification<Autor> spec = AutorSpecification.filterByParams(params);
    //     return autorRepo.findAll(spec, Sort.by("nome"));
    // }
    public Autor findById(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

    public boolean existsById(Long id) {
        return autorRepo.existsById(id);
    }
}
