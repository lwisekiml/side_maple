package com.maple.test;

//import lombok.SneakyThrows;
//import org.json.JSONArray;
//import org.json.JSONObject;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;

// 참고 : https://velog.io/@chosj1526/Java-JSON-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95-JSONObject-JSONArray-JsonParser%EB%A1%9C-%ED%8C%8C%EC%8B%B1%ED%95%98%EA%B8%B0
// 참고 : https://soonil.tistory.com/331
public class JsonTest {

    public static class Customer {
        private String name; // key
        private String city; // key

        Customer(String name, String city) {
            this.name = name;
            this.city = city;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getCity() {
            return city;
        }
        public String getName() {
            return name;
        }
    }

    @SneakyThrows
    public static void main(String[] args) throws IOException {

//        // JsonObject
//        JSONObject jo = new JSONObject();
//
//        jo.put("name", "benjamin");
//        jo.put("city", "New York");
//
//        System.out.println("jo : " + jo); // System.out.println(jo.toString()); 와 동일
//
//
//        // 1. HashMap으로 JSONObject 생성
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "bae");
//        map.put("age", "17");
//
//        JSONObject joByMap = new JSONObject(map);
//        System.out.println("joByMap : " + joByMap);
//
//        // 2. JSON 문자열로 JSONObject 객체 생성
//        String str = "{\"read\" : true, \"book\" : \"happy\"}";
//        JSONObject joByString = new JSONObject(str);
//        System.out.println("joByString : " + joByString + ", book : " + joByString.get("book"));
//
//        Iterator<String> iter = joByString.keys();
//        while(iter.hasNext()) {
//            String key = iter.next();
//            System.out.print(key+ ", ");
//        }
//        System.out.println();
//
//        joByString.put("writer", "davi");
//        System.out.println("joByString After Add : " + joByString);
//
//        // 3. POJO로 JSONObject 객체 생성
//        Customer customer = new Customer("Jone", "Seoul");
//        JSONObject jo3 = new JSONObject(customer);
//        System.out.println("jo3: " + jo3);
//
//        // 4. JSONArray
//        // JSONArray에 put(value)로 0개 이상의 데이터를 배열에 추가할 수 있다.
//        // 그리고 JSONArray는 JSONObject의 value가 되도록 다시 추가할 수 있다.
//        JSONArray ja = new JSONArray();
//        ja.put("harry");
//        ja.put("Sam");
//
//        JSONObject jo4 = new JSONObject();
//        jo4.put("feeling", "sad");
//        jo4.put("age", 17);
//        jo4.put("names", ja);
//
//        System.out.println("jo4 : " + jo4);
//
//        // JSONArray안에 JSONObject를 넣을수도 있다.
//        JSONObject jo1 = new JSONObject();
//        jo1.put("test1", "testValue1");
//        JSONObject jo2 = new JSONObject();
//        jo2.put("test2", "testValue2");
//
//        JSONArray jaByJSONObject = new JSONArray();
//        jaByJSONObject.put(jo1);
//        jaByJSONObject.put(jo2);
//        System.out.println("jaByJSONObject : " + jaByJSONObject);
//
//        // List로 JSONArray 객체 생성
//        List<String> namesList = new ArrayList<>();
//        namesList.add("Jam");
//        namesList.add("Miky");
//
//        JSONArray jaByList = new JSONArray(namesList);
//
//        JSONObject joByList = new JSONObject();
//        joByList.put("feeling", "soso");
//        joByList.put("age", 20);
//        joByList.put("names", jaByList);
//
//        System.out.println("joByList : " + joByList);
//
//        // JSON을 파일로 저장
//        JSONObject jo5 = new JSONObject();
//        jo5.put("saw", false);
//        jo5.put("name", "mimi");
//
//        String strOfJo = jo5.toString();
//        File jsonFile = new File("test.txt");
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
//        bw.write(strOfJo);
//        bw.close();

        // json 파싱(parsing)하기
        // JsonParser 사용
        // File(.json) To Json
        Reader reader = new FileReader("test.txt");

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader); // 우선, file을 Object로 만들기
        JSONObject joByFile = (JSONObject) obj;
        System.out.println("joByFile : " + joByFile);

        // Json 형태의 String To Json

        String jsonData = "{\"param1\":\"111\",\"param2\":\"222\"}";
        JSONParser parser = new JSONParser();
        Object o = parser.parse(jsonData);
        JSONObject joByString = (JSONObject) o;
        System.out.println("joByString : " + joByString);
    }
}
