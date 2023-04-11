package com.project.member.service;

import com.project.exception.BusinessLogicException;
import com.project.member.dto.PostMember;
import com.project.member.entity.Member;
import com.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.exception.ErrorCode.ALREADY_EXISTS_EMAIL;
import static com.project.exception.ErrorCode.ALREADY_EXISTS_NICKNAME;

/**
 * @author Jaeyoung Bang
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public PostMember.Response createMember(PostMember.Request request) {
        verifyExistsEmail(request);
        verifyExistsNickname(request);

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        memberRepository.save(member);

        return PostMember.Response.fromEntity(member);
    }

    private void verifyExistsEmail(PostMember.Request request) {
        memberRepository.findByEmail(request.getEmail())
                .ifPresent((member -> {
                    throw new BusinessLogicException(ALREADY_EXISTS_EMAIL);
                }));
    }

    private void verifyExistsNickname(PostMember.Request request) {
        memberRepository.findByNickname(request.getNickname())
                .ifPresent((member -> {
                    throw new BusinessLogicException(ALREADY_EXISTS_NICKNAME);
                }));
    }
}
