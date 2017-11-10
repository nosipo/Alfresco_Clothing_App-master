package com.nosipo.alfrescoclothing.factories.dresses;
import com.nosipo.alfrescoclothing.domain.dresses.MaxiDress;

public class MaxiDressFactory
{
    public static MaxiDress getMaxiDress(String name, String colour, String price)
    {
        MaxiDress maxiDress = new MaxiDress.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return maxiDress;
    }
}
