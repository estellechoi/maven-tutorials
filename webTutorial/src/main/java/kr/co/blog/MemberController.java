package kr.co.blog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.blog.members.Member;
import kr.co.blog.members.service.MemberService;

@Controller
@RequestMapping("/member") // 공통경로 명시 (중복 데이터 제거)
public class MemberController {

	// 컨테이너에서 동일타입(MemberService) 빈 객체 호출
	// MemberService 클래스 파일에서 @Service 어노테이션으로 빈 생성하였음. 
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model,
			@RequestParam("email") String email,
			@RequestParam(value = "pwd", required = false, defaultValue = "0000") String pwd) {

		// @RequestParam 어노테이션
		// HttpServletRequest 객체생성 및 getParameter 메소드 대체
		// required = ture 속성 : 필수값 지정 (값 없다면 Exception) 
		// defaultValue = "" 속성 : required = false 일 때, 값 없는 경우 기본값 지정 
		
		memberService.select(email, pwd);

		try {
			model.addAttribute("email", email);
			model.addAttribute("pwd", pwd);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "signinOk";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Member member) {
		// 커맨드 객체를 이용한 HTTP 전송 정보 얻기 
		// Member (DTO) 객체 생성시, setter 자동실행 (POST 값이 이름이 동일한 변수에 저장됨)
		
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		String username = request.getParameter("username");
//		String cell1 = request.getParameter("cell1");
//		String cell2 = request.getParameter("cell2");
//		String cell3 = request.getParameter("cell3");

		memberService.register(member.getEmail(), member.getPwd(), member.getUsername(), member.getCell1(), member.getCell2(), member.getCell3());
//
//		model.addAttribute("email", email);
//		model.addAttribute("pwd", pwd);
//		model.addAttribute("username", username);
//		model.addAttribute("cell", cell1 + "-" + cell2 + "-" + cell3);

		return "signupOk";
	}

}
