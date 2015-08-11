package net.trajano.test;

import javax.ejb.Stateless;
import javax.json.JsonObject;

@Stateless
public class WebSideSlsb {
	public JsonObject hello(JsonObject s) {
		System.out.println(s);
		return s;
	}
}
