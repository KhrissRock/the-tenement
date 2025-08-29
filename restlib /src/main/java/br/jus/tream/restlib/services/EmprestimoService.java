package br.jus.tream.restlib.services;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tream.restlib.domain.Emprestimo;
import br.jus.tream.restlib.repositories.EmprestimoRepository;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
	private final EmprestimoRepository emprestimoRepo;

	// For read-heavy operations
	// @Transactional(readOnly = true)
	public List<Emprestimo> findAll() {
		return emprestimoRepo.findAll();
	}

	public Emprestimo findById(Long id) {
		return emprestimoRepo.findById(id).get();
	}

	public List<Integer> findDistinctAno() {
		return emprestimoRepo.findDistinctAno();
	}

	public List<Emprestimo> findByIdUsuario(Long idUsuario) {
		return emprestimoRepo.findByUsuario_Id(idUsuario);
	}

	// Lombok's @RequiredArgsConstructor generates the constructor automatically

    public Long countEmprestimosPorMes(int mesIni, int mesFim) {
        LocalDate ini = LocalDate.of(LocalDate.now().getYear(), mesIni, 1);
        LocalDate fim = LocalDate.of(LocalDate.now().getYear(), mesFim, ini.lengthOfMonth());
        return emprestimoRepo.countByDataEmprestimoBetween(ini, fim);
    }
}
