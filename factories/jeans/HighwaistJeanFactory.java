package com.nosipo.alfrescoclothing.factories.jeans;
import com.nosipo.alfrescoclothing.domain.jeans.HighwaistJean;

public class HighwaistJeanFactory
{
    public static HighwaistJean getHighwaistJean(String name, String colour, String price)
    {
        HighwaistJean highwaistJean = new HighwaistJean.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return highwaistJean;
    }
}
