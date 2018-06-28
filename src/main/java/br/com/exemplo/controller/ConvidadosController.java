package br.com.exemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.exemplo.model.Convidado;
import br.com.exemplo.repository.IConvidados;

@Controller
public class ConvidadosController {

	@Autowired
	private IConvidados convRepository;

	@GetMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convRepository.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}
	
	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		convRepository.save(convidado);
		return "redirect:/convidados";
		
	}
	
	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		convRepository.delete(id);
		return "redirect:/convidados";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id) {
		convRepository.delete(id);
		return "redirect:/convidados";
	}

}
