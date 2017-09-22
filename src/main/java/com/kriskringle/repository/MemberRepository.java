package com.kriskringle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kriskringle.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
