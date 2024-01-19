package com.maple.service.character;

import com.maple.domain.Character;
import com.maple.repository.character.CharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    @SneakyThrows
    public void save(StringBuffer response) {

        // 캐릭터 기본 정보 조회
        Character character = new Character();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());

        character.setDate((String) jsonObject.get("date"));
        character.setCharacter_name((String) jsonObject.get("character_name"));
        character.setWorld_name((String) jsonObject.get("world_name"));
        character.setCharacter_gender((String) jsonObject.get("character_gender"));
        character.setCharacter_class((String) jsonObject.get("character_class")) ;
        character.setCharacter_class_level((String) jsonObject.get("character_class_level"));
        character.setCharacter_level((long) jsonObject.get("character_level"));
        character.setCharacter_exp((long) jsonObject.get("character_exp"));
        character.setCharacter_exp_rate((String) jsonObject.get("character_exp_rate"));
        character.setCharacter_guild_name((String) jsonObject.get("character_guild_name"));
        character.setCharacter_image((String) jsonObject.get("character_image"));

        System.out.println("character.toString() : " + character.toString());

        characterRepository.save(character);
    }
}
