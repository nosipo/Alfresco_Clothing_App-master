package com.nosipo.alfrescoclothing.factories.accessories;
import com.nosipo.alfrescoclothing.domain.accessories.Scarves;

public class ScarvesFactory
{
    public static Scarves getScarves(String name, String colour, String price)
    {
        Scarves scarves = new Scarves.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return scarves;
    }
}
