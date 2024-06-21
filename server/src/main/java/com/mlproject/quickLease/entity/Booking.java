package com.mlproject.quickLease.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @NotNull
    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    private UserEntity user;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @Column(name = "num_guest")
    private int numGuest;
}
