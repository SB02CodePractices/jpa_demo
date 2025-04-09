package com.sb02.jpa_demo.controller;

import com.sb02.jpa_demo.entity.Member;
import com.sb02.jpa_demo.service.MemberDto;
import com.sb02.jpa_demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Long memberId) {
        MemberDto member = memberService.getMember(memberId);
        return ResponseEntity.ok(member);
    }
}
