/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shops.controller;

import com.shops.ShopsNearbyBootApplication;
import com.shops.model.Address;
import com.shops.model.Shop;
import com.shops.service.GeocodeService;
import com.shops.service.ShopService;
import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author lenovo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShopsNearbyBootApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=12345"})
public class ShopsNearbyControllerTest {

    private RestTemplate restTemplate;
    private URL url;

    @Before
    public void setUp() throws Exception {
        this.url = new URL("http://localhost:" + 12345 + "/shop");
        restTemplate = new TestRestTemplate();
    }

    @InjectMocks
    ShopsNearbyController instance = new ShopsNearbyController();
    @Mock
    private GeocodeService geocodeService;
    @Mock
    private ShopService shopService;

    public ShopsNearbyControllerTest() {
    }

    @Test
    public void updateShop() throws Exception {
        Shop shop = new Shop();
        shop.setShopName("Grocery Store");
        Address address = new Address();
        address.setNumber("1600");
        address.setAddressLine1("Amphitheatre Parkway");
        address.setAddressLine2("Mountain View, CA");
        address.setPostCode("94043");
        shop.setShopAddress(address);

        ResponseEntity response = restTemplate.postForEntity(url.toString(), shop, null);

        org.junit.Assert.assertEquals("The Post request should  be successful.", HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test of add method, of class ShopsNearbyController.
     */
    @Test
    public void testAdd() {
        Shop shop = new Shop();
        shop.setShopName("Central");
        Address addr = new Address();
        addr.setAddressLine1("Amanora Park Town ");
        addr.setAddressLine2("Pune");
        addr.setPostCode("411028");
        shop.setShopAddress(addr);
        ResponseEntity response = restTemplate.postForEntity(url.toString(), shop, null);
        Assert.assertEquals("Post request is successfull !! ", HttpStatus.OK, response.getStatusCode());

    }

    /**
     * Test of get method, of class ShopsNearbyController.
     */
    @Test
    public void testGet() throws MalformedURLException {
        System.out.println("get");
        this.url = new URL("http://localhost:" + 12345 + "/shop/{latitude}/{longitude}");
        Object[] urlVariables = new Object[]{73.93989630, 73.93989630};
        ResponseEntity<Shop> response = restTemplate.getForEntity(url.toString(), Shop.class, urlVariables);
        Assert.assertNotNull("Should return a Shop with name.", response.getBody().getShopName());
        Assert.assertEquals("Get request is successfull !! ", HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test of getAll method, of class ShopsNearbyController.
     */
    @Test
    public void testGetAll() throws MalformedURLException {
        System.out.println("getAll");
        this.url = new URL("http://localhost:" + 12345 + "/allshops");
        //  restTemplate.getForObject(url.toString(), List.class);

    }

}
