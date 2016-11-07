package com.shops;

import com.shops.service.GeocodeService;
import com.shops.service.ShopService;
import com.shops.service.ShopServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Created by Shilpa Khataokar on 04/11/2016.
 * This is a Spring Boot application  
 */
@SpringBootApplication
public class ShopsNearbyBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopsNearbyBootApplication.class, args);
        System.out.println("YAY you ran Your first Spring boot application");
    }

    @Bean(name = "geocodeService")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public GeocodeService getGeocodeService() {
        GeocodeService service = new GeocodeService();
        return service;
    }

    @Bean(name = "shopService")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ShopService getShopService() {
        return new ShopServiceImpl();

    }
}
