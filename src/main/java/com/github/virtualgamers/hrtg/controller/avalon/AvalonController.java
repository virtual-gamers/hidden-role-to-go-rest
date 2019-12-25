package com.github.virtualgamers.hrtg.controller.avalon;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.service.avalon.AvalonService;;

@RestController("/avalon")
public class AvalonController {
    AvalonService avalonService;

    @GetMapping("/{gameId}/forceLancelotToFlip")
    @ResponseBody
    public void forceLancelotToFlip(@PathParam("gameId") final String gameId) {
        avalonService.forceLancelotToFlip(gameId);
    }

    @GetMapping("/{gameId}/lake/{usernameOfLaker}/{usernameOfLaked}")
    @ResponseBody
    public void lake(@PathParam("gameId") final String gameId,
            @PathParam("usernameOfLaker") final String usernameOfLaker,
            @PathParam("usernameOfLaked") final String usernameOfLaked) {
        avalonService.lake(gameId, usernameOfLaker, usernameOfLaked);
    }

    @GetMapping("/{gameId}/putOnQuest/{usernames}/{confirm}")
    public void putOnQuest(@PathParam("gameId") final String gameId,
            @PathParam("usernames") final String[] usernames,
            @PathParam("confirm") final boolean confirm) {
        avalonService.putOnQuest(gameId, usernames, confirm);
    }

    @GetMapping("/{gameId}/questVote/{username}/{vote}")
    @ResponseBody
    public void questVote(@PathParam("gameId") final String gameId,
            @PathParam("username") final String username,
            @PathParam("vote") final boolean approvedQuest) {
        avalonService.questVote(gameId, username, approvedQuest);
    }

    @GetMapping("/{gameId}/questAction/{username}/{action}")
    @ResponseBody
    public void questAction(@PathParam("gameId") final String gameId,
            @PathParam("username") final String username,
            @PathParam("vote") final boolean succeededQuest) {
        avalonService.questAction(gameId, username, succeededQuest);
    }
}
