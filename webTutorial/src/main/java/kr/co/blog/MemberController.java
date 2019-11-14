package kr.co.blog;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.blog.members.Member;
import kr.co.blog.members.service.MemberService;

@Controller
@RequestMapping("/member") // 공통경로 명시 (중복 데이터 제거)
public class MemberController {

	// 컨테이너에서 동일타입(MemberService) 빈 객체 호출
	// MemberService 클래스 파일에서 @Service 어노테이션으로 빈 생성하였음.
	@Autowired
	MemberService memberService;
	
	// 메소드에 ModelAttribute("name") 적용하는 경우
	// 어떤 RequestMapping 실행하더라도 뷰단에서 해당 이름으로 리턴값을 쓸 수 있다. 
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		return dateFormat.format(date);
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model, @RequestParam("email") String email,
			@RequestParam(value = "pwd", required = false, defaultValue = "0000") String pwd) {

		// @RequestParam 어노테이션
		// HttpServletRequest 객체생성 및 getParameter 메소드 대체
		// required = ture 속성 : 필수값 지정 (값 없다면 Exception)
		// defaultValue = "" 속성 : required = false 일 때, 값 없는 경우 기본값 지정

		memberService.select(email, pwd);

		try {
			model.addAttribute("email", email);
			model.addAttribute("pwd", pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "signinOk";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("m") Member member) {
		// 커맨드 객체를 이용한 HTTP 전송 정보 얻기
		// Member (DTO) 객체 생성시, setter 자동실행 (POST 값이 이름이 동일한 변수에 저장됨)
		// 이 때, DTO 변수의 자료형에 맞게 자동으로 값 저장됨 
		// @ModelAttribute("name") : 뷰단에서 커맨드 객체의 이름을 대체할 닉네임 생성하기 (자바코드에서는 대체 불가)
		// 뷰단에서 호출시 : ${객체이름.변수명} -> Model 필요 없음

//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		String username = request.getParameter("username");
//		String cell1 = request.getParameter("cell1");
//		String cell2 = request.getParameter("cell2");
//		String cell3 = request.getParameter("cell3");

		memberService.register(member.getEmail(), member.getPwd(), member.getUsername(), member.getCells(), member.getIsAdult(), member.getSports());
//		model.addAttribute("email", email);
//		model.addAttribute("pwd", pwd);
//		model.addAttribute("username", username);
//		model.addAttribute("cell", cell1 + "-" + cell2 + "-" + cell3);

		return "signupOk";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@ModelAttribute("m") Member member) {
		// 커맨드 객체를 이용해 DTO 에 HTTP 전송값을 넣는다 (setter 실행)
		
		// 해당 회원 탈퇴처리 후 남은 회원정보 모두 시스템 출력 
		memberService.remove(member);
		
		return "removeOk";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Model model, Member member) {
		
		// edit 메소드의 리턴값을 members[] 배열에 저장 
		Member members[] = memberService.edit(member);
		
		model.addAttribute("memberBefore", members[0]);
		model.addAttribute("memberAfter", members[1]);
		
		return "editOk";
	}
	
	@RequestMapping(value = "/editPwd", method=RequestMethod.POST)
	public ModelAndView editPwd(Member member) {
		
		// edit 메소드의 리턴값을 members[] 배열에 저장 
		Member members[] = memberService.edit(member);
		
		// ModelAndView 객체 생성 후 데이터와 뷰의 이름 추가 
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberPwdBefore", members[0]);
		mv.addObject("memberPwdAfter", members[1]);
		
		// 뷰 경로 
		mv.setViewName("editPwdOk");
		
		return mv;
	}
	
	// * Model 과 Model and View 
	// Model : 데이터만 전달 
	// Model and View : 데이터와 뷰의 이름을 함께 전달 

}
