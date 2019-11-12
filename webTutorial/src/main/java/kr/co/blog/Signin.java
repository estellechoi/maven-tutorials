package kr.co.blog;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Signin {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	// Model : 데이터베이스 출력 관련 ?
	public String signin(Model model) {
		model.addAttribute("signinKey", "signinValue");
		return "singin"; // signin.jsp
	}
}