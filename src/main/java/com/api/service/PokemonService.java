package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Pokemon;
import com.api.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pr;
	
	public void guardarPokemones(List<Pokemon> pokemones) {

		
	}

	public void guardarPokemones(Pokemon data) {
		
		Optional<Pokemon> poke = pr.findById(data.getId());
		Pokemon poke1;
		if(poke.isPresent()) {
		poke1=poke.get();
		}else {
		poke1 = new Pokemon();}
		
		poke1.setId(data.getId());
		poke1.setName(data.getName());
		poke1.setBase_experience(data.getBase_experience());
		poke1.setHeight(data.getHeight());
		poke1.setWeight(data.getWeight());
		poke1.setStats(data.getStats());
		pr.save(poke1);
	}
	
	
	public Double promedio() {
		List<Pokemon>pokemones=pr.findAll();
		Integer total = pokemones.size();
		Integer suma;
		for (Pokemon pokemon : pokemones) {
			 suma = suma + pokemon.getStats();
		}
		Double promedio= (double) (suma / total);
		return promedio;
	}
}
