package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon,String>{

}
