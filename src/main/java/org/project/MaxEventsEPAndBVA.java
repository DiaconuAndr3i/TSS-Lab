package org.project;

import org.project.utils.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MaxEventsEPAndBVA {
    public static Integer maxEvents(List<Pair<Double, Double>> events) {

        if(events.size() == 0)
            throw new IllegalArgumentException("EROARE DATE DE INPUT");

        events.stream()
                .filter(pair -> pair.getKey() < 0 || pair.getKey() > 23 ||
                        pair.getValue() < 0 || pair.getValue() > 23 ||
                        pair.getValue() % 1 != 0 || pair.getKey() % 1 != 0 ||
                        pair.getValue() < pair.getKey())
                .findFirst()
                .ifPresent(pair -> {
                    throw new IllegalArgumentException("EROARE DATE DE INPUT");
                });

        events.sort(Comparator.comparingDouble(Pair::getValue));

        int count = 0;
        Double end = -1.0;

        for (Pair<Double, Double> event : events) {
            if (event.getKey() >= end && !Objects.equals(event.getKey(), event.getValue())) {
                count++;
                end = event.getValue();
            }
        }
        return count;
    }
}
