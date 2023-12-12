package org.project;

import org.junit.jupiter.api.Test;
import org.project.utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxEventsBoundaryValueAnalysisTest {
    @Test
    public void testValidCase1(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(2.0, 5.0));
        list.add(new Pair<>(5.0, 6.0));
        assertEquals(2, MaxEventsBoundaryValueAnalysis.maxEvents(list));
    }

    @Test
    public void testValidCase2(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 3.0));
        list.add(new Pair<>(3.0, 3.0));
        list.add(new Pair<>(7.0, 10.0));
        assertEquals(2, MaxEventsBoundaryValueAnalysis.maxEvents(list));
    }

    @Test
    public void testValidCase3(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 1.0));
        assertEquals(0, MaxEventsBoundaryValueAnalysis.maxEvents(list));
    }

    @Test
    public void testInvalidCase(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(-1.0, 0.0));
            list.add(new Pair<>(4.0, 5.0));
            MaxEventsBoundaryValueAnalysis.maxEvents(list);
        });
    }
}