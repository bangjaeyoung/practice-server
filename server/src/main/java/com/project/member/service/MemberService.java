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
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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

    public MemberResponseDto.Patch updateMember(Long memberId,
                                                MemberRequestDto.Patch request) {

        // Todo : 회원 정보 수정 시, 본인 제외한 같은 이메일이나 닉네임이 있는 경우 예외 처리
        verifyExistsEmail(request.getEmail());
        verifyExistsNickname(request.getNickname());

        Member findMember = verifyExistsMember(memberId);
        findMember.setName(request.getName());
        findMember.setEmail(request.getEmail());
        findMember.setNickname(request.getNickname());
        findMember.setPassword(request.getPassword());

        return MemberResponseDto.Patch.fromEntity(findMember);
    }

    @Transactional(readOnly = true)
    public MemberResponseDto.Get findMember(Long memberId) {
        Member findMember = verifyExistsMember(memberId);

        return MemberResponseDto.Get.fromEntity(findMember);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto.Get> findMembers() {
        return memberRepository.findAll()
                .stream().map(MemberResponseDto.Get::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public void deleteMembers() {
        memberRepository.deleteAll();
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

    private Member verifyExistsMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessLogicException(MEMBER_NOT_FOUND)
        );
    }
}
