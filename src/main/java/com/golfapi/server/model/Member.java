package com.golfapi.server.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private String start_date;

    @Transient
    private Long membership_duration;

    public Member() {
    }

    public Member(Integer member_id, String name, String address, String email, String phone, String start_date) {
        this.member_id = member_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.start_date = start_date;
    }

    public String getMembership_duration() {
        if (start_date == null) {
            return "Unknown duration";
        }

        LocalDate now = LocalDate.now();
        Period period = Period.between(LocalDate.parse(start_date), now);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        StringBuilder duration = new StringBuilder();

        if (years > 0) {
            duration.append(years).append(" year");
            if (years > 1) {
                duration.append("s");
            }
        }

        if (months > 0) {
            if (duration.length() > 0) {
                duration.append(", ");
            }
            duration.append(months).append(" month");
            if (months > 1) {
                duration.append("s");
            }
        }

        if (days > 0) {
            if (duration.length() > 0) {
                duration.append(", ");
            }
            duration.append(days).append(" day");
            if (days > 1) {
                duration.append("s");
            }
        }

        return duration.toString();
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
