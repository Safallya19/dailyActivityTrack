package bgsm.bangalore.dailyActivityTrack.repo;

import bgsm.bangalore.dailyActivityTrack.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing People entities.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("SELECT p FROM People p WHERE p.email = :email")
    Optional<People> getPeopleByEmail(@Param("email") String email);
}
