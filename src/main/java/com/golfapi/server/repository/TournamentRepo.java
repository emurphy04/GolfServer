package com.golfapi.server.repository;

import com.golfapi.server.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
}
