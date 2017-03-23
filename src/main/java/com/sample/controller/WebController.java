package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.model.User;
import com.sample.service.UserService;

@Controller
public class WebController {

	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="UserService")
	public void setUserService(UserService us){
		this.userService = us;
	}	
	
	@RequestMapping("/")
	public String index(org.springframework.ui.Model model) {
		return "index";
	}

	@RequestMapping(value = {"/user"}, method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
	
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u){
		
		if(u.getId() == 0){
			this.userService.addUser(u);
		}else{
			this.userService.updateUser(u);
		}	
		return "redirect:/user";
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUserById(id);
        return "redirect:/user";
    }
 
	@RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }

}
