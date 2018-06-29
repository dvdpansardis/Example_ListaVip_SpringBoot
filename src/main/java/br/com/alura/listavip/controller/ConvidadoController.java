package br.com.alura.listavip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHello() {
		return "index";
	}

	@RequestMapping(path = "listaconvidados", method = RequestMethod.GET)
	public Model getListaConvidados(Model model) {
		List<Convidado> convidados = convidadoService.obterTodos();

		model.addAttribute("convidados", convidados);

		return model;
	}

	@RequestMapping(path = "salvar", method = RequestMethod.POST)
	public String salvar(@Param("nome") String nome, @Param("telefone") String telefone, @Param("email") String email) {
		convidadoService.salvar(new Convidado(nome, telefone, email));
		
//		convidadoService.enviarEmail(nome, email);

		return "redirect:listaconvidados";
	}

}
