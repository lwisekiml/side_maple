package com.maple.repository.character;

import com.maple.domain.Character;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CharacterRepository {

    private static final Map<Long, Character> store = new HashMap<>(); // static 사용
    private static long sequence = 0L; // static 사용

    public void save(Character character) {
        character.setId(++sequence);
    }
}
