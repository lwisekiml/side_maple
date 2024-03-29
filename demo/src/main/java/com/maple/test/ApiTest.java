package com.maple.test;

import com.maple.domain.CharacterBasic;
import com.maple.domain.CharacterStat;
import com.maple.dto.SkillInfoDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ApiTest {
    
    public static void main(String[] args) {
        try {
            String API_KEY = "";
            String characterName = URLEncoder.encode("", StandardCharsets.UTF_8);
            String ocid = "";
            String date = "2023-12-21";

            String urlString = "";
            URL url = new URL(urlString);

            // HTTP connection 설정
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", API_KEY);

            int responseCode = connection.getResponseCode();

            BufferedReader in;
            if(responseCode == 200) {
                // responseCode 200 정상응답
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                // responseCode 200 이외의 코드가 반환되었을 경우
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 캐릭터 기본 정보 조회
            CharacterBasic characterBasic = new CharacterBasic();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
//
//            characterBasic.setDate((String) jsonObject.get("date"));
//            characterBasic.setCharacter_name((String) jsonObject.get("character_name"));
//            characterBasic.setWorld_name((String) jsonObject.get("world_name"));
//            characterBasic.setCharacter_gender((String) jsonObject.get("character_gender"));
//            characterBasic.setCharacter_class((String) jsonObject.get("character_class")) ;
//            characterBasic.setCharacter_class_level((String) jsonObject.get("character_class_level"));
//            characterBasic.setCharacter_level((long) jsonObject.get("character_level"));
//            characterBasic.setCharacter_exp((long) jsonObject.get("character_exp"));
//            characterBasic.setCharacter_exp_rate((String) jsonObject.get("character_exp_rate"));
//            characterBasic.setCharacter_guild_name((String) jsonObject.get("character_guild_name"));
//            characterBasic.setCharacter_image((String) jsonObject.get("character_image"));
//
//            System.out.println("characterBasic.toString() : " + characterBasic.toString());

            // 캐릭터 스킬 정보 조회
            List<SkillInfoDto> list = new ArrayList<>();
            JSONArray character_skill = (JSONArray) jsonObject.get("character_skill");

            for (int i = 0; i < character_skill.size(); i++) {
                JSONObject skillBody = (JSONObject) character_skill.get(i);

                SkillInfoDto skillInfoDto = new SkillInfoDto();
                skillInfoDto.setSkill_name((String) skillBody.get("skill_name"));
                skillInfoDto.setSkill_description((String) skillBody.get("skill_description"));
                skillInfoDto.setSkill_level((long) skillBody.get("skill_level"));
                skillInfoDto.setSkill_effect((String) skillBody.get("skill_effect"));
                skillInfoDto.setSkill_icon((String) skillBody.get("skill_icon"));

                list.add(skillInfoDto);
            }

            CharacterStat characterStat = new CharacterStat(1L, "test", "ttt", list, 10);
            System.out.println("aaaa :" + characterStat.toString());

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}