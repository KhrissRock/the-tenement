package br.jus.tream.restlib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tream.restlib.services.ItemEmprestimoService;

import java.util.List;

@RestController
public class ItemEmprestimoController {
    private final ItemEmprestimoService service;

    public ItemEmprestimoController(ItemEmprestimoService service) {
        this.service = service;
    }

    @GetMapping("/livros/mais-emprestados")
    public List<Object[]> getLivrosMaisEmprestados() {
        return service.livrosMaisEmprestados();
    }
}