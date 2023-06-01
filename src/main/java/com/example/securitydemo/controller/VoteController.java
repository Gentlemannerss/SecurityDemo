package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VoteController {

    private final Map<String, Integer> partyVoteCounts = new HashMap<>();

    @PostMapping("/addVote") //Vote was al genoeg door de @Post
    public String addVote(@RequestParam String vote) {
        partyVoteCounts.merge(vote, 1, Integer::sum);
        return "Vote added successfully";
    }

    @GetMapping("/getVotes") //Votes was al genoeg, geen werkwoorden.
    public Map<String, Integer> getVotes() {
        return partyVoteCounts;
    }
}