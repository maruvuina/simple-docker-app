package com.example.project.repository;

import com.example.project.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Greeting}.
 */
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

    /**
     * Checks if Greeting exists by name.
     * @param name Greeting name
     * @return boolean
     */
    boolean existsByName(String name);
}
