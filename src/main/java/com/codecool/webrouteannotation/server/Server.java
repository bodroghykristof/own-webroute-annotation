package com.codecool.webrouteannotation.server;

import com.codecool.webrouteannotation.routes.Routes;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/list", Routes::list);
		server.createContext("/find", Routes::find);
		server.createContext("/delete", Routes::delete);
		server.setExecutor(null);
		server.start();
	}

}
