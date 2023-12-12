package org.project;

import org.junit.jupiter.api.Test;
import org.project.utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxEventsCauseEventGraphingTest {
    @Test
    public void testInvalidCase(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(2.0, 1.0));
            MaxEventsCauseEffectGraphing.maxEvents(list);
        });
    }

    @Test
    public void testValidCase(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 2.0));
        list.add(new Pair<>(3.0, 5.0));
        assertEquals(2, MaxEventsCauseEffectGraphing.maxEvents(list));
    }
}