package com.jungang.teamPro.view.controller.bak;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	private HandleMapping handerMapping;
	private ViewResolver viewResolver;

	@Override
	public void init() throws ServletException {
		handerMapping = new HandleMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1.클라언트 요청 uri
		String uri = request.getRequestURI();// 요청 uri
		String path = uri.substring(uri.lastIndexOf("/"));// command 추출

		// 2. HandlerMapping에서 path 추출하여 해당 controller 검색
		Controller ctrl = handerMapping.getController(path);

		// 3. 검색된 controller 실행
		String viewName = ctrl.handleRequest(request, response);

		// 4. viewResolver에 의한 화면 이동.
		String view = null;
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		// 5. 이동
		response.sendRedirect(view);
	}

}
