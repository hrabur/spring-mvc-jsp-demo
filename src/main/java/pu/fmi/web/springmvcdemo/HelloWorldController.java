package pu.fmi.web.springmvcdemo;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	public static class Input {
		@Pattern(regexp = "[a-zA-Z ]+")
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
	}
	
	@Value("${greeting}") // Injects value from application.properties
	private String greeting;
	
	@RequestMapping("/say-hello")
	public String sayHello(@Valid Input in, Model model) {
		model.addAttribute("greeting", greeting);
		model.addAttribute("name", in.getName());
		return "/WEB-INF/jsp/say-hello.jsp";
	}

}
