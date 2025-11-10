package bgsm.bangalore.dailyActivityTrack.service;

import bgsm.bangalore.dailyActivityTrack.entity.People;
import bgsm.bangalore.dailyActivityTrack.model.PeopleDto;
import bgsm.bangalore.dailyActivityTrack.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    public Optional<People> getPeopleByEmail(String email) {
       return peopleRepository.getPeopleByEmail(email);
    }

    public String createUser(PeopleDto peopleDto) {
        People people = new People();
        people.setName(peopleDto.getFirstName() + " " + peopleDto.getLastName());
        people.setEmail(peopleDto.getEmail());
        people.setPhone(peopleDto.getPhone());
        people.setMemberType("member");
        people.setProfileStatus("Active");
        People savedPeople = peopleRepository.save(people);
        return savedPeople.getEmail();
    }
}
