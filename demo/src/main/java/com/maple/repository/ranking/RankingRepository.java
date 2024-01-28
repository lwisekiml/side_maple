package com.maple.repository.ranking;

import com.maple.domain.OverallRanking;
import com.maple.dto.OverallRankingInfo;
import com.maple.repository.mybatis.OverallRankingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RankingRepository {

    private final OverallRankingMapper overallRankingMapper;

    public void save(OverallRanking overallRanking) {
        for (int i = 0; i < overallRanking.getRanking().size(); i++) {
            OverallRankingInfo overallRankingInfo = overallRanking.getRanking().get(i);
            overallRankingMapper.save(overallRankingInfo);
        }
    }
}
