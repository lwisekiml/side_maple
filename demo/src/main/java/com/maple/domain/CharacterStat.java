package com.maple.domain;

import java.util.List;

public class CharacterStat {
    Long id;
    String date;            // example: 2023-12-21T00:00+09:00
    String character_class; // 캐릭터 직업
    List final_stat;        // 현재 스탯 정보
    /*
    현재 스탯 정보
    {
        stat_name	string
        example: 최소 스탯 공격력
        스탯 명

        stat_value	string
        example: 43.75
        스탯 값
    }
     */
    long remain_ap;         // 잔연 AP

    public CharacterStat(Long id, String date, String character_class, List final_stat, long remain_ap) {
        this.id = id;
        this.date = date;
        this.character_class = character_class;
        this.final_stat = final_stat;
        this.remain_ap = remain_ap;
    }
}
