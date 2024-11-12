package com.smartbo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.member.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
