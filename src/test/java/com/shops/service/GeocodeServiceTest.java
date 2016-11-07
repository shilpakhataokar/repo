/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shops.service;

import com.google.maps.model.LatLng;
import com.shops.model.Address;
import com.shops.model.Shop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.util.Assert;

/**
 *
 * @author lenovo
 */
public class GeocodeServiceTest {

    private Shop shop;
    private GeocodeService instance;

    public GeocodeServiceTest() {
    }

    @Before
    public void setUp() {
        shop = new Shop();
        shop.setShopName("Central");
        Address addr = new Address();
        addr.setAddressLine1("Amanora Park Town ");
        addr.setAddressLine2("Pune");
        addr.setPostCode("411028");
        shop.setShopAddress(addr);
        instance = new GeocodeService();
        instance.init();
    }

    /**
     * Test of getGeocode method, of class GeocodeService.
     */
    @Test
    public void testGetGeocode() {
        LatLng result = instance.getGeocode(shop);
        Assert.notNull(result);
    }

    /**
     * Test of getFormattedAddress method, of class GeocodeService.
     */
    @Test
    public void testGetFormattedAddress() {
        String expResult = "Amanora Park Town ,Pune,411028";
        String result = instance.getFormattedAddress(shop);
        System.out.println(result);
        assertEquals(expResult, result);

    }

}
