package com.democde.inventryservice.repository;

import com.democde.inventryservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
