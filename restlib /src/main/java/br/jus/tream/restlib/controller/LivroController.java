package br.jus.tream.restlib.controller;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tream.restlib.domain.Livro;
import br.jus.tream.restlib.domain.DTO.LivroDTO;
import br.jus.tream.restlib.response.ApiResponse;
import br.jus.tream.restlib.services.LivroService;
import br.jus.tream.restlib.util.ResponseUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
	private final LivroService livroService;
	
	@Tag(name = "Livros", description = "Metodo para listar todos os livros")
	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		return ResponseEntity.ok(livroService.findAll());
	}
	
	@Tag(name = "Livros", description = "Metodo para listar todos os livros")
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Livro>> findById(@PathVariable Long id, HttpServletRequest request) {
		var livro = livroService.findById(id);
		return ResponseEntity.ok(ResponseUtil.success(livro,"Listagem ok", request.getRequestURI()));
				
	}

	@Tag(name = "Livros", description = "Metodo para listar todos os livros")
	@GetMapping("/generic")
	public ResponseEntity<ApiResponse<List<Livro>>> usingResponseGeneric(HttpServletRequest request) {
		var lst = livroService.findAll();
		return ResponseEntity.ok(ResponseUtil.success(lst,"Listagem ok", request.getRequestURI()));
	}
	
	@Tag(name = "Livros", description = "Metodo para listar todos os livros usando DTO")
	@GetMapping("/pages")
    public ResponseEntity<Page<LivroDTO>> listar(@PageableDefault(size = 10, page=0, sort = "titulo", direction = Sort.Direction.ASC) 
                                      Pageable paginacao) {
        var livros = this.livroService.findAll(paginacao);
          return ResponseEntity.ok(livros);
    }

	@Tag(name = "Livros", description = "Metodo para inserir livros")
@PostMapping
public ResponseEntity<Livro> add(@RequestBody Livro livro) {
    return ResponseEntity.ok(livroService.save(livro));
}

@Tag(name = "Livros", description = "Metodo para modificar livros")
@PutMapping
public ResponseEntity<Livro> update(@RequestBody Livro livro) {
    return ResponseEntity.ok(livroService.save(livro));
}

@Tag(name = "Livros", description = "Metodo para excluir livros")
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    livroService.deleteById(id);
    return ResponseEntity.noContent().build();
}
	
}
