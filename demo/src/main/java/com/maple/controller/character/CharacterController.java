package com.maple.controller.character;

import com.maple.domain.Character;
import com.maple.service.character.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/character")
@RequiredArgsConstructor // final 이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어준다.
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/basic") // 기본 정보 조회
    public void basic(Character character) {
       characterService.save(character);
    }
}
