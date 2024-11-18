package com.golfapi.server.controller;

import com.golfapi.server.model.Member;
import com.golfapi.server.model.Tournament;
import com.golfapi.server.service.MemberService;
import com.golfapi.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TournamentController {

    private final TournamentService tournamentService;
    private final MemberService memberService;

    @Autowired
    public TournamentController(TournamentService tournamentService, MemberService memberService) {
        this.tournamentService = tournamentService;
        this.memberService = memberService;
    }

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getTournaments();
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/tournaments")
    public void addTournament(@RequestBody Map<String, Object> tournamentMembers, Tournament tournament){
        List<Integer> member_ids = (List<Integer>) tournamentMembers.get("members");
        List<Member> members = new ArrayList<>();
        for (Integer memberId : member_ids) {
            members.add(memberService.findMemberById(memberId).get());
        }
        tournament.setMembers(members);

        tournament.setStart_date((String) tournamentMembers.get("start_date"));
        tournament.setEnd_date((String) tournamentMembers.get("end_date"));
        tournament.setEntry_fee(Double.parseDouble((String) tournamentMembers.get("entry_fee")));
        tournament.setPrize(Double.parseDouble((String) tournamentMembers.get("prize")));
        tournament.setLocation((String) tournamentMembers.get("location"));
        tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/tournaments/{id}")
    public void delTournament(@PathVariable int id){
        tournamentService.deleteTournament(id);
    }

    @SuppressWarnings("unchecked")
    @PutMapping("/tournaments/{id}")
    public void updateTournament(@PathVariable int id, @RequestBody Map<String, String> body, @RequestBody Map<String, Object> tournamentMembers){
        Tournament currentTournament = tournamentService.findTournamentById(id).get();
        List<Integer> member_ids = (List<Integer>) tournamentMembers.get("members");
        List<Member> members = new ArrayList<>();
        for (Integer memberId : member_ids) {
            members.add(memberService.findMemberById(memberId).get());
        }
        currentTournament.setMembers(members);
        currentTournament.setEnd_date(body.get("end_date"));
        currentTournament.setLocation(body.get("location"));
        currentTournament.setPrize(Double.parseDouble(body.get("prize")));
        currentTournament.setEntry_fee(Double.parseDouble(body.get("entry_fee")));
        currentTournament.setStart_date(body.get("start_date"));
        tournamentService.addTournament(currentTournament);
    }
}
