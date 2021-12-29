package com.itau.thecat.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itau.thecat.model.Breed;
import com.itau.thecat.model.StatusBreed;
import com.itau.thecat.repository.filter.BreedFilter;
import com.itau.thecat.service.TheCatService;

@Controller
@RequestMapping("/racas")
public class TheCatController {

	private static final String PESQUISA_VIEW = "PesquisaRacas";
	private static final String CADASTRO_VIEW = "CadastroRaca";

	@Autowired
	private TheCatService theCatService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Breed());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Breed breed, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		try {
			//theCatService.save(breed);
			attributes.addFlashAttribute("mensagem", "Raça salva com sucesso!");
			return "redirect:/racas/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("", null, e.getMessage());
			return CADASTRO_VIEW;
		}
	}

	@RequestMapping
	public ModelAndView listar(@ModelAttribute("filtro") BreedFilter filtro) {
		List<Breed> breeds = theCatService.filtrar(filtro);

		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("breeds", breeds);
		return mv;
	}

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Breed breed) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(breed);
		return mv;
	}


	@ModelAttribute("todosStatusBreed")
	public List<StatusBreed> todosStatusBreed() {
		return Arrays.asList(StatusBreed.values());
	}

}