package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Evaluation;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {

    private CarDto car;

    @Override
    public Set<Evaluation> getAllEvaluation() {
        return car.getEvaluations();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        return getLastEvaluation().getEvaluationDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
