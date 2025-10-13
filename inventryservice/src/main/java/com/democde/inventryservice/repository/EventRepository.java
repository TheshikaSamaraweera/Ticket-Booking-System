package com.democde.inventryservice.repository;

import com.democde.inventryservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long> {
}
