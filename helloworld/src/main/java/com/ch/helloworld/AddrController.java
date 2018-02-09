package com.ch.helloworld;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddrController {

	@RequestMapping(value = "/addr2")
	public String addr2(HttpServletRequest req, HttpServletResponse res, Model model)
			throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gen = req.getParameter("gen");
		String addr = req.getParameter("addr");
		String reg = req.getParameter("reg");

		if (gen.equals("m")) {
			gen = "남성";
		} else if (gen.equals("f")) {
			gen = "여성";
		}

		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gen", gen);
		model.addAttribute("addr", addr);
		model.addAttribute("reg", reg);

		return "addr2";
	}

}
