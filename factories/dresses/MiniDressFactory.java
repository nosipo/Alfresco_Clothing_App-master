package com.nosipo.alfrescoclothing.factories.dresses;
import com.nosipo.alfrescoclothing.domain.dresses.MiniDress;

public class MiniDressFactory
{
    public static MiniDress getMiniDress(String name, String colour, String price)
    {
        MiniDress miniDress = new MiniDress.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return miniDress;
    }
}
