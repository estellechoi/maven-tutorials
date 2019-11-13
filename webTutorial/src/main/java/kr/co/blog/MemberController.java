package kr.co.blog.members.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.blog.members.service.MemberService;

@Controller
public class MemberController {

	// 컨테이너에서 동일타입(MemberService) 빈 객체 호출
	// MemberService 클래스 파일에서 @Service 어노테이션으로 빈 생성하였음. 
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model, HttpServletRequest request) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		memberService.select(email, pwd);

		model.addAttribute("email", email);
		model.addAttribute("pwd", pwd);

		return "siginOk";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, HttpServletRequest request) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String username = request.getParameter("username");
		String cell1 = request.getParameter("cell1");
		String cell2 = request.getParameter("cell2");
		String cell3 = request.getParameter("cell3");

		memberService.register(email, pwd, username, cell1, cell2, cell3);

		model.addAttribute("email", email);
		model.addAttribute("pwd", pwd);
		model.addAttribute("username", username);
		model.addAttribute("cell", cell1 + "-" + cell2 + "-" + cell3);

		return "signupOk";
	}

}
