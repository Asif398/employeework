package com.asif.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bus_stop")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //1St Bus to bus_stop
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


    //2st Stop to bus_stop
    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    //advantage of the add another column or field
    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;




}