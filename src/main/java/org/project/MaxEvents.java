package org.project;

import org.project.utils.Pair;

import java.util.List;
import java.util.Objects;

public class MaxEvents {
    public static Integer maxEvents(List<Pair<Double, Double>> events) {

        if(events.size() == 0)
            throw new IllegalArgumentException("EROARE DATE DE INPUT");

        for (Pair<Double, Double> pair : events) {
            if (pair.getKey() < 0 || pair.getKey() > 23 ||
                    pair.getValue() < 0 || pair.getValue() > 23 ||
                    pair.getValue() % 1 != 0 || pair.getKey() % 1 != 0 ||
                    pair.getValue() < pair.getKey()) {

                throw new IllegalArgumentException("EROARE DATE DE INPUT");
            }
        }

        int n = events.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (events.get(j).getValue() > events.get(j+1).getValue()) {
                    Pair<Double, Double> temp = events.get(j);
                    events.set(j, events.get(j+1));
                    events.set(j+1, temp);
                }
            }
        }

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
