package com.mlproject.quickLease.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "num_bed_room")
    private int numBedRoom;

    @NotNull
    @Column(name = "num_bed")
    private int numBed;

    @NotNull
    @Column(name = "num_bath_room ")
    private int numBathRoom;

    @Column(name = "room_description")
    @NotNull
    @Lob
    private String roomDescription;


    @Column(name = "cost_per_day")
    private int costPerDay;

    @ManyToOne
    @JoinColumn(name ="location_id", referencedColumnName = "id")
    private Location location;
}
