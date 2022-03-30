package com.api.service;

import java.util.ArrayList;
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
	
	
	/* public Double promedio() {
		List<Pokemon>pokemones=pr.findAll();
		Integer total = pokemones.size();
		Integer suma;
		for (Pokemon pokemon : pokemones) {
			 suma = suma + pokemon.getStats();
		}
		Double promedio= (double) (suma / total);
		return promedio;
	}*/
	
	
/*	public Integer moda(List<String>id) {
		
	List<Pokemon>pokemones = new ArrayList<>();
	for (String string : id) {
		Optional<Pokemon> a = pr.findById(string);
		Pokemon b;
		if(a.isPresent()) {
			b=a.get();
		}
		pokemones.add(b);
	}
	
	int maximaVecesQueSeRepite = 0;
	int moda = 0;
	for(int i=0; i<pokemones.size(); i++){
	int vecesQueSeRepite = 0;
	for(int j=0; j<pokemones.size(); j++){
	if(pokemones.get(i) == pokemones.get(j))
	vecesQueSeRepite++;
	}
	if(vecesQueSeRepite > maximaVecesQueSeRepite){
	moda = pokemones.get(i);
	maximaVecesQueSeRepite = vecesQueSeRepite;
	}
	}

	System.out.println("La moda es "+moda+" y se repitió "+maximaVecesQueSeRepite+" veces.");
	}
	*/
}
