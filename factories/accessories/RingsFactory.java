package com.nosipo.alfrescoclothing.factories.accessories;
import com.nosipo.alfrescoclothing.domain.accessories.Rings;

public class RingsFactory
{
    public static Rings getRings(String name, String colour, String price)
    {
        Rings rings = new Rings.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return rings;
    }
}
