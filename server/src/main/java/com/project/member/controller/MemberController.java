package com.project.member.controller;

import com.project.member.dto.MemberRequestDto;
import com.project.member.dto.MemberResponseDto;
import com.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author Jaeyoung Bang
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/post")
    public MemberResponseDto.Post postMember(@Valid @RequestBody MemberRequestDto.Post request) {
        log.info("request : {}", request);

        return memberService.createMember(request);
    }

    @GetMapping("/{member-id}")
    public MemberResponseDto.Get getMember(@PathVariable("member-id") @Positive Long memberId) {
        return memberService.findMember(memberId);
    }

    @GetMapping
    public List<MemberResponseDto.Get> getMembers() {
        return memberService.findMembers();
    }
}
