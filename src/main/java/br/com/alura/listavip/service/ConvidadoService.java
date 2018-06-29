package br.com.alura.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public List<Convidado> obterTodos(){
		return convidadoRepository.findAll();
	}
	
	public void salvar(Convidado convidado) {
		convidadoRepository.save(convidado);
	}
	
//	public void enviarEmail(String nome, String email) {
//		EmailService emailService = new EmailService();
//		emailService.enviar(nome, email);
//	}
//	

}
