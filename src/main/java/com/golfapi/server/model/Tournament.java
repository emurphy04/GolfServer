package com.golfapi.server.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tournament_id;
    private String start_date;
    private String end_date;
    private String location;
    private double entry_fee;
    private double prize;

    @ManyToMany
    @JoinTable(
            name = "tournament_members",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members = new ArrayList<>();

    public Tournament() {
    }

    public Tournament(Integer tournament_id, String start_date, String end_date, String location, double entry_fee, double prize, List<Member> members) {
        this.tournament_id = tournament_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.entry_fee = entry_fee;
        this.prize = prize;
        this.members = members;
    }

    public Integer getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(Integer tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntry_fee() {
        return entry_fee;
    }

    public void setEntry_fee(double entry_fee) {
        this.entry_fee = entry_fee;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournament_id=" + tournament_id +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", location='" + location + '\'' +
                ", entry_fee=" + entry_fee +
                ", prize=" + prize +
                ", members=" + members +
                '}';
    }
}
