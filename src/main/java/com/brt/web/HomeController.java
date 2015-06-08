package com.brt.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brt.domain.User;
import com.brt.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	UserService userServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = {RequestMethod.GET,RequestMethod.HEAD})
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("user",new User());
		
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String userSubmit(@ModelAttribute(value="user") User user) {
		// TODO Auto-generated method stub
		userServiceImpl.save(user);
		return "home";

	}
	
	@RequestMapping(value = "/home/list", method = RequestMethod.GET)
	public String listUser(Model model) {
		// TODO Auto-generated method stub
		
		 return "list";

	}
}
