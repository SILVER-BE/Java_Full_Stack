package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    //생성자 주입 방식

    private Pokemon pokemon; //의존성

    /* 생성자가 하나일 때는 @Autowired 생략 가능 */
    @Autowired //생성자 의존성 주입
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }

}
