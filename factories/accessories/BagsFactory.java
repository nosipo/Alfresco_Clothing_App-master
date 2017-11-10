package com.nosipo.alfrescoclothing.factories.accessories;
import com.nosipo.alfrescoclothing.domain.accessories.Bags;

public class BagsFactory
{
    public static Bags getBags(String name, String colour, String price)
    {
        Bag bag = new Bag.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return bag;
    }
}

