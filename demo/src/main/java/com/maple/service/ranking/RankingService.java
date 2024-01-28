package com.maple.service.ranking;

import com.maple.domain.OverallRanking;
import com.maple.dto.OverallRankingInfo;
import com.maple.repository.ranking.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RankingRepository rankingRepository;

    public void save(StringBuffer response) throws ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());

        List<OverallRankingInfo> list = new ArrayList<>();
        JSONArray ranking = (JSONArray) jsonObject.get("ranking");

        for (int i = 0; i < ranking.size(); i++) {
            JSONObject rankingBody = (JSONObject) ranking.get(i);

            OverallRankingInfo overallRankingInfo = new OverallRankingInfo();
            overallRankingInfo.setDate((String) rankingBody.get("date")) ;
            overallRankingInfo.setRanking((long) rankingBody.get("ranking"));
            overallRankingInfo.setCharacter_name((String) rankingBody.get("character_name"));
            overallRankingInfo.setWorld_name((String) rankingBody.get("world_name"));
            overallRankingInfo.setClass_name((String) rankingBody.get("class_name"));
            overallRankingInfo.setSub_class_name((String) rankingBody.get("sub_class_name"));
            overallRankingInfo.setCharacter_level((long) rankingBody.get("character_level"));
            overallRankingInfo.setCharacter_exp((long) rankingBody.get("character_exp"));
            overallRankingInfo.setCharacter_popularity((long) rankingBody.get("character_popularity"));
            overallRankingInfo.setCharacter_guildname((String) rankingBody.get("character_guildname"));

            list.add(overallRankingInfo);
        }
        OverallRanking overallRanking = new OverallRanking(list);
        rankingRepository.save(overallRanking);
    }
}
