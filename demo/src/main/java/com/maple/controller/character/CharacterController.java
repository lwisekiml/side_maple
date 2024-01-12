package com.maple.controller.character;

import com.maple.service.character.CharacterService;
import org.springframework.stereotype.Controller;

@Controller
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }
}
