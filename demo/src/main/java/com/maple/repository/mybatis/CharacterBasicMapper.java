package com.maple.repository.mybatis;

import com.maple.domain.Character;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterBasicMapper {

    void save(Character characterInfo);

}
