package com.maple.test;

import com.maple.test.member.MemberService;
import com.maple.test.member.MemberServiceImpl;
import com.maple.test.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

}
