package br.jus.tream.restlib.services;

import org.springframework.stereotype.Service;

import br.jus.tream.restlib.repositories.ItemEmprestimoRepository;

import java.util.List;

@Service
public class ItemEmprestimoService {
    private final ItemEmprestimoRepository repo;

    public ItemEmprestimoService(ItemEmprestimoRepository repo) {
        this.repo = repo;
    }

    public List<Object[]> livrosMaisEmprestados() {
        return repo.findLivrosMaisEmprestados();
    }
}
