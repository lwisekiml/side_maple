package com.maple.test;

import com.maple.test.member.MemberRepository;
import com.maple.test.member.MemberService;
import com.maple.test.member.MemberServiceImpl;
import com.maple.test.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링으로 전환
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
