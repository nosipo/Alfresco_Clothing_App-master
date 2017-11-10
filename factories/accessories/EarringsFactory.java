package com.nosipo.alfrescoclothing.factories.accessories;
import com.nosipo.alfrescoclothing.domain.accessories.Earrings;

public class EarringsFactory {

    public static Earrings getEarrings(String name, String colour, String price)
    {
        Earrings earrings = new Earrings.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return earrings;
    }
}
