package com.shops.controller;

import com.google.maps.model.LatLng;
import com.shops.model.Shop;
import com.shops.service.GeocodeService;
import com.shops.service.ShopService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shilpa on 04/11/2016.
 * This is a Controller for all REST Endpoints 
 */
@RestController
public class ShopsNearbyController {

    @Autowired
    @Qualifier("geocodeService")
    private GeocodeService geocodeService;

    @Autowired
    @Qualifier("shopService")
    private ShopService shopService;

    @PostConstruct
    public void init() {

    }

    /**
     * REST endpoint for adding a shop
     *
     * @param shop
     * @return
     */
    @RequestMapping(path = "/shop", method = RequestMethod.POST)
    public Shop add(@RequestBody Shop shop) {

        LatLng latLng = geocodeService.getGeocode(shop);
        System.out.println(latLng.lat + " , " + latLng.lng);
        shop.setShopLatitude(latLng.lat);
        shop.setShopLongitude(latLng.lng);

        shop = shopService.add(shop);
        return shop;
    }

    /**
     * REST endpoint to find the nearest shop from a location marked with
     * latitude and longitude
     *
     * @param latitude, the latitude of the customer
     * @param longitude, the longitude of the customer
     * @return the nearest shop
     */
    @RequestMapping(path = "/shop/{latitude}/{longitude}", method = RequestMethod.GET)
    public Shop get(@PathVariable double latitude, @PathVariable double longitude) {
        Shop shop = shopService.get(latitude, longitude);
        return shop;
    }

    /**
     * REST endpoint for getting all the shops
     *
     * @return
     */
    @RequestMapping(path = "    ", method = RequestMethod.GET)
    public List<Shop> getAll() {
        List<Shop> shops = shopService.getAll();
        return shops;
    }

}
