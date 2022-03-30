package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.models.Pokemon;
import com.api.service.PokemonService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@RestController
public class PokemonController {

	@Autowired
	private PokemonService ps;
	@GetMapping(value="/traerpokemones/{id}")
	public String traerpokemones(@PathVariable String id) {
		String uri = "https://pokeapi.co/api/v2/pokemon/"+id;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri,String.class);
		Pokemon data = new Gson().fromJson(restTemplate.getForObject(uri,String.class), Pokemon.class);
		/*JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(parser).getAsJsonArray();

        // for each element of array
        for (JsonElement obj : gsonArr) {
        	
        	System.out.println( obj);
        }*/
		ps.guardarPokemones(data);
		return result;
	}
	
	
	@GetMapping(value="/traerpokemon")
	public String traerpokemonesXVariable(String id) {
		String uri = "https://pokeapi.co/api/v2/pokemon/"+id;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri,String.class);
		Pokemon data = new Gson().fromJson(restTemplate.getForObject(uri,String.class), Pokemon.class);
	
		ps.guardarPokemones(data);
		return result;
	}
}
