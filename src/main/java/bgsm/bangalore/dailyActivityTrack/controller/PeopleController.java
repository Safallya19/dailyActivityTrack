package bgsm.bangalore.dailyActivityTrack.controller;

import bgsm.bangalore.dailyActivityTrack.entity.People;
import bgsm.bangalore.dailyActivityTrack.model.PeopleDto;
import bgsm.bangalore.dailyActivityTrack.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static bgsm.bangalore.dailyActivityTrack.Constants.BASE_URL;

/**
 * Controller for managing people-related endpoints.
 */
@RestController
@RequestMapping(BASE_URL)
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @GetMapping("/people/info")
    public ResponseEntity<?> getUserInfo(@RequestParam("email") String email) {
       Optional<People> people = peopleService.getPeopleByEmail(email);
       System.out.print(people.get().getName());
        return people.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(null));

    }

    @PostMapping("/people")
    public ResponseEntity<?> createUser(@RequestBody PeopleDto peopleDto) {
        String mail = peopleService.createUser(peopleDto);
        if(Objects.isNull(mail)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User is created with email: " + mail);
    }

}
