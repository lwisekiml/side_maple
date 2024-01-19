package com.maple.repository.character;

import com.maple.domain.Character;
import com.maple.repository.mybatis.CharacterBasicMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    private final CharacterBasicMapper characterBasicMapper;

    public void save(Character characterInfo) {
        log.info("CharacterRepository save()");
        characterBasicMapper.save(characterInfo);
    }
}
