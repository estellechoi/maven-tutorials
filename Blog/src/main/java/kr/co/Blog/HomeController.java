package kr.co.Blog;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.DB.Command;
import kr.co.DB.Dto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/write")
	public String write() {
		return "/write";
	}

//	@RequestMapping(value = "/view", method = RequestMethod.POST)
//	public String view(HttpServletRequest request) {
//		String username = request.getParameter("username");
//		String age = request.getParameter("age");
//		String address = request.getParameter("address");
//		return "/view";
//	}
	
	@RequestMapping(value="/write_ok")
	public String write_ok(Dto dto) throws SQLException {
		Command cmd = new Command();
		cmd.write(dto);
		return "redirect:list";
	}
}
