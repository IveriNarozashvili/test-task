package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.Evaluation;
import lombok.*;

import java.util.Set;


@Data
@ToString(of = {"id", "brand", "model", "manufacturer", "year", "fuelCapacity", "seats"})
@EqualsAndHashCode(of = {"id", "brand", "model", "manufacturer", "year", "fuelCapacity", "seats"})
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufactures;
    private Short year;
    private Integer fuelCapacity;
    private Integer seats;
    private Set<Evaluation> evaluations;
    }

