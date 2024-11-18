package com.golfapi.server.controller;

import com.golfapi.server.model.Member;
import com.golfapi.server.model.Tournament;
import com.golfapi.server.service.MemberService;
import com.golfapi.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/tournaments/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable int id){
        return tournamentService.findTournamentById(id);
    }

    @GetMapping("/tournaments/location/{location}")
    public Optional<Tournament> getTournamentByLocation(@PathVariable String location){
        return tournamentService.getTournamentByLocation(location);
    }

    @GetMapping("/tournaments/date/{date}")
    public Optional<Tournament> getTournamentByDate(@PathVariable String date){
        return tournamentService.getTournamentByDate(date);
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
    public void updateTournament(@PathVariable int id, @RequestBody Map<String, Object> body){
        Tournament currentTournament = tournamentService.findTournamentById(id).get();
        List<Integer> member_ids = (List<Integer>) body.get("members");
        List<Member> members = new ArrayList<>();
        for (Integer memberId : member_ids) {
            members.add(memberService.findMemberById(memberId).get());
        }
        currentTournament.setMembers(members);
        currentTournament.setEnd_date((String) body.get("end_date"));
        currentTournament.setLocation((String) body.get("location"));
        currentTournament.setPrize(Double.parseDouble((String) body.get("prize")));
        currentTournament.setEntry_fee(Double.parseDouble((String) body.get("entry_fee")));
        currentTournament.setStart_date((String) body.get("start_date"));
        tournamentService.addTournament(currentTournament);
    }
}
