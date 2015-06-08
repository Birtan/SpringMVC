package com.brt.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.brt.domain.User;
import com.brt.service.UserService;

@Controller
@SessionAttributes("sessionUser")
@RequestMapping(value="session")
public class SessionController {
	@Inject
	UserService userServiceImpl;
	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	public String session( Model model) {
		
		model.addAttribute("user",new User());
		
		return "signin";
	}
	
	@RequestMapping(value = "/home", method = {RequestMethod.POST})
	public String userSubmit(@ModelAttribute(value="user") User user, Model model) {
		
	 User userFind=	userServiceImpl.find(user);
	 if (userFind!=null) {
		 model.addAttribute("sessionUser", userFind);
		 return "session";
	}
	
		return "signin";
	}
}
