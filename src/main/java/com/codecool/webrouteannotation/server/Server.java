package com.codecool.webrouteannotation.server;

import com.codecool.webrouteannotation.annotation.WebRoute;
import com.codecool.webrouteannotation.routes.Routes;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		initializeEndpoints(server);
		server.setExecutor(null);
		server.start();
	}

	private static void initializeEndpoints(HttpServer server) {
		Class<Routes> routesClass = Routes.class;
		Method[] methods = routesClass.getMethods();
		for (Method method : methods) {
			WebRoute annotation = method.getAnnotation(WebRoute.class);
			if (annotation != null) {
				if (annotation.active()) createPath(server, method, annotation);
			}
		}
	}

	private static void createPath(HttpServer server, Method method, WebRoute annotation) {
		server.createContext(annotation.path(), (HttpExchange exchange) -> {
			try {
				method.invoke(null, exchange);
			} catch (IllegalAccessException | InvocationTargetException e) {
				Routes.sendResponse(exchange, "Server could not handle request", 500);
			}
		});
	}

}
