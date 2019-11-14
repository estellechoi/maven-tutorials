package kr.co.blog;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.blog.shop.Shop;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home(Shop shop,
			@CookieValue(value = "gender", required = false) Cookie genderCookie,
			HttpServletRequest request) {
		// @CookieValue(value="name") Cookie cookieName
		// 동일 이름의 쿠키를 가져와서 쿠키객체 cookieName 에 저장 (동일이름 쿠키 없다면 Exception) 
		// Exception 피하기 -> required = false (디폴트값 true)
		if (genderCookie != null) {
			shop.setGender(genderCookie.getValue());
		}
		
		return "home"; // .jsp 생략 
	}
	
	@RequestMapping(value = "/homeOk", method = RequestMethod.POST)
	public String homeOk(Shop shop, HttpServletResponse response) {
		
		// 쿠키 객체 생성
		// 이름이 gender 이고 값은 shop.getGender()인 쿠키를 genderCookie 객체에 저장 
		Cookie genderCookie = new Cookie("gender", shop.getGender());
		
		if(shop.getIsCookieDel()) {
			// 쿠키를 생성하지 않는다 (유효시간 : 0)
			genderCookie.setMaxAge(0);
			shop.setGender(null);
		}
		else {
			// 쿠키 생성 (유효시간 지정)
			genderCookie.setMaxAge(60*60*24*30);
		}	
		// (클라이언트에게) response에 쿠키 추가 
		// 클라이언트의 로컬 PC에 쿠키가 저장됨 
		response.addCookie(genderCookie);
		
		return "homeOk"; // .jsp 생략 
	}
	
	
	
}
