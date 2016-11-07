/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shops.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class UtilityTest {

    public UtilityTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of haversine method, of class Utility.
     */
    @Test
    public void testHaversine() {
        System.out.println("haversine");
        double lat1 = 73.80;
        double lon1 = 18.56;
        double lat2 = 73.93;
        double lon2 = 18.51;
        double expResult = 14.537676549165168;
        double result = Utility.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 0.0);
    }

}
