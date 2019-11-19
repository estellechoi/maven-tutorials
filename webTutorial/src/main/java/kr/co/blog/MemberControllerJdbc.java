package kr.co.blog;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberDto;
import kr.co.blog.members.service.MemberServiceJdbc;

@Controller
@RequestMapping("/memberJdbc") // 공통경로 명시 (중복 데이터 제거)
public class MemberControllerJdbc {

	@Autowired
	MemberServiceJdbc memberService;
	
	// 메소드에 ModelAttribute("name") 적용하는 경우
	// 어떤 RequestMapping 실행하더라도 뷰단에서 해당 이름으로 리턴값을 쓸 수 있다. 
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		return dateFormat.format(date);
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model, MemberDto member) {

		MemberDto memberRs = memberService.select(member);

		try {
			model.addAttribute("email", memberRs.getEmail());
			model.addAttribute("pwd", memberRs.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "signinOk";
	}

	@RequestMapping("/signout")
	public String signout(MemberDto member, HttpSession session) {
		
		// 세션 종료 
		session.invalidate();
		
		return "signoutOk";
	}
	

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("m") MemberDto member, Model model) {
		
		int result = memberService.register(member);
		if(result == 0) {
			model.addAttribute("result", "fail");
			return "fail";
		}
		model.addAttribute("result", "good");
		return "signupOk";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@ModelAttribute("m") MemberDto member, HttpSession session) {
		// 커맨드 객체를 이용해 DTO 에 HTTP 전송값을 넣는다 (setter 실행)
		
		// 해당 회원 탈퇴처리 
		int result = memberService.remove(member);
		
		// 세션 종료
		session.invalidate();
		
		return "removeOk";
	}

}
