package com.sb02.jpa_demo.service;

import com.sb02.jpa_demo.entity.Address;
import com.sb02.jpa_demo.entity.Member;
import com.sb02.jpa_demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto getMember(long memberId) {
        Member m = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
        Address firstAddress = m.getAddressHistory().stream().findFirst().orElse(null);
        if (firstAddress != null) {
            return new MemberDto(m.getId(), m.getName(), firstAddress.getStreet());
        }
        return new MemberDto(m.getId(), m.getName(), null);
    }
}
