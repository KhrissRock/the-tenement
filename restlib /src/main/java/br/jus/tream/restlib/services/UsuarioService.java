package br.jus.tream.restlib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.jus.tream.restlib.domain.Usuario;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;
import br.jus.tream.restlib.repositories.UsuarioRepository;
import br.jus.tream.restlib.repositories.UsuarioSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepo;

    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Transactional
    public void delete(Usuario usuario) {
        usuarioRepo.delete(usuario);
    }

    @Transactional
    public void deleteById(Long id) {
        usuarioRepo.deleteById(id);
    }

    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    public List<Usuario> findByNomeLike(String nome) {
        String param = String.format("%%%s%%", nome.trim().toUpperCase());
        return usuarioRepo.findByNomeLike(param);
    }

    public List<Usuario> findAllLikeNomeAndEmail(ParamsDTO params) {
        return usuarioRepo.findAllLikeNomeAndEmail(params);
    }

    public List<Usuario> filterBySpecification(ParamsDTO params) {
        Specification<Usuario> spec = UsuarioSpecification.filterByParams(params);
        return usuarioRepo.findAll(spec, Sort.by("nome"));
    }

    public Usuario findById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public long count() {
        return usuarioRepo.count();
    }
    public boolean existsById(Long id) {
        return usuarioRepo.existsById(id);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }
    public Usuario findByEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }
    
    
}

