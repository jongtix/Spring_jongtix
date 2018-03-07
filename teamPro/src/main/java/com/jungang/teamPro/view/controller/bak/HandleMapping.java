package com.jungang.teamPro.view.controller.bak;

import java.util.HashMap;
import java.util.Map;

public class HandleMapping {
	private Map<String, Controller> mappings;

	public HandleMapping() {
		mappings = new HashMap<String, Controller>();
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}
}
