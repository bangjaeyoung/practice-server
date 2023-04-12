package com.project.member.service;

import com.project.exception.BusinessLogicException;
import com.project.member.dto.MemberRequestDto;
import com.project.member.dto.MemberResponseDto;
import com.project.member.entity.Member;
import com.project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.exception.ErrorCode.*;

/**
 * @author Jaeyoung Bang
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto.Post createMember(MemberRequestDto.Post request) {
        verifyExistsEmail(request.getEmail());
        verifyExistsNickname(request.getNickname());

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        memberRepository.save(member);

        return MemberResponseDto.Post.fromEntity(member);
    }

    @Transactional(readOnly = true)
    public MemberResponseDto.Get findMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(MEMBER_NOT_FOUND));

        return MemberResponseDto.Get.fromEntity(findMember);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto.Get> findMembers() {
        return memberRepository.findAll()
                .stream().map(MemberResponseDto.Get::fromEntity)
                .collect(Collectors.toList());
    }

    private void verifyExistsEmail(String email) {
        memberRepository.findByEmail(email)
                .ifPresent((member -> {
                    throw new BusinessLogicException(ALREADY_EXISTS_EMAIL);
                }));
    }

    private void verifyExistsNickname(String nickname) {
        memberRepository.findByNickname(nickname)
                .ifPresent((member -> {
                    throw new BusinessLogicException(ALREADY_EXISTS_NICKNAME);
                }));
    }
}
