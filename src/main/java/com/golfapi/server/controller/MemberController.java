package com.golfapi.server.controller;

import com.golfapi.server.model.Member;
import com.golfapi.server.repository.MemberRepo;
import com.golfapi.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getMembers();
    }

    @PostMapping("/members")
    public void addMember(@RequestBody Member member){
        memberService.addMember(member);
    }

    @DeleteMapping("/members/{id}")
    public void delMember(@PathVariable int id){
        memberService.deleteMember(id);
    }

    @PutMapping("/members/{id}")
    public void updateMember(@PathVariable int id, @RequestBody Map<String, String> body){
        Member currentMember = memberService.findMemberById(id).get();
        currentMember.setAddress(body.get("address"));
        currentMember.setEmail(body.get("email"));
        currentMember.setName(body.get("name"));
        currentMember.setPhone(body.get("phone"));
        currentMember.setStart_date(body.get("start_date"));
        memberService.addMember(currentMember);
    }
}
