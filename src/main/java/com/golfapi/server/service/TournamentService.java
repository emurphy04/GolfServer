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

    public Optional<Tournament> getTournamentByLocation(String location) {
        List<Tournament> tournaments = tournamentRepo.findAll();
        String location_parsed = location.replace("-", " ");
        for (Tournament tournament : tournaments) {
            if (tournament.getLocation().equalsIgnoreCase(location_parsed)){
                return Optional.of(tournament);
            }
        }
        return Optional.empty();
    }

    public Optional<Tournament> getTournamentByDate(String date) {
        List<Tournament> tournaments = tournamentRepo.findAll();
        for (Tournament tournament : tournaments) {
            if (tournament.getStart_date().equals(date)){
                return Optional.of(tournament);
            }
        }
        return Optional.empty();
    }
}
