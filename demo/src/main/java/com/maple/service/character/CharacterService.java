package com.maple.service.character;

import com.maple.domain.Character;
import com.maple.repository.character.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public void save(Character character) {
        characterRepository.save(character);
    }
}
