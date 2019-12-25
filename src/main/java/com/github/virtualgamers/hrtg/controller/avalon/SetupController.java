package com.github.virtualgamers.hrtg.controller.avalon;

import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.model.avalon.Player;
import com.github.virtualgamers.hrtg.service.avalon.SetUpService;

@RestController("/avalon/setup/")
public class SetupController {
    SetUpService setUpService;

    public SetupController(final SetUpService setUpService) {
        if (setUpService == null) {
            throw new IllegalStateException("SetUpService cannot be null");
        }
        this.setUpService = setUpService;
    }

    @GetMapping("/initGame/{partyId}")
    public void initGame(@PathParam("partyId") final String partyId) {
        setUpService.initGame(partyId);
    }

    @GetMapping("/assignBoard/{gameId}/{board}")
    public void assignBoard(@PathParam("gameId") final String gameId,
            @PathParam("board") final String board) {
        setUpService.assignBoard(gameId, board);
    }

    @GetMapping("{@gameId}/assignCrown")
    public void assignCrown(@PathParam("gameId") final String gameId,
            @RequestBody final Player player) {
        setUpService.assignCrown(gameId, player);
    }

    @GetMapping("{gameId}/assignLadyOfTheLake")
    public void assignLadyOfTheLake(@PathParam("gameId") final String gameId,
            @RequestBody final Player player) {
        setUpService.assignLadyOfTheLake(gameId, player);
    }

    @GetMapping("{@gameId}/assignQuestLakeOccurs/{quests}")
    public void assignQuestLakeOccurs(@PathParam("gameId") final String gameId,
            @RequestBody final int[] quests) {
        setUpService.assignQuestLakeOccurs(gameId, quests);
    }

    @GetMapping("{@gameId}/assignQuestsLancelotFlips/{quests}")
    public void assignQuestsLancelotFlips(@PathParam("gameId") final String gameId,
            @RequestBody final int[] quests) {
        setUpService.assignQuestsLancelotFlips(gameId, quests);
    }

    @GetMapping("{@gameId}/dealRoles/")
    public void dealRoles(@PathParam("gameId") final String gameId,
            @RequestBody final String[] roles,
            @RequestParam("performNightPhase") final boolean performNightPhase) {
        setUpService.dealRoles(gameId, roles, performNightPhase);
    }

    @GetMapping("{@gameId}/performNightPhase")
    public void performNightPhase(@PathParam("gameId") final String gameId) {
        setUpService.performNightPhase(gameId);
    }

    @GetMapping("{@gameId}/turnOrder/{userIds}")
    public void setTurnOrder(@PathParam("gameId") final String gameId,
            @PathParam("userIds") final String[] userIds) {
        setUpService.setTurnOrder(gameId, userIds);
    }
}
