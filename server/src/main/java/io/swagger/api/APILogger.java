package io.swagger.api;

public final class APILogger {
	private APILogger() {};
	
	public static void log(String requestResponse, String tag, Object... objects) {
		System.out.println("=====================================");
		System.out.println("API " + requestResponse + ": " + tag);
		for (Object o : objects) {
			System.out.println(o.toString());
		}
		System.out.println("=====================================");
	}
	
	public static void request(String tag, Object... objects) {
		log("Request", tag, objects);
	}
	
	public static void response(String tag, Object... objects) {
		log("Response", tag, objects);
	}
	
	public static void done(String log) {
		System.out.println("=====================================");
		System.out.println(log);
		System.out.println("=====================================");
	}
}
