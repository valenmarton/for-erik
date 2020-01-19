package fhtw.bsa1.projects.pokedex;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * 
 * API for getting data from <a href="https://pokeapi.co/">Poke API</a>
 *
 */
public class PokeAPI {
	/**	readonly var for the endpoint */
	public static final String ENDPOINT = "https://pokeapi.co/api/";
	
	/**
	 * 
	 * @param id - key of the Pokemon wihch should be returned
	 * @return a Pokemon object with the given id
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Pokemon getPokemon(int id) throws MalformedURLException, IOException {
		URL url = new URL(ENDPOINT + "v2/pokemon/" + id);
		URLConnection conn = url.openConnection();
		conn.addRequestProperty("User-Agent", "");
		
		/** open input stream for reading response data */
		InputStream is = conn.getInputStream();
	
		JsonReader jsonReader = Json.createReader(is);  
		JsonObject jsonObject = jsonReader.readObject();
		  
		jsonReader.close();
		is.close();
		
		/** parsing JSON object to Pokemon object */
		Pokemon pokemon = new Pokemon(jsonObject);
		System.out.println(pokemon.toString() + "\n"); 
		
		return pokemon;
	}
		
	/**
	 * 
	 * @param name - name of the Pokemon wihch should be returned
	 * @return a Pokemon object with the given name
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Pokemon getPokemon(String name) throws MalformedURLException, IOException {
		URL url = new URL(ENDPOINT + "v2/pokemon/" + name);
		URLConnection conn = url.openConnection();
		conn.addRequestProperty("User-Agent", "");
		InputStream is = conn.getInputStream();
	
		JsonReader jsonReader = Json.createReader(is);  
		JsonObject jsonObject = jsonReader.readObject();
		 
		jsonReader.close();
		is.close();
		
		Pokemon pokemon = new Pokemon(jsonObject);
		System.out.println(pokemon.toString() + "\n"); 
		
		return pokemon;
	}
	
	public List<Pokemon> getPokemonOfType(int id) {
		return null;
	}
	public List<Pokemon> getPokemonOfType(String type) {
		return null;};
	public List<Pokemon> getPokemonOfType(PokemonType t) {
		return null;};
	public List<Pokemon> getEvolutionChain(Pokemon p) {
		return null;};


			
}
