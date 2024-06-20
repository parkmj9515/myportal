package himedia.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {
	// GET - /users/join
//	@RequestMapping(value={"/", "/join"}, method=RequestMethod.GET)
	@GetMapping({ "/", "/main" })
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}

/*	// POST - /users/join -> /users/joinsuccess redirect
//	@RequestMapping(value="/join", method=RequestMethod.POST)	
	@PostMapping("/main")
	public String joinAction(@ModelAttribute UserVo vo) {
		System.out.println("FORM DATA:" + vo);
		// View 이름 대신에 redirect:
		return "redirect:/users/home.jsp";
	}

	// GET - /users/joinsuccess
	@GetMapping("/main")
	public String joinsuccess() {
		return "/WEB-INF/views/home.jsp";
	}
	*/ 
}