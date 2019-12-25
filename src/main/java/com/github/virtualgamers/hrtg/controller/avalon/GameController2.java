package com.github.virtualgamers.hrtg.controller.avalon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.virtualgamers.hrtg.model.avalon.Role;

@RestController("/game")
public class GameController2 {
    @GetMapping("/players/{username}")
    @ResponseBody
    public void getPlayers(@PathParam("gameId") final String gameId) {
        // return "gameService.startParty(partyLeader, boardConfigId);";
    }

    @GetMapping("/roles")
    public List<String> getRoles() {
        return Arrays.stream(Role.values())//
                .map(role -> role.toString().toLowerCase().replace("_", " ")) //
                .collect(Collectors.toList());
    }

}
