package com.maple.domain;

import java.util.List;

public class CharacterStat {
    Long id;
    String date;
    String Character_class;
    List final_stat;
    long remain_ap;

    public CharacterStat(Long id, String date, String character_class, List final_stat, long remain_ap) {
        this.id = id;
        this.date = date;
        Character_class = character_class;
        this.final_stat = final_stat;
        this.remain_ap = remain_ap;
    }
}
