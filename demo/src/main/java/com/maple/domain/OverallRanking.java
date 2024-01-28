package com.maple.domain;

import com.maple.dto.OverallRankingInfo;

import java.util.List;

public class OverallRanking {
    List<OverallRankingInfo> ranking;

    public OverallRanking(List<OverallRankingInfo> ranking) {
        this.ranking = ranking;
    }

    public List<OverallRankingInfo> getRanking() {
        return ranking;
    }

    public void setRanking(List<OverallRankingInfo> ranking) {
        this.ranking = ranking;
    }
}
