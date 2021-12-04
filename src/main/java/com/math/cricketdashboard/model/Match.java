package com.math.cricketdashboard.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Match {

    private Long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String MatchWinner;
    private String result;
    private String resultMargin;
    private String umpire1;
    private String umpire2;

}
