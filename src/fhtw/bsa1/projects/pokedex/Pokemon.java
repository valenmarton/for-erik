package fhtw.bsa1.projects.pokedex;

import java.util.Set;

import javax.json.JsonObject;

/**
 * 
 * Pokemon class for storing json data after parsing
 *
 */
public class Pokemon {
	private int id;
	private String name;
	private int height;
	private int weight;
	
	public Pokemon(JsonObject o) {
		id = o.getInt("id");
		name = o.getString("name");
		height = o.getInt("height");
		weight = o.getInt("weight");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
	public Set<PokemonType> getTypes() {
		return null;}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + "]";
	};
		
		
	
}
