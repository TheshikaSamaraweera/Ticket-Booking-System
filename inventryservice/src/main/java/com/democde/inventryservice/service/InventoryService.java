package com.democde.inventryservice.service;

import com.democde.inventryservice.entity.Event;
import com.democde.inventryservice.entity.Venue;
import com.democde.inventryservice.repository.EventRepository;
import com.democde.inventryservice.repository.VenueRepository;
import com.democde.inventryservice.response.EventInventoryResponse;
import com.democde.inventryservice.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InventoryService {


    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public InventoryService(final EventRepository eventRepository, final VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }



    public List<EventInventoryResponse> getAllEvents() {
        final List<Event> events = eventRepository.findAll();

        return events.stream().map(event -> EventInventoryResponse.builder()
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(String.valueOf(event.getVenue()))
                .build()).collect(Collectors.toList());
    }

    public VenueInventoryResponse getVenueInformation(final Long venueId) {
            final Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));

            return VenueInventoryResponse.builder()
                    .venuId(venue.getId())
                    .venueName(venue.getName())
                    .totalCapacity(venue.getTotalCapacity())
                    .build();
    }
}
