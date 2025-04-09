package com.sb02.jpa_demo.repository;

import com.sb02.jpa_demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
