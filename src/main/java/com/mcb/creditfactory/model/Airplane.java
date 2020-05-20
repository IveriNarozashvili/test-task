package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@ToString(of = {"id", "brand", "model", "manufacturer", "year", "fuelCapacity", "seats", "evaluations"})
@EqualsAndHashCode(of = {"id", "brand", "model", "manufacturer", "year", "fuelCapacity", "seats", "evaluations"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;

    private int fuelCapacity;
    private int seats;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Evaluation> evaluations;
}
