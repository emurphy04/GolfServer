package com.golfapi.server.service;

import com.golfapi.server.model.Member;
import com.golfapi.server.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member addMember(Member member){
        return memberRepo.save(member);
    }

    public List<Member> getMembers(){
        return memberRepo.findAll();
    }

    public Optional<Member> findMemberById(int id){
        return memberRepo.findById(id);
    }

    public void deleteMember(int id){
        memberRepo.deleteById(id);
    }
}
