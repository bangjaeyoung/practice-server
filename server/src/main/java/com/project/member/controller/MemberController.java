package com.project.member.controller;

import com.project.member.dto.PostMember;
import com.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jaeyoung Bang
 */
@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/post")
    public PostMember.Response postMember(@Valid @RequestBody PostMember.Request request) {
        log.info("request : {}", request);

        return memberService.createMember(request);
    }
}
