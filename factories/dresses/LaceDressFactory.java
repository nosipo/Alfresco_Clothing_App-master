package com.nosipo.alfrescoclothing.factories.dresses;
import com.nosipo.alfrescoclothing.domain.dresses.LaceDress;


public class LaceDressFactory
{
    public static LaceDress getLaceDress(String name, String colour, String price)
    {
        LaceDress laceDress = new LaceDress.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return laceDress;
    }
}
