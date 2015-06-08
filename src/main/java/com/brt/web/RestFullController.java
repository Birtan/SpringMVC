package com.brt.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.brt.domain.User;
import com.brt.service.UserService;

@RestController
@RequestMapping(value = "user")
@ResponseBody
@ResponseStatus(HttpStatus.OK)
public class RestFullController {
	@Inject
	private UserService userServiceImpl;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	List<User> getRest() {
		List<User> listUser = userServiceImpl.listUserRepository();
		
		
		return listUser;

	}

}
