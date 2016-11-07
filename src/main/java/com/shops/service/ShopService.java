package com.shops.service;

import com.shops.model.Shop;
import java.util.List;

/**
 * Created by Shilpa Khataokar on 04/11/2016.
 * Service interface
 */
public interface ShopService {

    public Shop add(Shop shop);

    public Shop get(double latitude, double longitude);

    public List<Shop> getAll();

}
