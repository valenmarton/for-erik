package fhtw.bsa1.projects.pokedex;

import java.net.MalformedURLException;
import java.net.URL;

import javax.json.JsonObject;

/**
 * 
 * NamedResource class for storing json data after parsing
 *
 */
public class NamedResource {
	private String name;
	private URL url;
	
	public NamedResource(JsonObject o) throws MalformedURLException {
		name = o.getString("name");
		url = new URL(o.getString("url"));
	}

	public String getName() {
		return name;
	}

	public URL getUrl() {
		return url;
	}
	
	
}
