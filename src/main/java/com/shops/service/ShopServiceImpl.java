package com.shops.service;

import com.google.maps.model.LatLng;
import com.shops.model.Shop;
import com.shops.util.Utility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shilpa Service implementation the add a Shop , Get
 */
public class ShopServiceImpl implements ShopService {

    /**
     * the list for storing data
     */
    final List<Shop> shopList = new ArrayList<>();

    /**
     * register a shop
     */
    @Override
    public Shop add(Shop shop) {
        shopList.add(shop);
        return shop;
    }

    /**
     * get the shop nearest to a geocode
     */
    @Override
    public Shop get(double latitude, double longitude) {
        LatLng geocode = new LatLng(latitude, longitude);
        Shop shop = findNearest(geocode);
        return shop;
    }

    /**
     * get all the registered shops
     */
    @Override
    public List<Shop> getAll() {
        return shopList;
    }

    /**
     * Find the shop nearest to this geocode
     *
     * @param geocode
     * @return
     */
    public Shop findNearest(LatLng geocode) {
        // customer latitude and longitude
        double lat1 = geocode.lat;
        double lon1 = geocode.lng;
        // hold the nearest distance found till now
        double nearestDist = -1;
        // hold the reference to the nearest shop found till now
        Shop nearestShop = null;
        for (Shop shop : shopList) {
            // latitude and longitude of the shop to compare
            double lat2 = shop.getShopLatitude();
            double lon2 = shop.getShopLongitude();
            // distance to the shop in comparison
            double dist = Utility.calculateDistance(lat1, lon1, lat2, lon2);
            // if the shop in comparison is nearer than the previous shop or if
            // it is the first shop
            if (dist < nearestDist || nearestDist == -1) {
                nearestShop = shop;
                nearestDist = dist;
            }
        }
        return nearestShop;
    }

}
