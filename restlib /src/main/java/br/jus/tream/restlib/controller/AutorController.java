package br.jus.tream.restlib.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tream.restlib.domain.Autor;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;
import br.jus.tream.restlib.response.ApiResponse;
import br.jus.tream.restlib.services.AutorService;
import br.jus.tream.restlib.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

	@Autowired

	private final AutorService autorService;

	@Tag(name = "Autors", description = "Metodo para listar todos os autors")
	@GetMapping
	public ResponseEntity<List<Autor>> findAll() {
		return ResponseEntity.ok(autorService.findAll());
	}

	@Tag(name = "Autors response generic", description = "Metodo para listar todos os autors usando Response Generic")
	@GetMapping("/generic")
	public ResponseEntity<ApiResponse<List<Autor>>> usingResponseGeneric(HttpServletRequest request) {
		var lst = autorService.findAll();
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Autors response generic", description = "Metodo para listar todos os autors usando Response Generic")
	@GetMapping("/like/{nome}")
	public ResponseEntity<ApiResponse<List<Autor>>> findByNomeLike(@PathVariable String nome,
			HttpServletRequest request) {
		List<Autor> lst = autorService.findByNomeLike(nome);
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	// @Tag(name = "Autors response generic", description = "Metodo para listar todos os autors usando Response Generic")
	// @GetMapping("/like/{nome}/celular/{celular}")
	// public ResponseEntity<ApiResponse<List<Autor>>> findByNomeAndCelular(@PathVariable String nome,
	// 		@PathVariable String celular, HttpServletRequest request) {
	// 	var param = new ParamsDTO(nome, celular);
	// 	var lst = autorService.findAllLikeNomeAnd(param);
	// 	return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	// }

	// @Tag(name = "Autors response generic", description = "Metodo para listar todos os autors usando Response Generic")
	// @GetMapping("/spec")
	// public ResponseEntity<List<Autor>> findBySpecitication(@ModelAttribute ParamsDTO params) {
	// 	var lst = autorService.filterBySpecification(params);
	// 	return ResponseEntity.ok(lst);
	// 	// return ResponseEntity.ok(ResponseUtil.success(lst,"Listagem com specification
	// 	// ok", request.getRequestURI()));
	// }

	@Tag(name = "Autors", description = "Metodo para inserir autors")
	@PostMapping
	public ResponseEntity<Autor> add(@RequestBody Autor autor) {
		return ResponseEntity.ok(autorService.save(autor));
	}

	@Tag(name = "Autors", description = "Metodo para modificar autors")
	@PutMapping
	public ResponseEntity<Autor> update(@RequestBody Autor autor) {
		return ResponseEntity.ok(autorService.save(autor));
	}

	@Tag(name = "Autors", description = "Metodo para excluir autors")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		autorService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
