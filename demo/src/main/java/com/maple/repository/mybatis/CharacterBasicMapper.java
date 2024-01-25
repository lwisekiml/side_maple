package com.maple.repository.mybatis;

import com.maple.domain.CharacterBasic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterBasicMapper {

    void save(CharacterBasic characterBasicInfo);

}
