package br.com.controller.homeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.daos.ProdutosDAO;
import br.com.model.Produtos;

@Controller
public class HomeController {
	
	
	@Autowired ProdutosDAO produtosDAO;
	
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/teste")
	public ModelAndView teste(){
		ModelAndView mv = new ModelAndView("teste");
		
		Produtos produto = new Produtos();
		produto.setCodBarras("987654321");
		produto.setDescProduto("Alcool");
		produtosDAO.save(produto);
		return mv;
	}

	@RequestMapping("/teste2")
	public ModelAndView teste2(){
		ModelAndView mv = new ModelAndView("teste2/teste2");
		return mv;
	}
	
	
}
