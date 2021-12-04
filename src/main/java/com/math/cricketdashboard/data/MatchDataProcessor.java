package com.math.cricketdashboard.data;


import com.math.cricketdashboard.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(final MatchInput matchInput) {

        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());

        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        String firstInningsTeam, secondInningsTeam;

        if("bat".equals(matchInput.getToss_decision())){

            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
            ? matchInput.getTeam2() : matchInput.getTeam1();
        } else{
            secondInningsTeam = matchInput.getToss_winner();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossWinner(match.getTossWinner());
        match.setTossDecision(match.getTossDecision());
        match.setMatchWinner(match.getMatchWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }

}
