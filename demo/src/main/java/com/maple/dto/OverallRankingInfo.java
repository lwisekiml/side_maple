package com.maple.dto;

import lombok.Data;

@Data
public class OverallRankingInfo {
    Long id;                    // id 값은 자동 증가 값
    String date;                // example: 2023-12-22T00:00+09:00
    long ranking;               // 종합 랭킹 순위
    String character_name;      // 캐릭터 명
    String world_name;          // 월드 명
    String class_name;          // 직업 명
    String sub_class_name;      // 전직 직업 명
    long character_level;       // 캐릭터 레벨
    long character_exp;         // 캐릭터 경험치
    long character_popularity;  // 캐릭터 인기도
    String character_guildname; // 길드 명
}
