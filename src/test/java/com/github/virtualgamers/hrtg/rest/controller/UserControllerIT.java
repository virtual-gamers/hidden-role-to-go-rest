package com.github.virtualgamers.hrtg.rest.controller;

import static org.junit.Assert.assertEquals;
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
import com.github.virtualgamers.hrtg.core.repository.UserRepository;
import com.github.virtualgamers.hrtg.core.service.PartyService;
import com.github.virtualgamers.hrtg.rest.HiddenRoleToGoRestApplication;
import com.github.virtualgamers.hrtg.rest.controller.core.UserController;

@SpringBootTest(classes = HiddenRoleToGoRestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartyService partyService;

    String USERNAME = "USERNAME";
    String PARTY_ID = "PARTY_ID";

    /**
     * Testing api for {@link UserController#getUser(String, String)}
     * <p>
     * URL: user/getUser/{partyId}/{username}
     */
    @Test
    public void getByUser() {
        // setup
        final Party party = partyService.startParty(USERNAME);
        final User expectedUser = userRepository.save(new User(party.getId(), USERNAME));
        final String url = createURLWithPort("/user/getUser/" + party.getId() + "/" + USERNAME);

        // expected
        final ResponseEntity<User> response =
                restTemplate.exchange(url, HttpMethod.GET, null, User.class);
        final User actualUser = response.getBody();

        // verify
        assertEquals(expectedUser.getPartyId(), actualUser.getPartyId());
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.toString(), actualUser.toString());

        // clean up
        userRepository.deleteById(
                new User(expectedUser.getPartyId(), expectedUser.getUsername()).getId());
    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + port + uri;
    }
}
