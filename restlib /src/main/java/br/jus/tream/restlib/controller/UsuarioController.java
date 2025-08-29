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
import br.jus.tream.restlib.domain.Usuario;
import br.jus.tream.restlib.domain.DTO.ParamsDTO;
import br.jus.tream.restlib.response.ApiResponse;
import br.jus.tream.restlib.services.UsuarioService;
import br.jus.tream.restlib.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	@Autowired

	private final UsuarioService usuarioService;

	@Tag(name = "Usuarios", description = "Metodo para listar todos os usuarios")
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@Tag(name = "Usuarios response generic", description = "Metodo para listar todos os usuarios usando Response Generic")
	@GetMapping("/generic")
	public ResponseEntity<ApiResponse<List<Usuario>>> usingResponseGeneric(HttpServletRequest request) {
		var lst = usuarioService.findAll();
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	@GetMapping("/like/{nome}")
	public ResponseEntity<ApiResponse<List<Usuario>>> findByNomeLike(@PathVariable String nome,
			HttpServletRequest request) {
		var lst = usuarioService.findByNomeLike(nome);
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Usuarios response generic", description = "Metodo para listar todos os usuarios usando Response Generic")
	@GetMapping("/like/{nome}/email/{email}")
	public ResponseEntity<ApiResponse<List<Usuario>>> findByNomeAndEmail(@PathVariable String nome,
			@PathVariable String email, HttpServletRequest request) {
		var param = new ParamsDTO(nome, email);
		var lst = usuarioService.findAllLikeNomeAndEmail(param);
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Usuarios", description = "Metodo para listar todos os usuarios usando Specification")
	@GetMapping("/spec")
	public ResponseEntity<List<Usuario>> findBySpecitication(@ModelAttribute ParamsDTO params) {
		var lst = usuarioService.filterBySpecification(params);
		return ResponseEntity.ok(lst);
		// return ResponseEntity.ok(ResponseUtil.success(lst,"Listagem com specification
		// ok", request.getRequestURI()));
	}

	@Tag(name = "Usuarios", description = "Metodo para inserir usuarios")
	@PostMapping
	public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.save(usuario));
	}

	@Tag(name = "Usuarios", description = "Metodo para modificar usuarios")
	@PutMapping
	public ResponseEntity<Usuario> updat(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.save(usuario));
	}

	@Tag(name = "Usuarios", description = "Metodo para excluir usuarios")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
