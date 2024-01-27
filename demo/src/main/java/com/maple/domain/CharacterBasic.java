package com.maple.domain;

import lombok.Data;

@Data
public class CharacterBasic {
    Long id;
    String date;                    // example: 2023-12-21T00:00+09:00
    String character_name;
    String world_name;
    String character_gender;
    String character_class;         // 캐릭터 직업
    String character_class_level;   // 캐릭터 전직 차수
    long character_level;
    long character_exp;
    String character_exp_rate;      // 현재 레벨에서 경험치 퍼센트
    String character_guild_name;
    String character_image;         // 캐릭터 외형 이미지
}
