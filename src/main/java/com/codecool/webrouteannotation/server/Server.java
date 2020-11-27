package com.codecool.webrouteannotation.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/test", (HttpExchange t) -> {
			String response = "This is the response";
			System.out.println("Hey");
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		});
		server.setExecutor(null);
		server.start();
	}

}
