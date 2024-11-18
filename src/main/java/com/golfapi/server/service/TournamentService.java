package com.golfapi.server.service;

import com.golfapi.server.model.Member;
import com.golfapi.server.model.Tournament;
import com.golfapi.server.repository.MemberRepo;
import com.golfapi.server.repository.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepo tournamentRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    public Tournament addTournament(Tournament tournament){
        return tournamentRepo.save(tournament);
    }

    public List<Tournament> getTournaments(){
        return tournamentRepo.findAll();
    }

    public Optional<Tournament> findTournamentById(int id){
        return tournamentRepo.findById(id);
    }

    public void deleteTournament(int id){
        tournamentRepo.deleteById(id);
    }
}
