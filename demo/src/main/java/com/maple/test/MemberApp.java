package com.maple.test;

import com.maple.test.member.Grade;
import com.maple.test.member.Member;
import com.maple.test.member.MemberService;
import com.maple.test.member.MemberServiceImpl;

// member 실행 및 테스트
public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
