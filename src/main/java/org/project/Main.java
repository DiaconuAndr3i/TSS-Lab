package org.project;

import org.project.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pair<Double, Double>> events = new ArrayList<>();
        events.add(new Pair<>(1.0, 3.0));
        events.add(new Pair<>(2.0, 5.0));
        events.add(new Pair<>(7.0, 7.0));
        events.add(new Pair<>(6.0, 8.0));
        events.add(new Pair<>(8.0, 10.0));
        events.add(new Pair<>(1.0, 1.0));

        System.out.println("Numărul maxim de evenimente care pot avea loc: " + MaxEventsEquivalencePartitioning.maxEvents(events));
        System.out.println("Numărul maxim de evenimente care pot avea loc: " + MaxEvents.maxEvents(events));
    }
}