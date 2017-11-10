package com.nosipo.alfrescoclothing.factories.accessories;
import com.nosipo.alfrescoclothing.domain.accessories.Bangles;

public class BanglesFactory
{
    public static Bangles getBangles(String name, String colour, String price)
    {
        Bangles bangles = new Bangles.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return bangles;
    }
}
