package com.github.virtualgamers.hrtg.service.avalon;

import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.model.Game;
import com.github.virtualgamers.hrtg.model.Party;
import com.github.virtualgamers.hrtg.model.avalon.Avalon;
import com.github.virtualgamers.hrtg.model.avalon.Player;

/**
 * {@link SetUpService} sets up a {@link Game} of {@link Avalon} for a {@link Party}
 *
 * @author CCThomas
 *
 */
@Component
public interface SetUpService {

    void initGame(String partyId);

    void assignBoard(String gameId, String board);

    void assignCrown(String gameId, Player player);

    void assignLadyOfTheLake(String gameId, Player player);

    void assignQuestLakeOccurs(String gameId, int[] quests);

    void assignQuestsLancelotFlips(String gameId, int[] quests);

    void dealRoles(String gameId, String[] roles, boolean performNightPhase);

    void performNightPhase(String gameId);

    void setTurnOrder(String gameId, String[] userIds);
}
