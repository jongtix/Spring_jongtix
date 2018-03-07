package com.jungang.teamPro.view.controller.bak;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request,
			HttpServletResponse response);
}
