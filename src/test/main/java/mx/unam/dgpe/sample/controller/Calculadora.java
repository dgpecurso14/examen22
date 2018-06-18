package mx.unam.dgpe.sample.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.apache.log4j.Logger;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

public class Calculadora extends AbstractVerticle {
	private static final Logger logger = Logger.getLogger(MyController.class);

	public void start(Future<Void> fut) {
		logger.info("Inicializando Vertical");
		Router router = Router.router(vertx);
	    router.route("/html/*").handler(StaticHandler.create("assets")); // para invocar
		// asi: http://localhost:8080/index.html
		// el directorio "upload-folder" será creado en la misma ubicación que el jar
		// fue ejecutado
		router.route().handler(BodyHandler.create().setUploadsDirectory("upload-folder"));
		router.get("/api/suma").handler(this::suma);
		router.get("/api/rest").handler(this::resta);
		router.get("/api/factorial").handler(this::factorial);
		router.get("/api/div").handler(this::division);
		router.get("/api/mult").handler(this::multiplicacion);
		 // Create the HTTP server and pass the "accept" method to the request handler.
		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080),
				result -> {
					System.out.println("hola mundo");
					if (result.succeeded()) {
						fut.complete();
					} else {
						fut.fail(result.cause());
					}
				});

		logger.info("Vertical iniciada !!!");
	}

	private void suma(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		HttpServerRequest request = routingContext.request();
		String a = request.getParam("a");
		String b = request.getParam("b");
		String host=request.localAddress().host();
		double da = 0, db = 0;
		String json = "";
		try {

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
		} catch (Exception e) {
			e.printStackTrace();
			Map<Object, Object> info = new HashMap<>();
			info.put("error", "Los valores pasados 'a' y 'b' no son números");
			info.put("valor", "");
			info.put("ip", host);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(info));
			return;
		}

		Map<Object, Object> info = new HashMap<>();
		info.put("error", "");
		info.put("valor", "" + (da + db));
		info.put("ip", host);
		json = Json.encodePrettily(info);

		response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(json);
	}

	
	private void factorial (RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		try {
			HttpServerRequest request = routingContext.request();
			
			String b = request.getParam("b");
			BigInteger bd=new BigInteger( b);
			BigInteger res = new BigInteger("1");
			for(int i=1; i<bd.doubleValue(); i++) {
				res=res.add(res.multiply(new BigInteger(i+"")));
				//System.out.println("en "+i+" es "+ res.toString());
						//n=n*i
				
			}
			//System.out.println("Factorial"+ res.toString());
			Map<Object, Object> json = new HashMap<>();
			json.put("digitos", res.toString().length());
			String r= Json.encodePrettily(json);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(r);
		}catch (Exception e) {
			// TODO: handle exception
			Map<Object, Object> json = new HashMap<>();
			json.put("digitos", -1);
			json.put("error", e.getMessage());
			String r= Json.encodePrettily(json);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(r);
		}
		
		
	}
	private void division(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		HttpServerRequest request = routingContext.request();
		String host=request.localAddress().host();
		String a = request.getParam("a");
		String b = request.getParam("b");
		double da = 0, db = 0;
		String json = "";
		try {

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
			if (db == 0) {
				Map<Object, Object> info = new HashMap<>();
				info.put("error", "No existe la división por cero");
				info.put("valor", "Inexistente");
				info.put("ip", host);
				response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
						.end(Json.encodePrettily(info));
				return;

			}
		} catch (Exception e) {
			e.printStackTrace();
			Map<Object, Object> info = new HashMap<>();
			info.put("error", "Los valores pasados 'a' y 'b' no son números");
			info.put("valor", "");
			info.put("ip", host);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(info));
			return;
		}

		Map<Object, Object> info = new HashMap<>();
		info.put("error", "");
		info.put("valor", "" + (da / db));
		info.put("ip", host);
		json = Json.encodePrettily(info);

		response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(json);
	}

	private void resta(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		HttpServerRequest request = routingContext.request();
		String host=request.localAddress().host();
		String a = request.getParam("a");
		String b = request.getParam("b");
		double da = 0, db = 0;
		String json = "";
		try {

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
		} catch (Exception e) {
			e.printStackTrace();
			Map<Object, Object> info = new HashMap<>();
			info.put("error", "Los valores pasados 'a' y 'b' no son números");
			info.put("valor", "");
			info.put("ip", host);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(info));
			return;
		}

		Map<Object, Object> info = new HashMap<>();
		info.put("error", "");
		info.put("valor", "" + (da - db));
		info.put("ip", host);
		json = Json.encodePrettily(info);

		response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(json);
	}

	private void multiplicacion(RoutingContext routingContext) {
		HttpServerResponse response = routingContext.response();
		HttpServerRequest request = routingContext.request();
		String host=request.localAddress().host();
		String a = request.getParam("a");
		String b = request.getParam("b");
		double da = 0, db = 0;
		String json = "";
		try {

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
		} catch (Exception e) {
			e.printStackTrace();
			Map<Object, Object> info = new HashMap<>();
			info.put("error", "Los valores pasados 'a' y 'b' no son números");
			info.put("valor", "");
			info.put("ip", host);
			response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(info));
			return;
		}

		Map<Object, Object> info = new HashMap<>();
		info.put("error", "");
		info.put("valor", "" + (da * db));
		info.put("ip", host);
		json = Json.encodePrettily(info);

		response.setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8").end(json);
	}

}
