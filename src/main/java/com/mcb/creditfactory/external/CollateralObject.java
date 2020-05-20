package com.mcb.creditfactory.external;

import com.mcb.creditfactory.model.Evaluation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public interface CollateralObject {
    default Evaluation getLastEvaluation() {
        Set<Evaluation> evaluations = new TreeSet<>(getAllEvaluation());

        Evaluation lastEvaluation = null;
        for (Evaluation evaluation : evaluations) {
            lastEvaluation = evaluations.stream().findFirst().get();

            if (lastEvaluation.getEvaluationDate().isBefore(evaluation.getEvaluationDate())) {
                lastEvaluation = evaluation;
            }
        }
            return lastEvaluation;
        }

        Set<Evaluation> getAllEvaluation ();
        Short getYear ();
        LocalDate getDate ();
        CollateralType getType ();

    }
