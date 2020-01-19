package fhtw.bsa1.projects.pokedex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fhtw.bsa1.projects.extras.Util;

public class PokeDex {

	/** console application for retrieving and using pokemon data */
	public static void main(String[] args) throws IOException {
		PokeAPI api = new PokeAPI();
		
		Scanner scanner = new Scanner(System.in);
		int answer;
		List<Pokemon> searchedPokemons = new ArrayList<>();
		
		do {
			System.out.println("Would you like to retrieve pokemon data based on id or name ?");
			System.out.println("Press '0' to exit - '1' to choose id - '2' to choose name: ");
			answer = scanner.nextInt();
			
			switch(answer) {
				case 0: break;
				case 1: {
						System.out.println("Give a pokemon id: ");
						int id = scanner.nextInt();
						searchedPokemons.add(api.getPokemon(id));
						break;
				}
				case 2: {
						System.out.println("Give a pokemon name: ");
						String name = scanner.next();
						searchedPokemons.add(api.getPokemon(name));
						break;
				}
				default: System.out.println("You gave bad number!");
			}
			
			// clears screen when not using eclipse terminal
			//Util.clearScreen();
		}
		while(answer != 0);
		
		System.out.println("Would you like to save the history? Press 'y' or 'n'!");
		char saveToFile = scanner.next().charAt(0);
		if(saveToFile == 'y') {
			System.out.println("Give a file name please: ");
			String fileName = scanner.next();
			for(Pokemon pokemon : searchedPokemons) {
				System.out.println("Written to the file : " + pokemon);
				Util.writeToSpecifiedFile(fileName, pokemon.toString());
			}
		}
		else {
			System.out.println("You did not save the pokemons.");
		}
		scanner.close();
		
		/** search for pokemons with id: 2, 3, 5 and write them to a file */
		//Util.getPokemonsByIdAndSortByHeightAndWriteToFile(2,3,5);
		
		/** search for pokemons with ids given in input.txt file */
		//Util.getPokemonsQueriedByAnInputFile(new File("input.txt"));
		
		System.out.println("Application shutdown.");
	}
}