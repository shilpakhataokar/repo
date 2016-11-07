/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shops.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.shops.model.Address;
import com.shops.model.Shop;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author shilpa
 * This Service Google Geocoding API to locate the latitude and longitude of a shop.
 */
public class GeocodeService {

    /**
     * the context
     */
    private GeoApiContext context;

    @PostConstruct
    public void init() {
        context = new GeoApiContext().setApiKey("AIzaSyAStfvIdjX8uLYghLSKYL9ZW5BHVZC2INE");
    }

    public LatLng getGeocode(Shop shop) {
        GeocodingResult[] results = null;
        LatLng geocode = null;
        try {
            results = GeocodingApi.geocode(context, getFormattedAddress(shop)).await();
            geocode = results[0].geometry.location;
        } catch (Exception ex) {
            Logger.getLogger(GeocodeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(results[0].geometry.location);
        return geocode;
    }

    String getFormattedAddress(Shop shop) {
        Address address = shop.getShopAddress();
//        if(Objects.isNull(address))
//        {
//           address = new Address("1600","94043", "Mountain View", "CA");
//        }
        StringBuffer formattedAddress = new StringBuffer();
        if (Objects.nonNull(address.getNumber())) {
            formattedAddress.append(address.getNumber()).append(",");
        }
        if (Objects.nonNull(address.getAddressLine1())) {
            formattedAddress.append(address.getAddressLine1()).append(",");
        }
        if (Objects.nonNull(address.getAddressLine2())) {
            formattedAddress.append(address.getAddressLine2()).append(",");
        }
        if (Objects.nonNull(address.getPostCode())) {
            formattedAddress.append(address.getPostCode());
        }

        return formattedAddress.toString();
    }

}
