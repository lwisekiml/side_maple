package com.maple.service.character;

import com.maple.domain.CharacterBasic;
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
        CharacterBasic characterBasic = new CharacterBasic();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());

        characterBasic.setDate((String) jsonObject.get("date"));
        characterBasic.setCharacter_name((String) jsonObject.get("character_name"));
        characterBasic.setWorld_name((String) jsonObject.get("world_name"));
        characterBasic.setCharacter_gender((String) jsonObject.get("character_gender"));
        characterBasic.setCharacter_class((String) jsonObject.get("character_class")) ;
        characterBasic.setCharacter_class_level((String) jsonObject.get("character_class_level"));
        characterBasic.setCharacter_level((long) jsonObject.get("character_level"));
        characterBasic.setCharacter_exp((long) jsonObject.get("character_exp"));
        characterBasic.setCharacter_exp_rate((String) jsonObject.get("character_exp_rate"));
        characterBasic.setCharacter_guild_name((String) jsonObject.get("character_guild_name"));
        characterBasic.setCharacter_image((String) jsonObject.get("character_image"));

        System.out.println("characterBasic.toString() : " + characterBasic.toString());

        characterRepository.save(characterBasic);
    }
}
