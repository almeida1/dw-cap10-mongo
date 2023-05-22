package com.fatec.sigvs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.sigvs.servico.IMantemProduto;


@Controller
@RequestMapping(path = "/sig")
public class GUIProdutoController {
	Logger logger = LogManager.getLogger(GUIProdutoController.class);
	@Autowired
	IMantemProduto mantemProduto;

	@GetMapping("/produtos")
	public ModelAndView retornaFormDeConsultaTodosProdutos() {
		logger.info(">>>>>> controller consulta todos chamado");
		ModelAndView mv = new ModelAndView("consultarProduto");
		mv.addObject("produtos", mantemProduto.consultaTodos());
		
		return mv;
	}
	@GetMapping("/produtos/{id}")
	public ModelAndView exclui_retornaFormDeConsultaTodosProdutos(@PathVariable("id") Long id) {
		logger.info(">>>>>> controller exclusao chamado");
		mantemProduto.delete(id);
		ModelAndView mv = new ModelAndView("consultarProduto");
		mv.addObject("produtos", mantemProduto.consultaTodos());
		return mv;
		
	}
}

