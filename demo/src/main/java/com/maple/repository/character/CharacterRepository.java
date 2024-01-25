package com.maple.repository.character;

import com.maple.domain.CharacterBasic;
import com.maple.repository.mybatis.CharacterBasicMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    private final CharacterBasicMapper characterBasicMapper;

    public void save(CharacterBasic characterBasicInfo) {
        log.info("CharacterRepository save()");
        characterBasicMapper.save(characterBasicInfo);
    }
}
