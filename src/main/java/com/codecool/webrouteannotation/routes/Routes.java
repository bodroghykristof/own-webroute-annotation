package com.codecool.webrouteannotation.routes;

import com.codecool.webrouteannotation.annotation.WebRoute;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Routes {

	@WebRoute(path = "/list", method = "GET")
	public static void list(HttpExchange httpExchange) throws IOException {
		String response = "This is the list of elements";
		sendResponse(httpExchange, response, 200);
	}

	@WebRoute(path = "/find", method = "GET")
	public static void find(HttpExchange httpExchange) throws IOException {
		String response = "Element was found";
		sendResponse(httpExchange, response, 200);
	}

	@WebRoute(path = "/delete", method = "GET")
	public static void delete(HttpExchange httpExchange) throws IOException {
		String response = "Element was removed";
		sendResponse(httpExchange, response, 202);
	}

	public static void sendResponse(HttpExchange httpExchange, String response, int statusCode) throws IOException {
		httpExchange.sendResponseHeaders(statusCode, response.length());
		OutputStream os = httpExchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
