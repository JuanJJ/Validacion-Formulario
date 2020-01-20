package spring.Validacion.Formulario.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.Validacion.Formulario.modelo.Persona;

@Controller
@RequestMapping("/example")
public class ExampleController {
	public static final String EXAMPLE_VIEW="example";
	public static final String FORM_VIEW="validaFormulario";
	public static final String RESULT_VIEW="resultado";
	
	//Se llama al formulario
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("persona", new Persona());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("persona")Persona persona,BindingResult bindingResult) {
		ModelAndView mav=new ModelAndView();
		if (bindingResult.hasErrors()) {
			//si hay errores esto te devuelve al formulario
			mav.setViewName(FORM_VIEW);
		} else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("persona", persona);
		}
		
		return mav;
		
	}
	
	
}
