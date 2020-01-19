package fhtw.bsa1.projects.extras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fhtw.bsa1.projects.pokedex.PokeAPI;
import fhtw.bsa1.projects.pokedex.Pokemon;

/**
 * Utility class providing convenience function for terminal control using
 * <a href="https://www.csie.ntu.edu.tw/~r92094/c++/VT100.html">vt100
 * commands</a>
 * 
 * @author Alija Sabic
 * @email sabic@technikum-wien.at
 * @version 0.1
 */
public class Util {

	/** vt100 escape sequences */
	public static final String ESC = "\033";
	/** cursor home: `[H` - Move cursor to upper left corner. */
	public static final String CURSORHOME = "[H";
	/** clear screen: `[2J` - Clear entire screen. */
	public static final String CLEARSCREEN = "[2J";

	/**
	 * `private` Constructor to prevent instantiations of this utility class.
	 */
	private Util() {
	}

	/**
	 * Clears the terminal screen (supporting vt100 commands).
	 */
	public static void clearScreen() {
		System.out.print(ESC + CURSORHOME + ESC + CLEARSCREEN);
		System.out.flush();
	}

	/**
	 * 
	 * @param fileName       - name of txt file
	 * @param pokemonToWrite - writes the searched pokemons to the {fileName}.txt
	 */
	public static void writeToSpecifiedFile(String fileName, String pokemonToWrite) {
		try {
			FileWriter writer = new FileWriter(fileName + ".txt", true);
			writer.write(pokemonToWrite + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id - id or ids of pokemons
	 * @return - returns a list of pokemons based on the id / ids and writes them to
	 *         a file named "sorted_pokemons_by_height"
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static List<Pokemon> getPokemonsByIdAndSortByHeightAndWriteToFile(int... id)
			throws MalformedURLException, IOException {
		List<Pokemon> pokemonList = new ArrayList<>();
		PokeAPI api = new PokeAPI();
		for (int i = 0; i < id.length; i++) {
			pokemonList.add(api.getPokemon(id[i]));
		}
		List<Pokemon> sortedPokemonList = pokemonList.stream().sorted(Comparator.comparingInt(Pokemon::getHeight))
				.collect(Collectors.toList());
		for (Pokemon pokemon : sortedPokemonList) {
			writeToSpecifiedFile("sorted_pokemons_by_height", pokemon.toString());
		}

		return sortedPokemonList;

	}

	/**
	 * 
	 * @param input - input file with 5 integers which are ids for pokemons to query
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static List<Integer> getPokemonsQueriedByAnInputFile(File input) throws MalformedURLException, IOException {
		List<Integer> listOfIds = new ArrayList<Integer>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(input));
			String number = null;

			while ((number = reader.readLine()) != null) {
				listOfIds.add(Integer.parseInt(number));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		PokeAPI api = new PokeAPI();
		for (int id : listOfIds) {
			api.getPokemon(id);
		}

		/*
		 * Scanner scanner = new Scanner(input); int [] idArray = new int [5]; int i =
		 * 0; PokeAPI api = new PokeAPI(); while(scanner.hasNextInt()) { idArray[i++] =
		 * scanner.nextInt(); } for(int id : idArray) { api.getPokemon(id); }
		 * scanner.close();
		 */
		return listOfIds;
	}

}