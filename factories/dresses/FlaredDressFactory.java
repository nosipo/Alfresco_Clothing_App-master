package com.nosipo.alfrescoclothing.factories.dresses;
import com.nosipo.alfrescoclothing.domain.dresses.FlaredDress;

public class FlaredDressFactory
{
    public static FlaredDress getFlaredDress(String name, String colour, String price)
    {
        FlaredDress flaredDress = new FlaredDress.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return flaredDress;
    }
}
