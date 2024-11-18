package com.golfapi.server.repository;

import com.golfapi.server.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Integer> {
}
