package org.project;

import org.junit.jupiter.api.Test;
import org.project.utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxEventsAllMethodsTest {
    @Test
    public void testValidCase1(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(2.0, 5.0));
        list.add(new Pair<>(5.0, 6.0));
        assertEquals(2, MaxEventsAllMethods.maxEvents(list));
    }

    @Test
    public void testValidCase2(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 3.0));
        list.add(new Pair<>(3.0, 3.0));
        list.add(new Pair<>(7.0, 10.0));
        assertEquals(2, MaxEventsAllMethods.maxEvents(list));
    }

    @Test
    public void testValidCase3(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 1.0));
        assertEquals(0, MaxEventsAllMethods.maxEvents(list));
    }

    @Test
    public void testInvalidCase1(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(-1.0, 0.0));
            list.add(new Pair<>(4.0, 5.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testInvalidCase2(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(2.0, 1.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testValidCase(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 2.0));
        list.add(new Pair<>(3.0, 5.0));
        assertEquals(2, MaxEventsAllMethods.maxEvents(list));
    }

    @Test
    public void testListEventsNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            MaxEventsAllMethods.maxEvents(new ArrayList<>());
        });
    }

    @Test
    public void testBothEventsOutsideDomainNegatives(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(-5.0, -4.0));
            list.add(new Pair<>(-3.0, -2.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testBothEventsOutsideDomainPositives(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(1.0, 50.0));
            list.add(new Pair<>(4.0, 60.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testBothEventsOutsideDomainWithOneEnd(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(-5.0, 3.0));
            list.add(new Pair<>(-3.0, 8.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testInvalidEvent(){
        assertThrows(IllegalArgumentException.class, () -> {
            List<Pair<Double, Double>> list = new ArrayList<>();
            list.add(new Pair<>(1.0, 2.0));
            list.add(new Pair<>(2.0, 1.0));
            list.add(new Pair<>(3.0, 5.0));
            MaxEventsAllMethods.maxEvents(list);
        });
    }

    @Test
    public void testValidCase4(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(1.0, 4.0));
        list.add(new Pair<>(2.0, 3.0));
        list.add(new Pair<>(3.0, 5.0));
        list.add(new Pair<>(6.0, 8.0));
        assertEquals(3, MaxEventsAllMethods.maxEvents(list));
    }

    @Test
    public void testValidCase5(){
        List<Pair<Double, Double>> list = new ArrayList<>();
        list.add(new Pair<>(5.0, 7.0));
        list.add(new Pair<>(1.0, 2.0));
        list.add(new Pair<>(3.0, 4.0));
        list.add(new Pair<>(6.0, 9.0));
        list.add(new Pair<>(8.0, 10.0));
        assertEquals(4, MaxEventsAllMethods.maxEvents(list));
    }
}