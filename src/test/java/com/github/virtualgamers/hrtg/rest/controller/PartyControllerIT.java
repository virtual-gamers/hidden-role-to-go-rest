package com.github.virtualgamers.hrtg.rest.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.github.virtualgamers.hrtg.core.model.Party;
import com.github.virtualgamers.hrtg.core.model.User;
import com.github.virtualgamers.hrtg.core.repository.PartyRepository;
import com.github.virtualgamers.hrtg.core.repository.UserRepository;
import com.github.virtualgamers.hrtg.core.service.PartyService;
import com.github.virtualgamers.hrtg.core.service.UserService;
import com.github.virtualgamers.hrtg.rest.HiddenRoleToGoRestApplication;

/**
 * Test api calls under the following url <br>
 * URL: /party
 *
 * @author ccthom94
 *
 */
@SpringBootTest(classes = HiddenRoleToGoRestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartyControllerIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartyService partyService;

    @Autowired
    UserService userService;

    final String USERNAME_1 = "USERNAME_1";
    final String USERNAME_2 = "USERNAME_2";


    /**
     * URL: /addToParty/{partyId}/{username}
     */
    @Test
    public void addToParty() {
        // setup
        final Party party = partyService.startParty(USERNAME_1);
        final String partyId = party.getId();
        final String url = createURLWithPort("/party/addToParty/" + partyId + "/" + USERNAME_2);

        // pre-verify
        final Party partyPreTest = partyService.getParty(partyId);
        assertEquals(partyId, partyPreTest.getId());
        final List<User> usersPreTest = partyPreTest.getUsers();
        assertEquals(1, usersPreTest.size());

        // execute
        final ResponseEntity<User> response = restTemplate.exchange( //
                url, // url the URL
                HttpMethod.POST, // method the HTTP method (GET, POST, etc)
                null, // requestEntity the entity (headers and/or body) to write to the request
                User.class);

        final User actualUser2 = response.getBody();

        // verify
        final User expectedUser2 = userService.getUser(partyId, USERNAME_2);
        assertEquals(expectedUser2.toString(), actualUser2.toString());
        final Party partyPostTest = partyService.getParty(partyId);
        assertEquals(partyId, partyPostTest.getId());
        final List<User> usersPostTest = partyPostTest.getUsers();
        assertEquals(2, usersPostTest.size());

        // clean up
        partyRepository.deleteById(partyId);
    }

    /**
     * URL: /getParty/{partyId}
     */
    @Test
    public void getParty() {

    }

    /**
     * URL: /startParty/{username}
     */
    @Test
    public void startParty() {

    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + port + uri;
    }
}
