package br.jus.tream.restlib.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.jus.tream.restlib.domain.Livro;
import br.jus.tream.restlib.domain.DTO.LivroDTO;
import br.jus.tream.restlib.exception.ObjectNotFoundException;
import br.jus.tream.restlib.repositories.LivroRepository;
import br.jus.tream.restlib.domain.LivroStatus;
import br.jus.tream.restlib.domain.Usuario;
import br.jus.tream.restlib.exception.LivroIndisponivelException;

@Service
@RequiredArgsConstructor
public class LivroService {
	private final LivroRepository livroRepo;

	public Livro findById(Long id) {
		Optional<Livro> obj = livroRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! id:" + id + ", Tipo:" + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return livroRepo.findAll();
	}

	public Page<LivroDTO> findAll(Pageable paginacao) {
		return livroRepo.findAll(paginacao).map(LivroDTO::new);
	}

	public void realizarEmprestimo(Livro livro, Usuario usuario) throws LivroIndisponivelException {
		if (livro.getStatus() == LivroStatus.EM_POSSE) {
			throw new LivroIndisponivelException("O livro '" + livro.getTitulo() + "' já está emprestado.");
		}
		// ...lógica para registrar o empréstimo...
		livro.setStatus(LivroStatus.EM_POSSE);
		// ...salvar alterações...
	}

	public void realizarDevolucao(Livro livro, Usuario usuario, BigDecimal multa) {
		// ...lógica para registrar a devolução...
		livro.setStatus(LivroStatus.DISPONIVEL);
		// ...salvar alterações...
	}

	public Livro save(Livro livro) {
		return livroRepo.save(livro);
	}

	public void deleteById(Long id) {
		livroRepo.deleteById(id);
	}
	public boolean existsById(Long id) {
		return livroRepo.existsById(id);
	}
}
