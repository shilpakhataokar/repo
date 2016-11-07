/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shops.service;

import com.shops.model.Address;
import com.shops.model.Shop;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.util.Assert;

/**
 *
 * @author lenovo
 */
public class ShopServiceTest {

    private Shop shop;
    private Shop shop2;
    private GeocodeService instance;
    private ShopService service;

    public ShopServiceTest() {
    }

    @Before
    public void setUp() {
        shop = new Shop();
        shop.setShopName("Central");
        shop.setShopLatitude(73.93);
        shop.setShopLongitude(18.51);
        Address addr = new Address();
        addr.setAddressLine1("Amanora Park Town ");
        addr.setAddressLine2("Pune");
        addr.setPostCode("411028");
        shop.setShopAddress(addr);
        shop2 = new Shop();
        shop2.setShopName("Website");
        addr = new Address();
        addr.setAddressLine1("Seasons Mall");
        addr.setAddressLine2("Pune");
        addr.setPostCode("411028");
        shop2.setShopLatitude(73.80);
        shop2.setShopLongitude(18.56);
        shop2.setShopAddress(addr);
        instance = new GeocodeService();
        instance.init();
        service = new ShopServiceImpl();
    }

    /**
     * Test of add method, of class ShopService.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Shop result = service.add(shop);
        System.out.println(result.toString());
    }

    /**
     * Test of get method, of class ShopService.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        double longitude = 73.94;
        double latitude = 18.51;
        service.add(shop);
        service.add(shop2);
        Shop result = service.get(longitude, latitude);
        assertEquals(shop.getShopName(), result.getShopName());

    }

    /**
     * Test of getAll method, of class ShopService.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        service.add(shop);
        List<Shop> result = service.getAll();
        Assert.notEmpty(result);
    }

}
