package fhtw.bsa1.projects.pokedex;

import javax.json.JsonObject;

/**
 * 
 * PokemonType class for storing json data after parsing
 *
 */
public class PokemonType {
	private int slot;
	
	public PokemonType(JsonObject o) {
		slot = o.getInt("slot");
	}

	public int getSlot() {
		return slot;
	}
	
}
