package com.maple.test;

import com.maple.CharacterInfo.Character;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiTest {
    
    public static void main(String[] args) {
        try {
            String API_KEY = "";
            String characterName = URLEncoder.encode("", StandardCharsets.UTF_8);
            String ocid = "";
            String date = "2023-12-21";

            String urlString = "https://open.api.nexon.com/maplestory/v1/character/basic?ocid=" + ocid + "&date=" + date;
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

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}