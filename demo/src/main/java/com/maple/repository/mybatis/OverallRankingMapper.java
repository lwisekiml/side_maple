package com.maple.repository.mybatis;

import com.maple.dto.OverallRankingInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OverallRankingMapper {

    void save(OverallRankingInfo overallRankingInfo);

}
