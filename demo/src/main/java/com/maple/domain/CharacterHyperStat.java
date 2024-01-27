package com.maple.domain;

import java.util.List;

public class CharacterHyperStat {
    Long id;
    String date;                                // example: 2023-12-21T00:00+09:00
    String character_class;                     // 캐릭터 직업
    String use_preset_no;                       // 적용 중인 프리셋 번호
    long use_available_hyper_stat;              // 사용 가능한 최대 하이퍼스탯 포인트

    List hyper_stat_preset_1;                   // 1번 프리셋 하이퍼 스탯 정보
    /*
    1번 프리셋 하이퍼 스탯 정보
    {
        stat_type	string          스탯 종류
        stat_point	number($int64)  스탯 투자 포인트
        stat_level	number($int64)  스탯 레벨
        stat_increase	string      스탯 상승량
    }
    */
    long hyper_stat_preset_1_remain_point;      // 1번 프리셋 하이퍼 스탯 잔여 포인트

    List hyper_stat_preset_2;                   // 2번 프리셋 하이퍼 스탯 정보
    long hyper_stat_preset_2_remain_point;      // 2번 프리셋 하이퍼 스탯 잔여 포인트

    List hyper_stat_preset_3;                   // 3번 프리셋 하이퍼 스탯 정보
    long hyper_stat_preset_3_remain_point;      // 3번 프리셋 하이퍼 스탯 잔여 포인트
}
