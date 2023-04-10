package com.project.member.repository;

import com.project.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jaeyoung Bang
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
