package com.github.virtualgamers.hrtg.service.avalon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.model.AbstractUser;
import com.github.virtualgamers.hrtg.model.Party;
import com.github.virtualgamers.hrtg.model.avalon.Avalon;
import com.github.virtualgamers.hrtg.model.avalon.Board;
import com.github.virtualgamers.hrtg.model.avalon.KnowledgeRole;
import com.github.virtualgamers.hrtg.model.avalon.KnowledgeUser;
import com.github.virtualgamers.hrtg.model.avalon.Player;
import com.github.virtualgamers.hrtg.model.avalon.Role;
import com.github.virtualgamers.hrtg.repository.PartyRepository;
import com.github.virtualgamers.hrtg.repository.UserRepository;
import com.github.virtualgamers.hrtg.repository.avalon.AvalonRepository;
import com.github.virtualgamers.hrtg.repository.avalon.PlayerRepository;

@Component
@Primary
public class SetUpServiceImpl implements SetUpService {
    PartyRepository partyRepository;
    PlayerRepository playerRepository;
    AvalonRepository avalonRepository;
    UserRepository userRepository;

    public SetUpServiceImpl(final PartyRepository partyRepository,
            final PlayerRepository playerRepository, final AvalonRepository avalonRepository,
            final UserRepository userRepository) {
        if (partyRepository == null) {
            throw new IllegalStateException("PartyRepository cannot be null");
        }
        if (playerRepository == null) {
            throw new IllegalStateException("PlayerRepository cannot be null");
        }
        if (avalonRepository == null) {
            throw new IllegalStateException("PartyRepository cannot be null");
        }
        if (userRepository == null) {
            throw new IllegalStateException("UserRepository cannot be null");
        }
        this.partyRepository = partyRepository;
        this.avalonRepository = avalonRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initGame(final String partyId) {
        final Optional<Party> optional = partyRepository.findById(partyId);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("No Party exists for partyId=" + partyId);
        }
        final Party party = optional.get();
        // party.setGame(new Avalon(party));

        final List<AbstractUser> users = party.getUsers();
        final LinkedList<AbstractUser> players = users.stream() //
                .map(user -> new Player(user)) //
                .collect(Collectors.toCollection(LinkedList::new));
        party.setUsers(players);
        partyRepository.save(party);
    }

    @Override
    public void assignBoard(final String gameId, final String board) {
        final Avalon avalon = getAvalon(gameId);
        final Board boardEnum = Board.valueOf(board);
        if (boardEnum == null) {
            throw new IllegalArgumentException("Board does not exists. board=" + board);
        }
        avalon.setBoard(boardEnum);
        avalonRepository.save(avalon);
    }

    @Override
    public void assignCrown(final String gameId, final Player player) {
        final Avalon avalon = getAvalon(gameId);
        avalon.setCurrentCrown(player);
        avalonRepository.save(avalon);
    }

    @Override
    public void assignLadyOfTheLake(final String gameId, final Player player) {
        final Avalon avalon = getAvalon(gameId);
        avalon.setCurrentLake(player);
        avalonRepository.save(avalon);
    }

    @Override
    public void assignQuestLakeOccurs(final String gameId, final int[] quests) {
        final Avalon avalon = getAvalon(gameId);
        avalon.setQuestsLakeOccurs(quests);
        avalonRepository.save(avalon);
    }

    @Override
    public void assignQuestsLancelotFlips(final String gameId, final int[] quests) {
        final Avalon avalon = getAvalon(gameId);
        avalon.setQuestsLancelotFlips(quests);
        avalonRepository.save(avalon);
    }

    @Override
    public void dealRoles(final String gameId, final String[] roles,
            final boolean performNightPhase) {
        final Avalon avalon = getAvalon(gameId);
        final List<AbstractUser> users = null; // avalon.getParty().getUsers();
        final List<Player> players =
                users.stream().map(user -> (Player) user).collect(Collectors.toList());
        if (players.size() != roles.length) {
            throw new IllegalStateException("Number of Players(" + players.size()
                    + ") does not match the Number of Roles(" + roles.length //
                    + "). " //
                    + "players=" + players.stream() //
                            .map(player -> player.toString()) //
                            .collect(Collectors.joining(", "))
                    + ", " //
                    + "roles="
                    + Arrays.stream(roles).map(role -> role).collect(Collectors.joining(", ")));
        }
        final List<Role> suffledRoles =
                Arrays.stream(roles).map(role -> Role.valueOf(role)).collect(Collectors.toList());

        Collections.shuffle(suffledRoles);
        Collections.shuffle(players);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setRole(suffledRoles.get(i));
        }
        avalonRepository.save(avalon);
        if (performNightPhase) {
            performNightPhase(gameId);
        }
    }

    @Override
    public void performNightPhase(final String gameId) {
        final Party party = null; // getAvalon(gameId).getParty();
        final List<Player> players = party.getUsers() //
                .stream().map(user -> (Player) user).collect(Collectors.toList());
        final Map<Role, List<Player>> roleToPlayers = new HashMap<>();
        for (final Player player : players) {
            if (!roleToPlayers.containsKey(player.getRole())) {
                roleToPlayers.put(player.getRole(), new ArrayList<Player>());
            }
            roleToPlayers.get(player.getRole()).add(player);
        }

        for (final Player player : players) {
            final List<KnowledgeUser> knowledgeUsers = new ArrayList<>();
            final List<KnowledgeRole> roleKnowledges = player.getRole().getRoleKnowledge();
            for (final KnowledgeRole roleKnowledge : roleKnowledges) {
                final List<Player> ps = roleToPlayers.get(roleKnowledge.getRole());
                for (final Player p : ps) {
                    knowledgeUsers.add(new KnowledgeUser(roleKnowledge, p.getUsername()));
                }
            }
            player.setKnowledgeUser(knowledgeUsers);
        }
        partyRepository.save(party);
    }

    @Override
    public void setTurnOrder(final String gameId, final String[] userIds) {
        final Party party = null; // getAvalon(gameId).getParty();
        final List<Player> players = party.getUsers() //
                .stream().map(user -> (Player) user).collect(Collectors.toList());
        final Player[] playerArray = new Player[userIds.length];
        for (final Player player : players) {
            for (int i = 0; i < userIds.length; i++) {
                if (player.getUsername().equals(userIds[i])) {
                    playerArray[i] = player;
                }
            }
        }
        final List<Player> ordered = new LinkedList<>();
        for (final Player p : playerArray) {
            ordered.add(p);
        }
    }

    private Avalon getAvalon(final String gameId) {
        final Optional<Avalon> optional = avalonRepository.findById(gameId);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("No Game exists for gameId=" + gameId);
        }
        return optional.get();
    }
}
