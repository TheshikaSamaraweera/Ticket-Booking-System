package com.democde.inventryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    private Long id;

    @Column(name = "name" )
    private String name;

    @Column(name = "total_capacity" )
    private Long totalCapacity;

    @Column(name = "left_capacity" )
    private Long leftCapacity;

    @OneToMany
    @JoinColumn(name = "venue_id") //name of the joined column
    private Venue venue;

}
