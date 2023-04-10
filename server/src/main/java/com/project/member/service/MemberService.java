package com.project.member.service;

import com.project.member.dto.PostMember;
import com.project.member.entity.Member;
import com.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jaeyoung Bang
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public PostMember.Response createMember(PostMember.Request request) {

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        memberRepository.save(member);

        return PostMember.Response.fromEntity(member);
    }
}
