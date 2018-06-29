package br.com.alura.listavip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.listavip.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
	
	List<Convidado> findByNome(String nome);

}
