package com.livestart.cakefactory.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		model.addAttribute("exception", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
		model.addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		model.addAttribute("status", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		model.addAttribute("path", request.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO));
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
