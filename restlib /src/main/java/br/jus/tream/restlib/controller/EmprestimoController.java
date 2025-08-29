package br.jus.tream.restlib.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tream.restlib.domain.Emprestimo;
import br.jus.tream.restlib.response.ApiResponse;
import br.jus.tream.restlib.services.EmprestimoService;
import br.jus.tream.restlib.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {
	@Autowired
	private final EmprestimoService emprestimoService;

	@Tag(name = "Emprestimos", description = "Metodo para listar todos os emprestimos")
	@GetMapping()
	public ResponseEntity<ApiResponse<List<Emprestimo>>> usingResponseGeneric(HttpServletRequest request) {
		var lst = emprestimoService.findAll();
		return ResponseEntity.ok(ResponseUtil.success(lst, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Emprestimos response generic", description = "Metodo para listar todos os emprestimos usando Response Generic")
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Emprestimo>> findById(@PathVariable Long id, HttpServletRequest request) {
		var obj = emprestimoService.findById(id);
		return ResponseEntity.ok(ResponseUtil.success(obj, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Emprestimos response generic", description = "Metodo para listar todos os emprestimos usando Response Generic")
	@GetMapping("/anos")
	public ResponseEntity<List<Integer>> findDistinctAno() {
		var lstAnos = this.emprestimoService.findDistinctAno();
		return ResponseEntity.ok(lstAnos);
	}

	@Tag(name = "Emprestimos response generic", description = "Metodo para listar todos os emprestimos usando Response Generic")
	@GetMapping("/usuario/{id}")
	public ResponseEntity<ApiResponse<List<Emprestimo>>> findByIdUsuario(@PathVariable Long id,
			HttpServletRequest request) {
		var obj = this.emprestimoService.findByIdUsuario(id);
		return ResponseEntity.ok(ResponseUtil.success(obj, "Listagem ok", request.getRequestURI()));
	}

	@Tag(name = "Emprestimos response generic", description = "Metodo para contar emprestimos por mes")
	@GetMapping("/totalemprestados/ini/{mesIni}/fim/{mesFim}")
    public Long getTotalEmprestadosPorMes(@PathVariable int mesIni, @PathVariable int mesFim) {
        return emprestimoService.countEmprestimosPorMes(mesIni, mesFim);
    }

}
