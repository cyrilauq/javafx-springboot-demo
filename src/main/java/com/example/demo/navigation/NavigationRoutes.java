package com.example.demo.navigation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class NavigationRoutes {
	private Map<String, String> routes;
	
	public NavigationRoutes() {
		routes = new HashMap<String, String>();
		routes.put("home", "ui.fxml");
		routes.put("ui2", "ui2.fxml");
	}
	
	public String getRoutePath(String routeName) {
		if(routes.containsKey(routeName)) return routes.get(routeName);
		throw new RuntimeException("no route found for the name [ " + routeName + " ]");
	}
}
