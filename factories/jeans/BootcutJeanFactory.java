package com.nosipo.alfrescoclothing.factories.jeans;
import com.nosipo.alfrescoclothing.domain.jeans.BootcutJean;

public class BootcutJeanFactory
{
    public static BootcutJean getFullhouseGatsby(String name, String colour, String price)
    {
        BootcutJean bootcutJean = new BootcutJean.Builder()
                .name(name)
                .price(price)
                .colour(colour)
                .build();
        return bootcutJean;
    }
}
